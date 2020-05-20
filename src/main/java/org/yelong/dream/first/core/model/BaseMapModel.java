/**
 * 
 */
package org.yelong.dream.first.core.model;

import java.util.Date;

import org.yelong.commons.util.map.CaseInsensitiveMapUtils.KeyStoreMode;
import org.yelong.core.model.map.MapModel;

/**
 * @author PengFei
 */
public abstract class BaseMapModel extends MapModel implements BaseModelable{

	private static final long serialVersionUID = -4448830529149248472L;

	public BaseMapModel() {
		this(KeyStoreMode.UPPER);
	}
	
	public BaseMapModel(KeyStoreMode keyStoreMode) {
		super(keyStoreMode);
	}
	
	@Override
	public String getId() {
		return getString(ID);
	}

	@Override
	public String getCreator() {
		return getString(CREATOR);
	}

	@Override
	public Date getCreateTime() {
		return getDate(CREATETIME);
	}

	@Override
	public String getUpdator() {
		return getString(UPDATOR);
	}

	@Override
	public Date getUpdateTime() {
		return getDate(UPDATETIME);
	}

	@Override
	public String getState() {
		return getString(STATE);
	}

	@Override
	public void setId(String id) {
		put(ID, id);
	}

	@Override
	public void setCreator(String creator) {
		put(CREATOR, creator);
	}

	@Override
	public void setCreateTime(Date createTime) {
		put(CREATETIME, createTime);
	}

	@Override
	public void setUpdator(String updator) {
		put(UPDATOR, updator);
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		put(UPDATETIME, updateTime);
	}

	@Override
	public void setState(String state) {
		put(STATE, state);
	}
	
}
