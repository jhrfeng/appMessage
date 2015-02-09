package com.jing.maven;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.jing.maven.common.util.JsonUtils;



/**
 * 接口测试父类
 * @author lee
 * @date 2014年10月27日 下午5:34:38
 *
 */
@Component
@Lazy(value=false)
public class SuperServiceTest implements ServletContextAware{
	
	private final static Logger log = LoggerFactory.getLogger(SuperServiceTest.class);
	
	//测试地址
	private static String jtestUrlString;
	
	protected static String serviceRootUrl;
	
	private ServletContext servletContext;
	
	//@Value("${jtest.urlString}")
	@Value("")
	public void setJtestUrlString(String jtestUrlString){
		SuperServiceTest.jtestUrlString=jtestUrlString;
	}
	
	@PostConstruct
	public void init() {
		serviceRootUrl = this.servletContext.getContextPath();
		jtestUrlString=jtestUrlString+serviceRootUrl+"/jtest/index.html";
	}
	
	public static void testServiceWithModel(String serviceUrlStr,String urlString,Object po) throws JsonMappingException, JsonGenerationException, IOException {
		String jsonString="{}";
		if (po!=null) {
			jsonString = JsonUtils.toJson(po, false);
		}

		byte[] encode=Base64.encodeBase64(jsonString.getBytes());
				
		String decodestr=new String(encode);
	    //判断当前系统是否支持Java AWT Desktop扩展
        if(java.awt.Desktop.isDesktopSupported()){
            try{
            	//第二个URL传递接口地址
            	urlString = urlString+"?url="+serviceUrlStr+"&base64="+decodestr;
                //创建一个URI实例,注意不是URL
                java.net.URI uri=java.net.URI.create(urlString);
                //获取当前系统桌面扩展
                java.awt.Desktop dp=java.awt.Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
                    //获取系统默认浏览器打开链接
                    dp.browse(uri);
                }
            }catch(java.lang.NullPointerException e){
                //此为uri为空时抛出异常
            }catch(java.io.IOException e){
                //此为无法获取系统默认浏览器
            }
        }
	}
	
	public static String getUrlString(String url, Object po) throws JsonMappingException, JsonGenerationException, IOException{
		log.info("----------jtestUrlString----------"+jtestUrlString);
		log.info("----------serviceRootUrl----------"+serviceRootUrl);
		
		String url_new = new String(jtestUrlString);
		
		String jsonString="{}";
		if (po!=null) {
			jsonString = JsonUtils.toJson(po, false);
		}

		byte[] encode=Base64.encodeBase64(jsonString.getBytes());
				
		String decodestr=new String(encode);
		
		url_new = url_new+"?url="+serviceRootUrl+url+"&base64="+decodestr;
		
		return url_new;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext=servletContext;
	}

}
