package com.esound.common.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * fileupload檔案上傳工具.
 * 
 * LIB: commons-fileupload and commons-io
 * 
 * @author Lyon
 * 
 **/
public class FileUploadUtil
{
	
	/**
     * 提取網頁參數與上傳檔案的值於MAP容器中.
     * 
     * @param request 使用者端送出的HTTP request
     * @return 網頁參數與上傳檔案的值
     **/    
    public static Map<String, Object> getMultipartParameterMap(HttpServletRequest request) throws Exception
    {
    	return FileUploadUtil.getMultipartParameterMap(request, null, null);
    }
    
	/**
     * 提取網頁參數與上傳檔案的值於MAP容器中.
     * 
     * @param request 使用者端送出的HTTP request
     * @param fileMaxMb 限制檔案大小(MB),null則無限制
     * @param limitFiles 限制檔案格式(逗號區隔) ex: JPG,WORD, null則無限制
     * @return 網頁參數與上傳檔案的值
     **/    
    public static Map<String, Object> getMultipartParameterMap(HttpServletRequest request, Integer fileMaxMb, String limitFiles) throws Exception
    {
    	Map<String, Object> paraMap = new HashMap<String, Object>();
    	
    	String TEMP_REPOSITY_DIR = "/file_tmp"; 
    	int MAX_MEMORY_SIZE = 0;  
    	
    	if(fileMaxMb==null)
    		fileMaxMb = 0;
    	
   	 	long MAX_FILE_SIZE = Long.valueOf(fileMaxMb*1024*1024); //MB
   	 
   	 	File tempDir = new File(TEMP_REPOSITY_DIR);
        if(!tempDir.exists()) 
        	tempDir.mkdir();
        
        List formItems = null;
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MAX_MEMORY_SIZE);
        factory.setRepository(tempDir);
        
        ServletFileUpload upload = new ServletFileUpload(factory);                       
        upload.setHeaderEncoding("Big5"); //重要，少了這行檔名部份中文會掛
        
        formItems = upload.parseRequest(request); //表單物件清單
        int itemSize = formItems.size();
        for (int i = 0; i < itemSize ; i++) 
        {
            FileItem item = (FileItem) formItems.get(i);
             
            if(item.isFormField())
            {
                String name = item.getFieldName();
                String val = item.getString("Big5");
                paraMap.put(name, val);
            }
            else
            {
                boolean hasFile = false;
            	String fileName = item.getName();
                if(!"".equals(fileName))
                {
                    boolean containDir = false;
                    containDir = (fileName.lastIndexOf("/")>=0 || fileName.lastIndexOf("\\")>=0) ? true : false;
                    if(containDir) 
                    {
                        fileName = fileName.substring(
                        Math.max(fileName.lastIndexOf("/"), fileName.lastIndexOf("\\"))+1 ,
                        fileName.length());    
                    }
                    
                    // 限制上傳檔案類型
                    if( limitFiles!=null && fileName!=null && fileName.length()>0 )
                    {
 	                   	String uFileName = fileName.toUpperCase();
 	                   	boolean allowUpload = false;
 	                   	for(String limit: limitFiles.toUpperCase().split(","))
 	                   	{
 	                   		if(uFileName.indexOf("."+limit)>-1)
 	                   		{
 	                   			allowUpload = true;
 	                   		}		
 	                   	}                    	
 	                   	if(!allowUpload)
 	                   	{
 							StringBuffer errMsg=new StringBuffer();
 							errMsg.append( "此檔案類型不允計上傳" );
 							throw new Exception(errMsg.toString()); 
 	                   	}	
                    }

                    // 限制上傳檔案大小
                    int sizeInBytes = (int) item.getSize(); 
                    if( MAX_FILE_SIZE>0 && sizeInBytes>MAX_FILE_SIZE )
                    {
                        StringBuffer errMsg=new StringBuffer();
                        errMsg.append( "目前檔案的大小為 "+ Math.ceil( (((double)sizeInBytes/1024d)/1024d) ) +" MB，" );
                        errMsg.append( "已超過系統設定 "+ Math.ceil( (((double)MAX_FILE_SIZE/1024d)/1024d) ) +" MB!" );
                        errMsg.append( "無法上傳!" );
                        throw new Exception(errMsg.toString());                   
                    }
                    else if( sizeInBytes>0 )
                    {
                    	paraMap.put("fileName", fileName); // 檔案名稱 String
                    	paraMap.put("fileInputStream", item.getInputStream()); // 檔案內容 InputStream
                    	paraMap.put("fileContent", item.get()); // 檔案內容 byte[]
                    	paraMap.put("fileSize", sizeInBytes); // 檔案大小(byte) int
                    	hasFile = true;
                    }
                }
                paraMap.put("hasFile", hasFile); // 檔案是否存在
            }
        }
		return paraMap;
    }
	
} //class FileUploadUtil
