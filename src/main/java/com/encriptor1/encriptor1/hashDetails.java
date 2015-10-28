package com.encriptor1.encriptor1;

/**
 * Data type*/
public class hashDetails {
	
	private String cipher; // the cipher text
	private int key;       // the key of the encryption algorithem
	
	public hashDetails(String hash, int key) {		
		this.cipher = hash;
		this.key = key;
	}
	
	public String getCipher() {
		return cipher;
	}
	public int getKey() {
		return key;
	}
	public String toString()
	{
		String s = "key: ";
		s += key;
		s += "\n cipher text:\n" + cipher;
		return s;
	}
}
