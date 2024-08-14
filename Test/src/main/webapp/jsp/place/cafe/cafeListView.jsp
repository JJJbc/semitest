<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Place List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/common.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/place/Place.css"
	type="text/css" />
<script defer src="${pageContext.request.contextPath}/js/movePage.js"></script>
<style type="text/css">
.list-box__li {
/* 	display: flex; */
	
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<jsp:include page="/jsp/common/header.jsp" />

	<!-- cafe list -->
	<div class="main-container">
		<div class="main-container__content">
			<ul class="list-box">
				<c:forEach var="cafeDto" items="${cafeList}">
					<li class="list-box__li">
						<a
						href="${pageContext.request.contextPath}/place/cafe/infomation?placeNo=${cafeDto.placeNo}"
						class="place--list"> 
							<img src="/img/place/${cafeDto.plImgPath}" alt="이미지 준비중" class="place--img" />
							<span class="place--title">${cafeDto.placeName}</span>
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<jsp:include page="/jsp/common/footer.jsp" />
</body>
</html>