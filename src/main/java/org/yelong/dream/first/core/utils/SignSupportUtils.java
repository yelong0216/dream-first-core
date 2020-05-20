package org.yelong.dream.first.core.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: SignSupportUtils
 * @Description: 创建签名，此类不可继承
 * @author Dwayne
 * @date 2020年3月9日
 *
 */
public final class SignSupportUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(SignSupportUtils.class);
	
//	public static void main(String[] args) throws Exception {
//		Map<String, String> headerMap = new HashMap<String, String>(); 
//		headerMap.put("timestamp", "1583997951719");
//		headerMap.put("timestamp", "1583997951719");
//		headerMap.put("schemaTag", "labbol");
//		headerMap.put("appKey", "labbol");
//		String body = "{\"queryInfo\":{\"pageNum\":1,\"pageSize\":30,\"filters\":[],\"sorters\":[{\"sortField\":\"createTime\",\"direction\":\"desc\"}]}}";
//		String appSecret = "labbol_secret";
//		System.out.println(generateSign( new HashMap<String, String>(), headerMap, body, appSecret));
//	}
	
	private static final String MD5 = "MD5";
	
	/**
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 * @throws GetHttpServletRequestReuseWrapperException 
	 * @throws UnsupportedEncodingException 
	 * @Title: generateSign
	 * @Description: 生成签名
	 * @param @param request
	 * @param @param header
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public static String generateSign(Map<String, String> parameterMap, Map<String, String> headerMap, String body, String appSecret) throws Exception {
		// 验证请求头
		if(headerMap.isEmpty())
			throw new Exception("headerMap is empty");
		if(StringUtils.isBlank(appSecret))
			throw new Exception("appSecret is empty");
		// 组装生成签名需要的参数
		Map<String, String> requestMap = new HashMap<String, String>();
		requestMap.put("appSecret", appSecret);
		requestMap.putAll(headerMap);
		if(!parameterMap.isEmpty())
			requestMap.putAll(parameterMap);
		if(StringUtils.isNotBlank(body))
			requestMap.put("requestBody", body);
		return encryptMap(requestMap);
	}
	
	private static String encryptMap(Map<String, String> map) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String md5Str = null;
		StringBuilder encryptStr = new StringBuilder();
		if(!map.isEmpty()) {
			logger.info("参与生成sign的值=======================" + map.toString());
			String []keys = (String[]) map.keySet().toArray(new String[0]);
			Arrays.sort(keys);
			for(String key :keys) {
				String value = map.get(key);
				if(StringUtils.isNotBlank(value))
					encryptStr.append(key).append(value);
			}
			logger.info("sign的值======================" + encryptStr.toString());
			MessageDigest md = MessageDigest.getInstance(MD5);
			//使用指定byte[]更新摘要
			md.update(encryptStr.toString().getBytes("utf-8"));
			//完成计算，返回指定结果数组
			byte[] b = md.digest();
			md5Str = byteArrayToHex(b);
		}
		return md5Str;
	}
	
	private static String byteArrayToHex(byte []bytes) {
		//字符数组，用来存放十六进制字符
		char[] hexReferChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		//一个字节占8位 ，一个十六进制字符占4位；十六进制字符数组的长度为字节数组长度的两倍
		char[] hexChars = new char[bytes.length * 2];
		int index = 0;
		for(byte b : bytes){
			//取字节高的4位     
			hexChars[index++] = hexReferChars[b >>> 4 & 0xf];
			//取字节低四位
			hexChars[index++] = hexReferChars[b & 0xf];
		}
		return new String(hexChars);
	}

}
