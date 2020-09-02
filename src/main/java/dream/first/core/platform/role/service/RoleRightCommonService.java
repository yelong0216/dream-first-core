/**
 * 
 */
package dream.first.core.platform.role.service;

import java.util.List;

import dream.first.core.platform.role.model.RoleRight;

/**
 * 角色权限
 * 
 * @since 1.0.0
 */
public interface RoleRightCommonService {

	/**
	 * 根据角色id查询该角色对应的模块属性
	 * 
	 * @param roleId 角色id
	 * @return 角色对应的模块属性
	 */
	List<RoleRight> findByRoleId(String roleId);

	/**
	 * 根据角色id与模块ids进行保存其关联关系
	 * 
	 * @param roleId    角色id
	 * @param moduleIds 模块id集合
	 */
	void saveRoleRight(String roleId, List<String> moduleIds);

	/**
	 * 根据角色id删除记录
	 * 
	 * @param roleId 角色id
	 */
	void removeByRoleId(String roleId);

	/**
	 * 查询角色的可操作的模块
	 * 
	 * @param roleId 角色id
	 * @return 角色可操作的模块
	 */
	List<String> findModuleIdByRoleId(String roleId);

}
