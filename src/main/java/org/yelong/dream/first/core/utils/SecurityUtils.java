/**
 * 
 */
package org.yelong.dream.first.core.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class SecurityUtils {

	private static final String PASSWORD_CRYPT_KEY = "__LAbOl__";
	private static final String DES = "DES";
	private static final String MD5 = "MD5";

	public static InputStream decryptDES4InputStream(InputStream in)
	{
		try
		{
			byte[] bytes = _decryptDES4InputStream(in, PASSWORD_CRYPT_KEY.getBytes());
			if (bytes != null) {
				return new ByteArrayInputStream(bytes);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] _decryptDES4InputStream(InputStream in, byte[] key)
			throws Exception
	{
		SecureRandom sr = new SecureRandom();

		DESKeySpec dks = new DESKeySpec(key);

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);

		SecretKey securekey = keyFactory.generateSecret(dks);

		Cipher cipher = Cipher.getInstance(DES);

		cipher.init(2, securekey, sr);

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		byte[] tmpbuf = new byte['?'];
		int count = 0;
		while ((count = in.read(tmpbuf)) != -1)
		{
			bout.write(tmpbuf, 0, count);
			tmpbuf = (byte[])null;
			tmpbuf = new byte['?'];
		}
		in.close();

		byte[] orgData = bout.toByteArray();

		return cipher.doFinal(orgData);
	}



	public static String encryptMD5(String data) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance(MD5);
			if (md5 != null) {
				try {
					return byte2hex(md5.digest(data.toString().getBytes("utf-8")));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0xFF);
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	public static void main(String[] args) {
		String string = encryptMD5("123");
		System.out.println(string);
	}

}
