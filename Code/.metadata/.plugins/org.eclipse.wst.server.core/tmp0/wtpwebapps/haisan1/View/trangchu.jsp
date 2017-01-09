<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="./View/Style.css" type="text/css" rel="stylesheet">
<title>hai san quang teo</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<img class="logo" src="../hinhanh/cooltext167942677404796.png">
			<img class="slogan" src="../hinhanh/slogan.jpg"> <img
				class="sdt" src="../hinhanh/sdt.png">
		</div>
		<div id="nav">
			<a href="#">Trang chủ</a> <a href="#">Lien he</a> <a href="#">Gioi
				thieu</a>
		</div>
		<div id="content">
			<div id="content_left">
				<span id="danhmuc">Danh muc san pham</span>
				<ul>
					<c:forEach items="${MyMap}" var="mapItem">
      					  ${mapItem.key} ${mapItem.value} <br />
					</c:forEach>

					<li><a href="#">Cá</a></li>
					<li><a href="#">Tôm-Ghẹ</a></li>
					<li><a href="#">Ốc-Sò</a></li>
					<li><a href="#">Mực</a></li>
				</ul>

			</div>
			<div id="content_right">
				<div id="row">
					<span class="title"><h3>Cá</h3></span>
					<div class="info">
						<ul>

							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>


						</ul>
					</div>

				</div>

				<div id="row">
					<span class="title"><h3>Tôm-Ghẹ</h3></span>
					<div class="info">
						<ul>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
						</ul>
					</div>

				</div>

				<div id="row">
					<span class="title"><h3>Sò-Ốc</h3></span>
					<div class="info">
						<ul>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
						</ul>
					</div>

				</div>

				<div id="row">
					<span class="title"><h3>Mực</h3></span>
					<div class="info">
						<ul>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
							<li><img src="../hinhanh/cacang.jpg">
								<p>ca cang</p>
								<h3>250 k/kg</h3></li>
						</ul>
					</div>

				</div>
			</div>
		</div>
		<div id="footer">
			<h3>Thong tin lien he</h3>
			<a href="#"><img src="../hinhanh/logofb.jpg"> </a>
			<p>moi chi tiet xin lien he :
			<p>anh Le Khanh Quang
			<p>so dien thoai: 01627157704
		</div>
	</div>
</body>
</html>