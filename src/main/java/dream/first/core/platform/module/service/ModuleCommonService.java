/**
 * 
 */
package dream.first.core.platform.module.service;

import java.util.List;

import org.yelong.core.annotation.Nullable;

import dream.first.core.platform.module.model.Module;

/**
 * 模块公共服务
 * 
 * @since 1.0.0
 */
public interface ModuleCommonService {

	// ==================================================save==================================================

	/**
	 * 保存模块，并设置一些默认属性
	 * 
	 * @param module 模模块信息
	 */
	void save(Module module);

	// ==================================================remove==================================================

	/**
	 * 删除模块信息 及子模块一同删除
	 * 
	 * @param moduleId 模块id
	 */
	boolean removeById(String moduleId);

	/**
	 * 批量删除,及子模块一同删除
	 * 
	 * @param moduleIds 模块id数组
	 */
	boolean removerByIdBatch(String[] moduleIds);

	/**
	 * 根据模块编号删除模块信息 及子模块一同删除
	 * 
	 * @param moduleNo 模块编号
	 */
	boolean removeByModuleNo(String moduleNo);

	/**
	 * 根据模块编号批量删除及子模块一同删除
	 * 
	 * @param moduleNos 模块编号
	 */
	boolean removerByModuleNoBatch(String[] moduleNos);

	// ==================================================modify==================================================

	/**
	 * 根据模块ID修改模块信息。 同时修改子集的模块编号。 修改子集的模块属性
	 * 
	 * @param module 模块信息
	 */
	void modifyById(Module module);

	/**
	 * 根据模块编号修改模块信息。 同时修改子集的模块编号。 修改子集的模块属性
	 * 
	 * @param module 模块信息
	 */
	void modifyByModuleNo(Module module);

	// ==================================================find==================================================

	/**
	 * 获取所有的模块
	 * 
	 * @return 所有的模块
	 */
	@Nullable
	List<Module> findAll();

	/**
	 * 根据模块编号查询模块
	 * 
	 * @param moduleNo 模块编号
	 * @return 模块
	 */
	@Nullable
	Module findByModuleNo(String moduleNo);

	/**
	 * 根据父模块编号查询模块
	 * 
	 * @param parentModuleNo 父模块编号
	 * @return 模块集合
	 */
	@Nullable
	List<Module> findByParentModuleNo(String parentModuleNo);

}
