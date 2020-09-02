/**
 * 
 */
package dream.first.core.platform.role.service;

import java.util.List;

import dream.first.core.platform.role.model.RoleDataRight;

/**
 * 角色数据权限
 * 
 * @since 1.0.0
 */
public interface RoleDataRightCommonService {

	/**
	 * 根据角色id查询记录
	 * 
	 * @param roleId 角色id
	 * @return 角色的权限
	 */
	List<RoleDataRight> findByRoleId(String roleId);

	/**
	 * 根据角色id删除记录
	 * 
	 * @param roleId 角色id
	 */
	void removeByRoleId(String roleId);

	/**
	 * 修改临时id
	 * 
	 * @param roleId    角色id
	 * @param tmpRoleId 临时角色id
	 */
	void modifyTmpId(String roleId, String tmpRoleId);

}
