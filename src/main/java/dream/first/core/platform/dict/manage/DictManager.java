package dream.first.core.platform.dict.manage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.yelong.core.annotation.Nullable;
import org.yelong.core.support.Dictionary;

import dream.first.core.platform.dict.model.Dict;

/**
 * 字典管理器
 * 
 * @since 2.0
 */
public interface DictManager {

	/**
	 * @return 所有的字典
	 */
	@Nullable
	List<Dict> getAll();

	/**
	 * 获取指定字典类型的所有字典
	 * 
	 * @param dictType 字典类型
	 * @return 指定字典类型的所有字典
	 */
	@Nullable
	List<Dict> getByDictType(String dictType);

	/**
	 * 获取指定多个字典类型的所有字典
	 * 
	 * @param dictTypes 字典类型数组
	 * @return 指定的所有字典类型的字典集合
	 */
	@Nullable
	List<Dict> getByDictTypes(String[] dictTypes);

	/**
	 * 获取指定字典类型的字典实例
	 * 
	 * @param dictType 字典类型
	 * @return 字典
	 */
	default Dictionary<String, String, String> getDictionary(String dictType) {
		return toDictionary(dictType, getByDictType(dictType));
	}

	/**
	 * 获取多个字典类型的字典映射
	 * 
	 * @param dictTypes 字典类型数组
	 * @return 字典映射
	 */
	@Nullable
	default Map<String, Dictionary<String, String, String>> getDictionarys(String[] dictTypes) {
		List<Dict> dicts = getByDictTypes(dictTypes);
		Map<String, List<Dict>> dictGroups = dicts.stream().collect(Collectors.groupingBy(Dict::getDictType));
		Map<String, Dictionary<String, String, String>> dictionaryMap = new LinkedHashMap<String, Dictionary<String, String, String>>(
				dictGroups.size());
		dictGroups.forEach((k, v) -> dictionaryMap.put(k, toDictionary(k, v)));
		return dictionaryMap;
	}

	/**
	 * 根据字典类型和字典值获取字典
	 * 
	 * @param dictType  字典类型
	 * @param dictValue 字典值
	 * @return 字典
	 */
	@Nullable
	Dict getByDictTypeAndValue(String dictType, String dictValue);

	/**
	 * 根据字典类型和字典值获取字典文本内容
	 * 
	 * @param dictType  字典类型
	 * @param dictValue 字典值
	 * @return 字典文本内容
	 */
	@Nullable
	default String getDictTextByDictTypeAndValue(String dictType, String dictValue) {
		Dict dict = getByDictTypeAndValue(dictType, dictValue);
		return null == dict ? null : dict.getDictText();
	}

	/**
	 * 根据字典类型和字典值获取字典文本内容
	 * 
	 * @param dictType     字典类型
	 * @param dictValue    字典值
	 * @param defaultValue 默认值。如果字典不存在则返回默认值
	 * @return 字典文本内容。如果字典不存在则返回默认值
	 */
	@Nullable
	default String getDictTextByDictTypeAndValue(String dictType, String dictValue, String defaultValue) {
		String dictText = getDictTextByDictTypeAndValue(dictType, dictValue);
		return null == dictText ? defaultValue : dictText;
	}

	/**
	 * 将字典转换为“字典”
	 * 
	 * @param type  字典类型
	 * @param dicts 字典集合
	 * @return “字典”
	 */
	default Dictionary<String, String, String> toDictionary(String type, List<Dict> dicts) {
		return Dictionary.build(type, dicts);
	}

}
