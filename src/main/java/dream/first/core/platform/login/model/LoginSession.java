package dream.first.core.platform.login.model;

import java.util.Date;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import dream.first.core.model.BaseModel;

/**
 * 登录会话控制
 * 
 * @since 1.0.0
 */
@Table(value = "CO_LOGIN_SESSION", alias = "loginSession", desc = "登录会话控制")
public class LoginSession extends BaseModel<LoginSession> {

	private static final long serialVersionUID = -6053945308075690282L;

	@Column(column = "loginIp", maxLength = 32, allowNull = false, columnName = "登录IP")
	private String loginIp;

	@Column(column = "username", maxLength = 32, allowNull = false, columnName = "用户名")
	private String username;

	@Column(column = "loginTime", allowNull = false, columnName = "登录时间")
	private Date loginTime;

	@Column(column = "userAgent", columnName = "客户端信息")
	private String userAgent;

	@Column(column = "sessionId", maxLength = 128, allowNull = false, columnName = "会话ID")
	private String sessionId;

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
