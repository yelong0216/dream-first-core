package dream.first.core.platform.module.constants;

/**
 * 模块是否记录日志
 * 
 * @since 1.0.0
 */
public enum ModuleLog {

	/** 记录 */
	RECORD("01"),
	/** 不记录 */
	UNRECORD("02");

	String code;

	public final String CODE;

	private ModuleLog(String code) {
		this.code = code;
		this.CODE = code;
	}

	public String code() {
		return this.code;
	}

}
