/**
 * 
 */
package dream.first.core.platform.module.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.model.collector.ModelCollectors;
import org.yelong.core.model.service.SqlModelService;

import dream.first.core.platform.module.model.Module;

/**
 * 模块工具类
 * 
 * @since 1.0.0
 */
public final class ModuleUtils {

	private ModuleUtils() {
	}

	/**
	 * 根据请求获取模块对象 根据请求源路径获取
	 * 
	 * @param request      请求
	 * @param modelService model service
	 * @return 返回请求对应的模块 如果该请求没有对应的模块则返回null
	 */
	public static Module getModule(HttpServletRequest request, SqlModelService modelService) {
		return getModule(request, modelService, false);
	}

	/**
	 * 根据请求获取模块对象 根据请求源路径获取，
	 * 
	 * @param request               请求
	 * @param modelService          model service
	 * @param parentModuleRecursive <tt>true</tt>父级递归。根据请求的路径层级进行查找
	 * @return 返回请求对应的模块 如果该请求没有对应的模块则返回null
	 */
	public static Module getModule(HttpServletRequest request, SqlModelService modelService,
			boolean parentModuleRecursive) {
		String requestUri = request.getRequestURI();
		Module module = getModuleByRequestUri(requestUri, modelService);
		if (!parentModuleRecursive) {
			return module;
		}
		if (null == module) {
			while (true) {
				String superRequestUri = getUrlSuperstratumUrl(requestUri);
				if (superRequestUri.equals(requestUri)) {
					break;
				}
				if (StringUtils.isBlank(requestUri) || StringUtils.isBlank(superRequestUri)) {
					break;
				}
				requestUri = superRequestUri;
				module = getModuleByRequestUri(superRequestUri, modelService);
				if (null != module) {
					break;
				}

			}
		}
		return module;
	}

	private static Module getModuleByRequestUri(String requestUri, SqlModelService modelService) {
		return modelService
				.collect(ModelCollectors.getModelBySingleColumnEQ(Module.class, "moduleSourceUrl", requestUri));
	}

	/**
	 * 返回这个url的上层url。如果这个url已经是最上层，则返回本身
	 * 
	 * @param url
	 * @return url的上层url
	 */
	private static String getUrlSuperstratumUrl(String url) {
		int index = url.lastIndexOf("/");
		if (index == -1) {
			return url;
		}
		return url.substring(0, index);
	}

}
