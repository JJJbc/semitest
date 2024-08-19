<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainSwipe</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/common.css"
	type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/event/mainEvent.css">
<link rel="stylesheet"
<%-- 	href="${pageContext.request.contextPath}/css/main/main.css" --%>
	type="text/css" />
<!-- swiper -->
<link rel="stylesheet"
	href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
<!-- icon -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/icon?family=Material+Icons">
<script defer src="${pageContext.request.contextPath}/js/swipe.js"></script>
<script defer src="${pageContext.request.contextPath}/js/movePage.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<jsp:include page="/jsp/common/header.jsp" />

	<!-- main 화면 -->
	<div id="main-container">
		<div class="main-container__content">
			<!-- Slider main container -->
			<div class="swiper">
				<!-- Additional required wrapper -->
				<!-- 				<div class="swiper-wrapper"> -->
				<!-- 					이미지 -->
				<!-- 					<div class="swiper-slide"> -->
				<!-- 						<a href="/Test/area/place/recommendcafe"> -->
				<!-- 						<h1>ㄹㄹ</h1> -->
				<%-- <%-- 						<img src="${pageContext.request.contextPath}/imgEx/1.jpg" alt="이미지 준비중" class="area--img" /> --%>
				
				<!-- 						</a> -->
				<!-- 					</div> -->

				<!-- 					<div class="swiper-slide"> -->
				<!-- 						<a href="/Test/area/place/recommendpension"> -->
				<!-- 						<h1>ㄹㄹ</h1> -->
				<%-- <%-- 						<img src="${pageContext.request.contextPath}/imgEx/2.jpg" alt="이미지 준비중" class="area--img" /> --%>
			
				<!-- 						</a> -->
				<!-- 					</div> -->

				<!-- 					<div class="swiper-slide"> -->
				<!-- 						<a href="/Test/area/place/recommendrestaurant"> -->
				<!-- 						<h1>ㄹㄹ</h1> -->
				<%-- <%-- 						<img src="${pageContext.request.contextPath}/imgEx/더바움.jpg" alt="이미지 준비중" class="area--img" /> --%>
			
				<!-- 						</a> -->
				<!-- 					</div> -->
				<!-- 					<div class="swiper-slide"> -->
				<!-- 						<h1>ㄹㄹ</h1> -->
				<!-- 					</div> -->
				<!-- 					<div class="swiper-slide"> -->
				<!-- 					<h1>ㄹㄹ</h1> -->

				<!-- 					</div> -->

				<!-- 					..... -->
				<!-- 				</div> -->
				<!-- 				If we need pagination -->
				<!-- 				<div class="swiper-pagination"></div> -->

				<!-- 				좌우버튼 -->
				<!-- 				<div class="swiper-button-prev"></div> -->
				<!-- 				<div class="swiper-button-next"></div> -->

				<!-- 				스크롤바 -->
				<!-- 				<div class="swiper-scrollbar"></div> -->
				<!-- 			</div> -->
				<div class="swiper">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<a href="/Test/area/place/recommendcafe">
							<img src="${pageContext.request.contextPath}/imgEx/1.jpg" alt="이미지 준비중" class="area--img" />	
							</a>						
						</div>
						<div class="swiper-slide">
							<a href="/Test/area/place/recommendpension">
							<img src="${pageContext.request.contextPath}/imgEx/2.jpg" alt="이미지 준비중" class="area--img" />
							</a>
						</div>
						<div class="swiper-slide">
							<a href="/Test/area/place/recommendrestaurant">
							<img src="${pageContext.request.contextPath}/imgEx/더바움.jpg" alt="이미지 준비중" class="area--img" />
							</a>
						</div>	
						<div class="swiper-slide">
							<img src="${pageContext.request.contextPath}/imgEx/카페더킹.jpg" alt="이미지 준비중" class="area--img" /> 
						</div>
						<div class="swiper-slide">
							<img src="${pageContext.request.contextPath}/imgEx/카페이루아.jpg" alt="이미지 준비중" class="area--img" />
						</div>
					</div>

					<div class="swiper-pagination"></div>

					<div class="swiper-button-prev">
						<div class="material-icons">arrow_back</div>
					</div>
					<div class="swiper-button-next">
						<div class="material-icons">arrow_forward</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="/jsp/common/footer.jsp" />
</body>
</html>