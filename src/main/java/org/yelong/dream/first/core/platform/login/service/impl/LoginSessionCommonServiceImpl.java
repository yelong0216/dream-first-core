/**
 * 
 */
package org.yelong.dream.first.core.platform.login.service.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.yelong.commons.lang.Strings;
import org.yelong.core.jdbc.sql.condition.support.Condition;
import org.yelong.core.model.service.SqlModelService;
import org.yelong.core.model.sql.SqlModel;
import org.yelong.dream.first.core.platform.login.model.LoginSession;
import org.yelong.dream.first.core.platform.login.service.LoginSessionCommonService;
import org.yelong.mybatis.spring.BaseService;

/**
 * 登录会话服务
 * 
 * @author PengFei
 * @since 1.0.0
 */
@Service
public class LoginSessionCommonServiceImpl extends BaseService implements LoginSessionCommonService{

	@Resource
	private SqlModelService modelService;
	
	@Override
	public LoginSession getByUsername(String username) {
		if(StringUtils.isBlank(username)) {
			return null;
		}
		SqlModel sqlModel = new SqlModel(LoginSession.class);
		sqlModel.addCondition(new Condition("username", "=", username));
		return modelService.findFirstBySqlModel(LoginSession.class, sqlModel);
	}

	@Override
	public void saveOverrideUsername(LoginSession loginSession) {
		Objects.requireNonNull(loginSession);
		Strings.requireNonBlank(loginSession.getUsername());
		SqlModel sqlModel = new SqlModel(LoginSession.class);
		sqlModel.addCondition(new Condition("username", "=", loginSession.getUsername()));
		modelService.removeBySqlModel(LoginSession.class, sqlModel);
		modelService.saveSelective(loginSession);
	}

}
