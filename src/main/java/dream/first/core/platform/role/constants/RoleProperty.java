/**
 * 
 */
package dream.first.core.platform.role.constants;

/**
 * 角色属性
 * 
 * @since 1.0.0
 */
public enum RoleProperty {

	/** 业务 */
	BUSINESS("01"),
	/** 系统 */
	SYSTEM("02"),
	/** 审计 */
	AUDIT("03");

	String code;

	public final String CODE;

	private RoleProperty(String code) {
		this.code = code;
		this.CODE = code;
	}

	public String code() {
		return this.code;
	}

}
