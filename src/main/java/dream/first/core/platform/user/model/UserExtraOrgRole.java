package dream.first.core.platform.user.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import dream.first.core.model.BaseModel;

/**
 * 用户附属组织与角色
 * 
 * @since 1.0.0
 */
@Table("CO_USER_EXTRAORG_ROLE")
public class UserExtraOrgRole extends BaseModel<UserExtraOrgRole> {

	private static final long serialVersionUID = 2287415287069683444L;

	@Column(columnName = "")
	private String extraOrgId;

	@Column(columnName = "用户id")
	private String userId;

	@Column(columnName = "组织id")
	private String orgId;

	@Column(columnName = "角色id")
	private String roleId;

	public String getExtraOrgId() {
		return extraOrgId;
	}

	public void setExtraOrgId(String extraOrgId) {
		this.extraOrgId = extraOrgId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}