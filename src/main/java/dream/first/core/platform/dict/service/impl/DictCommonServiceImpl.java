/**
 * 
 */
package dream.first.core.platform.dict.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.model.collector.ModelCollectors;
import org.yelong.mybatis.spring.BaseService;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.dict.model.Dict;
import dream.first.core.platform.dict.service.DictCommonService;

/**
 * 字典公共服务的默认实现
 * 
 * @since 1.0
 */
public class DictCommonServiceImpl extends BaseService implements DictCommonService {

	private final DreamFirstModelService modelService;

	public DictCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public List<Dict> findAll() {
		return modelService.findAll(Dict.class);
	}

	@Override
	public List<Dict> findByDictType(String dictType) {
		return modelService.collect(ModelCollectors.findBySingleColumnEQ(Dict.class, "dictType", dictType));
	}

	@Override
	public List<Dict> findByDictTypes(String[] dictTypes) {
		return modelService.collect(ModelCollectors.findBySingleColumnContains(Dict.class, "dictType", dictTypes));
	}

	@Override
	public Dict findByDictTypeAndValue(String dictType, String dictValue) {
		if (StringUtils.isBlank(dictType)) {
			return null;
		}
		if (StringUtils.isBlank(dictValue)) {
			return null;
		}
		Dict sqlModel = new Dict();
		sqlModel.setDictType(dictType);
		sqlModel.setDictValue(dictValue);
		return modelService.findFirstBySqlModel(Dict.class, sqlModel);
	}

}
