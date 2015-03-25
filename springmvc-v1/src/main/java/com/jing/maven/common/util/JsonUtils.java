package com.jing.maven.common.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtils {
	
	private static ObjectMapper m = new ObjectMapper();
	
	private static JsonFactory jf = new JsonFactory();
	
	public static <T> Object fromJson(String jsonAsString, Class<T> pojoClass)
		throws JsonMappingException, JsonParseException, IOException{
		return m.readValue(jsonAsString, pojoClass);
	}
	
	public static <T> Object fromJson(FileReader fr, Class<T> pojoClass)
		throws JsonParseException, IOException
	{
			return m.readValue(fr, pojoClass);
	}
	
	public static String toJson(Object pojo, boolean prettyPrint)
		throws JsonMappingException, JsonGenerationException, IOException
	{
		StringWriter sw = new StringWriter();
		JsonGenerator jg = jf.createJsonGenerator(sw);
		if(prettyPrint){
			jg.useDefaultPrettyPrinter();
		}
		m.writeValue(jg, pojo);
		return sw.toString();	
	}
	
	public static void toJson(Object pojo, Writer writer, boolean prettyPrint)
	throws JsonMappingException, JsonGenerationException, IOException{
		JsonGenerator jg = jf.createJsonGenerator(writer);
		if(prettyPrint){
			jg.useDefaultPrettyPrinter();
		}
		m.writeValue(jg, pojo);
	}
	
	public static String formatDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	
}
