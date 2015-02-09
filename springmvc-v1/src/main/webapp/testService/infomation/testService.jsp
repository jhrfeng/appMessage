
<%@ taglib prefix="c" uri="/WEB-INF/taglib/jsp-jstl-core.tld" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.jing.maven.SuperServiceTest"%>
<%@page import="com.jing.maven.DataSource"%>

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
			urlString=SuperServiceTest.getUrlString("/infomation/showInfo", DataSource.infomationRequestId());
		}else if(type.equals("002")){
			urlString=SuperServiceTest.getUrlString("/infomation/updateInfo", DataSource.infomationPO());
		}else if(type.equals("003")){
			urlString=SuperServiceTest.getUrlString("/infomation/updateRemark", DataSource.friendListPO());
		}else if(type.equals("004")){
			urlString=SuperServiceTest.getUrlString("/infomation/loadFriendList", DataSource.infomationRequestId());
		}else if(type.equals("005")){
			urlString=SuperServiceTest.getUrlString("/infomation/searchFriend", DataSource.infomationRequest());
		}else if(type.equals("006")){
			urlString=SuperServiceTest.getUrlString("/infomation/addFriend", DataSource.friendListPO());
		}else if(type.equals("007")){
			urlString=SuperServiceTest.getUrlString("/infomation/delFriend", DataSource.friendListPO());
		}else if(type.equals("008")){
			urlString=SuperServiceTest.getUrlString("/infomation/up_honeyname", DataSource.upHoneyname());
		}else if(type.equals("009")){
			urlString=SuperServiceTest.getUrlString("/infomation/up_remark", DataSource.upRemark());
		}else if(type.equals("010")){
			urlString=SuperServiceTest.getUrlString("/infomation/up_birthday", DataSource.upBirhday());
		}else if(type.equals("011")){
			urlString=SuperServiceTest.getUrlString("/infomation/up_area", DataSource.upArea());
		}else if(type.equals("012")){
			urlString=SuperServiceTest.getUrlString("/infomation/up_school", DataSource.upSchool());
		}else if(type.equals("013")){
			urlString=SuperServiceTest.getUrlString("/infomation/up_class", DataSource.upClass());
		}
	}
	response.sendRedirect(urlString);
%>
</body>
</html>