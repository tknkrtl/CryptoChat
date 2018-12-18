package controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESImpl {

	public static List<String> keyList=new ArrayList<String>();
	public static List<String> initVectorList = new ArrayList<String>();
	public static String key="";
	public static String initVector="";
	
	public static String encrypt(String value) {
	try {
		
		key=AESRandomKey.Rand();
		initVector=AESRandomKey.Rand();
		
		keyList.add(key);
		initVectorList.add(initVector);
		

		
		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

		
		System.out.println(iv);
		System.out.println(skeySpec);
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

		
		byte[] encrypted = cipher.doFinal(value.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	return null;
}

public static String decrypt(String encrypted,String key,String initVector) {
	try {

		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

		System.out.println(iv);
		System.out.println(skeySpec);
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

		return new String(original);
	} catch (Exception ex) {
		ex.printStackTrace();
	}

	return null;
}
}
