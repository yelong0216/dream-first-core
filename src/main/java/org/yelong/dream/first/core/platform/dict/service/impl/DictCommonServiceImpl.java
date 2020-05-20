/**
 * 
 */
package org.yelong.dream.first.core.platform.dict.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.yelong.core.model.service.SqlModelService;
import org.yelong.core.model.sql.SqlModel;
import org.yelong.dream.first.core.platform.dict.model.Dict;
import org.yelong.dream.first.core.platform.dict.service.DictCommonService;
import org.yelong.mybatis.spring.BaseService;

/**
 * 字典公共服务的默认实现
 * 
 * @author PengFei
 * @since 1.0.0
 */
public class DictCommonServiceImpl extends BaseService implements DictCommonService{
	
	@Resource
	private SqlModelService modelService;
	
	@Override
	public List<Dict> findByDictType(String dictType){
		Dict sqlDict = new Dict();
		sqlDict.setDictType(dictType);
		return modelService.findBySqlModel(Dict.class,sqlDict);
	}

	@Override
	public List<Dict> findByDictTypes(String[] dictTypes){
		SqlModel sqlModel = new SqlModel(Dict.class);
		sqlModel.addExtendAttribute("dictType", Arrays.asList((Object[])dictTypes));
		sqlModel.addConditionOperator("dictType", "IN");
		return modelService.findBySqlModel(Dict.class, sqlModel);
	}
	
}
