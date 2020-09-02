/**
 * 
 */
package dream.first.core.handler.interceptor;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 默认的拦截器配置
 * 
 * @since 1.0
 */
public class DefaultInterceptorConfiguration implements WebMvcConfigurer {

	@Resource
	private List<HandlerInterceptor> interceptors;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		for (HandlerInterceptor handlerInterceptor : interceptors) {
			InterceptorRegistration interceptor = registry.addInterceptor(handlerInterceptor);
			interceptor.addPathPatterns("/**");
			// 排除不拦截的
			interceptor.excludePathPatterns();
		}
	}

}
