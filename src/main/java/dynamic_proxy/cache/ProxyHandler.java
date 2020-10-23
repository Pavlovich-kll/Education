package dynamic_proxy.cache;

import dynamic_proxy.utils.ReflectionUtils;
import dynamic_proxy.utils.SerializableUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Класс- обработчик, обеспечивает функциональность кэширования
 */
public class ProxyHandler implements InvocationHandler {
    private final Object delegate;
    private final String cachePath;
    private final CacheType defaultCacheType;

    //Кэш:
    //Ключ - имя кэшируемого метода
    //Значение - мапа, где ключи - списки аргументов, значения - результат кэшируемой функции
    private Map<String, Map<ArrayList<?>, Object>> cache = new HashMap<>();

    public ProxyHandler(Object delegate, String cachePath, CacheType defaultCacheType) {
        this.delegate = delegate;
        this.cachePath = cachePath;
        this.defaultCacheType = defaultCacheType;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Если требуется кэширование
        if (method.isAnnotationPresent(Cache.class)) {
            Cache ann = method.getAnnotation(Cache.class);

            //формируем имя файла кэша для записи/чтения
            //либо по дефолту, либо берем имя метода
            String prefix = (ann.fileNamePrefix().length() > 0) ? ann.fileNamePrefix() : method.getName();
            String fileName = this.cachePath + prefix + ".cache";

            Map<ArrayList<?>, Object> methodCache = new HashMap<>();
            if (ann.cacheType() == CacheType.IN_FILE) {
                //Если нет кэша для файла, то пробуем загрузить с диска
                if (!this.cache.containsKey(method.getName())) {
                    Object loadedCache = SerializableUtils.deserialize(fileName, ann.zip());
                    if (loadedCache != null) {
                        methodCache = (Map<ArrayList<?>, Object>) loadedCache;
                        System.out.println("кэш для метода " + method.getName() + " был загружен из файла " + fileName);
                        this.cache.put(method.getName(), methodCache);
                    }
                }
            }

            //Список идентификационных классов аргументов из аннотации
            List<Class> identityArr = Arrays.asList(ann.identityBy());

            //Выбираем идентификационные аргументы
            ArrayList<Object> keys = new ArrayList();
            for (Object arg : args) {
                //Если массив identityBy не задан - добавляем все аргументы
                if (identityArr.isEmpty()) {
                    keys.add(arg);
                    //Иначе только те, что заданы в аннотации
                } else if (identityArr.contains(ReflectionUtils.GetPrimitiveClass(arg.getClass()))) {
                    System.out.println("\tИдентифицируем кэш по параметру: " + arg.getClass());
                    keys.add(arg);
                }
            }

            //Рассчитываем результат и помещвем в кэш
            Object returnValue = method.invoke(delegate, args);

            if (ann.listLength() != -1 && List.class.isAssignableFrom(returnValue.getClass())) {
                //Обрезаем лист до нужной длины, при необходимости
                //sublist не serializable, поэтому создаем новый
                List newList = new ArrayList(((List) returnValue).subList(0, ann.listLength()));
                returnValue = newList;
            }

            System.out.println("Помещено в кэш |" + method.getName() + "| " + keys + " : " + returnValue);
            methodCache.put(keys, returnValue);
            this.cache.put(method.getName(), methodCache);

            if (ann.cacheType() == CacheType.IN_FILE) {
                System.out.println("Кэш записан в файл " + fileName);
                SerializableUtils.serialize(this.cache.get(method.getName()), fileName, ann.zip());
            }
            return returnValue;
        }
        //Метод не кэшируется, просто вычисляем и возвращаем результат
        return method.invoke(delegate, args);
    }
}