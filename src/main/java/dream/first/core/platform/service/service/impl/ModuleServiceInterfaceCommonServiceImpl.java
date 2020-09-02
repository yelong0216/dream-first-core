/**
 * 
 */
package dream.first.core.platform.service.service.impl;

import java.util.List;

import org.yelong.core.model.collector.ModelCollectors;
import org.yelong.mybatis.spring.BaseService;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.service.model.ModuleServiceInterface;
import dream.first.core.platform.service.service.ModuleServiceInterfaceCommonService;

/**
 * @since 1.0.0
 */
public class ModuleServiceInterfaceCommonServiceImpl extends BaseService
		implements ModuleServiceInterfaceCommonService {

	protected final DreamFirstModelService modelService;

	public ModuleServiceInterfaceCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public List<ModuleServiceInterface> findAll() {
		return modelService.findAll(ModuleServiceInterface.class);
	}

	@Override
	public List<ModuleServiceInterface> findByServiceId(String serviceId) {
		return modelService
				.collect(ModelCollectors.findBySingleColumnEQ(ModuleServiceInterface.class, "serviceId", serviceId));
	}

	@Override
	public ModuleServiceInterface findByInterfaceName(String interfaceName) {
		return modelService.collect(
				ModelCollectors.getModelBySingleColumnEQ(ModuleServiceInterface.class, "interfaceName", interfaceName));
	}

}
