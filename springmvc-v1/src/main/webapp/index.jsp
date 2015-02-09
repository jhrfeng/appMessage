<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>欢迎你！！！</h1>

  <form:form method="post" enctype="multipart/form-data"  
   modelAttribute="uploadedFile" action="${pageContext.request.contextPath}/system/fileUpload">  
   <table>  
    <tr>  
     <td>Upload File: </td>  
     <td><input type="file" name="file" />  
     </td>  
     <td style="color: red; font-style: italic;">
     <form:errors  path="file" />  
     </td>  
    </tr>  
    <tr>  
     <td> </td>  
     <td><input type="submit" value="Upload" />  
     </td>  
     <td> </td>  
    </tr>  
   </table>  
  </form:form>  
  
</body>
</html>