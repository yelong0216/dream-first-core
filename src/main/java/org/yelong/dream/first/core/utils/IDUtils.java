/**
 * 
 */
package org.yelong.dream.first.core.utils;

import java.util.UUID;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class IDUtils {

	/**
	 * 32位字符的随机串
	 * @version 1.0
	 * @return id
	 */
	  public static String getUUID() {
	    return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	  }
	
}
