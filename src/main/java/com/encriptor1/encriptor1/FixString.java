package com.encriptor1.encriptor1;

/**
 * Dealing all the string changing that needed in this project
 */
public class FixString {
	
	// return the filename with _encrypted before the dot
	// pay attention: only one dot is allowed in fileName
	public static String fixEncrypted(String fileName) {
		
		String[] parts = fileName.split("\\.");
		String part1 = parts[0]; 
		String part2 = parts[1];
		String temp = ".";
		part1 += "_encrypted";		
		return new StringBuilder().append(part1).append(temp).append(part2).toString();		
	}
	
	// return the filename with _decrypted before the dot
	// pay attention: only one dot is allowed in fileName
	public static String fixDecrypted(String fileName) {
		
		String temp = ".";
		String[] parts = fileName.split("\\.");
		String part1 = parts[0]; 
		String part2 = parts[1];
		String temp2="";
		if(part1.toLowerCase().contains("_encrypted".toLowerCase())) {
			System.out.println("enter to if");
			temp2 = part1.replace("_encrypted", "");
			System.out.println(temp2);
		}
		
		part1 = temp2;
		
		part1 += "_decrypted";		
		return new StringBuilder().append(part1).append(temp).append(part2).toString();		
	}
	
	// return the file path with key.txt in the end
	// pay attention: only one dot is allowed in fileName
	public static String fixKey(String fileName) {
		
		String finaly = "";
		String[] parts = fileName.split("\\.");
		String part1 = parts[0];
		parts = part1.split("\\\\");
		
		for (int i = 0 ; i < parts.length-1 ; i++) {
			finaly += parts[i];
			finaly += "\\";
		}
		String part2 = "key.txt";
		finaly += part2;
		return finaly;			
	}
	
	// return the file path without the file name
	public static String onlyPath(String fileName) {
		String finaly = "";
		String[] parts = fileName.split("\\\\");
		
		for (int i = 0 ; i < parts.length-1 ; i++) {
			finaly += parts[i];
			if(i < parts.length-2)
				finaly += "\\";
		}
		
		return finaly;			
	}
	
	// return the text without spaces at all
	public static String clearSpaces(String text) {
		text = text.replaceAll("\\s","");
		return text;
	}

}
