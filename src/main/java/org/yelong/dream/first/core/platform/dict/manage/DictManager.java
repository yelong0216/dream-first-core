/**
 * 
 */
package org.yelong.dream.first.core.platform.dict.manage;

import java.util.List;

import org.yelong.core.annotation.Nullable;
import org.yelong.dream.first.core.platform.dict.model.Dict;

/**
 * 字典管理
 * 防止频繁访问数据库，由此类管理字典。
 * 
 * @author PengFei
 * @since 1.0.0
 */
public interface DictManager {

	/**
	 * 获取指定字典类型的字典
	 * @param dictTypes 字典类型
	 * @return 该字典类型的所有字典对象
	 */
	List<Dict> get(String ... dictTypes);
	
	/**
	 * 获取指定字典类型值对应的文本
	 * @param dictType 字典类型
	 * @param value 字典值
	 * @return 字典值对应的文本他
	 */
	@Nullable
	String getDictText(String dictType , String value);
	
	/**
	 * 重新加载字典。这将清空当前管理的字典并从数据库中加载字典。
	 */
	void reload();
	
	/**
	 * 重新加载字典。这将清空当前管理的字典并从数据库中加载字典。
	 * @param dictTypes 指定加载字典的类型。为空则加载所有字典
	 */
	void reload(@Nullable String ... dictTypes);
	
	/**
	 * 清空当前管理的字典
	 */
	void clear();
	
	/**
	 * 添加一个字典。且这个字典将添加到数据库中
	 * @param dict 
	 */
	void addDict(Dict dict);
	
}
