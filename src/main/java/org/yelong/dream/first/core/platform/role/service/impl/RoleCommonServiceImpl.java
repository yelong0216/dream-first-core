/**
 * 
 */
package org.yelong.dream.first.core.platform.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.core.jdbc.sql.sort.SortSqlFragment;
import org.yelong.core.model.service.ModelService;
import org.yelong.dream.first.core.platform.role.constants.RoleType;
import org.yelong.dream.first.core.platform.role.model.Role;
import org.yelong.dream.first.core.platform.role.model.RoleDataRight;
import org.yelong.dream.first.core.platform.role.model.RoleRight;
import org.yelong.dream.first.core.platform.role.service.RoleCommonService;
import org.yelong.dream.first.core.platform.role.service.RoleDataRightCommonService;
import org.yelong.dream.first.core.platform.role.service.RoleRightCommonService;
import org.yelong.mybatis.spring.BaseService;

/**
 * 角色
 * 
 * @author PengFei
 * @since 1.0.0
 */
public class RoleCommonServiceImpl extends BaseService implements RoleCommonService{

	@Resource
	private ModelService modelService;

	@Resource
	private RoleRightCommonService roleRightService;

	@Resource
	private RoleDataRightCommonService roleDataRightService;
	
	@Override
	public boolean existByRoleName(String roleName)  {
		if(StringUtils.isEmpty(roleName)) {
			return false;
		}
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("role.roleName", "=", roleName);
		List<Role> roleList = modelService.findByCondition(Role.class,combinationCondition);
		if( null == roleList || roleList.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void saveByOperator(Role role, List<String> moduleIds)  {
		modelService.save(role);
		if( null == moduleIds || moduleIds.isEmpty() ) {
			return;
		}
		roleRightService.saveRoleRight(role.getId(), moduleIds);
	}

	@Override
	public void saveByData(Role role,String tmpRoleId)  {
		modelService.save(role);
		//修改数据权限中的临时id为真id
		roleDataRightService.modifyTmpId(role.getId(), tmpRoleId);
	}
	
	@Override
	public void modifyById(Role role, List<String> moduleIds)  {
		modelService.modifySelectiveById(role);
		//如果角色是操作角色
		if(RoleType.OPERATE.code().equals(role.getRoleType())) {
			//删除之前的关联的module
			CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
			combinationCondition.and("roleId", "=", role.getId());
			modelService.removeByCondition(RoleRight.class, combinationCondition);
			//保存
			roleRightService.saveRoleRight(role.getId(), moduleIds);
		} else {//如果是数据角色

		}
	}

	@Override
	public void removeById(String roleId)  {
		if(StringUtils.isEmpty(roleId)) {
			return;
		}
		modelService.removeById(Role.class, roleId);
		roleRightService.removeByRoleId(roleId);
		roleDataRightService.removeByRoleId(roleId);
	}

	@Override
	public void copy(String roleId)  {
		if(StringUtils.isEmpty(roleId)) {
			return;
		}
		Role role = modelService.findById(Role.class,roleId);
		if( null == role ) {
			throw new RuntimeException("没有此角色，复制失败！");
		}
		List<RoleRight> roleRightList = null;
		List<RoleDataRight> roleDataRightList = null;
		if (RoleType.OPERATE.code().equals(role.getRoleType())) {
			roleRightList = roleRightService.findByRoleId(roleId);
		} else if (RoleType.DATA.code().equals(role.getRoleType())) {
			roleDataRightList = roleDataRightService.findByRoleId(roleId);
		}
		Role newRole = new Role();
		BeanUtils.copyProperties(newRole, role);
		newRole.setRoleName(role.getRoleName() + "-副本");
		newRole.setId(null);
		newRole.setCreator(null);
		newRole.setCreateTime(null);
		modelService.save(newRole);
		if (roleRightList != null) {
			for (RoleRight rr : roleRightList) {
				RoleRight newRoleRight = new RoleRight();
				BeanUtils.copyProperties(newRoleRight, rr);
				newRoleRight.setRoleId(newRole.getId());
				modelService.save(newRoleRight);
			}
		}
		if (roleDataRightList != null) {
			for (RoleDataRight rdr : roleDataRightList) {
				RoleDataRight newRoleDataRight = new RoleDataRight();
				BeanUtils.copyProperties(newRoleDataRight, rdr);
				newRoleDataRight.setRoleId(newRole.getId());
				modelService.save(newRoleDataRight);
			}
		}
	}

	@Override
	public List<Role> findRoleTree() {
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("role.roleType", "=", "01")
							.and("role.state", "=", "0");
		SortSqlFragment sortFragment = createSortSqlFragment(modelService);
		sortFragment.addSort("role.roleName", "asc");
		return modelService.findByConditionSort(Role.class, combinationCondition, sortFragment);
	}

}
