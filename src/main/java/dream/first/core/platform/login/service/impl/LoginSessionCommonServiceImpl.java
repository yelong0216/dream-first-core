/**
 * 
 */
package dream.first.core.platform.login.service.impl;

import java.util.Objects;

import org.yelong.commons.lang.Strings;
import org.yelong.core.model.collector.ModelCollectors;
import org.yelong.mybatis.spring.BaseService;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.login.model.LoginSession;
import dream.first.core.platform.login.service.LoginSessionCommonService;

/**
 * 登录会话服务
 * 
 * @since 1.0.0
 */
public class LoginSessionCommonServiceImpl extends BaseService implements LoginSessionCommonService {

	protected final DreamFirstModelService modelService;

	public LoginSessionCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public LoginSession getByUsername(String username) {
		return modelService.collect(ModelCollectors.getModelBySingleColumnEQ(LoginSession.class, "username", username));
	}

	@Override
	public void saveOverrideUsername(LoginSession loginSession) {
		Objects.requireNonNull(loginSession);
		Strings.requireNonBlank(loginSession.getUsername());
		modelService.collect(
				ModelCollectors.removeBySingleColumnEQ(LoginSession.class, "username", loginSession.getUsername()));
		modelService.saveSelective(loginSession);
	}

}
