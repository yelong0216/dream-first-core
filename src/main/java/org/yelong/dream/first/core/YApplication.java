/**
 * 
 */
package org.yelong.dream.first.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用属性配置。
 * 
 * 整个应用在运行时共享的属性。
 * 
 * @author PengFei
 * @since 1.0.0
 */
public final class YApplication {

	private static final Map<String,String> PROPERTIES = new HashMap<String, String>();

	public static final String getProperty(String key) {
		return PROPERTIES.get(key);
	}

	public static final String getProperty(String key,String defaultValue) {
		return PROPERTIES.getOrDefault(key, defaultValue);
	}

	public static final void setProperty(String key , String value) {
		PROPERTIES.put(key, value);
	}

	public static final Map<String, String> getProperties(){
		return PROPERTIES;
	}

}
