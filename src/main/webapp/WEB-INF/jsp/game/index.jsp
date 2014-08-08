<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
.hide{
	display:none;
}
.show{
	color:red;
	font-weight:bold;
}
.error{
	color:red;
	font-weight:bold;
}
</style>
<link rel="stylesheet" type="text/css" href="/uno/css/style.css" />
<script type="text/javascript" src="/uno/js/jquery-1.7.2.min.js"></script>
<script>
	$(document).ready(function(){
		var playerNum = $("#players").children().size();
		//$("#players div").css("width", 100 / (playerNum + 1) + "%");
		
		$("#players div").css("width", $("#players").width() / playerNum - 25);
	});
</script>
</head>
<body>
<div id="container">
	<!-- player filed -->
	<div id="players">
		<c:forEach items="${players}" var="num">
			<div id="player${num.index}">${num}</div>
		</c:forEach>
	</div>
	<div id="field">
		<div id="cemetery">${cemeteryNum}张</div>
		<div id="deck">${deckListNum}张</div>
	</div>
	<div id="console">
		<div id="cards">
			<c:forEach items="${cardList}" var="card">
				<div id="card${card.cardId}">${card.cardColor} - ${card.cardName}</div>
			</c:forEach>
		</div>
		<div id="command">
			<a href="javascript:void(0);">确定</a>
			<a href="javascript:void(0);">取消</a>
		</div>
	</div>
</div>
</body>
</html>
