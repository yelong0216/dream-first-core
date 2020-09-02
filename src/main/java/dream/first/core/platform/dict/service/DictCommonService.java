/**
 * 
 */
package dream.first.core.platform.dict.service;

import java.util.List;

import dream.first.core.platform.dict.model.Dict;

/**
 * 字典公共服务
 * 
 * @since 1.0
 */
public interface DictCommonService {

	/**
	 * @return 所有的字典
	 */
	List<Dict> findAll();

	/**
	 * 根据字典类型查询符合条件的数据
	 * 
	 * @param dictType 字典类型
	 * @return 该字典类型的字典
	 */
	List<Dict> findByDictType(String dictType);

	/**
	 * 根据字典类型查询符合条件的数据
	 * 
	 * @param dictTypes 字典类型数组
	 * @return 符合字典类型的字典
	 */
	List<Dict> findByDictTypes(String[] dictTypes);

	/**
	 * 根据字典类型和字典值查询字典信息
	 * 
	 * @param dictType  字典类型
	 * @param dictValue 字典值
	 * @return 符合条件的字典
	 */
	Dict findByDictTypeAndValue(String dictType, String dictValue);

}
