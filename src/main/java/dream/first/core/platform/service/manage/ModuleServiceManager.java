/**
 * 
 */
package dream.first.core.platform.service.manage;

import java.util.List;

import org.yelong.core.annotation.Nullable;

import dream.first.core.platform.service.model.ModuleService;
import dream.first.core.platform.service.model.ModuleServiceInterface;

/**
 * 模块服务接口管理器
 * 
 * @since 2.0
 */
public interface ModuleServiceManager {

	// ==================================================ModuleService==================================================

	/**
	 * 获取所有的模块服务
	 * 
	 * @return 所有的模块服务
	 */
	@Nullable
	List<ModuleService> getServiceAll();

	/**
	 * 根据服务名称获取模块服务信息。
	 * 
	 * @param serviceName 服务名称。此名称应该为服务的英文名称
	 * @return 模块服务
	 */
	@Nullable
	ModuleService getServiceByServiceName(String serviceName);
	

	/**
	 * 根据服务ID获取模块服务信息。
	 * 
	 * @param id 服务ID
	 * @return 模块服务
	 */
	ModuleService getServiceById(String id);

	// ==================================================ModuleServiceInterface==================================================

	/**
	 * 获取所有的模块服务接口
	 * 
	 * @return 所有的模块服务接口
	 */
	@Nullable
	List<ModuleServiceInterface> getInterfaceAll();

	/**
	 * 获取指定模块服务下的所有接口
	 * 
	 * @param serviceId 接口
	 * @return 指定模块服务下的所有接口
	 */
	@Nullable
	List<ModuleServiceInterface> getInterfaceByServiceId(String serviceId);

	/**
	 * 根据接口名称查询服务接口
	 * 
	 * @param interfaceName 接口名称
	 * @return
	 */
	@Nullable
	ModuleServiceInterface getInterfaceByInterfaceName(String interfaceName);

	/**
	 * 获取接口的路径。路径由服务路径拼接接口路径组成
	 * 
	 * @param interfaceName 接口名称
	 * @return 接口的路径
	 */
	@Nullable
	String getInterfaceUrl(String interfaceName);

}
