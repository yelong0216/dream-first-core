/**
 * 
 */
package dream.first.core.login;

import org.yelong.core.annotation.Nullable;

import dream.first.core.platform.org.model.Org;
import dream.first.core.platform.user.model.User;

/**
 * 当前登录（请求）用户{@link CurrentLoginUserInfo}的持有者
 * 
 * @since 1.0.0
 */
public final class CurrentLoginUserInfoHolder {

	private CurrentLoginUserInfoHolder() {
	}

	private static final ThreadLocal<CurrentLoginUserInfo> CURRENT_LOGIN_USER_INFO = new ThreadLocal<>();

	/**
	 * 设置当前登录（请求）用户的信息
	 * 
	 * @param currentLoginUserInfo 当前登录（请求）用户的信息
	 */
	public static void setCurrentLoginUserInfo(CurrentLoginUserInfo currentLoginUserInfo) {
		CURRENT_LOGIN_USER_INFO.set(currentLoginUserInfo);
	}

	/**
	 * @return 当前登录（请求）用户的信息
	 */
	@Nullable
	public static CurrentLoginUserInfo currentLoginUserInfo() {
		return CURRENT_LOGIN_USER_INFO.get();
	}

	/**
	 * @return 当前登录/请求人的相关信息
	 * @see #currentLoginUserInfo()
	 */
	@Nullable
	public static CurrentLoginUserInfo getCurrentLoginUserInfo() {
		return currentLoginUserInfo();
	}

	/**
	 * @return 当前登录/请求人用户信息
	 */
	@Nullable
	public static User getCurrentLoginUser() {
		CurrentLoginUserInfo currentLoginUserInfo = getCurrentLoginUserInfo();
		return null == currentLoginUserInfo ? null : currentLoginUserInfo.getUser();
	}

	/**
	 * @return 当前登录/请求人的用户名称(账号)
	 */
	@Nullable
	public static String getCurrentLoginUsername() {
		User user = getCurrentLoginUser();
		return null == user ? null : user.getUsername();
	}

	/**
	 * @return 当前登录/请求人的用户真实名称
	 */
	@Nullable
	public static String getCurrentLoginUserRealName() {
		User user = getCurrentLoginUser();
		return null == user ? null : user.getRealName();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门
	 */
	@Nullable
	public static Org getCurrentLoginUserOrg() {
		CurrentLoginUserInfo currentLoginUserInfo = getCurrentLoginUserInfo();
		return null == currentLoginUserInfo ? null : currentLoginUserInfo.getOrg();
	}

	/**
	 * @return 当前登录/请求人的用户所有在部门的ID
	 */
	@Nullable
	public static String getCurrentLoginUserOrgId() {
		Org org = getCurrentLoginUserOrg();
		return null == org ? null : org.getId();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门的编号
	 */
	@Nullable
	public static String getCurrentLoginUserOrgNo() {
		Org org = getCurrentLoginUserOrg();
		return null == org ? null : org.getOrgNo();
	}

}
