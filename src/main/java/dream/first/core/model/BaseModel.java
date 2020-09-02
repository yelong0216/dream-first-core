/**
 * 
 */
package dream.first.core.model;

import java.util.Date;

import org.yelong.core.model.Modelable;
import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.PrimaryKey;
import org.yelong.core.model.sql.SqlModel;

/**
 * 基础模型。包含基础的字段，并提供常用的方法
 * 
 * 注意：该类继承{@link SqlModel}，这个类的子类是可以转换为SQL的
 * 
 * @param <M> model type
 * @since 1.0
 */
public abstract class BaseModel<M extends Modelable> extends BaseSqlModel<M> implements BaseModelable {

	private static final long serialVersionUID = -4023707437316252376L;

	@PrimaryKey
	@Column(column = "id", maxLength = 32, allowNull = false, columnName = "主键")
	private String id;

	@Column(column = "creator", maxLength = 32, allowNull = false, columnName = "创建人")
	private String creator;

	@Column(column = "createTime", allowNull = false, columnName = "创建时间")
	private Date createTime;

	@Column(column = "updator", maxLength = 32, allowNull = false, columnName = "更新人")
	private String updator;

	@Column(column = "updateTime", allowNull = false, columnName = "更新时间")
	private Date updateTime;

	@Column(column = "state", maxLength = 1, allowNull = false, columnName = "状态")
	private String state;

	// ===========================Get/Set===========================

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getCreator() {
		return creator;
	}

	@Override
	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String getUpdator() {
		return updator;
	}

	@Override
	public void setUpdator(String updator) {
		this.updator = updator;
	}

	@Override
	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public void setState(String state) {
		this.state = state;
	}

}
