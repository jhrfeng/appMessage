
<%@ taglib prefix="c" uri="/WEB-INF/taglib/jsp-jstl-core.tld" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.jing.maven.test.SuperServiceTest"%>
<%@page import="com.jing.maven.test.DataSource"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>test customer 接口</title>
</head>

<body>
<%
	String type = request.getParameter("type");
    String urlString="";
	if(type!=null){
		if(type.equals("001")){
			urlString=SuperServiceTest.getUrlString("/system/feedback", DataSource.feedbackPO());
		}else if(type.equals("002")){
			urlString=SuperServiceTest.getUrlString("/system/about", DataSource.companyInfo());
		}else if(type.equals("003")){
			urlString=SuperServiceTest.getUrlString("/system/download", DataSource.companyInfo());
		}
	}
	response.sendRedirect(urlString);
%>
</body>
</html>