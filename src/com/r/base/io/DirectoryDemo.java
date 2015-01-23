package com.r.base.io;

import java.io.File;

public class DirectoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// All directories
		PPrint.pprint(Directory.walk(".").dirs);
		// All files beginning with 'T'
		for (File file : Directory.local(".", "T.*"))
			System.out.println(file);
		System.out.println("----------");
		// All java files beginning with 'T'
		for (File file : Directory.walk(".", "T.*\\.java"))
			System.out.println(file);
		System.out.println("============");
		// Class files containing "Z" or "z"
		for (File file : Directory.walk(".", "[Zz].*\\.class"))
			System.out.println(file);
	}

}
