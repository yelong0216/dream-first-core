/**
 * 
 */
package dream.first.core.platform.user.service.impl;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.user.service.UserExtraOrgRoleCommonService;

/**
 * @since 1.0.0
 */
public class UserExtraOrgRoleCommonServiceImpl implements UserExtraOrgRoleCommonService {

	protected final DreamFirstModelService modelService;

	public UserExtraOrgRoleCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

}
