<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>旅遊地點天氣查詢</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap"
	rel="stylesheet">
 <link rel="stylesheet" href="../../pan/cssFolder/index.css">
 <link rel="stylesheet" href="cssfolder/login.css">
<style>
</style>
</head>


<body>

<c:set var='functionCheck' value='logging' scope='session'/>

	<div id="container">
	
		<!-- 引入共同頁首 -->
		<jsp:include page='/fragment/topbar.jsp' />

		
		<!-- 主要內容 -->
		<div id="content">
			<div id="barNav"></div>
			<form id="loginFrame" action="<c:url value='LoginServlet'></c:url>" method='post'>
				<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
				<label for="inputEmail" class="sr-only">Email address</label>
					<input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required="" autofocus="">
				<label for="inputPassword" class="sr-only">Password</label>
					<input type="password" id="inputPassword" name="pwd" class="form-control" placeholder="Password" required="">
				<div class="checkbox mb-3">
				    <label>
				    	<input type="checkbox" value="remember-me"> Remember me
				    </label>
			  	</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			
			</form>
			

		</div>
		
		
		
		<footer> 
		
		</footer>

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
	<script>
/* 	$("#content").load("tester/test.jsp",function(data){
        alert(data)
    }) */
	</script>
		
		
</body>

</html>