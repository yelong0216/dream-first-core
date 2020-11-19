/**
 * 
 */
package dream.first.core.controller;

import org.yelong.core.annotation.Nullable;

import dream.first.base.controller.DreamFirstBaseCoreController;
import dream.first.base.userauth.CurrentAuthUserInfoHolder;
import dream.first.core.login.CurrentLoginUserInfo;
import dream.first.core.login.CurrentLoginUserInfoHolder;
import dream.first.core.platform.org.model.Org;
import dream.first.core.platform.user.model.User;

/**
 * 基础的 controller
 * 
 * 提供默认的JSON转换，获取当前登陆人等公共且常用的方法
 * 
 * @since 1.0.0
 */
public abstract class BaseCoreController extends DreamFirstBaseCoreController {

	/**
	 * @return 当前登录/请求人的相关信息
	 * @see CurrentLoginUserInfoHolder#currentLoginUserInfo()
	 */
	@Nullable
	public CurrentLoginUserInfo getCurrentLoginUserInfo() {
		return CurrentLoginUserInfoHolder.currentLoginUserInfo();
	}

	/**
	 * @return 当前登录/请求人用户信息
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUser()
	 */
	@Nullable
	public User getCurrentLoginUser() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUser();
	}
	
	/**
	 * @return 当前登录/请求人用户信息
	 * @see CurrentAuthUserInfoHolder#getCurrentLoginUserId()
	 */
	@Nullable
	public String getCurrentLoginUserId() {
		return CurrentAuthUserInfoHolder.getCurrentLoginUserId();
	}

	/**
	 * @return 当前登录/请求人的用户名称(账号)
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUsername()
	 */
	@Nullable
	public String getCurrentLoginUsername() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUsername();
	}

	/**
	 * @return 当前登录/请求人的用户真实名称
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserRealName()
	 */
	@Nullable
	public String getCurrentLoginUserRealName() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserRealName();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserOrg()
	 */
	@Nullable
	public Org getCurrentLoginUserOrg() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserOrg();
	}

	/**
	 * @return 当前登录/请求人的用户所有在部门的ID
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserOrgId()
	 */
	@Nullable
	public String getCurrentLoginUserOrgId() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserOrgId();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门的编号
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserOrgNo()
	 */
	@Nullable
	public String getCurrentLoginUserOrgNo() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserOrgNo();
	}

}
