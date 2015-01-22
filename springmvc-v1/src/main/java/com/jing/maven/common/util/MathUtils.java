package com.jing.maven.common.util;

public class MathUtils {
	
	public static String generateRandom6(){
		   java.util.Random dom = new java.util.Random();
		   int ints = dom.nextInt(100000);//6位
		   if(ints<10000){
			   return ints+"";
		   }else{
			   return generateRandom6();
		   }
	}

}
