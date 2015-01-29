package com.r.base.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutPutShortcut {
	static String file = "FileOutputShortcut.out";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile
						.read("src/com/r/base/io/FileOutPutShortcut.java")));
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while ((s = in.readLine()) != null)
			out.println(lineCount++ + ": " + s);
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}

}
