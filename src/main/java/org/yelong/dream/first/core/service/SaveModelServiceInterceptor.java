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
import org.yelong.dream.first.core.utils.IDUtils;

/**
 * @author 14308
 *
 */
@Intercepts({
		@Signature(type = ModelService.class,method = "save",args = Modelable.class),
		@Signature(type = ModelService.class,method = "saveSelective",args = Modelable.class)
})
public class SaveModelServiceInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		Object model = args[0];
		if( model instanceof BaseModelable ) {
			BaseModelable baseModelable = (BaseModelable) model;
			baseModelable.setId(IDUtils.getUUID());
			Date createTime = Dates.nowDate();
			baseModelable.setCreateTime(createTime);
			baseModelable.setCreator("yelong");
			baseModelable.setState(State.YES.getCode());
			baseModelable.setUpdateTime(createTime);
			baseModelable.setUpdator("yelong");
		}
		return invocation.proceed();
	}

}
