/**
 * 
 */
package dream.first.core.platform.module.constants;

/**
 * 模块是否显示
 * 
 * @since 1.0
 */
public enum ModuleShow {

	/** 显示 */
	SHOW("01"),
	/** 不显示 */
	UNSHOW("02");

	String code;

	public final String CODE;

	private ModuleShow(String code) {
		this.code = code;
		this.CODE = code;
	}

	public String code() {
		return this.code;
	}

}