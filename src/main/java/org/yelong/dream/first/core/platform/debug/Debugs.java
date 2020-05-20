/**
 * 
 */
package org.yelong.dream.first.core.platform.debug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yelong.commons.net.InetAddressUtils;
import org.yelong.core.model.service.ModelService;
import org.yelong.dream.first.core.platform.debug.model.Debug;

/**
 * debug 所用到的工具类
 * 这个类不参数业务，只是用来调试的。
 * 
 * @author PengFei
 * @since 1.0.0
 */
public final class Debugs {
	
	private Debugs() {}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Debugs.class);
	
	/**
	 * 插入一条debug记录
	 * @param modelService
	 * @param debugPeople 处理人
	 * @param debugDesc 描述
	 */
	public static final void insert(ModelService modelService ,String debugPeople ,  String debugDesc) {
		try {
			Debug debug = new Debug();
			debug.setDebugPeople(debugPeople);
			debug.setDebugDesc(debugDesc);
			debug.setCreateAddress(InetAddressUtils.getLocalHostAddress());
			modelService.saveSelective(debug);
		} catch (Exception e) {
			LOGGER.debug("创建debug记录异常",e);
		}
	}

}
