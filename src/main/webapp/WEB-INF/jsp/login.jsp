<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
.hide {
	display: none;
}

.show {
	color: red;
	font-weight: bold;
}

.error {
	color: red;
	font-weight: bold;
}
</style>
<link rel="stylesheet" type="text/css" href="/uno/css/style.css" />
<script type="text/javascript" src="/uno/js/jquery-1.7.2.min.js"></script>
<script>
	$(document).ready(function() {
		$("#button").bind("click", function() {
			if ($("#username").val() == "") {
				$(".error").html("请输入账号");
				return;
			}
			if ($("#password").val() == "") {
				$(".error").html("请输入密码");
				return;
			}
			$(".result").hide();
			$("#login").submit();
		});
		musemeLoader();
	});
</script>
</head>
<body>
	<div id="main">
		<div>
			<form title="登录" id="login" action="login.do" method="post"
				class="form-wrapper cf">
				<input id="username" name="username" value="${username}" type="text"
					placeholder="填入用户名" /> <input id="password" name="password"
					value="" type="password" placeholder="填入密码" /> <input id="referer"
					name="referer" value="${referer}" type="hidden" /> <input
					id="button" type="button" onclick="javascript:void(0);" value="查询" />
			</form>
		</div>
	</div>

</body>
</html>
