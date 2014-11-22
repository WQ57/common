package com.wq.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

/**
 * 文件工具类.
 * 
 * @author qingwu
 * @date 2014-5-29 下午5:19:07
 */
public class FileUtil {

	public static final String ENCODING_UTF_8 = "UTF-8";

	public static final String ENCODING_GBK = "GBK";

	public static final String ENCODING_GB2312 = "GB2312";

	public static final String ISO_8859_1 = "ISO-8859-1";

	public static final String ENCODING_DEFAULT = ENCODING_UTF_8;

	/**
	 * 创建文件夹路径.
	 * 
	 * @param path
	 *            文件路径
	 * @return
	 * @author qingwu
	 * @date 2014-8-11 下午3:26:06
	 */
	public static boolean mkDirs(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return file.mkdirs();
		}
		return false;
	}

	/**
	 * 创建文件.
	 * 
	 * @param path
	 *            文件路径
	 * @return
	 * @throws IOException
	 * @author qingwu
	 * @date 2014-8-11 下午3:24:19
	 */
	public static boolean createFile(String path) throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			return file.createNewFile();
		}
		return false;
	}

	/**
	 * 输入流转字符串.
	 * 
	 * @param in
	 *            输入流
	 * @param encoding
	 *            编码
	 * @return
	 * @throws IOException
	 * @author qingwu
	 * @date 2014-8-11 下午4:30:18
	 */
	public static String inputStreamToString(InputStream in, String encoding)
			throws IOException {
		Reader reader = new InputStreamReader(in, encoding);
		char[] cs = new char[512];
		int len = -1;
		StringBuffer sb = new StringBuffer();
		while ((len = reader.read(cs)) != -1) {
			sb.append(new String(cs, 0, len));
		}
		in.close();
		return sb.toString();
	}

	/**
	 * 读取文件内容(默认编码:IOUtil.ENCODING_DEFAULT).
	 * 
	 * @param path
	 *            文件路径
	 * @return
	 * @author qingwu
	 * @throws IOException
	 * @date 2014-8-11 下午4:10:10
	 */
	public static String readFile(String path) throws IOException {
		return readFile(path, ENCODING_DEFAULT);
	}

	/**
	 * 按照特定编码读取文件内容.
	 * 
	 * @param path
	 *            文件路径
	 * @param encoding
	 *            编码
	 * @return
	 * @throws IOException
	 * @author qingwu
	 * @date 2014-8-11 下午4:40:42
	 */
	public static String readFile(String path, String encoding)
			throws IOException {
		File file = new File(path);
		InputStream in = new FileInputStream(file);
		return inputStreamToString(in, encoding);
	}

	/**
	 * 写文件(默认编码:IOUtil.ENCODING_DEFAULT).
	 * 
	 * @param path
	 *            文件路径
	 * @param content
	 *            写入类容
	 * @author qingwu
	 * @throws IOException
	 * @date 2014-8-11 下午5:04:38
	 */
	public static void writeFile(String path, String content)
			throws IOException {
		writeFile(path, content, ENCODING_DEFAULT);
	}

	/**
	 * 写文件.
	 * 
	 * @param path
	 *            文件路径
	 * @param content
	 *            写入内容
	 * @param encoding
	 *            编码
	 * @author qingwu
	 * @throws IOException
	 * @date 2014-8-11 下午5:05:34
	 */
	public static void writeFile(String path, String content, String encoding)
			throws IOException {
		File file = new File(path);
		OutputStream out = new FileOutputStream(file);
		byte[] bytes = content.getBytes(encoding);
		out.write(bytes);
		out.close();
	}

	/**
	 * 保存文件.
	 * 
	 * @param in
	 *            输入流
	 * @param file_name
	 *            文件地址
	 * @author qingwu
	 * @date 2014-5-29 下午5:21:25
	 */
	public static void saveFile(InputStream is, String file_name) {
		File file = new File(file_name);
		OutputStream os = null;
		try {
			if (file.getParentFile() != null && !file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			os = new FileOutputStream(file);
			byte buffer[] = new byte[4 * 1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			os.flush();
		} catch (Exception e) {
			throw new UnCaughtException(e);
		} finally {
			try {
				os.close();
			} catch (Exception e) {
				throw new UnCaughtException(e);
			}
		}
	}
}
