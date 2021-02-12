package com.kakaopay.api.common;

import java.util.Random;

public class TokenGenerater {
	public static final char[] CHARS_64 = 
		{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
		 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
		 '0','1','2','3','4','5','6','7','8','9',
		 '-','_'};
	public static String generateToken() {
		Random rand = new Random(System.currentTimeMillis());
		return ""+CHARS_64[rand.nextInt(CHARS_64.length)] + CHARS_64[rand.nextInt(CHARS_64.length)]+CHARS_64[rand.nextInt(CHARS_64.length)];
	}
}
