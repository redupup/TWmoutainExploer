<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<c:set var='loginOK' value=''></c:set>


	<header>
		<!-- <h2>旅遊地點天氣查詢</h2> -->
	</header>
	<nav>
		<c:if test='${ empty sessionScope.memberBean }'>
			<div class="top"id="login"  >
				<c:choose>
					<c:when test="${ functionCheck != 'logging' }"> 
						<a href='<c:url value="/member/login/login.jsp" />'>會員登入</a>
					</c:when>
					<c:otherwise>
						會員登入
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
		<c:if test='${ !empty sessionScope.memberBean }'>
			<div  class="top" id="member"  >
				<c:choose>
					<c:when test="${ functionCheck != 'memberInfo' }"> 
						<a href='<c:url value="/member/info/memberInfo.jsp" />'>會員資料</a>
					</c:when>
					<c:otherwise>
						會員資料
					</c:otherwise>
				</c:choose>
			
			
			</div>
		</c:if>
		<c:if test='${ !empty sessionScope.adminBean }'>
			<div class="top" id="admin" class="text-info" >
				<c:choose>
					<c:when test="${ functionCheck != 'maintainInfo' }"> 
						<a href='<c:url value="/maintain/maintain.jsp" />'>資料維護</a>
					</c:when>
					<c:otherwise>
						資料維護
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
		<div class="top" id="mountain" class="text-info">
			<c:choose>
				<c:when test="${ functionCheck != 'mountain' }"> 
					<a href='<c:url value="/mountain/mountainIndex.jsp" />'>百戰百岳</a>
				</c:when>
				<c:otherwise>
					百戰百岳
				</c:otherwise>
			</c:choose>
		</div>
		<div class="top" id="house" class="text-info">
			<c:choose>
				<c:when test="${ functionCheck != 'house' }"> 
					<a href='<c:url value="/house/hList/house.jsp" />'>露營地/山中小屋</a>
				</c:when>
				<c:otherwise>
					露營地/山中小屋
				</c:otherwise>
			</c:choose>
		
		</div>
		<div class="top" id="shopping" class="text-info">
			<c:choose>
				<c:when test="${ functionCheck != 'shopping' }"> 
					<a href='<c:url value="/shopping/shoppingIndex.jsp" />'>購物商城</a>
				</c:when>
				<c:otherwise>
					購物商城
				</c:otherwise>
			</c:choose>
		
		</div>
		
		<div class="top" id="platform" class="text-info">
			<c:choose>
				<c:when test="${ functionCheck != 'platform' }"> 
					<a href='<c:url value="/platform/title/platform.jsp" />'>討論區</a>
				</c:when>
				<c:otherwise>
					討論區
				</c:otherwise>
			</c:choose>
		</div>
		
		

	</nav>



