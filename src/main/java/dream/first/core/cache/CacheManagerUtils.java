/**
 * 
 */
package dream.first.core.cache;

import java.util.function.Function;

import org.yelong.core.cache.CacheEntity;
import org.yelong.core.cache.CacheManager;

/**
 * 缓存管理器工具类
 *
 * @since 2.0
 */
public final class CacheManagerUtils {

	private CacheManagerUtils() {
	}

	/**
	 * 获取缓存的实体，如果不存在该键值的缓存则工具工厂获取值，在将值放入缓存中
	 * 
	 * @param <T>               cache entity type
	 * @param cacheManager      缓存管理器
	 * @param key               键值
	 * @param cacheValueFactory 缓存的值工厂
	 * @return 缓存的实体
	 */
	public static <T> CacheEntity<T> putCacheIfAbsent(CacheManager cacheManager, String key,
			Function<String, T> cacheValueFactory) {
		return cacheManager.putCacheIfAbsent(key, cacheValueFactory);
	}

	/**
	 * 获取缓存的值，如果不存在该键值的缓存则工具工厂获取值，在将值放入缓存中
	 * 
	 * @param <T>               cache entity type
	 * @param cacheManager      缓存管理器
	 * @param key               键值
	 * @param cacheValueFactory 缓存的值工厂
	 * @return 缓存的值
	 */
	public static <T> T putCacheObjIfAbsent(CacheManager cacheManager, String key,
			Function<String, T> cacheValueFactory) {
		return cacheManager.putCacheObjIfAbsent(key, cacheValueFactory);
	}

}
