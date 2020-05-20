package org.yelong.dream.first.core.platform.service.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;
import org.yelong.dream.first.core.model.BaseModel;

/**
 * 应用服务接口
 * @author PengFei
 * @since 1.0.0
 */
@Table(value="CO_MODULE_SERVICE_INTERFACE",alias = "moduleServiceInterface",desc = "应用服务接口")
public class ModuleServiceInterface extends BaseModel {
	
	private static final long serialVersionUID = 6690537561114285226L;
	
	@Column(columnName = "服务id")
	private String serviceId;
	
	@Column(columnName = "接口名称")
	private String interfaceName;
	
	@Column(columnName = "接口url")
	private String interfaceUrl;
	
	@Column(columnName = "接口状态")
	private String interfaceState;
	
	@Column(columnName = "接口描述")
	private String interfaceDesc;
	
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getInterfaceUrl() {
		return interfaceUrl;
	}

	public void setInterfaceUrl(String interfaceUrl) {
		this.interfaceUrl = interfaceUrl;
	}
	public String getInterfaceState() {
		return interfaceState;
	}

	public void setInterfaceState(String interfaceState) {
		this.interfaceState = interfaceState;
	}

	public String getInterfaceDesc() {
		return interfaceDesc;
	}

	public void setInterfaceDesc(String interfaceDesc) {
		this.interfaceDesc = interfaceDesc;
	}
	
}
