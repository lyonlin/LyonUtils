/****************************************************************************
 *
 * Copyright (c) 2017 ESound Tech. All Rights Reserved.
 *
 * This SOURCE CODE FILE, which has been provided by ESound as part
 * of a ESound product for use ONLY by licensed users of the product,
 * includes CONFIDENTIAL and PROPRIETARY information of ESound.
 *
 * USE OF THIS SOFTWARE IS GOVERNED BY THE TERMS AND CONDITIONS
 * OF THE LICENSE STATEMENT AND LIMITED WARRANTY FURNISHED WITH
 * THE PRODUCT.
 *
 * IN PARTICULAR, YOU WILL INDEMNIFY AND HOLD ESOUND, ITS RELATED
 * COMPANIES AND ITS SUPPLIERS, HARMLESS FROM AND AGAINST ANY CLAIMS
 * OR LIABILITIES ARISING OUT OF THE USE, REPRODUCTION, OR DISTRIBUTION
 * OF YOUR PROGRAMS, INCLUDING ANY CLAIMS OR LIABILITIES ARISING OUT OF
 * OR RESULTING FROM THE USE, MODIFICATION, OR DISTRIBUTION OF PROGRAMS
 * OR FILES CREATED FROM, BASED ON, AND/OR DERIVED FROM THIS SOURCE
 * CODE FILE.
 *
 *
 *     File name:       ReportMapObject.java
 *
 *     History:
 *     Date             Author         Comments
 *     -----------------------------------------------------------------------
 *     SEP 07, 2017     Lyon        Initial Release
 *****************************************************************************/
package com.esound.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * 報表共用物件
 * 
 **/
public class ReportMapObject 
{   
	private Map<String, String> dataMap = new HashMap<String, String>();
	
    public void setValue(String name, String value)
    {
    	if( name != null )
        {
    		dataMap.put(name, value==null?"":value);
        } 
    }
    
    public void setIntValue(String name, int value)
    {
    	if( name != null )
        {
    		dataMap.put(name, String.valueOf(value));
        } 
    }
    
    public void addIntValue(String name, int value)
    {
    	if( name != null )
        {
    		if(dataMap.containsKey(name))
    		{
    			try
				{
    				dataMap.put(name, String.valueOf(Integer.parseInt(dataMap.get(name))+value));
				}
				catch (Exception e)
				{
					
				}
    		}
    		else
    		{
    			dataMap.put(name, String.valueOf(value));
    		}    		
        }
    }
    
    public void addDoubleValue(String name, double value)
    {
    	if( name != null )
        {
    		if(dataMap.containsKey(name))
    		{
    			try
				{
    				dataMap.put(name, String.valueOf(Double.parseDouble(dataMap.get(name))+value));
				}
				catch (Exception e)
				{
					
				}
    		}
    		else
    		{
    			dataMap.put(name, String.valueOf(value));
    		}    		
        }
    }
    
    public String getValue(String name)
    {
    	return dataMap.get(name);
    }
    
    public int getIntValue(String name)
    {
    	try
		{
    		return Integer.parseInt(dataMap.get(name));
		}
		catch (Exception e)
		{
			return 0;
		}
    }
    
    public double getDoubleValue(String name)
    {
    	try
		{
    		return Double.parseDouble(dataMap.get(name));
		}
		catch (Exception e)
		{
			return 0;
		}
    }
    
	
} //class ReportMapObject