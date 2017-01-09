<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin cá nhân</title>
<link href="View/Style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function validateForm()
{
    // Bước 1: Lấy giá trị của username và password
    var fullname = document.getElementById('fullname').value;
    var address = document.getElementById('address').value;
    var tel = document.getElementById('tel').value;
    // Bước 2: Kiểm tra dữ liệu hợp lệ hay không
    if (fullname == ''){
    	document.getElementById('print').innerHTML='họ tên không được trống';
        return false;
    }
    if (address == '')
    {
    	document.getElementById('print').innerHTML='địa chỉ không được trống';
        return false;
    }
   
    if(tel==''){
    	document.getElementById('print').innerHTML='số điện thoại không được trống';
    	   return false;
    }
 
        return true;
    
 
  
}
</script>
</head>
<body>
	<div class="wrapper">

		<jsp:include page="Headeruser.jsp"></jsp:include>
		<jsp:include page="Nav.jsp"></jsp:include>
		<div class="content">
		<div class="content1">
			<div class="content_left">
				<span id="danhmuc">Quản lý thông tin cá nhân</span>
				<ul>
					<li><a href="${pageContext.request.contextPath}/View/changepassword.jsp">Đổi mật khẩu</a></li>
					<li><a href="${pageContext.request.contextPath}/View/Vieworder.jsp">Đơn đặt hàng</a></li>
				</ul>

			</div>
			<div class="content_right">
			<h2><span id="print">${success}</span></h2>
			<form action="Information_customer" method="post" onsubmit="return validateForm()">
			<table>
			<tr>
			<td>Tên đăng nhập:</td>
			<td>${customer.tendangnhap}</td>
			</tr>
			<tr>
			<td>Họ và tên:</td>
			<td><input type="text" name="fullname" id="fullname" value="${customer.tendangnhap}" ></td>
			</tr>
			<tr>
			<td>Địa chỉ:</td>
			<td>	<input type="text" name="address" id="address" value="${customer.diachi}" ></td>
			</tr>
			<tr>
			<td>Số điện thoại:</td>
			<td><input type="text" name="tel" id="tel" value="${customer.sodienthoai}"></td>
			</tr>
			<tr>
			<td></td>
			<td>
			<input type="submit" name="sm" value="sua"></td>
			</tr>
			</table>	
			</form>
			</div>
		</div>
		</div>


		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>