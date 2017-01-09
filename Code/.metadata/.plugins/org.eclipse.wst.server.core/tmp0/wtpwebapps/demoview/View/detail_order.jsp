<%@page import="Model.Giohang"%>
<%@page import="java.util.Map"%>
<%@page import="Model.Monhang"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link href="Style.css" rel="stylesheet" type="text/css">
<title>Chi tiết đơn đặt hàng</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Nav.jsp"></jsp:include>
<div class="content">


	<table class="tbcart" cellspacing="10px">
	<tr>
		<th> Ảnh</th>
		<th> Tên</th>
		<th> Số lượng</th>
		<th> Giá</th>
	</tr>
	<c:forEach items="${detailorder}" var="sp">
		<tr>
		<td><img alt="error" src="${pageContext.request.contextPath}/hinhanh/${sp.anh}" class="imgsmall"></td>
		<td>${sp.tensp}</td>
		<td>${sp.soluong}</td>
		<td><c:if test="${sp.khuyenmai>0 }">
			<span class="amountnew"><fmt:formatNumber type="number" pattern="###,###" value="${sp.gia-((sp.gia*sp.khuyenmai)/100)}"/>đ/kg</span><span class="amountold" ><fmt:formatNumber type="number" pattern="###,###" value="${sp.gia }"/>đ/kg</span>
			</c:if>	
			<c:if test="${sp.khuyenmai==0 }">
			<span class="amountnew"><fmt:formatNumber type="number" pattern="###,###" value="${sp.gia }"/>đ/kg</span>
			</c:if>			
		</td>
	   </tr>
	 </c:forEach>
	 <tr>
	 <th colspan="3"><h2>Tổng tiền:<fmt:formatNumber type="number" pattern="###,###" value="${total}"/>đ</h2></th>
	 </tr>
	<tr>
    <td></td>
     <td colspan="2">
    	<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
    	  <!-- Nhập địa chỉ email người nhận tiền (người bán) -->
            <input type="hidden" name="business" value="tranminhtamseller@gmail.com">
  			<input type="hidden" name="upload" value="1">
            <!-- tham số cmd có giá trị _xclick chỉ rõ cho paypal biết là người dùng nhất nút thanh toán -->
            <input type="hidden" name="cmd" value="_cart">


            <input type="hidden" name="return" value="http://localhost:8081/demoview/Pay?ordercode=${order.maddh}">
             
            
            <!-- Nút bấm. -->
        <c:set var="count" scope="request" value="1"></c:set>
		<c:forEach items="${detailorder}" var="sp">
		            <!-- Thông tin mua hàng. -->
            <input type="hidden" name="item_name_${count}" value="${sp.tensp}">
			<input type="hidden" name="amount_${count}" value="<fmt:formatNumber value='${(sp.gia-((sp.gia*sp.khuyenmai)/100))/dola}' maxIntegerDigits='4' maxFractionDigits='2' groupingUsed='false'/>">
			
			<input type="hidden" name="quantity_${count}" value="${sp.soluong}">
			<c:set var="count" scope="request" value="${count+1}"></c:set>
		 </c:forEach>
		 <c:if test="${!order.thanhtoan}">
		  <input type="submit" name="submit" value="Thanh toán qua Paypal">
		 </c:if>
           
	</form>
     </td>
    </tr>
	</table>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</div>

</body>
</html>