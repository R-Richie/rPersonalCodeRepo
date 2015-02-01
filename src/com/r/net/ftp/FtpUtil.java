package com.r.net.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FtpUtil {
	private FTPClient ftpClient;
	public static final int BINARY_FILE_TYPE = FTP.BINARY_FILE_TYPE;
	public static final int ASCII_FILE_TYPE = FTP.ASCII_FILE_TYPE;
	/**
	 * 利用ftpconfig进行服务器连接
	 * 
	 * @param ftpConfig
	 * @throws SocketException
	 * @throws IOException
	 */
	public void connctServer(FtpConfig ftpConfig) throws SocketException, IOException {
		String server = ftpConfig.getServer();
		int port = ftpConfig.getPort();
		String username = ftpConfig.getUsername();
		String password = ftpConfig.getPassword();
		String location = ftpConfig.getLocation();
		connectServer(server, port, username, password, location);
	}
	/**
	 * 使用详细信息进行服务器连接
	 * @param server：服务器地址
	 * @param port：ftp服务端口号
	 * @param user：用户名
	 * @param password：密码
	 * @param path：ftp工作目录
	 * @throws SocketException
	 * @throws IOException
	 */
	public void connectServer(String server, int port, String user, String password, String path) throws SocketException, IOException {
		ftpClient = new FTPClient();
		ftpClient.connect(server, port);
		System.out.println("Connected to " + server + ".");
		// System.out.println("连接返回码：" + ftpClient.getReply());
		ftpClient.login(user, password);
		if (path != null && path.length() != 0) {
			ftpClient.changeWorkingDirectory(path);
		}
		ftpClient.setBufferSize(1024);// 设置上次缓存大小
		ftpClient.setControlEncoding("UTF-8");// 设置编码
		ftpClient.setFileType(BINARY_FILE_TYPE);// 设置文件类型
	}
	/**
	 * 设置传输文件类型:FTP.BINARY_FILE_TYPE | FTP.ASCII_FILE_TYPE
	 * 二进制文件或文本文件
	 * @param fileType
	 * @throws IOException
	 */
	public void setFileType(int fileType) throws IOException {
		ftpClient.setFileType(fileType);
	}
	/**
	 * 
	 * @throws IOException
	 */
	public void closeConnect() throws IOException {
		if (ftpClient != null && ftpClient.isConnected()) {
			ftpClient.logout();
			ftpClient.disconnect();
		}
	}
	/**
	 * 切换ftp服务器工作目录
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public boolean changeDirectory(String path) throws IOException {
		return ftpClient.changeWorkingDirectory(path);
	}
	/**
	 * 在ftp上创建目录
	 * 
	 * @param pathName
	 * @return
	 * @throws IOException
	 */
	public boolean createDirectory(String pathName) throws IOException {
		return ftpClient.makeDirectory(pathName);
	}
	/**
	 * 删除服务器上的文件
	 * 
	 * @param pathName
	 * @return
	 * @throws IOException
	 */
	public boolean deleteFile(String pathName) throws IOException {
		return ftpClient.deleteFile(pathName);
	}
	/**
	 * 在服务器上删除目录
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public boolean removeDirectory(String path) throws IOException {
		return ftpClient.removeDirectory(path);
	}
	/**
	 * 删除所有文件和目录
	 * 
	 * @param path
	 * @param isAll
	 * @return
	 * @throws IOException
	 */
	public boolean removeDirectory(String path, boolean isAll) throws IOException {
		if (!isAll) {
			return removeDirectory(path);
		}

		FTPFile[] ftpFileArr = ftpClient.listFiles(path);
		if(ftpFileArr == null || ftpFileArr.length ==0){
			return removeDirectory(path);
		}
		for (FTPFile ftpFile : ftpFileArr) {
			String name = ftpFile.getName();
			if(ftpFile.isDirectory()){
				System.out.println("Delete subPath ["+path+"/"+name+"]");
				removeDirectory(path+"/"+name,true);
			}else if(ftpFile.isFile()){
				System.out.println("Delete file ["+"/"+name+"]");
				deleteFile(path + "/" + name);
			}
		}
		return ftpClient.removeDirectory(path);
	}
	/**
	 * 检查目录在服务器上是否存在
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public boolean existDirctory(String path) throws IOException {
		boolean flag = false;
		FTPFile[] listFiles = ftpClient.listFiles(path);
		for (FTPFile ftpFile : listFiles) {
			if (ftpFile.isDirectory()
					&& ftpFile.getName().equalsIgnoreCase(path)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	/**
	 * 上传文件到ftp服务器
	 * 
	 * @param isStream
	 *            输入流
	 * @param newName
	 *            新文件名称
	 * @return
	 * @throws IOException
	 */
	public boolean uploadFile(InputStream isStream, String newName)
			throws IOException {
		boolean flag = false;
		try {
			flag = ftpClient.storeFile(newName, isStream);
		} catch (IOException e) {
			flag = false;
			return false;
		} finally {
			if (isStream != null) {
				isStream.close();
			}
		}
		return flag;
	}
	/**
	 * 上传文件到ftp服务器
	 * 
	 * @param localFilePath
	 *            ：本地文件路径和名称
	 * @param remoteFileName
	 *            ：服务器文件名称
	 * @return
	 * @throws IOException
	 */
	public boolean uploadFile(String localFilePath, String remoteFileName)
			throws IOException {
		boolean flag = false;
		InputStream iStream = null;
		try {
			iStream = new FileInputStream(localFilePath);
			flag = ftpClient.storeFile(remoteFileName, iStream);
		} catch (IOException e) {
			flag = false;
			return flag;
		} finally {
			if (iStream != null) {
				iStream.close();
			}
		}
		return flag;
	}
	/**
	 * 上传文件到ftp服务器，上传新的文件名称和原名称一样
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public boolean uploadFile(String fileName) throws IOException {
		return uploadFile(fileName, fileName);
	}
	/**
	 * 从ftp服务器上下载文件到本地
	 * 
	 * @param remoteFileName
	 * @param localFileName
	 * @return
	 * @throws IOException
	 */
	public boolean download(String remoteFileName, String localFileName)
			throws IOException {
		boolean flag = false;
		File outfile = new File(localFileName);
		OutputStream oStream = null;
		try {
			oStream = new FileOutputStream(outfile);
			flag = ftpClient.retrieveFile(remoteFileName, oStream);
		} catch (FileNotFoundException e) {
			flag = false;
			return false;
		} finally {
			oStream.close();
		}
		return flag;
	}
	/**
	 * 从ftp服务器上下载文件到本地
	 * 
	 * @param sourceFileName
	 * @return
	 * @throws IOException
	 */
	public InputStream downFile(String sourceFileName) throws IOException {
		return ftpClient.retrieveFileStream(sourceFileName);
	}
	
	public static void main(String[] args) {
		FtpUtil ftpUtil = new FtpUtil();
		try {
			ftpUtil.connectServer("192.168.102.10", 21, "ljr", "ljr", "");
			ftpUtil.changeDirectory("upload");
			boolean download = ftpUtil.download("tview-11343.zip",
					"d://ftp/tview-11343.zip");
			System.out.println(download);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
