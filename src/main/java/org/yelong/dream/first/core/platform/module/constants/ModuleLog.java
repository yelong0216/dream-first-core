package org.yelong.dream.first.core.platform.module.constants;

/**
 * 模块是否记录日志
 * @author PengFei
 * @since 1.0.0
 */
public enum ModuleLog {

	/**记录*/
	RECORD("01"),
	/**不记录*/
	UNRECORD("02");
	
	String code;

	private ModuleLog(String code) { 
		this.code = code; 
	}

	public String code(){
		return this.code;
	}
	
}
