/**
 * 
 */
package org.yelong.dream.first.core.platform.module.constants;

/**
 * 模块属性
 * @author PengFei
 * @since 1.0.0
 */
public enum ModuleProperty {

	/**通用*/
	ALL("10"),
	/**业务*/
	BUSINESS("01"),
	/**系统*/
	SYSTEM("02"),
	/**审计*/
	AUDIT("03");
	
	String code;

	private ModuleProperty(String code) { 
		this.code = code; 
	}

	public String code(){
		return this.code;
	}
	
}
