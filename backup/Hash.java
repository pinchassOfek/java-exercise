package com.encriptor1.encriptor1;

import java.security.Key;

import java.security.SecureRandom;

import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

public class Hash 
{
	private static final String ALGORITHM = "AES";
	public static final int KEY_SIZE = 16;// = Cipher.getMaxAllowedKeyLength("AES");	

	private static byte[] createRandomKey()
			throws NoSuchAlgorithmException
	{
		SecureRandom random = new SecureRandom();
		//KEY_SIZE = Cipher.getMaxAllowedKeyLength("AES");
        byte[] key = new byte[KEY_SIZE];
        random.nextBytes(key);
        return key;
        //return toHex(key);
	}
	
	private static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0) 
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }
	
	private static byte[] fromHex(String hex)
    {
        byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++)
        {
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return binary;
    }
	
	 public hashDetails encrypt(String valueToEnc) throws Exception 
	 {
		 byte[] b = createRandomKey();
	    Key key = generateKey(b);
	    Cipher c = Cipher.getInstance(ALGORITHM);
	    c.init(Cipher.ENCRYPT_MODE, key); // falling
	    byte[] encValue = c.doFinal(valueToEnc.getBytes());
	    String encryptedValue = new BASE64Encoder().encode(encValue);
	    String stringKey = toHex(b);
	    hashDetails hd = new hashDetails(encryptedValue, stringKey);
	    return hd;
	}

	public String decrypt(String encryptedValue, String knownKey) throws Exception 
	{
		 Key key = new SecretKeySpec(fromHex(knownKey) , ALGORITHM);
	    Cipher c = Cipher.getInstance(ALGORITHM);
	    c.init(Cipher.DECRYPT_MODE, key);
	    byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
	    byte[] decValue = c.doFinal(decordedValue);
	    String decryptedValue = new String(decValue);
	    return decryptedValue;
	}

	private static Key generateKey(byte[] b) throws Exception 
	{		
	    Key key = new SecretKeySpec(b , ALGORITHM);
	    return key;
	}

}
