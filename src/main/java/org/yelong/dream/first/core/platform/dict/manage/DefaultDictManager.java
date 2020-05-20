/**
 * 
 */
package org.yelong.dream.first.core.platform.dict.manage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang3.ArrayUtils;
import org.yelong.core.model.service.ModelService;
import org.yelong.dream.first.core.platform.dict.model.Dict;
import org.yelong.dream.first.core.platform.dict.service.DictCommonService;

/**
 * 默认的字典管理
 * 
 * @author PengFei
 * @since 1.0.0
 */
public class DefaultDictManager implements DictManager{

	@Resource
	private DictCommonService dictService;
	
	@Resource
	private ModelService modelService;
	
	private final List<Dict> dictList = new ArrayList<Dict>();
	
	@Override
	public List<Dict> get(String... dictTypes) {
		if( null == dictTypes) {
			return Collections.unmodifiableList(dictList);
		}
		return dictList.stream().filter(x->	ArrayUtils.contains(dictTypes, x.getDictType())).collect(Collectors.toList());
	}

	@Override
	public String getDictText(String dictType, String value) {
		Dict dict = get(dictType).stream().filter(x->x.getDictValue().equals(value)).findFirst().orElse(null);
		return null == dict ? null : dict.getDictText();
	}

	@Override
	@PostConstruct
	public synchronized void reload() {
		clear();
		reload((String[])null);
	}

	@Override
	public synchronized void reload(String... dictTypes) {
		if( null == dictTypes) {
			dictList.addAll(modelService.findAll(Dict.class));
		} else {
			dictList.addAll(dictService.findByDictTypes(dictTypes));
		}
	}

	@Override
	public synchronized void clear() {
		dictList.clear();
		
	}

	@Override
	public void addDict(Dict dict) {
		// TODO Auto-generated method stub
		
	}
	
	public DictCommonService getDictService() {
		return dictService;
	}
	
	public ModelService getModelService() {
		return modelService;
	}
	
	public void setDictService(DictCommonService dictService) {
		this.dictService = dictService;
	}
	
	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}
	
}