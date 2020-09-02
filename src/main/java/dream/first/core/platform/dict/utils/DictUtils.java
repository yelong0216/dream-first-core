/**
 * 
 */
package dream.first.core.platform.dict.utils;

import java.util.List;

import org.yelong.core.support.Dictionary;
import org.yelong.support.spring.ApplicationContextDecorator;

import dream.first.core.platform.dict.manage.DictManager;
import dream.first.core.platform.dict.model.Dict;

/**
 * 字典工具。这个工具类必须在Spring容器中使用
 * 
 * @see ApplicationContextDecorator
 * @see DictManager
 * @since 2.0
 */
public final class DictUtils {

	private DictUtils() {
	}

	/**
	 * 根据字典类型和字典值获取字典文本内容
	 * 
	 * @param dictType  字典类型
	 * @param dictValue 字典值
	 * @return 字典文本内容
	 * @see DictManager#getDictTextByDictTypeAndValue(String, String)
	 */
	public static String getDictText(String dictType, String dictValue) {
		return getDictManager().getDictTextByDictTypeAndValue(dictType, dictValue);
	}

	/**
	 * 根据字典类型和字典值获取字典文本内容
	 * 
	 * @param dictType     字典类型
	 * @param dictValue    字典值
	 * @param defaultValue 默认值。如果字典不存在则返回默认值
	 * @return 字典文本内容。如果字典不存在则返回默认值
	 * @see DictManager#getDictTextByDictTypeAndValue(String, String, String)
	 */
	public static String getDictText(String dictType, String dictValue, String defaultValue) {
		return getDictManager().getDictTextByDictTypeAndValue(dictType, dictValue, defaultValue);
	}

	/**
	 * 获取指定字典类型的字典实例
	 * 
	 * @param dictType 字典类型
	 * @return 字典
	 * @see DictManager#getDictionary(String)
	 */
	public static Dictionary<String, String, String> getDictionary(String dictType) {
		return getDictManager().getDictionary(dictType);
	}

	/**
	 * 将字典转换为“字典”
	 * 
	 * @param type  字典类型
	 * @param dicts 字典集合
	 * @return “字典”
	 * @see DictManager#toDictionary(String, List)
	 */
	public static Dictionary<String, String, String> toDictionary(String dictType, List<Dict> dicts) {
		return getDictManager().toDictionary(dictType, dicts);
	}

	private static DictManager getDictManager() {
		return ApplicationContextDecorator.getBean(DictManager.class);
	}

}
