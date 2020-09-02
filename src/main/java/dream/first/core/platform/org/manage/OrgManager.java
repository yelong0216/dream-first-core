package dream.first.core.platform.org.manage;

import java.util.List;

import dream.first.core.platform.org.model.Org;

/**
 * 组织管理器
 * 
 * @since 2.0
 */
public interface OrgManager {

	/**
	 * 获取所有的组织机构
	 * 
	 * @return 所有的组织机构
	 */
	List<Org> getAll();

	/**
	 * 根据组织编号获取组织机构信息
	 * 
	 * @param orgNo 组织机构编号
	 * @return 组织机构信息
	 */
	Org getByOrgNo(String orgNo);

	/**
	 * 根据父组织机构编号获取组织机构信息
	 * 
	 * @param parentOrgNo 父组织机构编号
	 * @return 组织机构信息集合
	 */
	List<Org> getByParentOrgNo(String parentOrgNo);

}
