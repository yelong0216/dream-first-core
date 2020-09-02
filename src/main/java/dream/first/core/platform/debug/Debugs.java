/**
 * 
 */
package dream.first.core.platform.debug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.yelong.commons.net.InetAddressUtils;
import org.yelong.core.model.service.ModelService;
import org.yelong.support.spring.ApplicationContextDecorator;

import dream.first.core.DreamFirstCore;
import dream.first.core.platform.debug.model.Debug;

/**
 * debug 所用到的工具类 这个类不参与业务，只是用来调试的。
 * 
 * @since 1.0.0
 */
public final class Debugs {

	private Debugs() {
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(Debugs.class);

	public static final String DEBUG_PROPERTE_NAEM = DreamFirstCore.DREAM_FIRST_PROPERTIES_PREFIX + ".platform.debug";

	/**
	 * 插入一条debug记录
	 * 
	 * @param modelService model service
	 * @param debugPeople  处理人
	 * @param debugDesc    描述
	 */
	public static void insert(ModelService modelService, String debugPeople, String debugDesc) {
		if (!isDebug()) {
			return;
		}
		try {
			Debug debug = new Debug();
			debug.setDebugPeople(debugPeople);
			debug.setDebugDesc(debugDesc);
			debug.setCreateAddress(InetAddressUtils.getLocalHostAddress());
			modelService.saveSelective(debug);
		} catch (Exception e) {
			LOGGER.debug("创建debug记录异常", e);
		}
	}

	/**
	 * 是需要调试
	 * 
	 * @return <code>true</code> 需要调试
	 * @see ApplicationContextDecorator
	 * @see ApplicationContext
	 * @see Environment
	 */
	public static boolean isDebug() {
		Environment environment = ApplicationContextDecorator.getEnvironment();
		return environment.getProperty(DEBUG_PROPERTE_NAEM, Boolean.class, false);
	}

}
