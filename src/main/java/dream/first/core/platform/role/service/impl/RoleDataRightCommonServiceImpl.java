/**
 * 
 */
package dream.first.core.platform.role.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.mybatis.spring.BaseService;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.role.model.RoleDataRight;
import dream.first.core.platform.role.service.RoleDataRightCommonService;

/**
 * @since 1.0.0
 */
public class RoleDataRightCommonServiceImpl extends BaseService implements RoleDataRightCommonService {

	protected final DreamFirstModelService modelService;

	public RoleDataRightCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public void removeByRoleId(String roleId) {
		if (StringUtils.isEmpty(roleId)) {
			return;
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("roleDataRight.roleId", "=", roleId);
		modelService.removeByCondition(RoleDataRight.class, combinationCondition);
	}

	@Override
	public List<RoleDataRight> findByRoleId(String roleId) {
		if (StringUtils.isEmpty(roleId)) {
			return Collections.emptyList();
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("roleDataRight.roleId", "=", roleId);
		return modelService.findByCondition(RoleDataRight.class, combinationCondition);
	}

	@Override
	public void modifyTmpId(String roleId, String tmpRoleId) {
		if (StringUtils.isEmpty(tmpRoleId) || StringUtils.isEmpty(roleId)) {
			return;
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("roleDataRight.roleId", "=", tmpRoleId);
		RoleDataRight roleDataRight = new RoleDataRight();
		roleDataRight.setRoleId(roleId);
		modelService.modifyByCondition(roleDataRight, combinationCondition);
	}

}
