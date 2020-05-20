package org.yelong.dream.first.core.platform.user.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;
import org.yelong.dream.first.core.model.BaseModel;

/**
 * 用户角色
 * @author PengFei
 * @since 1.0.0
 */
@Table("CO_USER_ROLE")
public class UserRole extends BaseModel{
	
	private static final long serialVersionUID = -7899995642604594310L;

	@Column(columnName = "角色id")
	private String roleId;

	@Column(columnName = "用户id")
    private String userId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
}