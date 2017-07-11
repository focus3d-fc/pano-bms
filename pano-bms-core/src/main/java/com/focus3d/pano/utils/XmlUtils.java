package com.focus3d.pano.utils;

import java.io.File;
import java.io.FileWriter;
import java.net.MalformedURLException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * *
 * @author lihaijun
 *
 */
public class XmlUtils {
	/**
	 * *
	 * @param fileName
	 * @return
	 * @throws MalformedURLException
	 * @throws DocumentException
	 */
	public static Document read(String fileName) throws MalformedURLException, DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(fileName));
		return document;
	}
	/**
	 * *
	 * @param doc
	 * @return
	 */
	public static Element getRootElement(Document doc){
		return doc.getRootElement();
	}
	
	 /**
     * 格式化XML文档,并解决中文问题
     * @param filename
     * @return
     */
    public static int writeFile(String filename, Document document){
       int returnValue = 0;
       try{
           XMLWriter writer = null;
           /** 格式化输出,类型IE浏览一样 */
           OutputFormat format = OutputFormat.createPrettyPrint();
           /** 指定XML编码 */
           format.setEncoding("UTF-8");
           writer= new XMLWriter(new FileWriter(new File(filename)),format);
           writer.write(document);
           writer.close();     
           /** 执行成功,需返回1 */
           returnValue = 1;    
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return returnValue;
    }
}
