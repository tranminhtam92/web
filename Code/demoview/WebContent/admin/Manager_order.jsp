<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js" type="text/javascript"></script>

<script type="text/javascript">
  
 
           function changequantity(masp,quantity) {
               //$("#result").html('<img src="${pageContext.request.contextPath}/hinhanh/not-available.png" />');
                $.post('${pageContext.request.contextPath}/Cart?command=sua', {'masp':masp,'quantity':quantity}, function (data) {
                    $("#total").html(data);
                 });
           }
           function clickcheck(maddh){
        	   if($("#checkorder"+maddh).is(":checked")){
        		  
        		   $("#vieworder"+maddh).prop("checked", true);
        		   $("#vieworder"+maddh).prop("checked", true);
        		   $("#checkorder"+maddh).prop("disabled", true);
        		   $.post('${pageContext.request.contextPath}/Adminorder?key=updatecheckorder', {'checkorder':'true','ordercode':maddh}, function (data) {
    						
                    });
        	   }
        	   else{
        		   $.post('${pageContext.request.contextPath}/Adminorder?key=updatecheckorder', {'checkorder':'false','ordercode':maddh}, function (data) {
        			    
                   });
        	   }
           }
           function clickview(maddh){
        	   if($("#vieworder"+maddh).is(":checked")){
        		   $("#vieworder"+maddh).prop("disabled", true);
        		   $.post('${pageContext.request.contextPath}/Adminorder?key=updatevieworder', {'vieworder':'true','ordercode':maddh}, function (data) {
    
                    });
        	   }
        	   else{
        		   $.post('${pageContext.request.contextPath}/Adminorder?key=updatevieworder', {'vieworder':'false','ordercode':maddh}, function (data) {
        			    
                   });
        	   }
           }
           function clickpay(maddh){
        	   if($("#payorder"+maddh).is(":checked")){
        		   $("#vieworder"+maddh).prop("checked", true);
        		   $("#checkorder"+maddh).prop("checked", true);
        		   $("#vieworder"+maddh).prop("disabled", true);
        		   $("#checkorder"+maddh).prop("disabled", true);
        		   $.post('${pageContext.request.contextPath}/Adminorder?key=updatepayorder', {'payorder':'true','ordercode':maddh}, function (data) {
        			   $("#datepay"+maddh).html(data);
                    });
        	   }
        	   else{
        		   $.post('${pageContext.request.contextPath}/Adminorder?key=updatepayorder', {'payorder':'false','ordercode':maddh}, function (data) {
        			   $("#transportorder"+maddh).prop("checked", false);
        			   $("#datepay"+maddh).html("");
                   });
        	   }
           }
           function clicktransport(maddh){
        	   if($("#transportorder"+maddh).is(":checked")){
        		   
        		   $.post('${pageContext.request.contextPath}/Adminorder?key=updatetransportorder', {'transportorder':'true','ordercode':maddh}, function (data) {
        			   if(data=='error'){
        				   $("#transportorder"+maddh).prop("checked", false);
        				   $("#error").html("lỗi, chưa phân công nhân viên vận chuyển hoặc số lượng sản phẩm không đủ");
        			   }
        			   else{
        				   if(!$("#payorder"+maddh).is(":checked"))
        					   {
        					   $("#datepay"+maddh).html(data);
        					   }
        				   $("#vieworder"+maddh).prop("checked", true);
                		   $("#checkorder"+maddh).prop("checked", true);
                		   $("#payorder"+maddh).prop("checked", true);
                		   $("#vieworder"+maddh).prop("disabled", true);
                		   $("#checkorder"+maddh).prop("disabled", true);
                		 
        			   }
        			  
                    });
        	   }
        	   else{
        		   $.post('${pageContext.request.contextPath}/Adminorder?key=updatetransportorder', {'transportorder':'false','ordercode':maddh}, function (data) {
        			  
                   });
        	   }
           }
</script>
<title>Quản lý đơn đặt hàng</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Quản lý đơn đặt hàng</h1>


<table>

<tr>
<form action="${pageContext.request.contextPath}/Adminorder" action="post">
<td><input type="text" name="information" placeholder="nhập nội dung tìm kiếm" value="${information }"></td>
<td><select name="searchtype">
<c:if test="${searchtype=='ordercode' }">
	<option value="ordercode" selected="selected">mã đơn đặt hàng</option>
</c:if>
<c:if test="${searchtype!='ordercode' }">
	<option value="ordercode">mã đơn đặt hàng</option>
</c:if>	
<c:if test="${searchtype=='username' }">
	<option value="username" selected="selected">Tên đăng nhập</option>
</c:if>
<c:if test="${searchtype!='username' }">
	<option value="username" >Tên đăng nhập</option>
</c:if>	
<c:if test="${searchtype=='fullname' }">
	<option value="fullname" selected="selected">Tên người nhận hàng</option>
</c:if>
<c:if test="${searchtype!='fullname' }">
	<option value="fullname">Tên người nhận hàng</option>
</c:if>	
<c:if test="${searchtype=='date' }">
	<option value="date" selected="selected">Ngày đặt hàng</option>
</c:if>
<c:if test="${searchtype!='date' }">
	<option value="date">Ngày đặt hàng</option>
</c:if>	
		
		</select>
</td>
<td><input type="image" src="${pageContext.request.contextPath}/hinhanh/find.png" alt="submit" name="key" value="search" width="20px" height="20px"></td>
</form>
</tr>

<tr>
<form action="${pageContext.request.contextPath}/Adminorder" action="post">
<td colspan="2"><select name="fillorder">
	<c:if test="${filler=='1' }">
	<option value="1" selected="selected">Đơn đặt hàng hôm nay</option>
	</c:if>
	<c:if test="${filler!='1' }">
	<option value="1">Đơn đặt hàng hôm nay</option>
	</c:if>
	<c:if test="${filler=='2' }">
	<option value="2" selected="selected">Tất cả đơn đặt hàng</option>
	</c:if>
	<c:if test="${filler!='2' }">
	<option value="2">Tất cả đơn đặt hàng</option>
	</c:if>
	<c:if test="${filler=='3' }">
	<option value="3" selected="selected">Đơn đặt hàng trong 1 tháng</option>
	</c:if>
	<c:if test="${filler!='3' }">
	<option value="3">Đơn đặt hàng trong 1 tháng</option>
	</c:if>	
	<c:if test="${filler=='4' }">
	<option value="4" selected="selected">Đơn đặt hàng trong 1 tuần</option>
	</c:if>
	<c:if test="${filler!='4' }">
	<option value="4">Đơn đặt hàng trong 1 tuần</option>
	</c:if>	
	<c:if test="${filler=='5' }">
	<option value="5" selected="selected">Đơn đặt hàng đã thanh toán trong 1 tháng</option>
	</c:if>
	<c:if test="${filler!='5' }">
	<option value="5">Đơn đặt hàng đã thanh toán trong 1 tháng</option>
	</c:if>		
	<c:if test="${filler=='6' }">
	<option value="6" selected="selected">Đơn đặt hàng đã thanh toán trong 1 tuần</option>
	</c:if>
	<c:if test="${filler!='6' }">
	<option value="6">Đơn đặt hàng đã thanh toán trong 1 tuần</option>
	</c:if>	
	<c:if test="${filler=='7' }">
	<option value="7" selected="selected">Đơn đặt hàng chưa thanh toán trong 1 tháng</option>
	</c:if>
	<c:if test="${filler!='7' }">
	<option value="7">Đơn đặt hàng chưa thanh toán trong 1 tháng</option>
	</c:if>	
	<c:if test="${filler=='8' }">
	<option value="8" selected="selected">Đơn đặt hàng chưa thanh toán trong 1 tuần</option>
	</c:if>
	<c:if test="${filler!='8' }">
	<option value="8">Đơn đặt hàng chưa thanh toán trong 1 tuần</option>
	</c:if>
	<c:if test="${filler=='9' }">
	<option value="9" selected="selected">Đơn đặt hàng đã vận chuyển trong 1 tháng</option>
	</c:if>
	<c:if test="${filler!='9' }">
	<option value="9">Đơn đặt hàng đã vận chuyển trong 1 tháng</option>
	</c:if>	
	<c:if test="${filler=='10' }">
	<option value="10" selected="selected">Đơn đặt hàng đã vạn chuyển trong 1 tuần</option>
	</c:if>
	<c:if test="${filler!='10' }">
	<option value="10">Đơn đặt hàng đã vạn chuyển trong 1 tuần</option>
	</c:if>	
	<c:if test="${filler=='11' }">
	<option value="11" selected="selected">Đơn đặt hàng chưa vận chuyển trong 1 tháng</option>
	</c:if>
	<c:if test="${filler!='11' }">
	<option value="11">Đơn đặt hàng chưa vận chuyển trong 1 tháng</option>
	</c:if>	
	<c:if test="${filler=='12' }">
	<option value="12" selected="selected">Đơn đặt hàng chưa vận chuyển trong 1 tuần</option>
	</c:if>
	<c:if test="${filler!='12' }">
	<option value="12">Đơn đặt hàng chưa vận chuyển trong 1 tuần</option>
	</c:if>			
		
		</select>
</td>
<td><input type="image" src="${pageContext.request.contextPath}/hinhanh/find.png" alt="submit" name="key" value="filler" width="20px" height="20px"></td>
</form>
</tr>
</table>

<h2 id="error">${error }</h2>
<div class="table">
<table>
<tr>
<th> Mã đơn đặt hàng</th>
<th> Ngày đặt hàng</th>
<th>Tên khách hàng</th>
<th>Tên người nhận</th>
<th>Địa chỉ</th>
<th>Số điện thoại</th>
<th>Tổng tiền</th>
<th>Thanh toán</th>
<th>Ngày thanh toán</th>
<th>Vận chuyển</th>
<th>Ngày vận chuyển</th>
<th>Duyệt đơn</th>
<th>Xem đơn</th>
<th>Nhân viên vận chuyển</th>
<th>Nhân viên duyệt đơn</th>
</tr>
<c:forEach items="${list_order}" var="order">
<tr>
<td>${order.maddh }</td>
<td><fmt:formatDate pattern="dd/MM/yyyy"  value="${order.ngay}" /></td>
<td>${order.tenkhachhang}</td>
<td>${order.tennguoinhan}</td>
<td>${order.diachi}</td>
<td>${order.sodienthoai}</td>
<td><fmt:formatNumber type="number" value="${order.tongtien}" pattern="###,###"/></td>
<td><c:if test="${order.thanhtoan}">
<input type="checkbox" name="payorder" id="payorder${order.maddh }" checked="checked"  onclick="clickpay('${order.maddh}')">
</c:if>
<c:if test="${!order.thanhtoan}">
<input type="checkbox" name="payorder" id="payorder${order.maddh }" onclick="clickpay('${order.maddh}')" >
</c:if>
</td>
<td id="datepay${order.maddh }"><fmt:formatDate pattern="dd/MM/yyyy"  value="${order.ngaythanhtoan}" /></td>

<td><c:if test="${order.vanchuyen}">
<input type="checkbox" name="transportorder" id="transportorder${order.maddh }" checked="checked"  onclick="clicktransport('${order.maddh}')">
</c:if>
<c:if test="${!order.vanchuyen}">
<input type="checkbox" name="transportorder" id="transportorder${order.maddh }" onclick="clicktransport('${order.maddh}')" >
</c:if>
</td>
<td id="datetransport"><fmt:formatDate pattern="dd/MM/yyyy"  value="${order.ngayvanchuyen}" /></td>
<td><c:if test="${order.duyetdon}">
<input type="checkbox" name="checkorder" id="checkorder${order.maddh }" checked="checked" disabled="disabled" onclick="clickcheck('${order.maddh}')">
</c:if>
<c:if test="${!order.duyetdon}">
<input type="checkbox" name="checkorder" id="checkorder${order.maddh }" onclick="clickcheck('${order.maddh}')">
</c:if>
</td>
<td><c:if test="${order.xemdon}">
<input type="checkbox" name="vieworder" id="vieworder${order.maddh }" checked="checked" disabled="disabled" onclick="clickview('${order.maddh}')">
</c:if>
<c:if test="${!order.xemdon}">
<input type="checkbox" name="vieworder" id="vieworder${order.maddh }" onclick="clickview('${order.maddh}')" >
</c:if>
</td>
<td>${order.nhanvienvanchuyen}</td>

<c:if test="${order.nhanvien=='nv' }">
<td>

</td>
</c:if>
<c:if test="${order.nhanvien!='nv' }">
<td>
${order.nhanvien}
</td>
</c:if>
<td><a href="${pageContext.request.contextPath}/Adminorder?key=detail&ordercode=${order.maddh}">chi tiết</a></td>
<td><a href="${pageContext.request.contextPath}/AdminForward_edit?key=edit_order&ordercode=${order.maddh}">sửa</a></td>
<td><a href="${pageContext.request.contextPath}/Adminorder?key=delete&ordercode=${order.maddh}">xóa</a></td>
</tr>
</c:forEach>
</table>
</div>
<center>
<form action="${pageContext.request.contextPath}/Reportdondathang" method="post">
	<input type="submit" name="report" value="in đơn đặt hàng">
	</form>
	</center>
</div>
</div>
</div>
</body>
</html>