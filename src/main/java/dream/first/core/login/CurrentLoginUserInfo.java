/**
 * 
 */
package dream.first.core.login;

import dream.first.base.userauth.CurrentAuthUserInfo;
import dream.first.core.platform.org.model.Org;
import dream.first.core.platform.user.model.User;

/**
 * 当前登录（发送请求）的用户信息
 * 
 * @since 1.0.0
 */
public class CurrentLoginUserInfo extends CurrentAuthUserInfo<User, Org> {

	private static final long serialVersionUID = -4109346450125322854L;

}
