/**
 * 
 */
package org.yelong.dream.first.core.platform.dict.service;

import java.sql.SQLException;
import java.util.List;

import org.yelong.dream.first.core.platform.dict.model.Dict;

/**
 * 字典公共服务
 * 
 * @author PengFei
 * @since 1.0.0
 */
public interface DictCommonService {

	/**
	 * 根据字典类型查询符合条件的数据
	 * @param dictType 字典类型
	 * @return 该字典类型的字典
	 */
	List<Dict> findByDictType(String dictType);
	
	
	/**
	 * 根据字典类型查询符合条件的数据
	 * @param dictTypes 字典类型数组
	 * @return 符合字典类型的字典
	 * @throws SQLException
	 */
	List<Dict> findByDictTypes(String [] dictTypes);
	
}
