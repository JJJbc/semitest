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
<link rel="stylesheet" href="../css/common/common.css" type="text/css" />
<link rel="stylesheet" href="../css/common/areaAndPlace.css" type="text/css" />
<script defer src="../js/movePage.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />

	<!-- 펜션 리스트 배열로 호출 후 출력  -->
	<div class="main-container">
		<div class="main-container__content">
			<ul>
				<c:forEach var="pensionDto" items="${pensionList}">
					<li>
						<div>${pensionDto.placeName}</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>