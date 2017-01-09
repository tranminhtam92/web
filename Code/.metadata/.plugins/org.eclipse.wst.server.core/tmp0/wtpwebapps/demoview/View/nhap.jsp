<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${1000/1000 }
${pageContext.request.contextPath}
<img alt="aa" src="${pageContext.request.contextPath}/hinhanh/logo/png">
<form action="${pageContext.request.contextPath}/nhap" method="post" enctype="multipart/form-data">
<input type="text" name="txt">
<input type="text" name="taa">
<input type="file" name="fileupload" value="aaa">
<input type="submit" name="sm" value="submit">
</form>
    	
</body>
</html>