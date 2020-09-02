/**
 * 
 */
package dream.first.core.platform.service.service.impl;

import java.util.List;

import org.yelong.mybatis.spring.BaseService;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.service.model.ModuleService;
import dream.first.core.platform.service.service.ModuleServiceCommonService;

/**
 * @since 1.0.0
 */
public class ModuleServiceCommonServiceImpl extends BaseService implements ModuleServiceCommonService {

	protected final DreamFirstModelService modelService;

	public ModuleServiceCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public ModuleService findByServiceName(String serviceName) {
		ModuleService sqlModel = new ModuleService();
		sqlModel.setServiceNameEn(serviceName);
		ModuleService moduleService = modelService.findFirstBySqlModel(ModuleService.class, sqlModel);
		return moduleService;
	}

	@Override
	public List<ModuleService> findAll() {
		return modelService.findAll(ModuleService.class);
	}

	@Override
	public ModuleService findById(String id) {
		return modelService.findById(ModuleService.class, id);
	}

}
