package com.focus3d.pano.ibator.generate;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.ibator.api.Ibator;
import org.apache.ibatis.ibator.api.ShellCallback;
import org.apache.ibatis.ibator.config.IbatorConfiguration;
import org.apache.ibatis.ibator.config.xml.IbatorConfigurationParser;
import org.apache.ibatis.ibator.exception.InvalidConfigurationException;
import org.apache.ibatis.ibator.exception.XMLParserException;

import com.focustech.focus3d.Focus3dShellCallback;



/**
 * 代码生成
 *
 * 首先去ibatorconfig.xml文件里面修改需要生成的数据库表，然后运行此程序。
 * @author lihaijun
 *
 */
public class Generate {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//String projectPath = System.getProperty("user.dir");
		String projectPath = "F:\\Panorama\\pano-bms\\pano-bms-web\\src\\main\\resources\\context\\datasource\\sqlmap\\";
		generate(projectPath);
	}
	
	public static void generate(String projectPath) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		List<String> warnings = new ArrayList<String>();
		String configFilePath = projectPath + "\\ibatorconfig.xml";
		File configFile = new File(configFilePath);
		IbatorConfigurationParser cp = new IbatorConfigurationParser(warnings);
		IbatorConfiguration config = cp.parseIbatorConfiguration(configFile);
		ShellCallback callback = new Focus3dShellCallback(
				projectPath.substring(0, projectPath.lastIndexOf("\\") + 1));
		Ibator ibator = new Ibator(config, callback, warnings);
		ibator.generate(null);
	}
}
