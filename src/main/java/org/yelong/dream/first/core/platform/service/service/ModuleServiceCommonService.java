/**
 * 
 */
package org.yelong.dream.first.core.platform.service.service;

import org.yelong.dream.first.core.platform.service.model.ModuleService;

/**
 * @author PengFei
 * @since 1.0.0
 */
public interface ModuleServiceCommonService {

	/**
	 * 根据服务名称获取模块服务信息。
	 * @param serviceName 服务名称。此名称应该为服务的英文名称
	 * @return 模块服务
	 */
	ModuleService findByServiceName(String serviceName);
	
}
