/**
 * 
 */
package org.yelong.dream.first.core.platform.user.service.impl;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.yelong.core.jdbc.sql.defaults.DefaultSelectSqlFragment;
import org.yelong.core.model.service.ModelService;
import org.yelong.dream.first.core.platform.module.model.Module;
import org.yelong.dream.first.core.platform.role.model.Role;
import org.yelong.dream.first.core.platform.user.service.UserRightCommonService;
import org.yelong.mybatis.spring.BaseService;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class UserRightCommonServiceImpl extends BaseService implements UserRightCommonService{

	@Resource
	private ModelService modelService;
	
	@Override
	public List<Role> findRole(String userId) {
		Objects.requireNonNull(userId);
		String sql = "select role.* ,usr.id userId " + 
				"from CO_ROLE role " + 
				"inner join CO_USER_ROLE userRole on role.id = userRole.roleId " + 
				"inner join CO_USER usr on usr.id = userRole.userId "+ 
				"where usr.id = ? ";
		List<Role> roleList = modelService.execute(Role.class, new DefaultSelectSqlFragment(sql, userId));
		return roleList;
	}

	@Override
	public List<String> findRoleIds(String userId) {
		Objects.requireNonNull(userId);
		String sql = "select role.id " + 
				"from CO_ROLE role " + 
				"inner join CO_USER_ROLE userRole on role.id = userRole.roleId " + 
				"inner join CO_USER usr on usr.id = userRole.userId "+ 
				"where usr.id = ? ";
		return modelService.getBaseDataBaseOperation().selectColumn(sql,userId);
	}

	@Override
	public List<Module> findModule(String userId) {
		Objects.requireNonNull(userId);
		String sql = "select module.*  " + 
				"from CO_MODULE module " + 
				"inner join CO_ROLE_RIGHT roleRight on module.id = roleRight.moduleId " + 
				"inner join CO_USER_ROLE userRole on userRole.roleId = roleRight.roleId " + 
				"inner join CO_USER usr on usr.id = userRole.userId " + 
				"where usr.id = ?";
		List<Module> moduleList = modelService.execute(Module.class, new DefaultSelectSqlFragment(sql, userId));
		return moduleList;
	}

	@Override
	public List<String> findModuleIds(String userId) {
		Objects.requireNonNull(userId);
		String sql = "select module.id  " + 
				"from CO_MODULE module " + 
				"inner join CO_ROLE_RIGHT roleRight on module.id = roleRight.moduleId " + 
				"inner join CO_USER_ROLE userRole on userRole.roleId = roleRight.roleId " + 
				"inner join CO_USER usr on usr.id = userRole.userId " + 
				"where usr.id = ?";
		return modelService.getBaseDataBaseOperation().selectColumn(sql,userId);
	}

}
