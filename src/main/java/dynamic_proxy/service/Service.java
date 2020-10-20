package dynamic_proxy.service;

import dynamic_proxy.cache.Cache;
import dynamic_proxy.cache.CacheType;

import java.util.List;

/**
 * интерфейс с кешируемыми методами
 */
public interface Service {
    @Cache(cacheType = CacheType.IN_FILE, identityBy = {String.class, int.class})
    double doHardWork(final String work, final int value);

    @Cache(cacheType = CacheType.IN_MEMORY, fileNamePrefix = "myPrefix.zip", zip = true, listLength = 2)
    List<Double> run(final String item);
}