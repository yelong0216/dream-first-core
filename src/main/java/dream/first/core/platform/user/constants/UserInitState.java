/**
 * 
 */
package dream.first.core.platform.user.constants;

/**
 * 用户初始化状态
 * 
 * @since 1.0.0
 */
public enum UserInitState {

	/** 已经初始化 */
	HAS_BEEN_INIT("02");

	public final String CODE;

	private UserInitState(String code) {
		this.CODE = code;
	}

}
