/**
 * 
 */
package org.yelong.dream.first.core.platform.role.service;

import java.util.List;

import org.yelong.dream.first.core.platform.role.model.Role;

/**
 * 角色
 * 
 * @author PengFei
 * @since 1.0.0
 */
public interface RoleCommonService{

	/**
	 * 根据角色名称查询记录是否存在
	 * @param roleName 角色名称
	 * @return <tt>true</tt> 该角色名称的记录存在
	 */
	boolean existByRoleName(String roleName);
	
	/**
	 * 保存操作类型角色并保存关联的模块
	 * @param role 角色
	 * @param moduleIds 模块id
	 */
	void saveByOperator(Role role , List<String> moduleIds);
	
	/**
	 * 保存角色，且该角色为数据类型角色
	 * 且修改数据权限中的临时id为角色真实id
	 * @param role 
	 * @param tmpRoleId 临时id
	 */
	void saveByData(Role role , String tmpRoleId);
	
	/**
	 * 修改角色，并连同修改关联的模块
	 * 先删除该角色之前的模块，后添加模块
	 * @param role 角色
	 * @param moduleIds 模块id
	 */
	void modifyById(Role role , List<String> moduleIds);
	
	/**
	 * 删除角色。同时删除关联的角色模块信息及角色数据信息
	 * @param roleId 角色id
	 */
	void removeById(String roleId);
	
	/**
	 * 复制角色。
	 * 其角色名称前面加-副本
	 * @param roleId 角色id
	 */
	void copy(String roleId);
	
	/**
	 * 批量复制
	 * @param roleIds 角色id数组
	 */
	default void copyBatch(String [] roleIds ){
		for (String roleId : roleIds) {
			copy(roleId);
		}
	}
	
	/**
	 * 查询角色树
	 * @return 角色书
	 */
	List<Role> findRoleTree();
	
}
