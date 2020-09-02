/**
 * 
 */
package dream.first.core.platform.user;

import dream.first.core.platform.user.model.User;

/**
 * 
 * 用户工具类
 * 
 * @since 1.0.8
 */
public final class Users {

	private Users() {
	}

	/**
	 * 超级用户
	 */
	public static final String IS_SUPER_VALUE = "1";

	/**
	 * 是否是超级管理员
	 * 
	 * @param user 用户
	 * @return <tt>true</tt> 是超级管理员
	 */
	public static boolean isSuper(User user) {
		if (null == user) {
			return false;
		}
		return IS_SUPER_VALUE.equals(user.getIsSuper());
	}

}
