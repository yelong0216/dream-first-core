/**
 * 
 */
package dream.first.core.platform.service.manage;

import java.util.List;
import java.util.Objects;

import org.yelong.core.cache.CacheManager;
import org.yelong.core.cache.CacheManagerFactory;

import dream.first.core.cache.CacheManagerUtils;
import dream.first.core.platform.service.model.ModuleService;
import dream.first.core.platform.service.model.ModuleServiceInterface;
import dream.first.core.platform.service.service.ModuleServiceCommonService;
import dream.first.core.platform.service.service.ModuleServiceInterfaceCommonService;

/**
 * 默认的缓存支持的模块服务管理器
 * 
 * @since 2.0
 */
public class DefaultCacheableModuleServiceManager implements CacheableModuleServiceManager {

	protected final ModuleServiceManager moduleServiceManager;

	protected final CacheManager cacheManager;

	public DefaultCacheableModuleServiceManager(ModuleServiceCommonService moduleServiceCommonService,
			ModuleServiceInterfaceCommonService moduleServiceInterfaceCommonService,
			CacheManagerFactory cacheManagerFactory) {
		this(new SimpleModuleServiceManager(moduleServiceCommonService, moduleServiceInterfaceCommonService),
				cacheManagerFactory);
	}

	public DefaultCacheableModuleServiceManager(ModuleServiceManager moduleServiceManager,
			CacheManagerFactory cacheManagerFactory) {
		this.moduleServiceManager = Objects.requireNonNull(moduleServiceManager);
		this.cacheManager = Objects.requireNonNull(cacheManagerFactory).create("MODULE_SERVICE_MANAGE");
	}

	@Override
	public List<ModuleService> getServiceAll() {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "SERVICE_ALL",
				x -> moduleServiceManager.getServiceAll());
	}

	@Override
	public ModuleService getServiceByServiceName(String serviceName) {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "SERVICE_NAME:" + serviceName,
				x -> moduleServiceManager.getServiceByServiceName(serviceName));
	}

	@Override
	public ModuleService getServiceById(String id) {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "SERVICE_ID:" + id,
				x -> moduleServiceManager.getServiceById(id));
	}

	@Override
	public List<ModuleServiceInterface> getInterfaceAll() {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "INTERFACE_ALL",
				x -> moduleServiceManager.getInterfaceAll());
	}

	@Override
	public List<ModuleServiceInterface> getInterfaceByServiceId(String serviceId) {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "INTERFACE_SERVICEID:" + serviceId,
				x -> moduleServiceManager.getInterfaceByServiceId(serviceId));
	}

	@Override
	public ModuleServiceInterface getInterfaceByInterfaceName(String interfaceName) {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "INTERFACE_INTERFACENAME:" + interfaceName,
				x -> moduleServiceManager.getInterfaceByInterfaceName(interfaceName));
	}

	@Override
	public String getInterfaceUrl(String interfaceName) {
		return CacheManagerUtils.putCacheObjIfAbsent(cacheManager, "INTERFACEURL_INTERFACENAME:" + interfaceName,
				x -> moduleServiceManager.getInterfaceUrl(interfaceName));
	}

	@Override
	public CacheManager getCacheManager() {
		return cacheManager;
	}

}
