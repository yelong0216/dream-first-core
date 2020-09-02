/**
 * 
 */
package dream.first.core.platform.user.service;

import java.util.List;

import dream.first.core.platform.module.model.Module;
import dream.first.core.platform.role.model.Role;

/**
 * @since 1.0.0
 */
public interface UserRightCommonService {

	/**
	 * 查询用户所拥有的角色
	 * 
	 * @param userId 用户id
	 * @return 用户所拥有的角色
	 */
	List<Role> findRole(String userId);

	/**
	 * 查询用户所拥有的角色id
	 * 
	 * @param userId 用户id
	 * @return 用户所拥有的角色id
	 */
	List<String> findRoleIds(String userId);

	/**
	 * 查询用户可操作性的模块
	 * 
	 * @param userId 用户id
	 * @return 用户可操作性的模块
	 */
	List<Module> findModule(String userId);

	/**
	 * 查询用户可操作的模块id
	 * 
	 * @param userId 用户id
	 * @return 用户可操作性的模块
	 */
	List<String> findModuleIds(String userId);

}
