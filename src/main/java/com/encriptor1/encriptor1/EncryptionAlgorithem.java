package com.encriptor1.encriptor1;

import java.util.Random;

/**
 *  The encryption class
 */

public class EncryptionAlgorithem {
	
	private static final int MAX_KEY_VALUE = 9; // the key of the encription will be between 1 and MAX_KEY_VALUE

	private static int createRandomKey() {
		
		Random rand = new Random();	    
		int randomNum = rand.nextInt(MAX_KEY_VALUE) + 1;
		return randomNum;
	}


	public static hashDetails encrypt(String valueToEnc) 
	        throws Exception {
		
		hashDetails hd;
		int key = createRandomKey();
		char[] charArray = valueToEnc.toCharArray();
		String encrypted = "";
		for(char ot:charArray) {
			if( (ot != ' ') && (ot != '\n') ) {
				ot += key;
			}
			encrypted += ot;
		}
		hd = new hashDetails(encrypted,key);	 
		return hd;
	}

	/* computing and returning the decripted text*/
	public static String decrypt(String encryptedText, int knownKey) 
	        throws Exception {
		
		char[] charArray = encryptedText.toCharArray();
		String decrypted = "";
		for(char ot:charArray)
		{
			if( (ot != ' ') && (ot != '\n') )
				ot -= knownKey;		

			decrypted += ot;
		}
		return decrypted;
	}
}
