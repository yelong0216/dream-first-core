/**
 * 
 */
package dream.first.core.platform.user.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.mybatis.spring.BaseService;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.user.model.UserExtraOrg;
import dream.first.core.platform.user.service.UserExtraOrgCommonService;

/**
 * @since 1.0.0
 */
public class UserExtraOrgCommonServiceImpl extends BaseService implements UserExtraOrgCommonService {

	protected final DreamFirstModelService modelService;

	public UserExtraOrgCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public List<UserExtraOrg> findByUserId(String userId) throws Exception {
		if (StringUtils.isEmpty(userId)) {
			return Collections.emptyList();
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("userExtraOrg.userId", "=", userId);
		return modelService.findByCondition(UserExtraOrg.class, combinationCondition);
	}

}
