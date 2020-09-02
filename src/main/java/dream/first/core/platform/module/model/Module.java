/**
 * 
 */
package dream.first.core.platform.module.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;
import org.yelong.core.order.Orderable;

import dream.first.core.model.BaseModel;

/**
 * 模块
 * 
 * @since 1.0.0
 */
@Table(value = "CO_MODULE", alias = "module", desc = "模块")
public class Module extends BaseModel<Module> implements Comparable<Module>, Orderable {

	private static final long serialVersionUID = -1663619675171907021L;

	@Column(columnName = "模块编号")
	private String moduleNo;

	@Column(columnName = "父模块编号")
	private String parentModuleNo;

	@Column(columnName = "模块名称")
	private String moduleName;

	@Column(columnName = "模块类型")
	private String moduleType;

	@Column(columnName = "模块路径（模块的请求路径，这可能是一个路由的路径）")
	private String moduleUrl;

	@Column(column = "moduleSourceUrl", columnName = "模块源路径（用来记录日志和其他操作）")
	private String moduleSourceUrl;

	@Column(columnName = "模块顺序")
	private Integer moduleOrder;

	@Column(columnName = "是否显示模块")
	private String moduleShow;

	@Column(columnName = "模块是否记录日志")
	private String moduleLog;

	@Column(columnName = "模块编号")
	private String moduleDesc;

	@Column(columnName = "模块编号")
	private String moduleProperty;

	@Column(columnName = "模块编号")
	private String moduleIcon;

	public String getModuleNo() {
		return moduleNo;
	}

	public void setModuleNo(String moduleNo) {
		this.moduleNo = moduleNo;
	}

	public String getParentModuleNo() {
		return parentModuleNo;
	}

	public void setParentModuleNo(String parentModuleNo) {
		this.parentModuleNo = parentModuleNo;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public String getModuleUrl() {
		return moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

	public Integer getModuleOrder() {
		return moduleOrder;
	}

	public void setModuleOrder(Integer moduleOrder) {
		this.moduleOrder = moduleOrder;
	}

	public String getModuleShow() {
		return moduleShow;
	}

	public void setModuleShow(String moduleShow) {
		this.moduleShow = moduleShow;
	}

	public String getModuleLog() {
		return moduleLog;
	}

	public void setModuleLog(String moduleLog) {
		this.moduleLog = moduleLog;
	}

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public String getModuleProperty() {
		return moduleProperty;
	}

	public void setModuleProperty(String moduleProperty) {
		this.moduleProperty = moduleProperty;
	}

	public String getModuleIcon() {
		return moduleIcon;
	}

	public void setModuleIcon(String moduleIcon) {
		this.moduleIcon = moduleIcon;
	}

	public String getModuleSourceUrl() {
		return moduleSourceUrl;
	}

	public void setModuleSourceUrl(String moduleSourceUrl) {
		this.moduleSourceUrl = moduleSourceUrl;
	}

	@Override
	public int compareTo(Module o) {
		if (o.moduleOrder == null) {
			return 1;
		} else if (this.moduleOrder == null) {
			return -1;
		} else {
			return Integer.compare(this.moduleOrder, o.moduleOrder);
		}
	}

	@Override
	public int getOrder() {
		return null == this.moduleOrder ? LOWEST_PRECEDENCE : this.moduleOrder;
	}

}
