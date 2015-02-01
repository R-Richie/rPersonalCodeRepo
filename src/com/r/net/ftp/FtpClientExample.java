package com.r.net.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FtpClientExample {

	public static void getDataFiles(String server, String username, String password, String folder, String destinantionFolder, Calendar start, Calendar end) {
		try {
			FTPClient ftp = new FTPClient();
			ftp.connect(server);
			ftp.login(username, password);
			System.out.println("Connected to " + server + ".");
			System.out.println(ftp.getReplyString());
			// ftp.cwd(folder);
			ftp.changeWorkingDirectory(folder);
			System.out.println(ftp.printWorkingDirectory());
			FTPFile[] files = ftp.listFiles();
			System.out.println("Number of files in dir:" + files.length);
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
			for (int i = 0; i < files.length; i++) {
				// Date fileDate = files[i].getTimestamp().getTime();
				// if (fileDate.compareTo(start.getTime()) >= 0 &&
				// fileDate.compareTo(end.getTime()) <= 0) {
				// System.out.println(df.format(files[i].getTimestamp().getTime()));
					System.out.println("\t" + files[i].getName());
				File file = new File(destinantionFolder + File.separator + files[i].getName());
					FileOutputStream fos = new FileOutputStream(file);
					ftp.retrieveFile(files[i].getName(), fos);
					fos.close();
				file.setLastModified(new Date().getTime());
				// }
			}
			ftp.logout();
			ftp.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY) - 1);
		Calendar start = now;
		now.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY) + 2);
		Calendar end = now;
		getDataFiles("192.168.102.10", "ljr", "ljr", "upload", "D://ftp", start, end);

	}

}
