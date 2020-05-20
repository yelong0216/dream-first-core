/**
 * 
 */
package org.yelong.dream.first.core.platform.user.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.core.model.service.ModelService;
import org.yelong.dream.first.core.platform.user.model.UserExtraOrg;
import org.yelong.dream.first.core.platform.user.service.UserExtraOrgCommonService;
import org.yelong.mybatis.spring.BaseService;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class UserExtraOrgCommonServiceImpl extends BaseService implements UserExtraOrgCommonService{
	
	@Resource
	private ModelService modelService;
	
	@Override
	public List<UserExtraOrg> findByUserId(String userId) throws Exception {
		if(StringUtils.isEmpty(userId)) {
			return Collections.emptyList();
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("userExtraOrg.userId", "=", userId);
		return modelService.findByCondition(UserExtraOrg.class, combinationCondition);
	}

}
