<%@page import="Model.Giohang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="View/Style.css" rel="stylesheet" type="text/css">
<title>header</title>
</head>
<body>

		<div class="header">
			<div id="logo">
				<img alt="eror" src="${pageContext.request.contextPath}/hinhanh/cooltext167942677404796.png">
			</div>
			<div id="hotline">
				<img alt="eror" src="${pageContext.request.contextPath}/hinhanh/sdt.png">
			</div>
			<div id="searchcart">
				<div id="search">
					<form action="${pageContext.request.contextPath}/Forward" method="post">
						<select name="filler_order">
						<c:if test="${filler=='1'}">
							<option value="1" selected="selected"> tất cả</option>
						</c:if>
						<c:if test="${filler!='1'}">
							<option value="1"> tất cả</option>
						</c:if>
						<c:if test="${filler=='2'}">
							<option value="2" selected="selected"> trong 1 tháng</option>
						</c:if>
							<c:if test="${filler!='2'}">
							<option value="2"> trong 1 tháng</option>
						</c:if>
							<c:if test="${filler=='3'}">
							<option value="3" selected="selected"> trong 1 tuần</option>
						</c:if>
							<c:if test="${filler!='3'}">
							<option value="3"> trong 1 tuần</option>
						</c:if>
						<c:if test="${filler=='4'}">
							<option value="4" selected="selected"> thanh toán trong 1 tháng</option>
						</c:if>
							<c:if test="${filler!='4'}">
							<option value="4"> thanh toán trong 1 tháng</option>
						</c:if>
						<c:if test="${filler=='5'}">
							<option value="5" selected="selected"> chưa thanh toán trong 1 tháng</option>
						</c:if>
						<c:if test="${filler!='5'}">
							<option value="5"> chưa thanh toán trong 1 tháng</option>
						</c:if>
						<c:if test="${filler=='6'}">
							<option value="6" selected="selected"> thanh toán trong 1 tuần</option>
						</c:if>
						<c:if test="${filler!='6'}">
							<option value="6"> thanh toán trong 1 tuần</option>
						</c:if>
						<c:if test="${filler=='7'}">
							<option value="7" selected="selected"> chưa thanh toán trong 1 tuần</option>
						</c:if>
						<c:if test="${filler!='7'}">
							<option value="7"> chưa thanh toán trong 1 tuần</option>
						</c:if>
						<c:if test="${filler=='8'}">
							<option value="8" selected="selected">đã vận chuyển trong 1 tháng</option>
						</c:if>
						<c:if test="${filler!='8'}">
							<option value="8">đã vận chuyển trong 1 tháng</option>
						</c:if>
						<c:if test="${filler=='9'}">
							<option value="9" selected="selected">chưa vận chuyển trong 1 tháng</option>
						</c:if>
						<c:if test="${filler!='9'}">
							<option value="9">chưa vận chuyển trong 1 tháng</option>
						</c:if>
						<c:if test="${filler=='10'}">
							<option value="10" selected="selected">đã vận chuyển trong 1 tuần</option>
						</c:if>
						<c:if test="${filler!='10'}">
							<option value="10">đã vận chuyển trong 1 tuần</option>
						</c:if>
						<c:if test="${filler=='11'}">
							<option value="11" selected="selected"> chưa vận chuyển trong 1 tuần</option>
						</c:if>
						<c:if test="${filler!='11'}">
							<option value="11"> chưa vận chuyển trong 1 tuần</option>
						</c:if>
						
						</select>
						<input type="submit"
							name="btnsearch" value="lọc đơn đặt hàng">
					</form>

				</div>
		
			</div>

		</div>
</body>
</html>