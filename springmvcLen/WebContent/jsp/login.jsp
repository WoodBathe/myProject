<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

用户登录
<form action="user/login.do" method="post">
	用户名：<input type="text"  name="username" >
	<br>
	密码：<input type="password"  name="userpass" >
	<br>
	年龄：<input type="text"  name="age" >
	<br>
	多选：<input type="checkbox"  name="check" value="游戏">游戏
	<input type="checkbox"  name="check" value="下棋">下棋
	<input type="checkbox"  name="check" value="篮球">篮球
	<br>
	日期:<input type="text"  name="date">
	<br>
	<input type="submit" value="登录">
</form>


</body>
</html>