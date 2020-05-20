package org.yelong.dream.first.core.platform.service.dto;

import org.yelong.core.model.annotation.Select;
import org.yelong.core.model.annotation.Table;
import org.yelong.dream.first.core.platform.service.model.ModuleServiceInterface;

/**
 * 
 * @author PengFei
 * @date 2019年12月30日下午2:53:35
 */
@Table(value="CO_MODULE_SERVICE_INTERFACE",alias = "moduleServiceInterface")
/*
select moduleServiceInterface.*,moduleService.serviceName,moduleService.baseUrl serviceBaseUrl
from CO_MODULE_SERVICE_INTERFACE moduleServiceInterface
inner join CO_MODULE_SERVICE moduleService on moduleService.id = moduleServiceInterface.serviceId
 */
@Select("select moduleServiceInterface.*,moduleService.serviceName,moduleService.baseUrl serviceBaseUrl " + 
		"from CO_MODULE_SERVICE_INTERFACE moduleServiceInterface " + 
		"inner join CO_MODULE_SERVICE moduleService on moduleService.id = moduleServiceInterface.serviceId")
public class ModuleServiceInterfaceTemplateDTO extends ModuleServiceInterface{
	
	private static final long serialVersionUID = 6649244752514751546L;

	private String serviceName;
	
	private String serviceBaseUrl;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceBaseUrl() {
		return serviceBaseUrl;
	}

	public void setServiceBaseUrl(String serviceBaseUrl) {
		this.serviceBaseUrl = serviceBaseUrl;
	}
	
}
