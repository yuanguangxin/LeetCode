package 其他.线程安全的本地缓存;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程安全的本地缓存
 */
public class Main {
    Map<Object, Object> cache = new ConcurrentHashMap<>();

    public static Object load(Object key) {
        String value = key + "：value";
        return value;
    }

    public Object get(Object key) {
        Object value = cache.get(key);
        if (value == null) {
            synchronized (cache) {
                value = cache.get(key);
                if (value == null) {
                    value = load(key);
                    cache.put(key, value);
                }
            }
        }
        return value;
    }
}

