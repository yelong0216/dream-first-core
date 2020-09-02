/**
 * 
 */
package dream.first.core.utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import dream.first.core.login.CurrentLoginUserInfo;
import dream.first.core.login.CurrentLoginUserInfoHolder;
import dream.first.core.platform.user.Users;
import dream.first.core.platform.user.model.User;

/**
 * 权限认证工具类
 * 
 * @since 1.0
 */
public final class AuthUtils {

	private AuthUtils() {
	}

	/**
	 * 判断登录用户是否拥有该模块的权限。登录用户为超级管理员时返回true
	 * 
	 * @param moduleId 模块ID
	 * @return <code>true</code> 存在该模块的权限
	 */
	public static boolean hasOpRight(String moduleId) {
		if (StringUtils.isBlank(moduleId)) {
			return false;
		}
		CurrentLoginUserInfo currentLoginUserInfo = CurrentLoginUserInfoHolder.currentLoginUserInfo();
		if (null == currentLoginUserInfo) {
			return false;
		}
		// 如果为超级管理员则不用验证权限
		User user = currentLoginUserInfo.getUser();
		if (null == user) {
			return false;
		}
		if (Users.isSuper(user)) {
			return true;
		}
		// 验证用户是否拥有该模块的权限
		List<String> opRights = currentLoginUserInfo.getOpRights();
		return opRights.contains(moduleId);
	}
}
