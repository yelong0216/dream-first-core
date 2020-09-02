/**
 * 
 */
package dream.first.core.platform.user.service;

import java.util.List;

import dream.first.core.platform.user.model.User;
import dream.first.core.platform.user.model.UserRole;

/**
 * @since 1.0.0
 */
public interface UserRoleCommonService {

	/**
	 * 根据用户查询用户角色信息
	 * 
	 * @param userId 用户id
	 * @return 用户角色信息
	 */
	List<UserRole> findByUserId(String userId);

	/**
	 * 根据角色名称查询拥有该角色的用户信息
	 * 
	 * @param roleName 角色名称
	 * @return 拥有该角色的所有用户信息
	 */
	List<User> findUserByRoleName(String roleName);

	/**
	 * 查询是否存在用户名称和角色名称的记录 翻译：查询用户(username)是否是这个(roleName)角色
	 * 
	 * @param username 用户名
	 * @param roleName 角色名
	 * @return <tt>true</tt> 是
	 */
	boolean existByUsernameAndRoleName(String username, String roleName);

}
