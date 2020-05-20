/**
 * 
 */
package org.yelong.dream.first.core.platform.service.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.model.service.SqlModelService;
import org.yelong.dream.first.core.platform.service.dto.ModuleServiceInterfaceTemplateDTO;
import org.yelong.dream.first.core.platform.service.service.ModuleServiceInterfaceCommonService;
import org.yelong.mybatis.spring.BaseService;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class ModuleServiceInterfaceCommonServiceImpl extends BaseService implements ModuleServiceInterfaceCommonService{

	@Resource
	private SqlModelService modelService;
	
	@Override
	public String getInterfaceUrl(String interfaceName) {
		if(StringUtils.isEmpty(interfaceName)) {
			return null;
		}
		ModuleServiceInterfaceTemplateDTO moduleServiceInterfaceTemplateVO = new ModuleServiceInterfaceTemplateDTO();
		moduleServiceInterfaceTemplateVO.setInterfaceName(interfaceName);
		moduleServiceInterfaceTemplateVO = modelService.findFirstBySqlModel(ModuleServiceInterfaceTemplateDTO.class, moduleServiceInterfaceTemplateVO);
		if(null == moduleServiceInterfaceTemplateVO) {
			return null;
		} else {
			return moduleServiceInterfaceTemplateVO.getServiceBaseUrl()+"/"+moduleServiceInterfaceTemplateVO.getInterfaceUrl();
		}
	}

}
