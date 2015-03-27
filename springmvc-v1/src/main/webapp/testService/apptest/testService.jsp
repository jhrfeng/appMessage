
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
			urlString=SuperServiceTest.getUrlString("/accountsys/thirdLogin", DataSource.otherAccountLogin());
		}else if(type.equals("002")){
			urlString=SuperServiceTest.getUrlString("/accountsys/logout", null);
		}else if(type.equals("003")){
			urlString=SuperServiceTest.getUrlString("/information/showInfo",null);
		}else if(type.equals("004")){
			urlString=SuperServiceTest.getUrlString("/information/findOtherInfo", DataSource.infomationPO());
		}else if(type.equals("005")){
			urlString=SuperServiceTest.getUrlString("/information/updateRemark", DataSource.friendListPO());
		}else if(type.equals("006")){
			urlString=SuperServiceTest.getUrlString("/information/loadFriendList", null);
		}else if(type.equals("007")){
			urlString=SuperServiceTest.getUrlString("/information/searchFriend", DataSource.infomationRequest());
		}else if(type.equals("008")){
			urlString=SuperServiceTest.getUrlString("/information/addFriend", DataSource.addFriends());
		}else if(type.equals("009")){
			urlString=SuperServiceTest.getUrlString("/information/delFriend", DataSource.addFriends());
		}else if(type.equals("010")){
			urlString=SuperServiceTest.getUrlString("/information/modify_nickname", DataSource.upHoneyname());
		}else if(type.equals("011")){
			urlString=SuperServiceTest.getUrlString("/information/up_remark", DataSource.upRemark());
		}else if(type.equals("012")){
			urlString=SuperServiceTest.getUrlString("/information/modify_birthday", DataSource.upBirhday());
		}else if(type.equals("013")){
			urlString=SuperServiceTest.getUrlString("/information/modify_area", DataSource.upArea());
		}else if(type.equals("014")){
			urlString=SuperServiceTest.getUrlString("/information/modify_school", DataSource.upSchool());
		}else if(type.equals("015")){
			urlString=SuperServiceTest.getUrlString("/information/modify_class", DataSource.upClass());
		}else if(type.equals("016")){
			urlString=SuperServiceTest.getUrlString("/system/feedback", DataSource.feedbackPO());
		}else if(type.equals("017")){
			urlString=SuperServiceTest.getUrlString("/system/about", DataSource.companyInfo());
		}else if(type.equals("018")){
			urlString=SuperServiceTest.getUrlString("/system/download", DataSource.companyInfo());
		}else if(type.equals("019")){
			urlString=SuperServiceTest.getUrlString("/information/modify_signature", DataSource.signature());
		}
	}
	response.sendRedirect(urlString);
%>
</body>
</html>