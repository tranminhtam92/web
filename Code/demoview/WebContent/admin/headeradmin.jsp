<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="nav">
			<div id="menu">
				<ul>
					<li> QT
				</ul>
			</div>
			<div id="account">
		
				
				<ul>
				<li><a href="${pageContext.request.contextPath}/Logout">Thoát</a>
					<li>${sessionScope.name }</a>
					
				</ul>
				
			
			</div>

		</div>
</body>
</html>