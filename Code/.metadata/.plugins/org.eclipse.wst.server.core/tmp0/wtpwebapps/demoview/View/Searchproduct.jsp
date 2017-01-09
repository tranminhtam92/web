<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link href="View/Style.css" rel="stylesheet" type="text/css">
<title>Web ban hai san</title>
</head>
<body>
<div class="wrapper">

<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Nav.jsp"></jsp:include>
 <div class="content">
 <c:if test="${empty listproduct}">
 <h2><span>không có sản phẩm '${productname}' được tìm thấy</span></h2>
 </c:if>
  <c:if test="${not empty listproduct}">


 		<div class="product_type">
				<div id="title"></div>
				<div id="product">
					<ul>
					<c:forEach items="${listproduct}" var="product">
						<li><a href="${pageContext.request.contextPath}/sanphamtheoloai?type=productCode&productId=${product.masp}"><img class="image_normal" src="${pageContext.request.contextPath}/hinhanh/${product.anh}">
							<p>${product.tensp}</p>
							<h3>${product.gia}/${product.donvitinh}</h3>
							</a>
					</c:forEach>
					
					</ul>
				</div>
			</div>
</c:if>
 </div>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>