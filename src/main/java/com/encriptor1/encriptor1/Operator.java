package com.encriptor1.encriptor1;

/**
 *  Operating all the system like the exercise claims.
 */

public class Operator {
	
	/* 
	 * Encryption method.
	 * return the path of the encrypted file
	 * */
	public static String encryptFile(String path)  
			throws Exception {

		String text = FileArrangement.readFile(path);	// get the content of the file to encrypt
		hashDetails d = EncryptionAlgorithem.encrypt(text);	// encrypt the text of the file
		path = FixString.fixEncrypted(path);	// return the full path + file name of the text file of the encrypted text
		String keyFile = FixString.fixKey(path);	// return the full path + file name of the text file of the key
		FileArrangement.writeToFile(path, d.getCipher());	// write the encrypted file
		FileArrangement.writeToFile(keyFile, Integer.toString(d.getKey()));	// write the key file
		return FixString.onlyPath(path);
	}

	/* 
	 * Decription method.
	 * return the path of the encrypted file
	 * */
	public static String decryptFile(String path, String keyPath) 
			throws Exception {

		String encryptedText = FileArrangement.readFile(path);	// get the content of the encrypted file
		String keyWithNoSpaces = FixString.clearSpaces(FileArrangement.readFile(keyPath));
		int key = Integer.parseInt(keyWithNoSpaces);	// get content of the key file
		String decryptedText = EncryptionAlgorithem.decrypt(encryptedText, key);  // decrypt the text of the file
		path = FixString.fixDecrypted(path);	// return the full path + file name of the text file of the decrypted text
		FileArrangement.writeToFile(path, decryptedText);	// write the decrypted file
		return FixString.onlyPath(path);
	}

}
