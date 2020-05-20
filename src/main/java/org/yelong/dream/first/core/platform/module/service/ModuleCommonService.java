/**
 * 
 */
package org.yelong.dream.first.core.platform.module.service;

import org.yelong.dream.first.core.platform.module.model.Module;

/**
 * 模块公共服务
 * 
 * @author PengFei
 * @since 1.0.0
 */
public interface ModuleCommonService{

	/**
	 * 保存模块，并设置一些默认属性
	 * @author 彭飞
	 * @date 2019年9月25日上午10:55:24
	 * @version 1.0
	 * @param module 模块对象
	 * @throws Exception
	 */
	void save(Module module) throws Exception;
	
	
	/**
	 * 修改模块信息。
	 * 同事修改子集的模块编号。
	 * 修改子集的模块属性
	 * @author 彭飞
	 * @date 2019年9月25日上午11:11:36
	 * @version 1.0
	 * @param module
	 * @throws Exception
	 */
	void modifyById(Module module) throws Exception;
	
	/**
	 * 修改模块信息。
	 * 同事修改子集的模块编号。
	 * 修改子集的模块属性
	 * @author 彭飞
	 * @date 2019年9月25日上午11:11:36
	 * @version 1.0
	 * @param module
	 * @throws Exception
	 */
	void modifyByModuleNo(Module module) throws Exception;
	
	/**
	 * 删除模块信息
	 * 及子模块一同删除
	 * @author 彭飞
	 * @date 2019年9月25日上午11:33:16
	 * @version 1.0
	 * @param moduleId 模块id
	 * @throws Exception
	 */
	boolean removeById(String moduleId) throws Exception;
	
	
	/**
	 * 批量删除
	 * @author 彭飞
	 * @date 2019年9月25日上午11:33:52
	 * @version 1.0
	 * @param moduleIds
	 * @throws Exception
	 */
	default boolean removerByIdBatch(String [] moduleIds )throws Exception{
		for (String moduleId : moduleIds) {
			removeById(moduleId);
		}
		return true;
	}
	
	/**
	 * 删除模块信息
	 * 及子模块一同删除
	 * @author 彭飞
	 * @date 2019年9月25日上午11:33:16
	 * @version 1.0
	 * @param moduleId 模块id
	 * @throws Exception
	 */
	boolean removeByModuleNo(String moduleNo) throws Exception;
	
	
	/**
	 * 批量删除
	 * @author 彭飞
	 * @date 2019年9月25日上午11:33:52
	 * @version 1.0
	 * @param moduleIds
	 * @throws Exception
	 */
	default boolean removerByModuleNoBatch(String [] moduleNos )throws Exception{
		for (String moduleNo : moduleNos) {
			removeByModuleNo(moduleNo);
		}
		return true;
	}
	
	/**
	 * 根据模块编号查询模块
	 * @date 2019年12月6日下午3:55:42
	 * @param moduleNo
	 * @return
	 */
	Module findByModuleNo(String moduleNo);
	
	
}
