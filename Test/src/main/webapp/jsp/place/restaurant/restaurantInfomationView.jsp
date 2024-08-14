<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Info</title>
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/common/common.css"	type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/place/Place.css" type="text/css" />
<script defer src="${pageContext.request.contextPath}/js/movePage.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<jsp:include page="/jsp/common/header.jsp" />

	<!-- cafe information -->
	<div class="main-container">
		<div class="main-container_content">
			<div class="image-container">
				<img src="/imgEx/더바움.jpg" alt="이미지 준비중" />
			</div>
			<div class="info-container">
				<ul>
					<li class="placeName">${restaurant.placeName}</li>
					<li>Address : ${restaurant.plAddress}</li>
					<li>Phone : ${restaurant.plPhone}</li>
					<li><a href="${restaurant.plWebsite}" target="_blank" class="place--webSite">Web : <span>${restaurant.plWebsite}</span></a></li>
				</ul>
			</div>
		</div>
	</div>

	<jsp:include page="/jsp/common/footer.jsp" />
</body>
</html>