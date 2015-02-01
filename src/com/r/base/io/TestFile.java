package com.r.base.io;

import java.io.File;
import java.io.IOException;

public class TestFile {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		File file1 = new File("Data.txt");
		System.out.println(file1.getAbsolutePath());
		File parent = new File("src/com/r/base");
		File file2 = new File(parent, "/io/TestFile.java");
		System.out.println(file2.getAbsolutePath());
		System.out.println(file1.getCanonicalPath());
		System.out.println(file2.getParent());
		File[] roots = File.listRoots();
		for (File root : roots) {
			System.out.println(root.getAbsolutePath());
		}
	}
}
