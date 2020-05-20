/**
 * 
 */
package org.yelong.dream.first.core.platform.user.service;

import java.util.List;

import org.yelong.dream.first.core.platform.user.model.UserExtraOrg;

/**
 * @author PengFei
 * @since 1.0.0
 */
public interface UserExtraOrgCommonService{
	
	/**
	 * 根据用户id查询用户附属部门信息
	 * @param userId 用户id
	 * @return 用户附属部门信息
	 */
	List<UserExtraOrg> findByUserId(String userId) throws Exception;
	

}
