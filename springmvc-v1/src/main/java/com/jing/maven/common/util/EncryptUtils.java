package com.jing.maven.common.util;

import java.security.MessageDigest;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;

public class EncryptUtils {

	public static final String encryptMD5(String source) {
		if (source == null) {
			source = "";
		}
		Sha256Hash hash = new Sha256Hash(source);
		return new Md5Hash(hash).toString();
	}
	
	 // 鍔犲瘑鍚庤В瀵�
	 public static String JM(String inStr) {
	  char[] a = inStr.toCharArray();
	  for (int i = 0; i < a.length; i++) {
	   a[i] = (char) (a[i] ^ 't');
	  }
	  String k = new String(a);
	  return k;
	 }
	 
	 public static String encodePassword(String password,String algorithm) { 
			byte[] unencodedPassword = password.getBytes(); 
			MessageDigest md = null; 
			try { 
			md = MessageDigest.getInstance(algorithm); 
			} catch (Exception e) { 
			return password; 
			} 
			md.reset(); 
			md.update(unencodedPassword); 
			byte[] encodedPassword = md.digest(); 
			StringBuffer buf = new StringBuffer(); 
			for (int i = 0; i < encodedPassword.length; i++) { 
			if ((encodedPassword[i] & 0xff) < 0x10) { 
			buf.append("0"); 
			} 
			buf.append(Long.toString(encodedPassword[i] & 0xff, 16)); 
			} 
			return buf.toString(); 
		} 
	 
	 
	    public static String string2MD5(String inStr){  
	        MessageDigest md5 = null;  
	        try{  
	            md5 = MessageDigest.getInstance("MD5");  
	        }catch (Exception e){  
	            System.out.println(e.toString());  
	            e.printStackTrace();  
	            return "";  
	        }  
	        char[] charArray = inStr.toCharArray();  
	        byte[] byteArray = new byte[charArray.length];  
	  
	        for (int i = 0; i < charArray.length; i++)  
	            byteArray[i] = (byte) charArray[i];  
	        byte[] md5Bytes = md5.digest(byteArray);  
	        StringBuffer hexValue = new StringBuffer();  
	        for (int i = 0; i < md5Bytes.length; i++){  
	            int val = ((int) md5Bytes[i]) & 0xff;  
	            if (val < 16)  
	                hexValue.append("0");  
	            hexValue.append(Integer.toHexString(val));  
	        }  
	        //9a7866489df
	        String md5str1 = hexValue.toString();  
	        String md5str2 = convertMD5(inStr);
	        String hexStr = md5str1.substring(17, 28) + md5str2.toLowerCase() + md5str1.substring(10, 12);
	        return hexStr;  
	  
	    }  
	  

	    public static String convertMD5(String inStr){  
	  
	        char[] a = inStr.toCharArray();  
	        for (int i = 0; i < a.length; i++){  
	            a[i] = (char) (a[i] ^ 't');  
	        }  
	        String s = new String(a);  
	        return s;  
	  
	    } 
}
