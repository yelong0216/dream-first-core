package dream.first.core.platform.module.manage;

import java.util.List;

import dream.first.core.platform.module.model.Module;
import dream.first.core.platform.module.service.ModuleCommonService;

/**
 * 简单的模块管理器
 * 
 * @since 2.0
 */
public class SimpleModuleManager implements ModuleManager {

	protected final ModuleCommonService moduleCommonService;

	public SimpleModuleManager(ModuleCommonService moduleCommonService) {
		this.moduleCommonService = moduleCommonService;
	}

	@Override
	public List<Module> getAll() {
		return moduleCommonService.findAll();
	}

	@Override
	public Module getByModuleNo(String moduleNo) {
		return moduleCommonService.findByModuleNo(moduleNo);
	}

	@Override
	public List<Module> getByParentModuleNo(String parentModuleNo) {
		return moduleCommonService.findByParentModuleNo(parentModuleNo);
	}

}
