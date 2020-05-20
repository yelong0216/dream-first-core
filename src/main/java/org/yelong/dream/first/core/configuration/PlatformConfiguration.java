/**
 * 
 */
package org.yelong.dream.first.core.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yelong.dream.first.core.Labbol;
import org.yelong.dream.first.core.platform.dict.service.DictCommonService;
import org.yelong.dream.first.core.platform.dict.service.impl.DictCommonServiceImpl;
import org.yelong.dream.first.core.platform.login.service.LoginSessionCommonService;
import org.yelong.dream.first.core.platform.login.service.impl.LoginSessionCommonServiceImpl;
import org.yelong.dream.first.core.platform.module.service.ModuleCommonService;
import org.yelong.dream.first.core.platform.module.service.impl.ModuleCommonServiceImpl;
import org.yelong.dream.first.core.platform.org.service.OrgCommonService;
import org.yelong.dream.first.core.platform.org.service.impl.OrgCommonServiceImpl;
import org.yelong.dream.first.core.platform.role.service.RoleCommonService;
import org.yelong.dream.first.core.platform.role.service.RoleDataRightCommonService;
import org.yelong.dream.first.core.platform.role.service.RoleRightCommonService;
import org.yelong.dream.first.core.platform.role.service.impl.RoleCommonServiceImpl;
import org.yelong.dream.first.core.platform.role.service.impl.RoleDataRightCommonServiceImpl;
import org.yelong.dream.first.core.platform.role.service.impl.RoleRightCommonServiceImpl;
import org.yelong.dream.first.core.platform.service.service.ModuleServiceCommonService;
import org.yelong.dream.first.core.platform.service.service.ModuleServiceInterfaceCommonService;
import org.yelong.dream.first.core.platform.service.service.impl.ModuleServiceCommonServiceImpl;
import org.yelong.dream.first.core.platform.service.service.impl.ModuleServiceInterfaceCommonServiceImpl;
import org.yelong.dream.first.core.platform.user.service.UserCommonService;
import org.yelong.dream.first.core.platform.user.service.UserExtraOrgCommonService;
import org.yelong.dream.first.core.platform.user.service.UserExtraOrgRoleCommonService;
import org.yelong.dream.first.core.platform.user.service.UserRightCommonService;
import org.yelong.dream.first.core.platform.user.service.UserRoleCommonService;
import org.yelong.dream.first.core.platform.user.service.impl.UserCommonServiceImpl;
import org.yelong.dream.first.core.platform.user.service.impl.UserExtraOrgCommonServiceImpl;
import org.yelong.dream.first.core.platform.user.service.impl.UserExtraOrgRoleCommonServiceImpl;
import org.yelong.dream.first.core.platform.user.service.impl.UserRightCommonServiceImpl;
import org.yelong.dream.first.core.platform.user.service.impl.UserRoleCommonServiceImpl;

/**
 * 平台服务配置
 * 
 * 这些服务默认情况下是注入的
 * 
 * @author PengFei
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(prefix = PlatformConfiguration.LABBOL_PLATFORM_PROPERTIES_PREFIX,
name = "auto",
havingValue = "true",
matchIfMissing = true)
public class PlatformConfiguration {

	public static final String LABBOL_PLATFORM_PROPERTIES_PREFIX = Labbol.LABBOL_PROPERTIES_PREFIX+".platform";
	
	//===========================字典============================
	
	/**
	 * @return 字典服务
	 */
	@Bean
	@ConditionalOnMissingBean(DictCommonService.class)
	public DictCommonService dictService() {
		return new DictCommonServiceImpl();
	}
	
	//===========================模块============================
	
	/**
	 * @return 模块服务
	 */
	@Bean
	@ConditionalOnMissingBean(ModuleCommonService.class)
	public ModuleCommonService moduleService() {
		return new ModuleCommonServiceImpl();
	}
	
	//===========================组织============================
	
	/**
	 * @return 组织服务
	 */
	@Bean
	@ConditionalOnMissingBean(OrgCommonService.class)
	public OrgCommonService orgService() {
		return new OrgCommonServiceImpl();
	}
	
	//===========================角色============================
	
	/**
	 * @return 角色数据权限
	 */
	@Bean
	@ConditionalOnMissingBean(RoleDataRightCommonService.class)
	public RoleDataRightCommonService roleDataRightService() {
		return new RoleDataRightCommonServiceImpl();
	}
	
	/**
	 * @return 角色权限
	 */
	@Bean
	@ConditionalOnMissingBean(RoleRightCommonService.class)
	public RoleRightCommonService roleRightCommonService() {
		return new RoleRightCommonServiceImpl();
	}
	/**
	 * @return 角色服务
	 */
	@Bean
	@ConditionalOnMissingBean(RoleCommonService.class)
	public RoleCommonService roleService() {
		return new RoleCommonServiceImpl();
	}
	
	//===========================用户============================
	
	/**
	 * @return 用户组织角色权限
	 */
	@Bean
	@ConditionalOnMissingBean(UserExtraOrgRoleCommonService.class)
	public UserExtraOrgRoleCommonService userExtraOrgRoleService() {
		return new UserExtraOrgRoleCommonServiceImpl();
	}
	
	/**
	 * @return 用户组织权限
	 */
	@Bean
	@ConditionalOnMissingBean(UserExtraOrgCommonService.class)
	public UserExtraOrgCommonService userExtraOrgService() {
		return new UserExtraOrgCommonServiceImpl();
	}
	
	/**
	 * @return 用户权限
	 */
	@Bean
	@ConditionalOnMissingBean(UserRightCommonService.class)
	public UserRightCommonService userRightCommonService() {
		return new UserRightCommonServiceImpl();
	}
	
	/**
	 * @return 用户角色
	 */
	@Bean
	@ConditionalOnMissingBean(UserRoleCommonService.class)
	public UserRoleCommonService userRoleService() {
		return new UserRoleCommonServiceImpl();
	}
	
	/**
	 * @return 用户服务
	 */
	@Bean
	@ConditionalOnMissingBean(UserCommonService.class)
	public UserCommonService userCommonService() {
		return new UserCommonServiceImpl();
	}
	
	//===========================服务接口============================
	
	/**
	 * @return 模块接口服务
	 */
	@Bean
	@ConditionalOnMissingBean(ModuleServiceInterfaceCommonService.class)
	public ModuleServiceInterfaceCommonService moduleServiceInterfaceService() {
		return new ModuleServiceInterfaceCommonServiceImpl();
	}
	
	/**
	 * @return 模块接口服务
	 */
	@Bean
	@ConditionalOnMissingBean(ModuleServiceCommonService.class)
	public ModuleServiceCommonService moduleServiceCommonService() {
		return new ModuleServiceCommonServiceImpl();
	}
	
	//===========================登录============================
	
	/**
	 * @return 登录会话服务
	 */
	@Bean
	@ConditionalOnMissingBean(LoginSessionCommonService.class)
	public LoginSessionCommonService loginSessionCommonService() {
		return new LoginSessionCommonServiceImpl();
	}
	
}
