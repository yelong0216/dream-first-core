/**
 * 
 */
package dream.first.core.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.yelong.core.cache.CacheManagerFactory;
import org.yelong.core.cache.simple.SimpleCacheManagerFactory;

import dream.first.core.DreamFirstCore;
import dream.first.core.platform.dict.manage.CacheableDictManager;
import dream.first.core.platform.dict.manage.DefaultCacheableDictManager;
import dream.first.core.platform.dict.service.DictCommonService;
import dream.first.core.platform.icon.manage.CacheableIconManager;
import dream.first.core.platform.icon.manage.DefaultCacheableIconManager;
import dream.first.core.platform.icon.service.IconCommonService;
import dream.first.core.platform.module.manage.CacheableModuleManager;
import dream.first.core.platform.module.manage.DefaultCacheableModuleManager;
import dream.first.core.platform.module.service.ModuleCommonService;
import dream.first.core.platform.org.manage.CacheableOrgManager;
import dream.first.core.platform.org.manage.DefaultCacheableOrgManager;
import dream.first.core.platform.org.service.OrgCommonService;
import dream.first.core.platform.service.manage.CacheableModuleServiceManager;
import dream.first.core.platform.service.manage.DefaultCacheableModuleServiceManager;
import dream.first.core.platform.service.service.ModuleServiceCommonService;
import dream.first.core.platform.service.service.ModuleServiceInterfaceCommonService;

/**
 * 使用缓存的配置
 * 
 * @since 2.0
 */
@ConditionalOnProperty(prefix = DreamFirstCore.DREAM_FIRST_PROPERTIES_PREFIX, name = "cache", havingValue = "true", matchIfMissing = false)
public class DreamFirstCacheConfiguration {

	/**
	 * @return 默认的缓存管理器工厂
	 */
	@Bean
	@ConditionalOnMissingBean(CacheManagerFactory.class)
	public CacheManagerFactory cacheManagerFactory() {
		return new SimpleCacheManagerFactory("default");
	}

	// ===========================字典============================

	/**
	 * @param cacheManagerFactory 缓存管理器工厂
	 * @return 字典管理管理器
	 */
	@Bean
	@ConditionalOnMissingBean(CacheableDictManager.class)
	public CacheableDictManager cacheableDictManager(DictCommonService dictCommonService,
			CacheManagerFactory cacheManagerFactory) {
		return new DefaultCacheableDictManager(dictCommonService, cacheManagerFactory);
	}

	// ===========================图标============================

	/**
	 * @param iconManager
	 * @param cacheManagerFactory
	 * @return 图标管理器
	 */
	@Bean
	@ConditionalOnMissingBean(CacheableIconManager.class)
	public CacheableIconManager cacheableIconManager(IconCommonService iconCommonService,
			CacheManagerFactory cacheManagerFactory) {
		return new DefaultCacheableIconManager(iconCommonService, cacheManagerFactory);
	}

	// ===========================组织============================

	/**
	 * @param orgCommonService    组织公共服务
	 * @param cacheManagerFactory 缓存管理器工厂
	 * @return 组织管理器
	 */
	@Bean
	@ConditionalOnMissingBean(CacheableOrgManager.class)
	public CacheableOrgManager cacheableOrgManager(OrgCommonService orgCommonService,
			CacheManagerFactory cacheManagerFactory) {
		return new DefaultCacheableOrgManager(orgCommonService, cacheManagerFactory);
	}

	// ===========================模块============================

	/**
	 * @param moduleCommonService 模块公共服务
	 * @param cacheManagerFactory 缓存管理器工厂
	 * @return 模块管理器
	 */
	@Bean
	@ConditionalOnMissingBean(CacheableModuleManager.class)
	public CacheableModuleManager cacheableModuleManager(ModuleCommonService moduleCommonService,
			CacheManagerFactory cacheManagerFactory) {
		return new DefaultCacheableModuleManager(moduleCommonService, cacheManagerFactory);
	}

	// ===========================模块服务============================

	/**
	 * @param moduleServiceManager
	 * @param cacheManagerFactory
	 * @return 模块服务管理器
	 */
	@Bean
	@ConditionalOnMissingBean(CacheableModuleServiceManager.class)
	public CacheableModuleServiceManager cacheableModuleServiceManager(
			ModuleServiceCommonService moduleServiceCommonService,
			ModuleServiceInterfaceCommonService moduleServiceInterfaceCommonService,
			CacheManagerFactory cacheManagerFactory) {
		return new DefaultCacheableModuleServiceManager(moduleServiceCommonService, moduleServiceInterfaceCommonService,
				cacheManagerFactory);
	}

}
