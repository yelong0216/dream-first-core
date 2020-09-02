/**
 * 
 */
package dream.first.core.platform.role.constants;

/**
 * 角色类型
 * 
 * @since 1.0.0
 */
public enum RoleType {

	/** 操作 */
	OPERATE("01"),
	/** 数据 */
	DATA("02");

	String code;

	public final String CODE;

	private RoleType(String code) {
		this.code = code;
		this.CODE = code;
	}

	public String code() {
		return this.code;
	}

}
