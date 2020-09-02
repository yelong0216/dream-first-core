/**
 * 
 */
package dream.first.core.platform.org.service.impl;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.support.Condition;
import org.yelong.core.model.collector.ModelCollectors;
import org.yelong.mybatis.spring.BaseService;

import dream.first.core.model.service.DreamFirstModelService;
import dream.first.core.platform.org.Orgs;
import dream.first.core.platform.org.model.Org;
import dream.first.core.platform.org.service.OrgCommonService;
import dream.first.core.platform.user.model.User;
import dream.first.core.utils.NumberFormatUtils;

/**
 * @since 1.0.0
 */
public class OrgCommonServiceImpl extends BaseService implements OrgCommonService {

	protected final DreamFirstModelService modelService;

	public OrgCommonServiceImpl(DreamFirstModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public String generateOrgNo(String parentOrgNo) {
		String newOrgNo = "";
		String sql = "select max(org.orgNo) orgNo from CO_ORG org where org.parentOrgNo = ?";
		String maxOrgNo = modelService.getBaseDataBaseOperation().selectSingleObject(sql, parentOrgNo);
		if (StringUtils.isBlank(maxOrgNo))
			newOrgNo = parentOrgNo + "0001";
		else {
			newOrgNo = parentOrgNo + NumberFormatUtils.format(Integer.valueOf(
					Integer.valueOf(maxOrgNo.substring(maxOrgNo.length() - 4, maxOrgNo.length())).intValue() + 1),
					"0000");
		}
		return newOrgNo;
	}

	@Override
	public Org findByOrgNo(String orgNo) {
		if (StringUtils.isBlank(orgNo)) {
			return null;
		}
		Org org = new Org();
		org.setOrgNo(orgNo);
		return modelService.findFirstBySqlModel(Org.class, org);
	}

	@Override
	public void removeOrg(String orgNo) {
		removeOrg(orgNo, Orgs.ROOT_ORG_ID);
	}

	@Override
	public void removeOrg(String orgNo, String userNewOrgId) {
		if (StringUtils.isBlank(orgNo)) {
			return;
		}
		Org org = findByOrgNo(orgNo);
		if (null == org) {
			return;
		}
		User modifyUserSqlModel = new User();
		modifyUserSqlModel.setOrgId(org.getId());

		User user = new User();
		user.setOrgId(userNewOrgId);

		modelService.modifySelectiveBySqlModel(user, modifyUserSqlModel);

		Org removeOrgSqlModel = new Org();
		removeOrgSqlModel.addCondition(new Condition("orgNo", "like", orgNo + "%"));
		modelService.removeBySqlModel(Org.class, removeOrgSqlModel);
	}

	@Override
	public void removeOrgByOrgNos(String[] orgNos) {
		removeOrgByOrgNos(orgNos, Orgs.ROOT_ORG_ID);
	}

	@Override
	public void removeOrgByOrgNos(String[] orgNos, String userNewOrgId) {
		for (String orgNo : orgNos) {
			removeOrg(orgNo, userNewOrgId);
		}
	}

	@Override
	public void saveOrg(Org org) {
		modelService.saveSelective(org);
		if ((StringUtils.isNotBlank(org.getOldParentOrgNo()))
				&& (!org.getOldParentOrgNo().equals(org.getParentOrgNo()))) {
			String sql = "update CO_ORG set orgNo = REPLACE(orgNo, substr(orgNo, 1, length(parentOrgNo)), ?), parentOrgNo = ? where parentOrgNo like ?";
			Object[] params = ArrayUtils.toArray(org.getOrgNo(), org.getOrgNo(), org.getOldOrgNo() + "%");
			modelService.getBaseDataBaseOperation().update(sql, params);
		}
	}

	@Override
	public void modifyOrg(Org org) {
		modelService.modifySelectiveById(org);
		if ((StringUtils.isNotBlank(org.getOldParentOrgNo()))
				&& (!org.getOldParentOrgNo().equals(org.getParentOrgNo()))) {
			String sql = "update CO_ORG set orgNo = REPLACE(orgNo, substr(orgNo, 1, length(parentOrgNo)), ?), parentOrgNo = ? where parentOrgNo like ?";
			Object[] params = ArrayUtils.toArray(org.getOrgNo(), org.getOrgNo(), org.getOldOrgNo() + "%");
			modelService.getBaseDataBaseOperation().update(sql, params);
		}
	}

	@Override
	public List<Org> findAll() {
		return modelService.findAll(Org.class);
	}

	@Override
	public List<Org> findByParentOrgNo(String parentOrgNo) {
		return modelService.collect(ModelCollectors.findBySingleColumnEQ(Org.class, "parentOrgNo", parentOrgNo));
	}

}
