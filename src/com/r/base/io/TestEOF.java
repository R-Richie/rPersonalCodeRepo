package com.r.base.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream("src/com/r/base/io/TestEOF.java")));
		while (in.available() != 0)
			System.out.print((char) in.readByte());
	}

}
