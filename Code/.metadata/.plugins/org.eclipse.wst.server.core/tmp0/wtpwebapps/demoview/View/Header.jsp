<%@page import="Model.Giohang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="View/Style.css" rel="stylesheet" type="text/css">
<title>header</title>
</head>
<body>
<%
Giohang gh=(Giohang)session.getAttribute("cart");
if(gh==null){
	gh= new Giohang();
	session.setAttribute("cart", gh);
}
%>
		<div class="header">
			<div id="logo">
				<img alt="eror" src="${pageContext.request.contextPath}/hinhanh/cooltext167942677404796.png" >
			</div>
			<div id="hotline">
				<img alt="eror" src="${pageContext.request.contextPath}/hinhanh/sdt.png">
			</div>
			<div id="searchcart">
				<div id="search">
					<form action="Searchproduct" class="searchproduct">
					<table>
					<tr>
					<th><input type="text" name="productname" id="productname" placeholder="nhập sản phẩm tìm kiếm" value="${productname}"> </th>
					<th><input type="image" src="${pageContext.request.contextPath}/hinhanh/find.png" alt="submit" name="key" value="tìm kiếm" width="30px" height="30px"></th>
					</tr>
					</table>
						
						<!-- input type="submit" id="btnsearch" name="btnsearch" value="tìm kiếm"> -->
						
					</form>

				</div>
				<div id="giohang">
				
						<a href="${pageContext.request.contextPath}/Cart?command=giỏ hàng">
						<span ><img alt="error" src="${pageContext.request.contextPath}/hinhanh/carticon.png"></img></span>
						<span>giỏ hàng</span>
						<span ><%=gh.countitem() %></span>
						</a>
					
					
				</div>
			
			</div>

		</div>
</body>
</html>