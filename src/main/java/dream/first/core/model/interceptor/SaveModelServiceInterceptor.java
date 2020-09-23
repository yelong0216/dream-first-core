/**
 * 
 */
package dream.first.core.model.interceptor;

import java.util.Date;

import org.yelong.commons.util.Dates;
import org.yelong.core.interceptor.Intercepts;
import org.yelong.core.interceptor.Invocation;
import org.yelong.core.interceptor.Signature;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.service.ModelService;
import org.yelong.core.model.service.ModelServiceInterceptor;

import dream.first.core.login.CurrentLoginUserInfo;
import dream.first.core.login.CurrentLoginUserInfoHolder;
import dream.first.core.model.BaseModelable;
import dream.first.core.platform.constants.State;
import dream.first.core.utils.IDUtils;

/**
 * 模型保存拦截器。模型保存时默认修改模型的创建人、创建时间等数据。
 * 
 * @since 2.0
 */
@Intercepts({ @Signature(type = ModelService.class, method = "save", args = Modelable.class),
		@Signature(type = ModelService.class, method = "saveSelective", args = Modelable.class) })
public class SaveModelServiceInterceptor implements ModelServiceInterceptor {

	public static final String SYSTEM_ADMIN_USER_NAME = "system";

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		Object model = args[0];
		if (model instanceof BaseModelable) {
			BaseModelable baseModelable = (BaseModelable) model;
			baseModelable.setId(IDUtils.getUUID());
			Date createTime = Dates.nowDate();
			baseModelable.setCreateTime(createTime);
			baseModelable.setUpdateTime(createTime);
			baseModelable.setState(State.YES.getCode());
			String userName = SYSTEM_ADMIN_USER_NAME;
			CurrentLoginUserInfo currentLoginUserInfo = CurrentLoginUserInfoHolder.currentLoginUserInfo();
			if (null != currentLoginUserInfo) {
				if (null != currentLoginUserInfo.getUser()) {
					userName = currentLoginUserInfo.getUser().getUsername();
				}
			}
			baseModelable.setCreator(userName);
			baseModelable.setUpdator(userName);
		}
		return invocation.proceed();
	}

}
