<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<title>Quản lý nhà cung cấp</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Thêm mới nhà cung cấp</h1>
<h2>${error}</h2>
<div class="table">
<form action="${pageContext.request.contextPath}/Adminmanufactor" method="post">
<table>
<tr>
<td>Mã nhà cung cấp :</td>

<td> <input type="text" name="manufactorcode" value="${manufactor.manhacungcap}" required></td>
</tr>
<tr>
<td> Tên nhà cung cấp:</td>
<td> <input type="text" name="manufactorname" value="${manufactor.tennhacungcap}}" required></td>
</tr>
<tr>
<td> Địa chỉ:</td>
<td> <input type="text" name="manufactoraddress" value="${manufactor.diachi }" required></td>
</tr>
<tr>
<td> Số điện thoại:</td>
<td> <input type="text" name="manufactortel" value="${manufactor.sodienthoai }" required></td>
</tr>

<tr>
<td></td>
<td> <input type="submit" name="key" value="add"></td>
</tr>
</table>
</form>
</div>
</div>
</div>
</div>
</body>
</html>