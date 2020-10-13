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
<title>商品資訊維護</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap"
	rel="stylesheet">
 <link rel="stylesheet" href="../pan/cssFolder/index.css">
 <link rel="stylesheet" href="shoppingMall.css">
<style>
</style>
</head>

<body>

<c:set var='functionCheck'  value="shopping" scope="session"/>

	<div id="container">
	
		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />

		
		<!-- 主要內容 -->
		<div id="content">
		<nav class="shopping_nav">
		<c:forEach var="firstClass" items="${ClassName}" varStatus="vs">
			<div class="top" id="${firstClass.tableName}" class="text-info">
				<div>
				 	${firstClass.tableTitle}
				</div>

			</div>
		</c:forEach>
		
					
			</nav>
			
			<div>
			<FORM ACTION="MaintainServlet">
				輸入產品名: <INPUT TYPE="TEXT" NAME="name"><BR>
				 <INPUT	NAME="DELETE" TYPE="SUBMIT" VALUE="刪除">
				 <br>
				修改型號: <INPUT TYPE="TEXT" NAME="type">
<!-- 				修改價格: <INPUT TYPE="TEXT" NAME="price"> -->
				修改次分類: <INPUT TYPE="TEXT" NAME="secondClass">
				修改庫存: <INPUT TYPE="TEXT" NAME="stock">
				 <INPUT	NAME="UPDATE" TYPE="SUBMIT" VALUE="修改">
				 
			</FORM>
				<hr>
				<hr>
				<a href='<c:url value="/shopping/InsertPage.jsp" />'>新增一筆商品資訊</a>
				<hr>

			
		</div>
		<table border='1'>
			<tr width="100%">
				<th width='25%' align='center'>產品名</th>
				<th width='5%' align='center'>型號</th>
				<th width='5%' align='center'>價格</th>
				<th width='25%' align='center'>圖片</th>
				<th width='25%' align='center'>敘述</th>
				<th width='5%' align='center'>次分類</th>
				<th width='5%' align='center'>庫存</th>
				<th width='5%' align='center'>主分類</th>
			</tr>
			<c:forEach varStatus="stVar" var="aProductBean"
				items="${products_DPP}">
				<c:choose>
				<c:when test="${aProductBean.firstClassname == 'cloth_class'}"> 
					
					<tr class="sm_active" >
						<td width='200' align='center'>${aProductBean.name}</td>
						<td width='100' align='center'>${aProductBean.type}</td>
						<td width='50' align='center'>${aProductBean.price}</td>
						<td width='500' align='center'>${aProductBean.imgUrl}</td>
						<td width='200' align='center'>${aProductBean.description}</td>
						<td width='200' align='center'>${aProductBean.secondClass}</td>
						<td width='40' align='center'>${aProductBean.stock}</td>
						<td width='200' align='center' class="${aProductBean.firstClassname}">${aProductBean.firstClassname}</td>
					</tr>
				
				</c:when>
				<c:otherwise>
					<tr class="sm_wait" >
						<td align='center'>${aProductBean.name}</td>
						<td align='center'>${aProductBean.type}</td>
						<td align='center'>${aProductBean.price}</td>
						<td align='center'>${aProductBean.imgUrl}</td>
						<td align='center'>${aProductBean.description}</td>
						<td align='center'>${aProductBean.secondClass}</td>
						<td align='center'>${aProductBean.stock}</td>
						<td align='center' class="${aProductBean.firstClassname}">${aProductBean.firstClassname}</td>
					</tr>
				</c:otherwise>
				</c:choose>
				
			</c:forEach>

		</table>
			

		</div>

		<footer> 
		
		</footer>

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
	<script>
		$(".shopping_nav").find(".top").on("click",function(){
			let thisID = $(this).attr("id");
			/* console.log(thisID); */
			let td = $("."+thisID);
			/* console.log(td); */
			$("tbody").find("tr:gt(0)").removeClass("sm_active").addClass("sm_wait")
			$("."+thisID).parent().removeClass("sm_wait").addClass("sm_active")
			
		})
	
	</script>
		
		
</body>

</html>