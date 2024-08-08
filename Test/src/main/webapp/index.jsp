<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dog With You</title>
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/common/common.css">
<script defer src="./js/movePage.js"></script>

</head>
<body>

<jsp:include page="./jsp/common/header.jsp"/>

<div id="main-container">
  <div class="main-container__content">메인 구조 확인용1</div>
  <div class="main-container__content">메인 구조 확인용2</div>
  <div class="main-container__content">메인 구조 확인용3</div>
  <div class="main-container__content">메인 구조 확인용4</div>
</div>

<jsp:include page="./jsp/common/footer.jsp"/>


</body>
</html>