/**
 * 
 */
package org.yelong.dream.first.core.platform.module.constants;

/**
 * 模块是否显示
 * @author 彭飞
 * @date 2019年9月25日上午10:31:52
 * @version 1.0
 */
public enum ModuleShow {

	/**显示*/
	SHOW("01"), 
	/**不显示*/
	UNSHOW("02");

	String code;

	private ModuleShow(String code) { 
		this.code = code; 
	}

	public String code(){
		return this.code;
	}

}