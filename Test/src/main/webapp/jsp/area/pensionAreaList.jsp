<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pensionAreaList</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
<link rel="stylesheet" href="../css/common/common.css" type="text/css" />
<link rel="stylesheet" href="../css/common/areaAndPlace.css" type="text/css" />
<script defer src="../js/movePage.js"></script>
<style type="text/css">




</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />

	<!-- palce list -->
	<div class="main-container">
		<div class="main-container__content">
			<ul>
				<c:forEach var="areaDto" items="${areaList}">
					<li>						
						<button onclick="movePensionListfnc()" class="areaBtn">${areaDto.areaName}</button>							
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp" />

</body>
</html>