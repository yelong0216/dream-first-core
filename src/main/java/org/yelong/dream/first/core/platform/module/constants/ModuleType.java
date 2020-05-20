package org.yelong.dream.first.core.platform.module.constants;

/**
 * 模块类型
 * @author PengFei
 * @since 1.0.0
 */
public enum ModuleType {

	/**模块*/
	MODULE("01"), 
	/**操作*/
	OPERATE("02");

	String code;

	private ModuleType(String code) { 
		this.code = code; 
	}

	public String code() {
		return this.code;
	}

}
