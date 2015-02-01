package com.r.base.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		try {
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(
					BufferedInputFile.read(
							"src/com/r/base/io/FormattedMemoryInput.java")
							.getBytes()));
			while (true) {
				System.out.print((char) in.readByte());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("End of stream");
		}

	}

}
