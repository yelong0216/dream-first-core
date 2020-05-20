/**
 * 
 */
package org.yelong.dream.first.core.platform.service.service.impl;

import javax.annotation.Resource;

import org.yelong.core.model.service.SqlModelService;
import org.yelong.dream.first.core.platform.service.model.ModuleService;
import org.yelong.dream.first.core.platform.service.service.ModuleServiceCommonService;
import org.yelong.mybatis.spring.BaseService;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class ModuleServiceCommonServiceImpl extends BaseService implements ModuleServiceCommonService{

	@Resource
	private SqlModelService modelService;
	
	@Override
	public ModuleService findByServiceName(String serviceName) {
		ModuleService sqlModel = new ModuleService();
		sqlModel.setServiceNameEn(serviceName);
		ModuleService moduleService = modelService.findFirstBySqlModel(ModuleService.class, sqlModel);
		return moduleService;
	}
	
}
