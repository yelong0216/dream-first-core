package org.yelong.dream.first.core.platform.user.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;
import org.yelong.core.model.annotation.Transient;
import org.yelong.dream.first.core.model.BaseModel;

/**
 * 用户附属部门
 * 
 * @author PengFei
 * @since 1.0.0
 */
@Table("CO_USER_EXTRAORG")
public class UserExtraOrg extends BaseModel{
	
	private static final long serialVersionUID = 8500687079797831260L;

	@Column(columnName = "用户id")
	private String userId;

	@Column(columnName = "组织id")
    private String orgId;

    @Transient
    private String orgName;

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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}