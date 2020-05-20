/**
 * 
 */
package org.yelong.dream.first.core.platform.org.service;

import org.yelong.dream.first.core.platform.org.Orgs;
import org.yelong.dream.first.core.platform.org.model.Org;

/**
 * 组织
 * 
 * @author PengFei
 * @since 1.0.0
 */
public interface OrgCommonService{

	/**
	 * 根据父组织编号生成编号
	 * @param parentOrgNo 父组织编号
	 * @return 组织编号
	 */
	String generateOrgNo(String parentOrgNo) ;
	
	/**
	 * 根据组织编号查询组织机构信息
	 * @param orgNo 组织机构编号
	 * @return 组织机构信息
	 */
	Org findByOrgNo(String orgNo);
	
	/**
	 * 移除组织机构和其子组织机构，且该组织机构和子组织机构下面的用户默认移动到根组织{@link Orgs#ROOT_ORG_ID}下面
	 * @param orgNo 被删除的组织编号
	 */
	void removeOrg(String orgNo) ;
	
	/**
	 * 移除组织机构和其子组织机构，并且该组织机构及其子组织结构中的用户将被移动到新的组织下面 
	 * @param orgNo 被移除的组织机构编号
	 * @param userNewOrgId 被移除的组织机构中的用户的新组织机构id
	 */
	void removeOrg(String orgNo , String userNewOrgId);
	
	/**
	 * 移除组织机构和其子组织机构，且该组织机构和子组织机构下面的用户默认移动到根组织{@link Orgs#ROOT_ORG_ID}下面
	 * @param orgNos 被删除的组织编号数组
	 */
	void removeOrgByOrgNos(String [] orgNos) ;
	
	/**
	 * 移除组织机构和其子组织机构，并且该组织机构及其子组织结构中的用户将被移动到新的组织下面 
	 * @param orgNos 被移除的组织机构编号数组
	 * @param userNewOrgId 被移除的组织机构中的用户的新组织机构id
	 */
	void removeOrgByOrgNos(String [] orgNos , String userNewOrgId);
	
	/**
	 * 保存组织，并修改组织编号等信息。
	 * @param org 组织机构
	 */
	void saveOrg(Org org) ;
	
	/**
	 * 保存组织，并修改组织编号等信息。
	 * @param org 组织机构
	 */
	void modifyOrg(Org org) ;
	
}
