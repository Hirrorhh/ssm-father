<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index.jsp</title>
</head>
<body>
<form action="/user/t/basetype.do" method="post">
		<table>
			<tr>
				<td>姓名:</td>
				<td><input name="name" value="liuyan" /></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input name="age" value="20" /></td>
			</tr>
			<tr>
				<td>收入:</td>
				<td><input name="income" value="100000" /></td>
			</tr>
			<tr>
				<td>结婚:</td>
				<td><input type="radio" name="isMarried" value="true"
					checked="checked" />是 <input type="radio" name="isMarried"
					value="false" />否</td>
			</tr>
			<tr>
				<td>兴趣:</td>
				<td><input type="checkbox" name="interests" value="shopping"
					checked="checked" />购物 <input type="checkbox" name="interests"
					value="sport" checked="checked" />运动 <input type="checkbox"
					name="interests" value="movie" checked="checked" />看电影</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交表单" /></td>
			</tr>
		</table>
	</form>
	
	<br/>
	<br/>
	<br/>
<form action="/user/t/list.do" method="post">
	用户一：<input type="text" name="users[0].name" value="zhangsan"/>
	用户二：<input type="text" name="users[1].name" value="lisi"/>
	用户三：<input type="text" name="users[2].name" value="wangwu"/>
	<input type="submit" value="提交"/>
</form>	
	
	
	
	
	
	
	
	
</body>
</html>