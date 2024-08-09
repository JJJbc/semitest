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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/areaAndPlace.css" type="text/css" />
<script defer src="${pageContext.request.contextPath}/js/movePage.js"></script>
<style type="text/css">


</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<jsp:include page="/jsp/common/header.jsp" />

	<!-- pension information -->
	<div class="main-container">
		<div class="main-container__content">
			<ul>
				<h2>${pension.placeName}</h2>
				<p>Address : ${pension.plAddress}</p>
				<p>Phone : ${pension.plPhone}</p>
				<p>Web : ${pension.plWebsite}</p>
			</ul>
		</div>
	</div>

	<jsp:include page="/jsp/common/footer.jsp" />
</body>
</html>