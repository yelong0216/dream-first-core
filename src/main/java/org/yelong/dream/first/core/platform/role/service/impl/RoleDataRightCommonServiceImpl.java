/**
 * 
 */
package org.yelong.dream.first.core.platform.role.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.core.model.service.ModelService;
import org.yelong.dream.first.core.platform.role.model.RoleDataRight;
import org.yelong.dream.first.core.platform.role.service.RoleDataRightCommonService;
import org.yelong.mybatis.spring.BaseService;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class RoleDataRightCommonServiceImpl extends BaseService implements RoleDataRightCommonService{
	
	@Resource
	private ModelService modelService;

	@Override
	public void removeByRoleId(String roleId)  {
		if(StringUtils.isEmpty(roleId)) {
			return ;
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("roleDataRight.roleId", "=", roleId);
		modelService.removeByCondition(RoleDataRight.class, combinationCondition);
	}

	@Override
	public List<RoleDataRight> findByRoleId(String roleId)  {
		if(StringUtils.isEmpty(roleId)) {
			return Collections.emptyList();
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("roleDataRight.roleId", "=", roleId);
		return modelService.findByCondition(RoleDataRight.class, combinationCondition);
	}

	@Override
	public void modifyTmpId(String roleId, String tmpRoleId)  {
		if(StringUtils.isEmpty(tmpRoleId) || StringUtils.isEmpty(roleId)) {
			return;
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("roleDataRight.roleId", "=", tmpRoleId);
		RoleDataRight roleDataRight = new RoleDataRight(); 
		roleDataRight.setRoleId(roleId);
		modelService.modifyByCondition(roleDataRight, combinationCondition);
	}

}
