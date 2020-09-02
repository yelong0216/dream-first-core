package dream.first.core.platform.role.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import dream.first.core.model.BaseModel;

/**
 * 角色权限
 * 
 * @since 1.0.0
 */
@Table(value = "CO_ROLE_RIGHT", alias = "roleRight", desc = "角色权限")
public class RoleRight extends BaseModel<RoleRight> {

	private static final long serialVersionUID = 4212434013101511047L;

	@Column(columnName = "角色id")
	private String roleId;

	@Column(columnName = "模块id")
	private String moduleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

}