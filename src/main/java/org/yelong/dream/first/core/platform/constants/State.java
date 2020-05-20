/**
 * 
 */
package org.yelong.dream.first.core.platform.constants;

/**
 * 
 * 模型中基础属性 state 所对应的值
 * 
 * @author PengFei
 * @since 1.0.0
 */
public enum State {

	/**有效*/
	YES("0"),
	/**作废*/
	NO("1");
	
	private String code;
	
	State(String code){
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
}
