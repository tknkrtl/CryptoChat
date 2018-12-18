package controller;

import java.util.Random;

public class AESRandomKey {

	public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	public static String Rand()
	{

		Random random = new Random();
		alphabet.charAt(random.nextInt(alphabet.length()));
		StringBuilder builder = new StringBuilder(16);
		for (int i = 0; i < 16; i++) {
		    builder.append(alphabet.charAt(random.nextInt(alphabet.length())));
		}
		return builder.toString();
		
	}

	
}
