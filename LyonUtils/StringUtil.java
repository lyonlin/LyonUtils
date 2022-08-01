/**
 * @author Lyon
 **/
package utils;

import java.util.UUID;

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
	 * 是否為非NULL及非空值
	 */
	public static boolean isNotEmpty(String obj) {
		return !isEmpty(obj);
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
	
	/*
	 * 取得UUID
	 * */
	public static String getUUID()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}
	
    /**
     * 在字串左邊填滿指定字元.
     *
     * @param the_str 欲轉換的字串.
     * @param len 欲填滿的長度.
     * @param fill_ch 欲填滿的指定字元.
     * @return 轉換後的字串.
     **/
    public static String fillLeft(String the_str, int len, char fill_ch)
    {
        if(the_str == null)
        {
            the_str = "";
        }
        else if(the_str.length() >= len)
        {
            return the_str;
        }
        
        StringBuffer str_buf = new StringBuffer();
        
        for (int i = len; i > the_str.length(); i--)
            str_buf.append(fill_ch);
            
        str_buf.append(the_str);
        
        return str_buf.toString();
    } //method fillLeft

    /**
     * 在字串右邊填滿指定字元.
     *
     * @param the_str 欲轉換的字串.
     * @param len 欲填滿的長度.
     * @param fill_ch 欲填滿的指定字元.
     * @return 轉換後的字串.
     **/
    public static String fillRight(String the_str, int len, char fill_ch)
    {
        if(the_str == null)
        {
            the_str = "";
        }
        else if(the_str.length() >= len)
        {
            return the_str;
        }

        StringBuffer str_buf = new StringBuffer();
        
        str_buf.append(the_str);
        
        for (int i = len; i > the_str.length(); i--)
            str_buf.append(fill_ch);
            
        return str_buf.toString();
    } //method fillRight
	
}