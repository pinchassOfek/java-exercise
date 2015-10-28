package com.encriptor1.encriptor1;
import java.lang.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Encription 
{
	public static hashDetails encrypt(String nonEncrypted) 
			throws Exception
	{
		
		hashDetails hash = new Hash().encrypt(nonEncrypted);
		return hash;
	}
	
	public static String decrypt(String encryptedValue, String knownKey) 
			throws Exception
	{
		String decryptedText = new Hash().decrypt(encryptedValue, knownKey);
		return decryptedText;
	}

}
