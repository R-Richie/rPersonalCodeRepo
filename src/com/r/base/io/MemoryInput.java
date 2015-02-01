package com.r.base.io;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringReader in = new StringReader(
				BufferedInputFile.read("src/com/r/base/io/MemoryInput.java"));
		int c;
		while ((c = in.read()) != -1)
			System.out.print((char) c);
	}

}
