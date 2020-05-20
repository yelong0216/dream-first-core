/**
 * 
 */
package org.yelong.dream.first.core.login;

/**
 * 当前登录（请求）用户{@link CurrentLoginUserInfo}的持有者
 * 
 * @author PengFei
 * @since 1.0.0
 */
public final class CurrentLoginUserInfoHolder {

	private CurrentLoginUserInfoHolder() {}
	
	private static final ThreadLocal<CurrentLoginUserInfo> CURRENT_LOGIN_USER_INFO = 
			new ThreadLocal<>();

	/**
	 * 设置当前登录（请求）用户的信息
	 * @param currentLoginUserInfo 当前登录（请求）用户的信息
	 */
	public static void setCurrentLoginUserInfo(CurrentLoginUserInfo currentLoginUserInfo) {
		CURRENT_LOGIN_USER_INFO.set(currentLoginUserInfo);
	}

	/**
	 * 获取当前登录（请求）用户的信息
	 * @return 当前登录（请求）用户的信息
	 */
	public static CurrentLoginUserInfo currentLoginUserInfo() {
		return CURRENT_LOGIN_USER_INFO.get();
	}
	
}
