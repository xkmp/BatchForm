package xiaokai.api.form.tool;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Winfxk
 */
public class Tool {
	private static String colorKeyString = "123456789abcdef";

	/**
	 * 从一段字符内截取另一段字符
	 * 
	 * @param Context 要截取字符的原文
	 * @param text1   要截取的第一段文字
	 * @param text2   要截取的第二段文字
	 * @return 截取完毕的内容
	 */
	public static String cutString(String Context, String strStart, String strEnd) {
		int strStartIndex = Context.indexOf(strStart);
		int strEndIndex = Context.lastIndexOf(strEnd);
		if (strStartIndex < 0 || strEndIndex < 0)
			return null;
		return Context.substring(strStartIndex, strEndIndex).substring(strStart.length());
	}

	/**
	 * 下载文件
	 * 
	 * @param urlStr   要下载的文件的连接
	 * @param fileName 下载后文件的名字
	 * @param savePath 要保存的位置
	 * @throws IOException
	 */
	public static void DownFile(String urlStr, String fileName, String savePath) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(3 * 1000);
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		InputStream inputStream = conn.getInputStream();
		byte[] getData = readInputStream(inputStream);
		File saveDir = new File(savePath);
		if (!saveDir.exists())
			saveDir.mkdir();
		File file = new File(saveDir + File.separator + fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getData);
		fos.close();
		if (inputStream != null)
			inputStream.close();
	}

	/**
	 * 保存字节流
	 * 
	 * @param inputStream 文件流
	 * @return
	 * @throws IOException
	 */
	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1)
			bos.write(buffer, 0, len);
		bos.close();
		return bos.toByteArray();
	}

	/**
	 * 发送HTTP请求
	 * 
	 * @param httpUrl 请求地址
	 * @param param   请求的内容
	 * @return
	 * @throws Exception
	 */
	public static String getHttp(String httpUrl, String param) throws Exception {
		return getHttp(httpUrl, "POST", param);
	}

	/**
	 * 发送HTTP请求
	 * 
	 * @param httpUrl 请求地址
	 * @param Type    请求的方式
	 * @param param   请求的内容
	 * @return
	 * @throws Exception
	 */
	public static String getHttp(String httpUrl, String Type, String param) throws Exception {
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		URL url = new URL(httpUrl);
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(Type);
		connection.setConnectTimeout(15000);
		connection.setReadTimeout(60000);
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
		if (param != null && !param.isEmpty()) {
			OutputStream os = null;
			os = connection.getOutputStream();
			os.write(param.getBytes());
			os.close();
		}
		if (connection.getResponseCode() == 200) {
			is = connection.getInputStream();
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuffer sbf = new StringBuffer();
			String temp = null;
			while ((temp = br.readLine()) != null) {
				sbf.append(temp);
				sbf.append("\r\n");
			}
			result = sbf.toString();
		}
		if (null != br)
			br.close();
		if (null != is)
			is.close();
		connection.disconnect();
		return result;
	}

	/**
	 * 判断字符串是否是整数型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(Object str) {
		try {
			Float.valueOf(String.valueOf(str)).intValue();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获取随机数
	 * 
	 * @param min 随机数的最小值
	 * @param max 随机数的最大值
	 * @return
	 */
	public static int getRand(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

	/**
	 * 将字符串染上随机颜色
	 * 
	 * @param Font      要染色的字符串
	 * @param ColorFont 随机染色的颜色代码
	 * @return
	 */
	public static String getColorFont(String Font, String ColorFont) {
		String text = "";
		for (int i = 0; i < Font.length(); i++) {
			int rand = Tool.getRand(0, ColorFont.length() - 1);
			text += "§" + ColorFont.substring(rand, rand + 1) + Font.substring(i, i + 1);
		}
		return text;
	}

	/**
	 * 将字符串染上随机颜色
	 * 
	 * @param Font 要染色的字符串
	 * @return
	 */
	public static String getColorFont(String Font) {
		return getColorFont(Font, colorKeyString);
	}

	/**
	 * 将一段不知道什么玩意转化为纯整数
	 * 
	 * @param object
	 * @return
	 */
	public static int ObjectToInt(Object object) {
		return ObjectToInt(object, 0);
	}

	/**
	 * 讲一段不知道什么玩意转化为纯数字
	 * 
	 * @param object
	 * @param i      若不是纯数字将默认转化的值
	 * @return
	 */
	public static int ObjectToInt(Object object, int i) {
		if (object == null)
			return i;
		String string = String.valueOf(object);
		if (string.isEmpty() || !isInteger(object))
			return i;
		return string.contains(".") ? Float.valueOf(object.toString()).intValue() : Integer.valueOf(string);
	}

	/**
	 * 一个Object值转换为bool值，转化失败返回false
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean ObjToBool(Object obj) {
		return ObjToBool(obj, false);
	}

	/**
	 * 一个Object值转换为bool值，转化失败返回false
	 * 
	 * @param obj
	 * @param Del
	 * @return
	 */
	public static boolean ObjToBool(Object obj, boolean Del) {
		if (obj == null)
			return Del;
		try {
			return Boolean.valueOf(String.valueOf(obj));
		} catch (Exception e) {
			return Del;
		}
	}
}
