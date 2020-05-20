/**
 * 
 */
package org.yelong.dream.first.core.platform.user.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.ConditionSqlFragment;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.core.jdbc.sql.executable.SelectSqlFragment;
import org.yelong.core.model.service.SqlModelService;
import org.yelong.dream.first.core.platform.constants.State;
import org.yelong.dream.first.core.platform.user.model.User;
import org.yelong.dream.first.core.platform.user.model.UserExtraOrg;
import org.yelong.dream.first.core.platform.user.model.UserExtraOrgRole;
import org.yelong.dream.first.core.platform.user.model.UserRole;
import org.yelong.dream.first.core.platform.user.service.UserCommonService;
import org.yelong.dream.first.core.utils.SecurityUtils;
import org.yelong.mybatis.spring.BaseService;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class UserCommonServiceImpl extends BaseService implements UserCommonService{

	@Resource
	private SqlModelService modelService;

	@Override
	public User findByUserName(String userName)  {
		if(StringUtils.isEmpty(userName)) {
			return null;
		}
		ConditionSqlFragment conditionFragment = createSimpleSqlCondition(modelService,"userName = ? ",userName);
		List<User> userList = modelService.findByCondition(User.class, conditionFragment);
		return (null != userList && !userList.isEmpty()) ? userList.get(0) : null;
	}

	public String getPwdSign(String password) {
		if (StringUtils.isNotBlank(password)) {
			return SecurityUtils.encryptMD5(password + "freder").toLowerCase();
		}
		return "";
	}

	@Override
	public void modifyPassword(String userId, String oldPassword, String newPassword)  {
		if( oldPassword.equals(newPassword) ) {
			return;
		}
		User user = new User();
		user.setId(userId);
		user.setPassword(newPassword);
		user.setPwdSign(getPwdSign(newPassword));
		user.setInitState("02");
		user.setPwdUpdateTime(new Date());
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("id", "=", userId);
		combinationCondition.and("password", "=", oldPassword);
		modelService.modifySelectiveByCondition(user, combinationCondition);
	}

	@Override
	public void remove(String userId)  {
		if(StringUtils.isEmpty(userId)) {
			return;
		}
		//删除之前的关系
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("userId", "=", userId);
		modelService.removeByCondition(UserRole.class, combinationCondition);
		modelService.removeByCondition(UserExtraOrg.class, combinationCondition);
		modelService.removeByCondition(UserExtraOrgRole.class, combinationCondition);
		//软删除
		User user = new User();
		user.setId(userId);
		user.setState(State.NO.getCode());
		modelService.modifySelectiveById(user);
	}

	
	@Override
	public void resetPassword(String userId)  {
		if(StringUtils.isEmpty(userId)) {
			return;
		}
		User user = new User();
		user.setId(userId);
//		user.setPassword("C1BB5938DF9F21908D35C1455E2F4800");//q1w2e3r$
//		user.setPwdSign("f690446014242a3531ff8a1fd3e4e911");
		user.setPassword("95D98DDFECDB70676F59C71FEB1555A6");
		user.setInitState("01");
		modelService.modifySelectiveById(user);
	}
	
	@Override
	public void lockUser(String userId)  {
		if(StringUtils.isEmpty(userId)) {
			return;
		}
		User user = new User();
		user.setIsLock("02");
		user.setId(userId);
		modelService.modifySelectiveById(user);
	}
	
	@Override
	public void unLockUser(String userId)  {
		if(StringUtils.isEmpty(userId)) {
			return;
		}
		User user = new User();
		user.setIsLock("01");
		user.setLoginFailTimes(0);
		user.setId(userId);
		modelService.modifySelectiveById(user);
	}
	@Override
	public String getPasswordSign(String password) {
		if (StringUtils.isNotBlank(password)) {
			return SecurityUtils.encryptMD5(password + "freder").toLowerCase();
		}
		return "";
	}

	@Override
	public List<User> findByRoleCondition(ConditionSqlFragment condition) {
		String sql = "select usr.*, org.orgName usrOrgName "
				+ "from CO_USER usr inner join CO_ORG org on usr.orgId = org.id "
				+ "inner join CO_USER_ROLE userrole on userrole.userId = usr.id";
		
		SelectSqlFragment selectSqlFragment = modelService.getModelConfiguration().getModelSqlFragmentFactory().createSelectSqlFragment(sql);
		if( null != condition ) {
			selectSqlFragment.setConditionSqlFragment(condition);
		}
		return modelService.execute(User.class, selectSqlFragment);
	}
	
}
