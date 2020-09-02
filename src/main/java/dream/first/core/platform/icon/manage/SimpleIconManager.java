package dream.first.core.platform.icon.manage;

import java.util.List;

import dream.first.core.platform.icon.model.Icon;
import dream.first.core.platform.icon.service.IconCommonService;

/**
 * 简单的缓存管理器
 * 
 * @since 2.0
 */
public class SimpleIconManager implements IconManager {

	protected final IconCommonService iconCommonService;

	public SimpleIconManager(IconCommonService iconCommonService) {
		this.iconCommonService = iconCommonService;
	}

	@Override
	public List<Icon> getAll() {
		return iconCommonService.findAll();
	}

}
