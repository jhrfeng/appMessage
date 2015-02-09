package com.jing.maven.common.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	 private static Properties properties;
	   
	   static{
		   initConfig();
	   }
	   
		/**
		 * 初始化配置
		 */
		public static void initConfig() {
			try {
				//读取配置文件
				if (properties == null) {
					InputStream inputstream = PropertyUtil.class.getClassLoader().getResourceAsStream("conf/application.properties");
					properties = new Properties();
					properties.load(inputstream);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 读取application.properties中的key的值
		 * @param key
		 * @return
		 */
		public static Object getValue(String key){
			return properties.getProperty(key);
		}
}
