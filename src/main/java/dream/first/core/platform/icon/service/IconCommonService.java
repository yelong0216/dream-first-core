package dream.first.core.platform.icon.service;

import java.util.List;

import dream.first.core.platform.icon.model.Icon;

/**
 * 图标公共服务
 * 
 * @since 2.0
 */
public interface IconCommonService {

	/**
	 * @return 所有的图标
	 */
	List<Icon> findAll();
	
}
