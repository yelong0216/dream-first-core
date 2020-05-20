/**
 * 
 */
package org.yelong.dream.first.core.platform.dict.utils;

import java.util.List;

import org.yelong.dream.first.core.platform.dict.model.Dict;
import org.yelong.dream.first.core.platform.dict.service.DictCommonService;
import org.yelong.support.spring.ApplicationContextDecorator;

/**
 * 字典工具
 * 
 * @author PengFei
 * @since 1.0.0
 */
public class DictUtils {
	
	/**
	 * 获取指定字典类型值的文本
	 * @date 2019年12月19日下午3:18:17
	 * @param dictType 字典类型
	 * @param value 值
	 * @return 字典文本
	 */
	public static final String getDictText(String dictType,String value) {
		//return ApplicationContextDecorator.getBean(DictManager.class).getDictText(dictType, value);
		List<Dict> dictList = ApplicationContextDecorator.getBean(DictCommonService.class).findByDictType(dictType);
		Dict dict = dictList.stream().filter(x->x.getDictValue().equals(value)).findFirst().orElse(null);
		return null == dict ? null : dict.getDictText();
	}
	
}
