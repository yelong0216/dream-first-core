/**
 * 
 */
package dream.first.core.platform.constants;

import org.yelong.commons.lang.EnumUtilsE.Codeable;

/**
 * 
 * 模型中基础属性 state 所对应的值
 * 
 * @since 1.0.0
 */
public enum State implements Codeable<String> {

	/** 有效 */
	YES("0"),
	/** 作废 */
	NO("1");

	private String code;

	public final String CODE;

	State(String code) {
		this.code = code;
		this.CODE = code;
	}

	public String getCode() {
		return code;
	}

}
