<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link href="Style.css" rel="stylesheet" type="text/css">
<title>Web ban hai san</title>
<script type="text/javascript">
function validateForm()
{
    // Bước 1: Lấy giá trị của username và password
    var receiver = document.getElementById('receiver').value;
    var address = document.getElementById('address').value;
    var tel = document.getElementById('tel').value;
    // Bước 2: Kiểm tra dữ liệu hợp lệ hay không
    if (receiver == ''){
        alert('Bạn chưa nhập tên nguoi nhận');
        return false;
    }
    if (address == '')
    {
        alert('Bạn chưa nhập dia chi');
        return false;
    }
   
    if(tel==''){
    	   alert('chưa nhập số điện thoại');
    	   return false;
    }
 
        return true;
    
 
  
}
</script>

</head>
<body>
<div class="wrapper">

<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Nav.jsp"></jsp:include>
 <div class="content">
 <h2>Bạn nên điền đầy đủ thông tin để chúng tôi có thể chuyển đến nhanh chóng và chính xác</h2>
 <div>
 <form action="${pageContext.request.contextPath}/Cart" method="post" onsubmit="return validateForm()">
	  <table>
		 <tr>
		 <td>Tên người nhận: </td>
		 <td><input type="text" name="tennguoinhan" id="receiver"></td>
		 </tr>
		 <tr>
		 <td>địa chỉ: </td>
		 <td><input type="text" name="diachi" id="address"></td>
		 </tr>
		  <tr>
		 <td>số điện thoại: </td>
		 <td><input type="text" name="sodienthoai" id="tel"></td>
		 </tr>
		  <tr>
		 <td></td>
		 <td><input type="submit" name="command" value="đặt hàng"></td>
		 </tr>
	 </table>
 </form>

 </div>
 </div>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>