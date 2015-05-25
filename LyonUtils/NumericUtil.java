/**
 * @author Lyon
 **/
package utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class NumericUtil {

	public static void main(String[] args) {
		System.out.println(NumericUtil.isNumeric("+10.12"));
		System.out.println(NumericUtil.isNumeric("-10.12"));
		System.out.println(NumericUtil.isInteger("10"));
		System.out.println(NumericUtil.isInteger("10"));
	}
	
	static String numericFormat = "#,##0.00";
	
	/**
	 * 是否為數值
	 */
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 是否為整數
	 */
	public static boolean isInteger(String str) {
		return str.matches("^[-\\+]?[\\d]*$");
	}
	
	/**
     * 格式化數值
     **/
    public static String format(Double num)
    {
    	String result = "";
    	try {
    		result = new DecimalFormat(numericFormat).format(num);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return result;    	
    } //method formatNumeric	
    
    /**
     * 格式化數值
     **/
    public static String format(Integer num)
    {
    	String result = "";
    	try {
    		result = format((double)num);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return result;    
    } //method format	
    
    /**
     * 格式化數值
     **/
    public static String format(String num)
    {
    	String result = "";
    	try {
    		result = format(Double.parseDouble(num));
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return result;    
    } //method format	
    
    /**
     * 格式化數值
     **/
    public static String format(BigDecimal num)
    {
    	String result = "";
    	try {
    		result = format(num.doubleValue());
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return result;    
    } //method format
    
    /**
     * BigDecimal轉前台數值
     **/
    public static String toNumber(BigDecimal num)
    {
    	String result = "";
    	try {
    		result = new DecimalFormat("0.00").format(num);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return result;    
    } //method toNumber	
	
}