/**
 * 
 */
package dream.first.core.platform.icon.service.impl;

import java.util.List;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.icon.model.Icon;
import dream.first.core.platform.icon.service.IconCommonService;

/**
 * 图标公共服务默认实现
 * 
 * @since 2.0
 */
public class IconCommonServiceImpl implements IconCommonService {

	protected final DreamFirstModelService modelService;

	public IconCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public List<Icon> findAll() {
		return modelService.findAll(Icon.class);
	}

}
