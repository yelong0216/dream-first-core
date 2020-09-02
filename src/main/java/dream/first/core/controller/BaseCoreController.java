/**
 * 
 */
package dream.first.core.controller;

import org.yelong.core.annotation.Nullable;
import org.yelong.support.spring.mvc.controller.AbstractSpringMvcController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dream.first.core.gson.GsonSupplier;
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
public abstract class BaseCoreController extends AbstractSpringMvcController {

	/**
	 * 使用默认的Gson将对象转换转换为JSON
	 * 
	 * @param obj 对象
	 * @return JSON格式的字符串
	 * @see #getGson()
	 */
	protected String toJson(Object obj) {
		Gson gson = getGson();
		return gson.toJson(obj);
	}

	/**
	 * @return 默认的Gson
	 * @see GsonSupplier#getDefaultGson()
	 */
	protected Gson getGson() {
		return GsonSupplier.getDefaultGson();
	}

	/**
	 * @return 默认Gson构建器
	 * @see GsonSupplier#createGsonBuilder()
	 */
	protected GsonBuilder createDefaultGsonBuilder() {
		return GsonSupplier.createGsonBuilder();
	}

	// ==================================================当前登录/请求人信息==================================================

	/**
	 * @return 当前登录/请求人的相关信息
	 * @see CurrentLoginUserInfoHolder#currentLoginUserInfo()
	 */
	@Nullable
	protected CurrentLoginUserInfo getCurrentLoginUserInfo() {
		return CurrentLoginUserInfoHolder.currentLoginUserInfo();
	}

	/**
	 * @return 当前登录/请求人用户信息
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUser()
	 */
	@Nullable
	protected User getCurrentLoginUser() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUser();
	}

	/**
	 * @return 当前登录/请求人的用户名称(账号)
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUsername()
	 */
	@Nullable
	protected String getCurrentLoginUsername() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUsername();
	}

	/**
	 * @return 当前登录/请求人的用户真实名称
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserRealName()
	 */
	@Nullable
	protected String getCurrentLoginUserRealName() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserRealName();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserOrg()
	 */
	@Nullable
	protected Org getCurrentLoginUserOrg() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserOrg();
	}

	/**
	 * @return 当前登录/请求人的用户所有在部门的ID
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserOrgId()
	 */
	@Nullable
	protected String getCurrentLoginUserOrgId() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserOrgId();
	}

	/**
	 * @return 当前登录/请求人的用户所在部门的编号
	 * @see CurrentLoginUserInfoHolder#getCurrentLoginUserOrgNo()
	 */
	@Nullable
	protected String getCurrentLoginUserOrgNo() {
		return CurrentLoginUserInfoHolder.getCurrentLoginUserOrgNo();
	}

}
