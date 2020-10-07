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
<title>岳進者</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../../pan/cssFolder/index.css">
<link rel="stylesheet" href="../mountainIndex.css">
<link rel="stylesheet" href="m_design.css">
<style>
</style>
</head>

<body>

	<!-- <c:set var='functionCheck'  value="none" scope="session"/> -->

	<div id="container">

		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />


		<!-- 主要內容 -->
		<div id="content">
			<div id="c_container">
				<jsp:include page="/mountain/m_frag/secondTop.jsp"></jsp:include>
				<div id="m_present">
					<div id="stocker"></div>
					<div class="d_nav">
						<a id="a_act1" class="d_nav_a">活動管理</a>
					</div>
					<div class="d_nav">
						<a id="a_act2" class="d_nav_a">新增活動</a>
					</div>

					<div class="act_manage act_active">
						<table class="table">
							<thead class="thead-light">
								<tr>
									<th scope="col">#</th>
									<th scope="col">活動名稱</th>
									<th scope="col">活動日期及天數</th>
									<th scope="col">活動金額</th>
									<th scope="col">報名上限</th>
									<th scope="col">已報名人數</th>
									<th scope="col">控制選項</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th class="act_row scope="row">1</th>
									<td class="act_name">Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
									<td>@mdo</td>
									<td>@mdo</td>
									<td>@mdo</td>
								</tr>
								<tr>
									<th class="act_row "scope="row">2</th>
									<td class="act_name">Jacob</td>
									<td>Thornton</td>
									<td>@fat</td>
									<td>@fat</td>
									<td>@fat</td>
									<td>@fat</td>
								</tr>
								<tr>
									<th class="act_row scope="row">3</th>
									<td class="act_name">Larry</td>
									<td>the Bird</td>
									<td>@twitter</td>
									<td>@twitter</td>
									<td>@twitter</td>
									<td>@twitter</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="act_manage"></div>

				</div>

			</div>

		</div>

		<footer> </footer>

	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script src="../../pan/jsFolder/index.js"></script>
	<script id="contentCov"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script
		src="//s3-ap-northeast-1.amazonaws.com/justfont-user-script/jf-61018.js"></script>

	<script src="../mountain.js"></script>


</body>

</html>