package org.yelong.dream.first.core.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;

import javax.crypto.Cipher;

import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * Created by wk on 2017/2/14.
 */

public class RSAUtils {
	/** 可以先注册到虚拟机中,再通过名称使用;也可以不注册,直接传入使用 */  
    public static final Provider pro = new BouncyCastleProvider();  
    /** 种子,改变后,生成的密钥对会发生变化 */  
    private static final String seedKey = "random";  
   
    private static final String charSet = "UTF-8";  
      
    private static PrivateKey privateKey = null;  
    private static PublicKey publicKey = null;  
    private static String jsPublicKey = null;  
      
    static{  
        try {  
            generateKeyPair();  
            getJsPublicKey();  
        } catch (Exception e) {  
        	e.printStackTrace();
            throw new RuntimeException("生成密钥对失败");  
        }  
    }  
  
    /** 
     * 生成密钥对 
     * @throws Exception 
     */  
    private static void generateKeyPair() throws Exception {  
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", pro);  
        kpg.initialize(1024, new SecureRandom(seedKey.getBytes()));  
        KeyPair kp = kpg.generateKeyPair();  
  
        privateKey = kp.getPrivate();  
        publicKey = kp.getPublic();  
          
    }
    /** 
     * 解密 
     */  
    public static byte[] decrypt(byte[] encrypted) throws Exception {  
    	//Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithMD5AndMGF1Padding", pro);  
        Cipher cipher = Cipher.getInstance("RSA", pro);  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
        byte[] re = cipher.doFinal(encrypted);  
        return re;  
    }  
  
    /** 
     * 解密js加密后的值 
     */  
    public static String decodeJsValue(String jsValue) throws Exception {  
        byte[] input = Hex.decode(jsValue);  
        byte[] raw = decrypt(input);  
  
        // 标志位为0之后的是输入的有效字节  
        int i = raw.length - 1;  
        while (i > 0 && raw[i] != 0) {  
            i--;  
        }  
        i++;  
        byte[] data = new byte[raw.length - i];  
        for (int j = i; j < raw.length; j++) {  
            data[j - i] = raw[j];  
        }  
  
        return new String(data, charSet);  
    }  
      
    /** 
     * js加密时使用的公钥字符串 
     * <p><b>注意：</b> 
     * 生成的密钥对的值与 种子（seedKey）、虚拟机实现等都有关系，不同的机器生成的密钥值可能不同。 
     * 在实际测试时发现，同样的环境，有些机器每次生成的密钥值也不同，比如每次重启服务器后值不同。 
     * 所以在实际生产环境中使用时，该值需要通过服务器端输出到客户端。 
     * 如果有多台服务器，可能每台服务器的值不同，所以需要有类似F5的策略，保证多次请求路由到一台服务器上。 
     */  
    public static String getJsPublicKey(){  
        if(jsPublicKey == null){  
        	BCRSAPublicKey jce = (BCRSAPublicKey) publicKey;  
            jsPublicKey = jce.getModulus().toString(16);  
        }  
        return jsPublicKey;  
    }  
    
    public static void main(String []args) throws Exception {
    	//注意：需要使用该值替换test.html中的公钥值  
        System.out.println("js中使用的公钥字符串: " + getJsPublicKey());  
      
          
        // js加密后的值  
        //String de = "8fa2f1bece5a4dc036819f3b6b67f7ed81b5e8d70371581b19bcbc50fd5977c1 01378e494f9f058e217906834bfe8d92e88e0b8ba0025387e2aaee52b4af2607 fda2bcbe0291276e56509c2ac5e19a7dbe94491bf328ebb0c0c251ee87771d74 0c79bc727c557eb4beef7ab73202c674dc7da5811754d2fcef8393ab81f65d9c";  
        //System.out.println("解密后: " + decodeJsValue(de));  
    }
}
