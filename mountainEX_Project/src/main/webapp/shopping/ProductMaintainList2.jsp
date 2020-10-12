<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<!-- functionCheck 的 value對應值 -->
<!-- 會員登入 = logging -->
<!-- 會員資料 = memberInfo -->
<!-- 資料維護 = maintainInfo -->
<!-- 百戰百岳 = mountain -->
<!-- 露營地/山中小屋 = house -->
<!-- 購物商城 = shopping -->
<!-- 討論區 = platform -->

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>商品資訊</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../pan/cssFolder/index.css">
<style>
</style>
</head>

<body>

	<c:set var='functionCheck' value="shopping" scope="session" />

	<div id="container"></div>
	<!-- 引入共同頁首 -->
	<jsp:include page='/fragment/topbar.jsp' />


	<!-- 主要內容 -->
	<div>
		<FORM ACTION="/MaintanSevlet">
			輸入產品名: <INPUT TYPE="TEXT" NAME="name"><BR>
			 <INPUT	NAME="刪除" TYPE="SUBMIT" VALUE="DELETE">
			<hr>
			輸入型號: <INPUT TYPE="TEXT" NAME="type">
			輸入價格: <INPUT TYPE="TEXT" NAME="price">
			輸入圖片連結: <INPUT TYPE="TEXT" NAME="imgUrl">
			輸入描述: <INPUT TYPE="TEXT" NAME="description">
			輸入次分類: <INPUT TYPE="TEXT" NAME="secondClass">
			輸入庫存: <INPUT TYPE="TEXT" NAME="stock">
			輸入主分類: <INPUT TYPE="TEXT" NAME="firstClassname"><br>
			 <INPUT	NAME="新增" TYPE="SUBMIT" VALUE="INSET"> 
			 <INPUT	NAME="修改" TYPE="SUBMIT" VALUE="UPDATE">
		</FORM>
		
	</div>
	

	<div id="content">
		<table border='1'>
			<tr>
				<td width='200' align='center'>產品名</td>
				<td width='100' align='center'>型號</td>
				<td width='50' align='center'>價格</td>
				<td width='500' align='center'>圖片</td>
				<td width='200' align='center'>敘述</td>
				<td width='200' align='center'>次分類</td>
				<td width='40' align='center'>庫存</td>
				<td width='200' align='center'>主分類</td>
			</tr>
			<c:forEach varStatus="stVar" var="aProductBean"
				items="${products_DPP}">
				<tr>
					<td align='center'>${aProductBean.name}</td>
					<td align='center'>${aProductBean.type}</td>
					<td align='center'>${aProductBean.price}</td>
					<td align='center'>${aProductBean.imgUrl}</td>
					<td align='center'>${aProductBean.description}</td>
					<td align='center'>${aProductBean.secondClass}</td>
					<td align='center'>${aProductBean.stock}</td>
					<td align='center'>${aProductBean.firstClassname}</td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script src="../pan/jsFolder/index.js"></script>
	<script id="contentCov"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>