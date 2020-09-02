/**
 * 
 */
package dream.first.core.platform.user.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.ConditionSqlFragment;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.mybatis.spring.BaseService;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.constants.State;
import dream.first.core.platform.user.model.User;
import dream.first.core.platform.user.model.UserExtraOrg;
import dream.first.core.platform.user.model.UserExtraOrgRole;
import dream.first.core.platform.user.model.UserRole;
import dream.first.core.platform.user.service.UserCommonService;
import dream.first.core.utils.SecurityUtils;

/**
 * @since 1.0.0
 */
public class UserCommonServiceImpl extends BaseService implements UserCommonService {

	protected final DreamFirstModelService modelService;

	public UserCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public User findByUserName(String userName) {
		if (StringUtils.isEmpty(userName)) {
			return null;
		}
		ConditionSqlFragment conditionFragment = createSimpleSqlCondition(modelService, "userName = ? ", userName);
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
	public void modifyPassword(String userId, String oldPassword, String newPassword) {
		if (oldPassword.equals(newPassword)) {
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
	public void remove(String userId) {
		if (StringUtils.isEmpty(userId)) {
			return;
		}
		// 删除之前的关系
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("userId", "=", userId);
		modelService.removeByCondition(UserRole.class, combinationCondition);
		modelService.removeByCondition(UserExtraOrg.class, combinationCondition);
		modelService.removeByCondition(UserExtraOrgRole.class, combinationCondition);
		// 软删除
		User user = new User();
		user.setId(userId);
		user.setState(State.NO.getCode());
		modelService.modifySelectiveById(user);
	}

	@Override
	public void resetPassword(String userId) {
		if (StringUtils.isEmpty(userId)) {
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
	public void lockUser(String userId) {
		if (StringUtils.isEmpty(userId)) {
			return;
		}
		User user = new User();
		user.setIsLock("02");
		user.setId(userId);
		modelService.modifySelectiveById(user);
	}

	@Override
	public void unLockUser(String userId) {
		if (StringUtils.isEmpty(userId)) {
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
	public DreamFirstModelService getDreamFirstModelService() {
		return this.modelService;
	}

}
