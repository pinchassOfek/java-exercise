package com.encriptor1.encriptor1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileArrangement {
	
	public static void writeToFile(String path, String text) 
	        throws IOException {
		
		FileWriter fileWriter = new FileWriter(path);           
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		String[] parts = text.split("\n");
		for (String line: parts) {          
			bufferedWriter.write(line);
			bufferedWriter.newLine();
		}
		
		bufferedWriter.close();
		fileWriter.close();
	}

	public static String readFile(String path) 
	        throws IOException {
		
		String line = null, text = "";
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);


		while((line = bufferedReader.readLine()) != null) {
			text += new StringBuilder().append(line).append("\n").toString();
		}   

		bufferedReader.close();
		return text;
	}
	
}
