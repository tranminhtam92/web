<%@page import="Model.Loaisanpham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.LoaisanphamDAO"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>


<title>nav</title>
</head>
<body>
<%String username=(String)session.getAttribute("username"); %>
	<div class="nav">
			<div id="menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/">Trang chủ</a>
						<%
						String maloai = request.getParameter("maloai");
						LoaisanphamDAO lspDAO = new LoaisanphamDAO();
						ArrayList<Loaisanpham> listlsp = lspDAO.getallloaisanpham();
						for(Loaisanpham lsp:listlsp){
						%>
					<li><a href="${pageContext.request.contextPath}/sanphamtheoloai?type=typeCode&maloai=<%=lsp.getMaloai() %>"><%=lsp.getTenloai()%></a>
				
					<%} %>
				</ul>
			</div>
			<div id="account">
			<%if(username==null){
				%>
			
				<ul>
					<li><a href="${pageContext.request.contextPath}/View/Register.jsp">Đăng ký</a>
					<li><a href="${pageContext.request.contextPath}/View/login.jsp">Đăng nhập</a>
				
				</ul>
				<% }%>
			<%if(username!=null){
				%>
				
				<ul>
				<li><a href="${pageContext.request.contextPath}/Loginout">Thoát</a>
					<li><a href="${pageContext.request.contextPath}/Information_customer?sm=thông tin cá nhân">thông tin khách hàng</a>
					
				</ul>
				<%} %>
			
			</div>

		</div>
</body>
</html>