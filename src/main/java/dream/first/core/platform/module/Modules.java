/**
 * 
 */
package dream.first.core.platform.module;

/**
 * 模块工具
 * 
 * @since 2.0
 */
public final class Modules {

	private Modules() {
	}

	/**
	 * 根模块的主键标识值
	 */
	public static final String ROOT_MODULE_ID = "-1";

	/**
	 * 根模块的编号
	 */
	public static final String ROOT_MODULE_NO = "0000";

	/**
	 * 是否是根模块ID
	 * 
	 * @param moduleId 模块id
	 * @return <tt>true<tt> 是根模块ID
	 */
	public static boolean isRootModuleId(String moduleId) {
		return ROOT_MODULE_ID.equals(moduleId);
	}

	/**
	 * 是否是根模块编号
	 * 
	 * @param moduleNo 模块编号
	 * @return <tt>true</tt> 是根模块编号
	 */
	public static boolean isRootModuleNo(String moduleNo) {
		return ROOT_MODULE_NO.equals(moduleNo);
	}

}
