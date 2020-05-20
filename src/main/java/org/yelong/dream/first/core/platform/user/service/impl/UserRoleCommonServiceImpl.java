/**
 * 
 */
package org.yelong.dream.first.core.platform.user.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.core.jdbc.sql.defaults.DefaultSelectSqlFragment;
import org.yelong.core.jdbc.sql.executable.SelectSqlFragment;
import org.yelong.core.model.service.ModelService;
import org.yelong.dream.first.core.platform.user.model.User;
import org.yelong.dream.first.core.platform.user.model.UserRole;
import org.yelong.dream.first.core.platform.user.service.UserRoleCommonService;
import org.yelong.mybatis.spring.BaseService;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class UserRoleCommonServiceImpl extends BaseService implements UserRoleCommonService{

	@Resource
	private ModelService modelService;
	
	@Override
	public List<UserRole> findByUserId(String userId){
		if(StringUtils.isEmpty(userId)) {
			return Collections.emptyList();
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("userRole.userId", "=", userId);
		return modelService.findByCondition(UserRole.class,combinationCondition);
	}
	
	
	@Override
	public List<User> findUserByRoleName(String roleName){
		String sql = "select usr.*  " + 
				"from CO_USER usr " + 
				"inner join CO_USER_ROLE userRole on usr.id = userRole.userId " + 
				"inner join CO_ROLE role on role.id = userRole.roleId where role.roleName = ? ";
		SelectSqlFragment selectSqlFragment = new DefaultSelectSqlFragment(sql, roleName);
		return modelService.execute(User.class, selectSqlFragment);
	}
	
	@Override
	public boolean existByUsernameAndRoleName(String username, String roleName) {
		String sql = "select count(1) from CO_USER u  " + 
				"inner join CO_USER_ROLE userRole on userRole.userId = u.id " + 
				"inner join CO_ROLE role on role.id = userRole.roleId " + 
				"where u.username = ? and role.rolename = ? ";
		return modelService.getBaseDataBaseOperation().count(sql, username,roleName) > 0;
	}
	
}
