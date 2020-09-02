/**
 * 
 */
package dream.first.core.platform.user.service.impl;

import java.util.List;
import java.util.Objects;

import org.yelong.mybatis.spring.BaseService;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.module.model.Module;
import dream.first.core.platform.role.model.Role;
import dream.first.core.platform.user.service.UserRightCommonService;

/**
 * @since 1.0.0
 */
public class UserRightCommonServiceImpl extends BaseService implements UserRightCommonService {

	protected final DreamFirstModelService modelService;

	public UserRightCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public List<Role> findRole(String userId) {
		Objects.requireNonNull(userId);
		String sql = "select role.* ,usr.id userId " + "from CO_ROLE role "
				+ "inner join CO_USER_ROLE userRole on role.id = userRole.roleId "
				+ "inner join CO_USER usr on usr.id = userRole.userId " + "where usr.id = ? ";
		List<Role> roleList = modelService.findBySQL(Role.class, sql, new Object[] { userId });
		return roleList;
	}

	@Override
	public List<String> findRoleIds(String userId) {
		Objects.requireNonNull(userId);
		String sql = "select role.id " + "from CO_ROLE role "
				+ "inner join CO_USER_ROLE userRole on role.id = userRole.roleId "
				+ "inner join CO_USER usr on usr.id = userRole.userId " + "where usr.id = ? ";
		return modelService.getBaseDataBaseOperation().selectColumn(sql, userId);
	}

	@Override
	public List<Module> findModule(String userId) {
		Objects.requireNonNull(userId);
		String sql = "select module.*  " + "from CO_MODULE module "
				+ "inner join CO_ROLE_RIGHT roleRight on module.id = roleRight.moduleId "
				+ "inner join CO_USER_ROLE userRole on userRole.roleId = roleRight.roleId "
				+ "inner join CO_USER usr on usr.id = userRole.userId " + "where usr.id = ?";
		List<Module> moduleList = modelService.findBySQL(Module.class, sql, new Object[] { userId });
		return moduleList;
	}

	@Override
	public List<String> findModuleIds(String userId) {
		Objects.requireNonNull(userId);
		String sql = "select module.id  " + "from CO_MODULE module "
				+ "inner join CO_ROLE_RIGHT roleRight on module.id = roleRight.moduleId "
				+ "inner join CO_USER_ROLE userRole on userRole.roleId = roleRight.roleId "
				+ "inner join CO_USER usr on usr.id = userRole.userId " + "where usr.id = ?";
		return modelService.getBaseDataBaseOperation().selectColumn(sql, userId);
	}

}
