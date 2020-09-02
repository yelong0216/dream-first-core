/**
 * 
 */
package dream.first.core.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import dream.first.core.DreamFirstCore;
import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.dict.manage.DictManager;
import dream.first.core.platform.dict.manage.SimpleDictManager;
import dream.first.core.platform.dict.service.DictCommonService;
import dream.first.core.platform.dict.service.impl.DictCommonServiceImpl;
import dream.first.core.platform.icon.manage.IconManager;
import dream.first.core.platform.icon.manage.SimpleIconManager;
import dream.first.core.platform.icon.service.IconCommonService;
import dream.first.core.platform.icon.service.impl.IconCommonServiceImpl;
import dream.first.core.platform.login.service.LoginSessionCommonService;
import dream.first.core.platform.login.service.impl.LoginSessionCommonServiceImpl;
import dream.first.core.platform.module.manage.ModuleManager;
import dream.first.core.platform.module.manage.SimpleModuleManager;
import dream.first.core.platform.module.service.ModuleCommonService;
import dream.first.core.platform.module.service.impl.ModuleCommonServiceImpl;
import dream.first.core.platform.org.manage.OrgManager;
import dream.first.core.platform.org.manage.SimpleOrgManager;
import dream.first.core.platform.org.service.OrgCommonService;
import dream.first.core.platform.org.service.impl.OrgCommonServiceImpl;
import dream.first.core.platform.role.service.RoleCommonService;
import dream.first.core.platform.role.service.RoleDataRightCommonService;
import dream.first.core.platform.role.service.RoleRightCommonService;
import dream.first.core.platform.role.service.impl.RoleCommonServiceImpl;
import dream.first.core.platform.role.service.impl.RoleDataRightCommonServiceImpl;
import dream.first.core.platform.role.service.impl.RoleRightCommonServiceImpl;
import dream.first.core.platform.service.manage.ModuleServiceManager;
import dream.first.core.platform.service.manage.SimpleModuleServiceManager;
import dream.first.core.platform.service.service.ModuleServiceCommonService;
import dream.first.core.platform.service.service.ModuleServiceInterfaceCommonService;
import dream.first.core.platform.service.service.impl.ModuleServiceCommonServiceImpl;
import dream.first.core.platform.service.service.impl.ModuleServiceInterfaceCommonServiceImpl;
import dream.first.core.platform.user.service.UserCommonService;
import dream.first.core.platform.user.service.UserExtraOrgCommonService;
import dream.first.core.platform.user.service.UserExtraOrgRoleCommonService;
import dream.first.core.platform.user.service.UserRightCommonService;
import dream.first.core.platform.user.service.UserRoleCommonService;
import dream.first.core.platform.user.service.impl.UserCommonServiceImpl;
import dream.first.core.platform.user.service.impl.UserExtraOrgCommonServiceImpl;
import dream.first.core.platform.user.service.impl.UserExtraOrgRoleCommonServiceImpl;
import dream.first.core.platform.user.service.impl.UserRightCommonServiceImpl;
import dream.first.core.platform.user.service.impl.UserRoleCommonServiceImpl;

/**
 * 平台服务配置
 * 
 * 这些服务默认情况下是注入的
 * 
 * @since 1.0.0
 */
@ConditionalOnProperty(prefix = DreamFirstPlatformConfiguration.DREAM_FIRST_PROPERTIES_PREFIX, name = "auto", havingValue = "true", matchIfMissing = true)
public class DreamFirstPlatformConfiguration {

	public static final String DREAM_FIRST_PROPERTIES_PREFIX = DreamFirstCore.DREAM_FIRST_PROPERTIES_PREFIX
			+ ".platform";

	// ===========================字典============================

	/**
	 * @return 字典服务
	 */
	@Bean
	@ConditionalOnMissingBean(DictCommonService.class)
	public DictCommonService dictService(DreamFirstModelService modelService) {
		return new DictCommonServiceImpl(modelService);
	}

	/**
	 * @param dictCommonService 字典公共服务
	 * @return 字典管理管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = DictManager.class)
	public DictManager dictManager(DictCommonService dictCommonService) {
		return new SimpleDictManager(dictCommonService);
	}

	// ===========================图标============================

	/**
	 * @return 图标管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = IconCommonService.class)
	public IconCommonService iconCommonService(DreamFirstModelService modelService) {
		return new IconCommonServiceImpl(modelService);
	}

	/**
	 * @return 图标管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = IconManager.class)
	public IconManager iconManager(IconCommonService iconCommonService) {
		return new SimpleIconManager(iconCommonService);
	}

	// ===========================模块============================

	/**
	 * @return 模块服务
	 */
	@Bean
	@ConditionalOnMissingBean(ModuleCommonService.class)
	public ModuleCommonService moduleService(DreamFirstModelService modelService) {
		return new ModuleCommonServiceImpl(modelService);
	}

	/**
	 * @param moduleCommonService 模块公共服务
	 * @return 模块管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = ModuleManager.class)
	public ModuleManager moduleManager(ModuleCommonService moduleCommonService) {
		return new SimpleModuleManager(moduleCommonService);
	}

	// ===========================组织============================

	/**
	 * @return 组织服务
	 */
	@Bean
	@ConditionalOnMissingBean(OrgCommonService.class)
	public OrgCommonService orgService(DreamFirstModelService modelService) {
		return new OrgCommonServiceImpl(modelService);
	}

	/**
	 * @param orgCommonService 组织公共服务
	 * @return 组织管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = OrgManager.class)
	public OrgManager orgManager(OrgCommonService orgCommonService) {
		return new SimpleOrgManager(orgCommonService);
	}

	// ===========================角色============================

	/**
	 * @return 角色数据权限
	 */
	@Bean
	@ConditionalOnMissingBean(RoleDataRightCommonService.class)
	public RoleDataRightCommonService roleDataRightService(DreamFirstModelService modelService) {
		return new RoleDataRightCommonServiceImpl(modelService);
	}

	/**
	 * @return 角色权限
	 */
	@Bean
	@ConditionalOnMissingBean(RoleRightCommonService.class)
	public RoleRightCommonService roleRightCommonService(DreamFirstModelService modelService) {
		return new RoleRightCommonServiceImpl(modelService);
	}

	/**
	 * @return 角色服务
	 */
	@Bean
	@ConditionalOnMissingBean(RoleCommonService.class)
	public RoleCommonService roleService(DreamFirstModelService modelService, RoleRightCommonService roleRightService,
			RoleDataRightCommonService roleDataRightService) {
		return new RoleCommonServiceImpl(modelService, roleRightService, roleDataRightService);
	}

	// ===========================用户============================

	/**
	 * @return 用户组织角色权限
	 */
	@Bean
	@ConditionalOnMissingBean(UserExtraOrgRoleCommonService.class)
	public UserExtraOrgRoleCommonService userExtraOrgRoleService(DreamFirstModelService modelService) {
		return new UserExtraOrgRoleCommonServiceImpl(modelService);
	}

	/**
	 * @return 用户组织权限
	 */
	@Bean
	@ConditionalOnMissingBean(UserExtraOrgCommonService.class)
	public UserExtraOrgCommonService userExtraOrgService(DreamFirstModelService modelService) {
		return new UserExtraOrgCommonServiceImpl(modelService);
	}

	/**
	 * @return 用户权限
	 */
	@Bean
	@ConditionalOnMissingBean(UserRightCommonService.class)
	public UserRightCommonService userRightCommonService(DreamFirstModelService modelService) {
		return new UserRightCommonServiceImpl(modelService);
	}

	/**
	 * @return 用户角色
	 */
	@Bean
	@ConditionalOnMissingBean(UserRoleCommonService.class)
	public UserRoleCommonService userRoleService(DreamFirstModelService modelService) {
		return new UserRoleCommonServiceImpl(modelService);
	}

	/**
	 * @return 用户服务
	 */
	@Bean
	@ConditionalOnMissingBean(UserCommonService.class)
	public UserCommonService userCommonService(DreamFirstModelService modelService) {
		return new UserCommonServiceImpl(modelService);
	}

	// ===========================服务接口============================

	/**
	 * @return 模块接口服务
	 */
	@Bean
	@ConditionalOnMissingBean(ModuleServiceInterfaceCommonService.class)
	public ModuleServiceInterfaceCommonService moduleServiceInterfaceService(DreamFirstModelService modelService) {
		return new ModuleServiceInterfaceCommonServiceImpl(modelService);
	}

	/**
	 * @return 模块接口服务
	 */
	@Bean
	@ConditionalOnMissingBean(ModuleServiceCommonService.class)
	public ModuleServiceCommonService moduleServiceCommonService(DreamFirstModelService modelService) {
		return new ModuleServiceCommonServiceImpl(modelService);
	}

	/**
	 * @param moduleServiceCommonService          模块服务公共服务
	 * @param moduleServiceInterfaceCommonService 模块服务接口公共服务
	 * @return 模块服务管理器
	 */
	@Bean
	@ConditionalOnMissingBean(value = ModuleServiceManager.class)
	public ModuleServiceManager moduleServiceManager(ModuleServiceCommonService moduleServiceCommonService,
			ModuleServiceInterfaceCommonService moduleServiceInterfaceCommonService) {
		return new SimpleModuleServiceManager(moduleServiceCommonService, moduleServiceInterfaceCommonService);
	}

	// ===========================登录============================

	/**
	 * @return 登录会话服务
	 */
	@Bean
	@ConditionalOnMissingBean(LoginSessionCommonService.class)
	public LoginSessionCommonService loginSessionCommonService(DreamFirstModelService modelService) {
		return new LoginSessionCommonServiceImpl(modelService);
	}

}
