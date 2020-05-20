/**
 * 
 */
package org.yelong.dream.first.core.platform.role.constants;

/**
 * 角色属性
 * @author PengFei
 * @since 1.0.0
 */
public enum RoleProperty {

	/**业务*/
	BUSINESS("01"),
	/**系统*/
	SYSTEM("02"),
	/**审计*/
	AUDIT("03");

	String code;

	private RoleProperty(String code) { 
		this.code = code; 
	}

	public String code(){
		return this.code;
	}

}
