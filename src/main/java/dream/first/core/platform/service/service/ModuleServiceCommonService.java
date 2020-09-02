/**
 * 
 */
package dream.first.core.platform.service.service;

import java.util.List;

import dream.first.core.platform.service.model.ModuleService;

/**
 * 模块服务工具服务
 * 
 * @since 1.0.0
 */
public interface ModuleServiceCommonService {

	/**
	 * 获取所有的模块服务
	 * 
	 * @return 所有的模块服务
	 */
	List<ModuleService> findAll();

	/**
	 * 根据服务名称获取模块服务信息。
	 * 
	 * @param serviceName 服务名称。此名称应该为服务的英文名称
	 * @return 模块服务
	 */
	ModuleService findByServiceName(String serviceName);

	/**
	 * 根据服务ID获取模块服务信息。
	 * 
	 * @param id 服务ID
	 * @return 模块服务
	 */
	ModuleService findById(String id);

}
