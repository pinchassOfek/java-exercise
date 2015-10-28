package com.encriptor1.encriptor1;

public class Testing {
	
	public Testing() throws Exception {
		
		String text = "hello\nmy name is pini\ni am hungry";
		System.out.println("text:\n" + text + "\n");
		//String path = "C:\\temp2\\text.txt"; text_encrypted
		String path = "C:\\temp2\\text.txt";
				
		encriptionCheck(text);
		
		fixStringCheck(path);
		
		fileCheck(path, text);
	}
	
	private static void encriptionCheck(String text) 
			throws Exception {
		
		System.out.println("\n\n Encryption check:");
		hashDetails d = EncryptionAlgorithem.encrypt(text);
		System.out.println("encrypted text:\n" + d.toString() + "\n");
		String decrypted = EncryptionAlgorithem.decrypt(d.getCipher(), d.getKey());
		System.out.println("decripted text:\n" + decrypted + "\n");
	}
	
	private static void fixStringCheck(String path) 
			throws Exception {
		
		System.out.println("\n\n path check:");
		System.out.println("path: " + path);
		System.out.println(FixString.fixEncrypted((path)));
		System.out.println(FixString.fixKey(path));
		System.out.println(FixString.fixDecrypted((path)));
		System.out.println(FixString.onlyPath(path));
	}
	
	private static void fileCheck(String path, String text) 
			throws Exception {
		
		path = FixString.fixEncrypted((path));
		System.out.println("\n\n file check:");
		FileArrangement.writeToFile(path, text);
		System.out.println("the text in the file:");
		System.out.println(FileArrangement.readFile(path));
	}
}
