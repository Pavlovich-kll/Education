package dynamic_proxy.cache;

import dynamic_proxy.service.Service;
import dynamic_proxy.service.ServiceImpl;
import java.lang.reflect.Proxy;

public class CacheProxy {
    private final String cachePath;
    private final CacheType defaultCacheType;

    //Принимает настройки хранения файлов (путь к кэшу или дефолтная реализация)
    public CacheProxy(String cachePath, CacheType defaultCacheType) {
        this.cachePath = cachePath;
        this.defaultCacheType = defaultCacheType;
    }

    //Принимает ссылку на сервис
    //возвращает кэширующую версию сервиса (прокси объект)
    public Service cache(ServiceImpl serviceImpl) {
        return (Service) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Service.class},
                new ProxyHandler(serviceImpl, cachePath, defaultCacheType));
    }
}