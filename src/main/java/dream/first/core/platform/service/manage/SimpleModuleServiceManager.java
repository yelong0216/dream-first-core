package dream.first.core.platform.service.manage;

import java.util.List;
import java.util.Objects;

import dream.first.core.platform.service.model.ModuleService;
import dream.first.core.platform.service.model.ModuleServiceInterface;
import dream.first.core.platform.service.service.ModuleServiceCommonService;
import dream.first.core.platform.service.service.ModuleServiceInterfaceCommonService;

public class SimpleModuleServiceManager implements ModuleServiceManager {

	protected final ModuleServiceCommonService moduleServiceCommonService;

	protected final ModuleServiceInterfaceCommonService moduleServiceInterfaceCommonService;

	public SimpleModuleServiceManager(ModuleServiceCommonService moduleServiceCommonService,
			ModuleServiceInterfaceCommonService moduleServiceInterfaceCommonService) {
		this.moduleServiceCommonService = Objects.requireNonNull(moduleServiceCommonService);
		this.moduleServiceInterfaceCommonService = Objects.requireNonNull(moduleServiceInterfaceCommonService);
	}

	@Override
	public List<ModuleService> getServiceAll() {
		return moduleServiceCommonService.findAll();
	}

	@Override
	public ModuleService getServiceByServiceName(String serviceName) {
		return moduleServiceCommonService.findByServiceName(serviceName);
	}

	@Override
	public ModuleService getServiceById(String id) {
		return moduleServiceCommonService.findById(id);
	}

	@Override
	public List<ModuleServiceInterface> getInterfaceAll() {
		return moduleServiceInterfaceCommonService.findAll();
	}

	@Override
	public List<ModuleServiceInterface> getInterfaceByServiceId(String serviceId) {
		return moduleServiceInterfaceCommonService.findByServiceId(serviceId);
	}

	@Override
	public ModuleServiceInterface getInterfaceByInterfaceName(String interfaceName) {
		return moduleServiceInterfaceCommonService.findByInterfaceName(interfaceName);
	}

	@Override
	public String getInterfaceUrl(String interfaceName) {
		ModuleServiceInterface moduleServiceInterface = getInterfaceByInterfaceName(interfaceName);
		if (null == moduleServiceInterface) {
			return null;
		}
		ModuleService moduleService = getServiceById(moduleServiceInterface.getServiceId());
		if (null == moduleService) {
			return null;
		}
		String baseUrl = moduleService.getBaseUrl();
		if (!baseUrl.endsWith("/")) {
			baseUrl = baseUrl + "/";
		}
		String interfaceUrl = moduleServiceInterface.getInterfaceUrl();
		if (interfaceUrl.startsWith("/")) {
			interfaceUrl = interfaceUrl.substring(1);
		}
		return baseUrl + interfaceUrl;
	}

}
