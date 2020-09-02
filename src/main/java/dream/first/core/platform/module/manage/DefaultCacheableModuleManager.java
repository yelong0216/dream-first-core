/**
 * 
 */
package dream.first.core.platform.module.manage;

import java.util.List;
import java.util.Objects;

import org.yelong.core.cache.CacheManager;
import org.yelong.core.cache.CacheManagerFactory;

import dream.first.core.cache.CacheManagerUtils;
import dream.first.core.platform.module.model.Module;
import dream.first.core.platform.module.service.ModuleCommonService;

/**
 * 
 * 简单的缓存支持的模块管理器
 * 
 * @since 2.0
 */
public class DefaultCacheableModuleManager implements CacheableModuleManager {

	protected final CacheManager cacheManager;

	protected final ModuleManager moduleManager;

	public DefaultCacheableModuleManager(ModuleCommonService moduleCommonService,
			CacheManagerFactory cacheManagerFactory) {
		this(new SimpleModuleManager(moduleCommonService), cacheManagerFactory);
	}

	public DefaultCacheableModuleManager(ModuleManager moduleManager, CacheManagerFactory cacheManagerFactory) {
		this.moduleManager = Objects.requireNonNull(moduleManager);
		this.cacheManager = Objects.requireNonNull(cacheManagerFactory).create("MODULE_MANAGER");
	}

	@Override
	public List<Module> getAll() {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "MODULE_ALL", x -> moduleManager.getAll());
	}

	@Override
	public Module getByModuleNo(String moduleNo) {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "moduleNo:" + moduleNo,
				x -> moduleManager.getByModuleNo(moduleNo));
	}

	@Override
	public List<Module> getByParentModuleNo(String parentModuleNo) {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "parentModuleNo:" + parentModuleNo,
				x -> moduleManager.getByParentModuleNo(parentModuleNo));
	}

	@Override
	public CacheManager getCacheManager() {
		return cacheManager;
	}
	
}
