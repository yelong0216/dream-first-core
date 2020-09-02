/**
 * 
 */
package dream.first.core.platform.icon.manage;

import java.util.List;
import java.util.Objects;

import org.yelong.core.cache.CacheManager;
import org.yelong.core.cache.CacheManagerFactory;

import dream.first.core.cache.CacheManagerUtils;
import dream.first.core.platform.icon.model.Icon;
import dream.first.core.platform.icon.service.IconCommonService;

/**
 * 默认的缓存支持的图标管理器
 * 
 * @since 2.0
 */
public class DefaultCacheableIconManager implements CacheableIconManager {

	protected final IconManager iconManager;

	protected final CacheManager cacheManager;

	public DefaultCacheableIconManager(IconCommonService iconCommonService, CacheManagerFactory cacheManagerFactory) {
		this(new SimpleIconManager(iconCommonService), cacheManagerFactory);
	}

	public DefaultCacheableIconManager(IconManager iconManager, CacheManagerFactory cacheManagerFactory) {
		this.iconManager = Objects.requireNonNull(iconManager);
		this.cacheManager = Objects.requireNonNull(cacheManagerFactory).create("ICON_MANAGER");
	}

	@Override
	public List<Icon> getAll() {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "ICON_ALL", x -> iconManager.getAll());
	}

	@Override
	public CacheManager getCacheManager() {
		return this.cacheManager;
	}

}
