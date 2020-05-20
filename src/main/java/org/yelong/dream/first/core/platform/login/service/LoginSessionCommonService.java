/**
 * 
 */
package org.yelong.dream.first.core.platform.login.service;

import org.yelong.dream.first.core.platform.login.model.LoginSession;

/**
 * 登录会话公共服务
 * 
 * @author PengFei
 * @since 1.0.0
 */
public interface LoginSessionCommonService {
	
	/**
	 * 根据用户名称获取第一个用户登录的会话信息
	 * @param username 用户名
	 * @return 用户登录的会话信息
	 */
	LoginSession getByUsername(String username);
	
	/**
	 * 保存用户的登录会话信息并且覆盖之前的用户登录的会话信息
	 * @param loginSession 用户登录的会话信息
	 */
	void saveOverrideUsername(LoginSession loginSession);
	
}
