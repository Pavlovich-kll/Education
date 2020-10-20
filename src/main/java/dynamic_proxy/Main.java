package dynamic_proxy;

import dynamic_proxy.cache.CacheProxy;
import dynamic_proxy.cache.CacheType;
import dynamic_proxy.service.Service;
import dynamic_proxy.service.ServiceImpl;

import java.io.File;

public class Main {
    //Каталог хранения кэша вычислений
    private static final String CACHE_PATH = "D:\\Education\\Education\\src\\main\\resources" + File.separator;
    private static final CacheType DEFAULT_CACHE_TYPE = CacheType.IN_FILE;

    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy(CACHE_PATH, DEFAULT_CACHE_TYPE);
        Service service = cacheProxy.cache(new ServiceImpl());

        System.out.println("\n>Метод doHardWork");
        System.out.println("Результат: " + service.doHardWork("work2", 422));
        System.out.println("Результат: " + service.doHardWork("work2", 422));
        System.out.println("Результат: " + service.doHardWork("work1", 4));
        System.out.println("Результат: " + service.doHardWork("work1", 4));

        System.out.println("\n>Метод run");
        System.out.println("Результат: " + service.run("Test"));
        System.out.println("Результат: " + service.run("Test"));
        System.out.println("Результат: " + service.run("Test Test"));
        System.out.println("Результат: " + service.run("Test Test"));
    }
}
