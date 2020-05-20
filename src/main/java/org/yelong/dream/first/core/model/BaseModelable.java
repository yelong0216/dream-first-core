/**
 * 
 */
package org.yelong.dream.first.core.model;

import java.util.Date;

import org.yelong.core.model.Modelable;

/**
 * 基础model支持
 * 
 * 基础model应包含[id,创建人,创建时间,修改人,修改时间,状态]6个基础属性
 * 
 * @author PengFei
 */
public interface BaseModelable extends Modelable{
	
	//==================column==================
	
	//id，唯一标识
	String ID = "id";
	
	//创建人
	String CREATOR = "creator";
	
	//创建时间
	String CREATETIME = "createTime";
	
	//修改人
	String UPDATOR = "updator";
	
	//修改时间
	String UPDATETIME = "updateTime";
	
	//状态
	String STATE = "state";
	
	//=================== get ===================
	
	/**
	 * @return id。 数据的唯一标识
	 */
	String getId();
	
	/**
	 * @return 创建人
	 */
	String getCreator();
	
	/**
	 * @return 创建时间
	 */
	Date getCreateTime();
	
	/**
	 * @return 修改人
	 */
	String getUpdator();
	
	/**
	 * @return 修改时间
	 */
	Date getUpdateTime();
	
	/**
	 * @return 状态
	 */
	String getState();
	
	//=================== set ===================
	
	/**
	 * @param id 唯一标识
	 */
	void setId(String id);
	
	/**
	 * @param creator 创建人
	 */
	void setCreator(String creator);
	
	/**
	 * @param createTime 创建时间
	 */
	void setCreateTime(Date createTime);
	
	/**
	 * @param updator 修改人
	 */
	void setUpdator(String updator);
	
	/**
	 * @param updateTime 修改时间
	 */
	void setUpdateTime(Date updateTime);
	
	/**
	 * @param state 状态
	 */
	void setState(String state);
	
}
