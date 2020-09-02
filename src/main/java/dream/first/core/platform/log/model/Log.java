package dream.first.core.platform.log.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import dream.first.core.model.BaseModel;

/**
 * 日志
 * 
 * @since 1.0.0
 */
@Table("CO_LOG")
public class Log extends BaseModel<Log> {

	private static final long serialVersionUID = 4685982837904504544L;

	@Column(columnName = "开始时间")
	private String startTime;

	@Column(columnName = "结束时间")
	private String endTime;

	@Column(columnName = "用户名称")
	private String userName;

	@Column(columnName = "用户ip地址")
	private String userIp;

	@Column(columnName = "请求路径")
	private String requestPath;

	@Column(columnName = "操作时间")
	private Integer operTimes;

	@Column(columnName = "开始时间（ms）")
	private String operModule;

	@Column(columnName = "请求参数（包含请求消息体）")
	private String requestParams;

	@Column(columnName = "响应参数")
	private String responseParams;

	@Column(columnName = "日志描述")
	private String logDesc;

	@Column(columnName = "事件类型（登录日志、操作日志等）")
	private String eventType;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}

	public Integer getOperTimes() {
		return operTimes;
	}

	public void setOperTimes(Integer operTimes) {
		this.operTimes = operTimes;
	}

	public String getOperModule() {
		return operModule;
	}

	public void setOperModule(String operModule) {
		this.operModule = operModule;
	}

	public String getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(String requestParams) {
		this.requestParams = requestParams;
	}

	public String getResponseParams() {
		return responseParams;
	}

	public void setResponseParams(String responseParams) {
		this.responseParams = responseParams;
	}

	public String getLogDesc() {
		return logDesc;
	}

	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}