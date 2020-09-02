package dream.first.core.cache;

import org.yelong.core.cache.CacheManager;

/**
 * 缓存管理器支持
 * 
 * @since 2.0
 */
public interface CacheManagerable {

	/**
	 * @return 缓存管理器
	 */
	CacheManager getCacheManager();

	/**
	 * 清空缓存管理器中的所有缓存对象
	 */
	default void clearCache() {
		getCacheManager().clear();
	}

}
