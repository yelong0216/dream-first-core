/**
 * 
 */
package org.yelong.dream.first.core.service;

import java.util.Date;

import org.yelong.commons.util.Dates;
import org.yelong.core.interceptor.Interceptor;
import org.yelong.core.interceptor.Intercepts;
import org.yelong.core.interceptor.Invocation;
import org.yelong.core.interceptor.Signature;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.service.ModelService;
import org.yelong.dream.first.core.model.BaseModelable;
import org.yelong.dream.first.core.platform.constants.State;

/**
 * @author PengFei
 *
 */
@Intercepts({
	@Signature(type = ModelService.class,method = "modifyById",args = Modelable.class),
	@Signature(type = ModelService.class,method = "modifySelectiveById",args = Modelable.class)
})
public class ModifyModelServiceInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		Object model = args[0];
		if( model instanceof BaseModelable ) {
			BaseModelable baseModelable = (BaseModelable) model;
			Date createTime = Dates.nowDate();
			baseModelable.setState(State.YES.getCode());
			baseModelable.setUpdateTime(createTime);
			baseModelable.setUpdator("yelong");
		}
		return invocation.proceed();
	}

}
