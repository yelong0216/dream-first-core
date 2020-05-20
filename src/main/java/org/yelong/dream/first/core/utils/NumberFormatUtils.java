/**
 * 
 */
package org.yelong.dream.first.core.utils;

import java.text.DecimalFormat;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class NumberFormatUtils {

	public static String format(Long text, String partten){
		DecimalFormat df = new DecimalFormat(partten);

		return df.format(text);
	}

	public static String format(Integer text, String partten){
		DecimalFormat df = new DecimalFormat(partten);

		return df.format(text);
	}

	public static String format(Float text, String partten){
		DecimalFormat df = new DecimalFormat(partten);

		return df.format(text);
	}

	public static String format(Short text, String partten){
		DecimalFormat df = new DecimalFormat(partten);

		return df.format(text);
	}

}
