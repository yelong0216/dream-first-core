/**
 * 
 */
package dream.first.core.cache;

import java.util.function.Function;

import org.yelong.core.cache.CacheEntity;
import org.yelong.core.cache.CacheManager;

import dream.first.base.cache.DreamFirstCacheManagerUtils;

public final class CacheManagerUtils {

	private CacheManagerUtils() {
	}

	public static <T> CacheEntity<T> putCacheIfAbsent(CacheManager cacheManager, String key,
			Function<String, T> cacheValueFactory) {
		return DreamFirstCacheManagerUtils.putCacheIfAbsent(cacheManager, key, cacheValueFactory);
	}

	public static <T> T putCacheObjIfAbsent(CacheManager cacheManager, String key,
			Function<String, T> cacheValueFactory) {
		return DreamFirstCacheManagerUtils.putCacheObjIfAbsent(cacheManager, key, cacheValueFactory);
	}

}
