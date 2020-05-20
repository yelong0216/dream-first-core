/**
 * 
 */
package org.yelong.dream.first.core.model;

import java.util.Date;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.PrimaryKey;
import org.yelong.core.model.sql.SqlModel;

/**
 * 基础模型。包含基础的字段，并提供你常用的方法
 * 
 * 注意：该类继承{@link SqlModel}，这个类的子类是可以转换为sql的
 * 
 * @author PengFei
 * @version 1.0.0
 */
public abstract class BaseModel extends SqlModel implements BaseModelable{

	private static final long serialVersionUID = -4023707437316252376L;

	/**
	 * 主键
	 */
	@PrimaryKey
	@Column(columnName = "主键")
	private String id;

	@Column(columnName = "创建人")
	private String creator;

	@Column(columnName = "创建时间")
	private Date createTime;

	@Column(columnName = "修改人")
	private String updator;

	@Column(columnName = "修改时间")
	private Date updateTime;

	@Column(columnName = "状态")
	private String state;

	//===========================Get/Set===========================

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
