<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đổi mật khẩu</title>
<link href="View/Style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function validateForm()
{
    // Bước 1: Lấy giá trị của username và password
    var passnew = document.getElementById('passnew').value;
    // Bước 2: Kiểm tra dữ liệu hợp lệ hay không
    if (passnew == ''){
    	document.getElementById('print').innerHTML='lỗi, mật khẩu mới không được trống';
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
		<div class="contentchangepass">
			<h2><span id="print"> ${notify}</span></h2>
			<form action="${pageContext.request.contextPath}/Information_customer" method="post" onsubmit="return validateForm()">
			<table>
			<tr>
			<td>Mật khẩu cũ:</td>
			<td><input type="password" name="passold" id="passold" value=""></td>
			</tr>
			<tr>
			<td>Mật khẩu mới:</td>
			<td><input type="password" name="passnew" id="passnew" value="" ></td>
			</tr>
			<tr>
			<td>Nhập lại mật khẩu mới:</td>
			<td>	<input type="password" name="re_passnew" id="re_passnew" value="" ></td>
			</tr>
			<tr>
			<td></td>
			<td>
			<input type="submit" name="sm" value="đổi mật khẩu"></td>
			</tr>
			</table>	
			</form>
		</div>
		</div>


		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>