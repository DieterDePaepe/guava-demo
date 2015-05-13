package com.github.dieterdepaepe.demo.guava;

import com.google.common.base.Function;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Callables;

import java.util.concurrent.ExecutionException;

public class CacheDemo {
    public static void main(String[] args) throws ExecutionException {
        Function<String, Integer> stringLength = new Function<String, Integer>() {
            public Integer apply(String input) {
                return input.length();
            }
        };

        Cache<String, Integer> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .build();

        cache.getIfPresent("Hello"); //null
        cache.put("Hello", 5);
        cache.get("world", Callables.returning(5)); //5
        cache.invalidateAll();

        LoadingCache<String, Integer> loadingCache = CacheBuilder.newBuilder().build(CacheLoader.from(stringLength));
        loadingCache.getIfPresent("Hello"); //null
        loadingCache.get("World"); //5
    }
}
