/**
 * 
 */
package dream.first.core.platform.role.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.mybatis.spring.BaseService;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.role.model.RoleRight;
import dream.first.core.platform.role.service.RoleRightCommonService;

/**
 * @since 1.0.0
 */
public class RoleRightCommonServiceImpl extends BaseService implements RoleRightCommonService {

	protected final DreamFirstModelService modelService;

	public RoleRightCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public List<RoleRight> findByRoleId(String roleId) {
		if (StringUtils.isEmpty(roleId)) {
			return Collections.emptyList();
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("roleRight.roleId", "=", roleId);
		return modelService.findByCondition(RoleRight.class, combinationCondition);
	}

	@Override
	public void saveRoleRight(String roleId, List<String> moduleIds) {
		if (StringUtils.isEmpty(roleId)) {
			return;
		}
		if (CollectionUtils.isEmpty(moduleIds)) {
			return;
		}
		for (String moduleId : moduleIds) {
			RoleRight roleRight = new RoleRight();
			roleRight.setModuleId(moduleId);
			roleRight.setRoleId(roleId);
			modelService.save(roleRight);
		}
	}

	@Override
	public void removeByRoleId(String roleId) {
		if (StringUtils.isEmpty(roleId)) {
			return;
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("roleRight.roleId", "=", roleId);
		modelService.removeByCondition(RoleRight.class, combinationCondition);
	}

	@Override
	public List<String> findModuleIdByRoleId(String roleId) {
		return findByRoleId(roleId).stream().map(RoleRight::getModuleId).collect(Collectors.toList());
	}

}
