package com.encriptor1.encriptor1;

import java.util.Scanner;

public class GUI {
	
	private static Scanner input = new Scanner(System.in);

	public static void run() 
	        throws Exception {
		
		int choice; // the choice of the user
		boolean keepGoing = true; // keep running the program again and again until the user enter the exit option

		while(keepGoing) {
			String path, onlyPath, keyPath;
			System.out.println("Please choose:");
			System.out.println("0. Exit");
			System.out.println("1. Encription");
			System.out.println("2. Decription");
			choice = input.nextInt();

			switch (choice) {
			case 0: // exit
				keepGoing = false; 
				System.out.println("Goodbye");
				break;
				
			case 1: // encrypt 
				System.out.println("Please enter path of file you want to encrypt");
				input.nextLine();
				path = input.nextLine();
				onlyPath = Operator.encryptFile(path);
				System.out.println("The path of the encrypted file and key file is:\n" + onlyPath);
				break;
				
			case 2: // decrypt
				System.out.println("Please enter path of the encrypted file");
				input.nextLine();
				path = input.nextLine();
				System.out.println("Please enter path of the key file");				
				keyPath = input.nextLine();
				onlyPath = Operator.decryptFile(path, keyPath);
				System.out.println("The path of the decrypted file is:\n" + onlyPath);
				break;

			default:
				System.out.println("ERROR: option does not exist.\nplease choose again\n");
				break;
			}

			System.out.println("\n--------------------------------------------------------------------\n");
		}
	}

}
