package org.xtwy.nio;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * #author qinghao
 * #date 2019-05-24 23:07
 */
public class GuavaTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Cache<String, Object> cache = CacheBuilder.newBuilder()
                .refreshAfterWrite(10, TimeUnit.SECONDS)
                .maximumSize(3)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) throws Exception {

                        System.out.println("进入了 load");

                        System.out.println("dsadsa");
                        return null;
                    }

                    @Override
                    public ListenableFuture reload(String key, Object oldValue) throws Exception {
                        System.out.println("进入了 reload");
                        System.out.println("kkk");
                        return null;
                    }
                });

        cache.put("a", "123");
        cache.put("b", "123");
        cache.put("c", "123");
        cache.put("d", "123");


        System.out.println(cache.size());
//        Object a = cache.getIfPresent("a");
        Object v = ((LoadingCache) cache).get("a");
        System.out.println(v);
        TimeUnit.SECONDS.sleep(15);
        System.out.println(cache.size());
        v = ((LoadingCache) cache).getUnchecked("a");


    }
}
