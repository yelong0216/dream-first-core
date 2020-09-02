package dream.first.core.platform.module.manage;

import java.util.List;

import org.yelong.core.annotation.Nullable;

import dream.first.core.platform.module.model.Module;

/**
 * 模块管理器
 * 
 * @since 1.0.0
 */
public interface ModuleManager {

	/**
	 * 获取所有的模块
	 * 
	 * @return 所有的模块
	 */
	@Nullable
	List<Module> getAll();

	/**
	 * 根据模块编号获取模块
	 * 
	 * @param moduleNo 模块编号
	 * @return 模块
	 */
	@Nullable
	Module getByModuleNo(String moduleNo);

	/**
	 * 根据父模块编号获取模块
	 * 
	 * @param parentModuleNo 父模块编号
	 * @return 模块集合
	 */
	@Nullable
	List<Module> getByParentModuleNo(String parentModuleNo);

}
