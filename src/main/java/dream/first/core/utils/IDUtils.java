/**
 * 
 */
package dream.first.core.utils;

import java.util.UUID;

/**
 * @since 1.0.0
 */
public class IDUtils {

	/**
	 * 获取32位字符的随机串
	 * 
	 * @return 32位字符的随机串
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

}
