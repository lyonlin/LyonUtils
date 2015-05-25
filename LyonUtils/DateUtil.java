/**
 * @author Lyon
 **/
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) {
		System.out.println(DateUtil.formatDcDate(new Date()));
		System.out.println(DateUtil.formatDcDateTime(new Date()));
		System.out.println(DateUtil.formatRocDate(new Date()));
		System.out.println(DateUtil.formatRocDateTime(new Date()));
	}
	
	static SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy/MM/dd");
	static SimpleDateFormat DateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    /**
     * 格式化日期為yyyy/MM/dd
     **/
    public static String formatDcDate(Date date)
    {
        String strDate = "";
        
        if(date != null)
        {
            strDate = DateFormat.format(date);
        }
        
        return strDate;
    } //method formatDCDate
    
    /**
     * 格式化日期為yyyy/MM/dd HH:mm:ss
     **/
    public static String formatDcDateTime(Date date)
    {
        String strDate = "";
        
        if(date != null)
        {
            strDate = DateTimeFormat.format(date);
        }
        
        return strDate;
    } //method formatDCDateTime
 
    /**
     * 格式化日期為yyy/MM/dd
     **/
    public static String formatRocDate(Date date)
    {
        String strDate = "";
        
        if(date != null)
        {
            strDate = dcToRoc(DateFormat.format(date));
            if(strDate.length() < 9)
            {
                strDate = "0" + strDate;
            }
        }
        
        return strDate;
    } //method formatRocDate
 
    /**
     * 格式化日期為yyy/MM/dd HH:mm:ss
     **/
    public static String formatRocDateTime(Date date)
    {
        String strDate = "";
        
        if(date != null)
        {
            strDate = dcToRoc(DateTimeFormat.format(date));
            if(strDate.length() < 18)
            {
                strDate = "0" + strDate;
            }
        }
        
        return strDate;
    } //method formatRocDateTime
 
    /**
     * 格式化日期為自定格式
     *
     * @param date 要格式化的日期 
     * @param format 日期格式 
     * @return 自定格式的日期字串.
     **/
    public static String formatDate(Date date, String format)
    {
        String strDate = "";
        
        if(date != null)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            strDate = dateFormat.format(date);
        }
        
        return strDate;
    } //method formatDate

    /**
     * 將西元日期格式轉成民國日期格式
     * 
     * @param str 可轉成民國日期格式的西元日期格式
     * @return 民國日期;如果所傳進的日期格式不正確則傳回原字串
     **/
    public static String dcToRoc(String str)
    {
        String chineseDate = str;
        
        if(str != null && str.length() >= 4)
        {
            try
            {
                int chineseYear = Integer.parseInt(str.substring(0,4)) - 1911;
                if(chineseYear > 0)
                {
                    if(str.length() > 4)
                    {
                        chineseDate = chineseYear + str.substring(4);
                    }
                    else
                    {
                        chineseDate = "" + chineseYear;
                    }
                }
            }
            catch(Exception ex)
            {
                
            }
       }
        
        return chineseDate;
    } //method DC2ChineseYear
    
	
}