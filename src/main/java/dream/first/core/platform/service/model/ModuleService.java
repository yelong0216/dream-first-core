package dream.first.core.platform.service.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import dream.first.core.model.BaseModel;

/**
 * 模块服务表
 * 
 * @since 1.0.0
 */
@Table(value = "CO_MODULE_SERVICE", alias = "moduleService", desc = "模块服务")
public class ModuleService extends BaseModel<ModuleService> {

	private static final long serialVersionUID = 7796930686023478870L;

	@Column(columnName = "服务管理人")
	private String serviceCharger;

	@Column(columnName = "上线时间")
	private String onlineDate;

	@Column(columnName = "基础url")
	private String baseUrl;

	@Column(columnName = "服务状态")
	private String serviceState;

	@Column(columnName = "服务版本")
	private String serviceVersion;

	@Column(columnName = "服务英文名")
	private String serviceNameEn;

	@Column(columnName = "服务备注")
	private String serviceRemark;

	@Column(columnName = "服务名")
	private String serviceName;

	public String getServiceCharger() {
		return serviceCharger;
	}

	public void setServiceCharger(String serviceCharger) {
		this.serviceCharger = serviceCharger;
	}

	public String getOnlineDate() {
		return onlineDate;
	}

	public void setOnlineDate(String onlineDate) {
		this.onlineDate = onlineDate;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getServiceState() {
		return serviceState;
	}

	public void setServiceState(String serviceState) {
		this.serviceState = serviceState;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getServiceNameEn() {
		return serviceNameEn;
	}

	public void setServiceNameEn(String serviceNameEn) {
		this.serviceNameEn = serviceNameEn;
	}

	public String getServiceRemark() {
		return serviceRemark;
	}

	public void setServiceRemark(String serviceRemark) {
		this.serviceRemark = serviceRemark;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
