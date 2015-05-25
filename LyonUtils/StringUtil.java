/**
 * @author Lyon
 **/
package utils;

public class StringUtil {

	/**
	 * 是否為NULL或空值
	 */
	public static boolean isEmpty(String str) {
		if ((str != null) && (str.trim().length() > 0))
			return false;
		else
			return true;
	}
	
	/**
	 * isEmpty時，回傳空值
	 */
	public static String nullToEmpty(String str) {
		if (isEmpty(str))
			return "";
		else
			return str;
	}
	
	/**
	 * isEmpty時，回傳NULL
	 */
	public static String emptyToNull(String str) {
		if (isEmpty(str))
			return null;
		else
			return str;
	}
	
}