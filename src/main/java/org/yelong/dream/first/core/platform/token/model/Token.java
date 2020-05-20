package org.yelong.dream.first.core.platform.token.model;

import java.util.Date;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;
import org.yelong.dream.first.core.model.BaseModel;

/**
 * 令牌
 * 
 * @author PengFei
 * @since 1.0.0
 */
@Table(value = "TUS_USER_AUTH",alias = "token",desc = "令牌")
public class Token extends BaseModel{
	
	private static final long serialVersionUID = 87669142986863374L;

	@Column(value = "用户id")
	private String userId;

	@Column(value = "用户名")
    private String userName;

	@Column(value = "认证令牌")
    private String authToken;

	@Column(value = "令牌创建时间")
    private Date authCreateTime;

	@Column(value = "令牌失效时间")
    private Date authExpireTime;

	@Column(value = "用户真实姓名")
    private String realName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public Date getAuthCreateTime() {
		return authCreateTime;
	}

	public void setAuthCreateTime(Date authCreateTime) {
		this.authCreateTime = authCreateTime;
	}

	public Date getAuthExpireTime() {
		return authExpireTime;
	}

	public void setAuthExpireTime(Date authExpireTime) {
		this.authExpireTime = authExpireTime;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
    
}