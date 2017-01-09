<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Sanpham" %>
 <%@ page import="java.util.ArrayList" %>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Content</title>
</head>
<body>

		<div class="content">
			<div class="product_type">
				<div id="title">Sản phẩm bán chạy</div>
				<div id="product">
					<ul>
					<c:forEach items="${spbanchay}" var="sp">
					
					<li><a href="${pageContext.request.contextPath}/sanphamtheoloai?type=productCode&productId=${sp.masp}"><img class="image_normal" src="${pageContext.request.contextPath}/hinhanh/${sp.anh}">
							
							<c:if test="${sp.khuyenmai>0}">
							<span class="amountnew"><fmt:formatNumber type="number" value="${sp.gia-((sp.gia*sp.khuyenmai)/100)}" pattern="###,###"/>đ/${sp.donvitinh}</span><span class="amountold"><fmt:formatNumber type="number" value="${sp.gia-((sp.gia*sp.khuyenmai)/100)}" pattern="###,###"/> đ/${sp.donvitinh}</span>
					
							<div id="sale">-${sp.khuyenmai}%</div>
						   </c:if>
						   	<c:if test="${sp.khuyenmai==0}">
							<span class="amountnew"><fmt:formatNumber type="number" value="${sp.gia-((sp.gia*sp.khuyenmai)/100)}" pattern="###,###"/>đ/${sp.donvitinh}</span>
							</c:if>
							<c:if test="${sp.sanphammoi}">
							<div id="new">Mới</div>
						  </c:if>
							<div class="productname">${sp.tensp }</div>
							</a>
					</c:forEach>
					</ul>
				</div>
			</div>
			<%int i=0; %>
			<c:forEach  items="${danhmuc}" var="dm">
			<div class="product_type">
				<div id="title"><a href="${pageContext.request.contextPath}/sanphamtheoloai?type=typeCode&maloai=${dm.maloai}">${dm.tenloai}</a></div>
				<div id="product">
					<ul>
					<%ArrayList<Sanpham> listsp=new ArrayList<>();
					listsp=(ArrayList) request.getAttribute("loaisanpham"+i);
					 for (Sanpham sp : listsp) {
					%>
					<li><a href="${pageContext.request.contextPath}/sanphamtheoloai?type=productCode&productId=<%=sp.getMasp()%>"><img class="image_normal" src="${pageContext.request.contextPath}/hinhanh/<%=sp.getAnh()%>">
							
							<%if(sp.getKhuyenmai()>0) {%>
							<span class="amountnew"><fmt:formatNumber type="number" value="<%=sp.getGia()-((sp.getGia()*sp.getKhuyenmai()))/100%>" pattern="###,###"/>đ/<%=sp.getDonvitinh().trim()%></span><span class="amountold"><fmt:formatNumber type="number" value="<%=sp.getGia()%>" pattern="###,###"/>đ/<%=sp.getDonvitinh().trim()%></span>
					
							<div id="sale">-<%=sp.getKhuyenmai()%>%</div>
							<%}
							if(sp.getKhuyenmai()==0){%>
							<span class="amountnew"><fmt:formatNumber type="number" value="<%=sp.getGia()%>" pattern="###,###"/>đ /<%=sp.getDonvitinh().trim()%></span>
							<%} %>
							<%if(sp.isSanphammoi()) {%>
							<div id="new">Mới</div>
							<%} %>
							<div class="productname"><%=sp.getTensp()%></div>
							</a>
					<%} %>
					</ul>
				</div>
				</div>
				<%i++;%>
			</c:forEach>
			
			
			
			
		</div>
</body>
</html>