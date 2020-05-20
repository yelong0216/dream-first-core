package org.yelong.dream.first.core.platform.sign.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;
import org.yelong.dream.first.core.model.BaseModel;

/**
 * 签名
 * 
 * @author PengFei
 * @since 1.0.0
 */
@Table(value = "CO_KEY_SECRET",alias = "sign",desc = "签名")
public class Sign extends BaseModel {
	
	private static final long serialVersionUID = -7784179554097713615L;

	@Column(columnName = "appkey")
	private String appKey;
	
	@Column(columnName = "appSecret")
	private String appSecret;

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
}
