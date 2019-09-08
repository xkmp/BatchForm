package xiaokai.tool;

/**
 * @author Winfxk
 */
public class Tool {
	private static String colorKeyString = "123456789abcdef";

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
