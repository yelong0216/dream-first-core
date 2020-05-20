/**
 * 
 */
package org.yelong.dream.first.core.platform.org;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.model.service.SqlModelService;
import org.yelong.dream.first.core.platform.org.model.Org;

/**
 * @author PengFei
 */
public final class Orgs {

	private Orgs() {}

	/**
	 * 根组织的主键标识值
	 */
	public static final String ROOT_ORG_ID = "-1";

	/**
	 * 根组织的编号
	 */
	public static final String ROOT_ORG_NO = "0000";

	/**
	 * 是否是根组织编号
	 * @param orgNo 组织编号
	 * @return <tt>true</tt> 是根组织编号
	 */
	public static boolean isRootOrgNo(String orgNo) {
		return StringUtils.isBlank(orgNo) ? false : ROOT_ORG_NO.equals(orgNo);
	}

	/**
	 * 是否是根组织ID
	 * @param orgId 组织id
	 * @return <tt>true<tt> 是跟组织ID
	 */
	public static boolean isRootOrgId(String orgId) {
		return StringUtils.isBlank(orgId) ? false : ROOT_ORG_ID.equals(orgId);
	}

	/**
	 * @see #getConditionOrg(SqlModelService, Org, String)
	 */
	public static String getConditionOrgId(SqlModelService modelService , Org currentLoginUserOrg , String conditionOrgId) {
		return getConditionOrg(modelService, currentLoginUserOrg, conditionOrgId).getId();
	}

	/**
	 * @see #getConditionOrg(SqlModelService, Org, String)
	 */
	public static String getConditionOrgNo(SqlModelService modelService , Org currentLoginUserOrg , String conditionOrgId) {
		return getConditionOrg(modelService, currentLoginUserOrg, conditionOrgId).getOrgNo();
	}

	/**
	 * 比较传入的组织id与当前登录人的组织id并获取符合需求的进行查询的组织条件。
	 * 1、如果conditionOrgId的组织不存在则默认为根组织
	 * 2、如果conditionOrgId的组织与currentLoginUserOrg均为跟组织则直接返回根组织
	 * 3、如果conditionOrgId的组织与currentLoginUserOrg相同则返回currentLoginUserOrg
	 * 4、如果currentLoginUserOrg隶属于conditionOrgId的组织则返回currentLoginUserOrg
	 * 5、如果conditionOrgId的组织隶属于currentLoginUserOrg则返回conditionOrgId
	 * 
	 * 使用场景：
	 * 根据组织树进行查询：
	 * 		查询时选中了登录人所有组织的父类组织时，不允许查询出父类的记录时
	 * 
	 * @param modelService model service
	 * @param currentLoginUserOrg 当前登录人的组织
	 * @param conditionOrgId 传入的条件组织id
	 * @return
	 */
	public static Org getConditionOrg(SqlModelService modelService , Org currentLoginUserOrg , String conditionOrgId) {
		Objects.requireNonNull(currentLoginUserOrg," 'currentLoginUserOrg' not allow null");
		if(StringUtils.isBlank(conditionOrgId)) {
			conditionOrgId = ROOT_ORG_ID;
		}
		if( conditionOrgId.equals(currentLoginUserOrg.getId())  ) {
			return currentLoginUserOrg;
		}
		Org conditionOrg = modelService.findById(Org.class, conditionOrgId);
		if( null == conditionOrg ) {//不存在还是当前登陆人的
			return currentLoginUserOrg;
		}
		//查询的组织与当前登陆人不同时，如果组织大于当前人的组织则查询当前人组织
		if(currentLoginUserOrg.getOrgNo().contains(conditionOrg.getOrgNo())) {
			return currentLoginUserOrg;
		} else {
			return conditionOrg;
		}
	}
}
