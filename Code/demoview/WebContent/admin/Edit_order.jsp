<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function checkdate(){
	var string=document.getElementById("date").value;
	var string1=document.getElementById("orderdate").value;
	/*var datenow=new Date(document.getElementById("date").value);
	if(document.getElementById("date").value instanceof Date){
		document.getElementById("error").innerHTML=datenow.toString();
	}*/
	if(string=="")
		{
		document.getElementById("error").innerHTML="ngày vận chuyển không được để trống";
		return false;
		}
	var trasportdate=new Date(string);
	var orderdate=new Date(string1);
	if(trasportdate.getTime()<orderdate.getTime()){
		document.getElementById("error").innerHTML="Lỗi, ngày vận chuyển phải lớn hơn ngày đặt hàng";
		return false;
	}
	return true;
}
</script>
<title>Quản lý đơn đặt hàng</title>
</head>
<body>
<!--  <td> <fmt:formatDate pattern="dd/MM/yyyy"  value="${order.ngay}" /></td>
<td>${order.tennguoinhan}</td>
<td>${order.diachi}</td>
<td>${order.sodienthoai}</td>
<td>${order.thanhtoan}</td>
<td> <fmt:formatDate pattern="dd/MM/yyyy"  value="${order.ngaythanhtoan}" /></td>
<td>${order.vanchuyen}</td>
<td> <fmt:formatDate pattern="dd/MM/yyyy"  value="${order.ngayvanchuyen}" /></td>
-->
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Sửa đơn đặt hàng</h1>
<h2 id=error></h2>
<div class="table">
<form action="${pageContext.request.contextPath}/Adminorder" method="post" onsubmit="return checkdate()">
<table>
<tr>
<td>Mã đơn đặt hàng :</td>
<td> ${order.maddh}</td>
<td> <input type="hidden" name="ordercode" value="${order.maddh}" ></td>
</tr>
<tr>
<td>Thanh toán:</td>
<c:if test="${order.thanhtoan}">
<td><input type="radio" name="pay" value="true" checked="checked" disabled="disabled"> đã thanh toán </td>
<td><input type="radio" name="pay" value="false" disabled="disabled"> chưa thanh toán </td>
</c:if>
<c:if test="${!order.thanhtoan}">
<td><input type="radio" name="pay" value="true"  disabled="disabled"> đã thanh toán </td>
<td><input type="radio" name="pay" value="false" checked="checked" disabled="disabled"> chưa thanh toán </td>
</c:if>
</tr>
<tr>
<td>Ngày đặt:</td>
<td> <input id="orderdate" type="date" name="orderdate" value="${order.ngay}" readonly="readonly"/></td>
</tr>
<tr>
<td>Vận chuyển:</td>
<c:if test="${order.vanchuyen}">
<td><input type="radio" name="transport" value="true" checked="checked" disabled="disabled"> hàng đã được chuyển </td>
<td><input type="radio" name="transport" value="false" disabled="disabled"> hàng chưa được chuyển</td>
</c:if>
<c:if test="${!order.vanchuyen}">
<td><input type="radio" name="transport" value="true" disabled="disabled" > hàng đã được chuyển </td>
<td><input type="radio" name="transport" value="false" checked="checked"disabled="disabled"> hàng chưa được chuyển</td>
</c:if>
</tr>
<td>Ngày vận chuyển:</td>
<td> <input id="date" type="date" name="datetransport"value="${order.ngayvanchuyen}" /></td>
</tr>
<tr>
<td>Người vận chuyển:</td>
<td> <select name="employeecode">
<c:forEach items="${list_employee}" var="employee">
<c:if test="${employee.manhanvien==order.manhanvienvanchuyen}">
<option value="${employee.manhanvien}" selected="selected">${employee.tennhanvien}</option>
</c:if>
<c:if test="${employee.manhanvien!=order.manhanvienvanchuyen}">
<option value="${employee.manhanvien}">${employee.tennhanvien}</option>
</c:if>
</c:forEach>

</select></td>
</tr>
<tr>
<td></td>
<td> <input type="submit" name="key" value="edit"></td>
</tr>
</table>
</form>
</div>
</div>
</div>
</div>
</body>
</html>