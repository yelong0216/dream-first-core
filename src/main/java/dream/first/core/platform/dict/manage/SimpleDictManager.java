/**
 * 
 */
package dream.first.core.platform.dict.manage;

import java.util.List;

import javax.annotation.Resource;

import dream.first.core.platform.dict.model.Dict;
import dream.first.core.platform.dict.service.DictCommonService;

/**
 * 简单的字典管理器
 * 
 * @since 2.0
 */
public class SimpleDictManager implements DictManager {

	@Resource
	protected final DictCommonService dictCommonService;

	public SimpleDictManager(DictCommonService dictCommonService) {
		this.dictCommonService = dictCommonService;
	}

	@Override
	public List<Dict> getAll() {
		return dictCommonService.findAll();
	}

	@Override
	public List<Dict> getByDictType(String dictType) {
		return dictCommonService.findByDictType(dictType);
	}

	@Override
	public List<Dict> getByDictTypes(String[] dictTypes) {
		return dictCommonService.findByDictTypes(dictTypes);
	}

	@Override
	public Dict getByDictTypeAndValue(String dictType, String dictValue) {
		return dictCommonService.findByDictTypeAndValue(dictType, dictValue);
	}

}
