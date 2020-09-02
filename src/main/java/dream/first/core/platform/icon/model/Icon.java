/**
 * 
 */
package dream.first.core.platform.icon.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import dream.first.core.model.BaseModel;

/**
 * 图标
 * 
 * @since 1.0.0
 */
@Table(value = "CO_ICON", alias = "icon", desc = "图标")
public class Icon extends BaseModel<Icon> {

	private static final long serialVersionUID = -6254356196113995923L;

	@Column(columnName = "图标类型")
	private String iconClass;

	@Column(columnName = "图标路径")
	private String iconPath;

	@Column(columnName = "图标描述")
	private String iconRemark;

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getIconRemark() {
		return iconRemark;
	}

	public void setIconRemark(String iconRemark) {
		this.iconRemark = iconRemark;
	}

}
