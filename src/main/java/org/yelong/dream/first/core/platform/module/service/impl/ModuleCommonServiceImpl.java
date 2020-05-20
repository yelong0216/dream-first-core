/**
 * 
 */
package org.yelong.dream.first.core.platform.module.service.impl;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.BaseDataBaseOperation;
import org.yelong.core.jdbc.sql.condition.combination.CombinationConditionSqlFragment;
import org.yelong.core.model.ModelConfiguration;
import org.yelong.core.model.service.ModelService;
import org.yelong.dream.first.core.platform.module.constants.ModuleLog;
import org.yelong.dream.first.core.platform.module.model.Module;
import org.yelong.dream.first.core.platform.module.service.ModuleCommonService;
import org.yelong.mybatis.spring.BaseService;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class ModuleCommonServiceImpl extends BaseService implements ModuleCommonService{

	@Resource
	private ModelService modelService;
	
	@Resource
	private ModelConfiguration modelConfiguration;
	
	private String moduleTableName;
	
	@Override
	public void save(Module module) throws Exception {
		setModuleDefaultPropertyValue(module);
		//设置模块编号
		module.setModuleNo(generateModuleNo(module.getParentModuleNo()));
		modelService.save(module);
	}

	/**
	 * 根据父编号生成模块编号
	 * @param parentModuleNo 父模块编号
	 * @return 生成的模块编号
	 * @throws SQLException 
	 */
	protected String generateModuleNo(String parentModuleNo) throws SQLException {
		BaseDataBaseOperation db = modelService.getBaseDataBaseOperation();
		String newModuleNo = "";
		String sql = "select max(module.moduleNo) moduleNo from "+moduleTableName+" module where module.parentModuleNo = ?";
		String maxModuleNo = db.selectSingleObject(sql,new Object[] { parentModuleNo});
		if (StringUtils.isBlank(maxModuleNo))
			newModuleNo = parentModuleNo + "0001";
		else {
			newModuleNo = parentModuleNo + format(Integer.valueOf(Integer.valueOf(maxModuleNo.substring(maxModuleNo.length() - 4, maxModuleNo.length())).intValue() + 1), "0000");
		}
		return newModuleNo;
	}

	@Override
	public void modifyById(Module module) throws Exception {
		if( StringUtils.isEmpty(module.getId()) ) {
			throw new SQLException("根据id修改信息时，id是空的");
		}
		BaseDataBaseOperation db = modelService.getBaseDataBaseOperation();
		//setModuleDefaultPropertyValue(module);
		Module oldModule = modelService.findById(Module.class,module.getId());
		//如果模块父级更变则修改编号，其子级编号也修改
		if( !oldModule.getParentModuleNo().equals(module.getParentModuleNo()) ) {
			//设置模块编号
			module.setModuleNo(generateModuleNo(module.getParentModuleNo()));
			String sql = "update "+moduleTableName+" set moduleNo = REPLACE(moduleNo, substr(moduleNo, 1, length(parentModuleNo)), ?), parentModuleNo = ? where parentModuleNo like ?";
			Object [] params = {module.getModuleNo(),module.getModuleNo(),oldModule.getModuleNo()};
			db.update(sql, params);
		}
		//修改模块属性类型。
		if( !module.getModuleProperty().equals(oldModule.getModuleProperty()) ) {
			String sql = "update "+moduleTableName+" set moduleProperty = ? where parentModuleNo like ?";
			Object [] params = {module.getModuleProperty(),module.getModuleNo()};
			db.update(sql, params);
		}
		modelService.modifySelectiveById(module);
	}

	@Override
	public void modifyByModuleNo(Module module) throws Exception {
		module.setId(findByModuleNo(module.getModuleNo()).getId());
		modifyById(module);
	}
	
	/**
	 * 设置module默认的属性值
	 * @param module
	 */
	protected void setModuleDefaultPropertyValue(Module module) {
		//默认记录日志
		if( StringUtils.isEmpty(module.getModuleLog()) ) {
			module.setModuleLog(ModuleLog.RECORD.code());
		}
		//默认属性为通用
	}

	@Override
	public boolean removeById(String moduleId) throws Exception {
		if(StringUtils.isEmpty(moduleId)) {
			return false;
		}
		Module module = modelService.findById(Module.class,moduleId);
		modelService.removeById(Module.class, moduleId);
		CombinationConditionSqlFragment combinationConditionFragment = createCombinationSqlCondition(modelService);
		combinationConditionFragment.and("moduleNo", "like", module.getModuleNo()+"%");
		modelService.removeByCondition(Module.class, combinationConditionFragment);
		return true;
	}

	@Override
	public boolean removeByModuleNo(String moduleNo) throws Exception {
		Objects.requireNonNull(moduleNo);
		Module module = findByModuleNo(moduleNo);
		if( null != module ) {
			modelService.removeById(Module.class, module.getId());
			CombinationConditionSqlFragment combinationConditionFragment = createCombinationSqlCondition(modelService);
			combinationConditionFragment.and("moduleNo", "like", module.getModuleNo()+"%");
			modelService.removeByCondition(Module.class, combinationConditionFragment);
		}
		return true;
	}
	
	@Override
	public Module findByModuleNo(String moduleNo) {
		CombinationConditionSqlFragment combinationCondition = createCombinationSqlCondition(modelService);
		combinationCondition.and("module.moduleNo", "=", moduleNo);
		return modelService.findFirstByCondition(Module.class, combinationCondition);
	}
	
	@PostConstruct
	public void getModuleTable() {
		moduleTableName = modelConfiguration.getModelAndTableManager().getTableName(Module.class);
	}
	
	private static String format(Integer text, String partten){
		DecimalFormat df = new DecimalFormat(partten);
		return df.format(text);
	}

}
