<%@page import="Model.SanphamDAO"%>
<%@page import="ConnectDB.ConnectDB"%>
<%@page import="Model.Sanpham"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="content">
	<div class="contentproducttype">
		<div class="product_type">
				<div id="title">${producttypename}</div>
				<div id="product">
					<ul>
					
					<c:forEach items="${listsp }" var="sp">
					
					<li><a href="${pageContext.request.contextPath}/sanphamtheoloai?type=productCode&productId=${sp.masp}"><img class="image_normal" src="${pageContext.request.contextPath}/hinhanh/${sp.anh}">
							
							<c:if test="${sp.khuyenmai>0}">
							<span class="amountnew"><fmt:formatNumber type="number" pattern="###,###" value="${sp.gia-((sp.gia*sp.khuyenmai)/100)}"/>đ/${sp.donvitinh}</span><span class="amountold"><fmt:formatNumber type="number" pattern="###,###" value="${sp.gia}"/>đ/${sp.donvitinh}</span>
							
							<div id="sale">-${sp.khuyenmai}%</div>
						    </c:if>
							<c:if test="${sp.khuyenmai==0}">
							<span class="amountnew"><fmt:formatNumber type="number" pattern="###,###" value="${sp.gia}"/>đ/${sp.donvitinh}</span>
						    </c:if>
							<c:if test="${sp.sanphammoi}">
							<div id="new">Mới</div>
							</c:if>
							<div class="productname">${sp.tensp}</div>
							</a>
					</c:forEach>
					</ul>
				</div>
				</div>
	</div>
	</div>
</body>
</html>