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
<title>新增商品資訊</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../pan/cssFolder/index.css">
<link rel="stylesheet" href="shoppingMall.css">
<style>
</style>
</head>

<body>

	<c:set var='functionCheck' value="shopping" scope="session" />

	<div id="container">

		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />


		<!-- 主要內容 -->
		<div id="content">
			<nav class="shopping_nav">
				<c:forEach var="firstClass" items="${ClassName}" varStatus="vs">
					<div class="top" id="${firstClass.tableName}" class="text-info">
						<div>${firstClass.tableTitle}</div>

					</div>
				</c:forEach>


			</nav>

			<div>
				<FORM ACTION="MaintainServlet">


					<table border='1'>
						<tr width="100%">
							<th width='25%' align='center'>產品名</th>
							<th width='5%' align='center'>型號</th>
							<th width='5%' align='center'>價格</th>
							<th width='25%' align='center'>圖片連結</th>
							<th width='25%' align='center'>敘述</th>
							<th width='5%' align='center'>次分類</th>
							<th width='5%' align='center'>庫存</th>
							<th width='5%' align='center'>主分類ID</th>
							<th width='5%' align='center'>主分類</th>
						</tr>
						<tr width="100%">
							<td width='25%' align='center'><INPUT TYPE="TEXT"
								NAME="name"></td>
							<td width='5%' align='center'><INPUT TYPE="TEXT" NAME="type"></td>
							<td width='5%' align='center'><INPUT TYPE="TEXT"
								NAME="price"></td>
							<td width='25%' align='center'><INPUT TYPE="TEXT"
								NAME="imgUrl" VALUE="null"></td>
							<td width='25%' align='center'><INPUT TYPE="TEXT"
								NAME="description" VALUE="null"></td>
							<td width='5%' align='center'><INPUT TYPE="TEXT"
								NAME="secondClass"></td>
							<td width='5%' align='center'><INPUT TYPE="TEXT"
								NAME="stock"></td>
							<td width='5%' align='center'><INPUT TYPE="TEXT"
								NAME="firstClassID" id="firstClassID"readonly value="10"></td>
							
							<td width='5%' align='center'>
								<select name="firstClassname" id="firstClassname">
										<option value="cloth_class" selected>戶外服飾</option>
										<option value="shoes_class">爬山涉水</option>
										<option value="kitchen_class">戶外廚房</option>
										<option value="tent_class">野外的家</option>
										<option value="backpack_class">功能背包</option>
										<option value="light_class">照明設備</option>
										<option value="promech_class">專業儀器</option>
										<option value="proclimb_class">技術攀登</option>
										<option value="water_class">水上用具</option>
										<option value="other_class">配件、其他</option>
								</select>
							</td>
						</tr>


					</table>
					<hr>
					<INPUT NAME="INSERT" TYPE="SUBMIT" VALUE="確認新增">

				</FORM>

			</div>

			<footer> </footer>

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
			$(".shopping_nav").find(".top").on(
					"click",
					function() {
						let thisID = $(this).attr("id");
						/* console.log(thisID); */
						let td = $("." + thisID);
						/* console.log(td); */
						$("tbody").find("tr:gt(0)").removeClass("sm_active")
								.addClass("sm_wait")
						$("." + thisID).parent().removeClass("sm_wait")
								.addClass("sm_active")

			})
			$("#firstClassname").on("change",function(){
				let val = $("#firstClassname").val()
				switch(val){
					case "cloth_class" :
						$("#firstClassID").val(10);
						break;
					case "shoes_class" :
						$("#firstClassID").val(20);
						break;
					case "kitchen_class" :
						$("#firstClassID").val(30);
						break;
					case "tent_class" :
						$("#firstClassID").val(40);
						break;
					case "backpack_class" :
						$("#firstClassID").val(50);
						break;
					case "light_class" :
						$("#firstClassID").val(60);
						break;
					case "personal_class" :
						$("#firstClassID").val(70);
						break;
					case "promech_class" :
						$("#firstClassID").val(80);
						break;
					case "proclimb_class" :
						$("#firstClassID").val(90);
						break;
					case "water_class" :
						$("#firstClassID").val(100);
						break;
					case "other_class" :
						$("#firstClassID").val(110);
						break;
				
				
				}
			})
					
					
		</script>
</body>

</html>