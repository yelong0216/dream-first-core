/**
 * 
 */
package dream.first.test.core.cache;

import org.junit.jupiter.api.Test;
import org.yelong.core.cache.CacheEntity;
import org.yelong.core.cache.CacheManager;
import org.yelong.core.cache.simple.SimpleCacheManager;

import dream.first.core.cache.CacheManagerUtils;

/**
 *
 */
public class CacheManagerUtilsTest {

	private CacheManager cacheManager = new SimpleCacheManager();

	@Test
	public void getCacheOrPut() {
		CacheEntity<String> cacheEntity = CacheManagerUtils.putCacheIfAbsent(cacheManager, "abc", (x) -> x);
		System.out.println(cacheEntity.get());
		System.out.println(cacheManager.getCache("abc"));
		System.out.println(CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "abc", (x) -> x + "abc"));
		System.out.println(cacheManager.getCache("abc"));
		cacheManager.clear();
		System.out.println(CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "abc", (x) -> x + "abc"));
		System.out.println(cacheManager.getCache("abc"));
	}

}
