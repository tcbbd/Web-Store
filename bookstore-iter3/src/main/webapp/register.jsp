<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<link type="text/css" href="style.css" rel="stylesheet"/>
<link type="text/css" href="jquery.validator.css" rel="stylesheet"/>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="jquery.validator.js"></script>
<script src="local/zh_CN.js"></script>
<title>注册</title>
</head>
<body>
  <c:set var="current" scope="request" value="register"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>  
  <section class="container">
    <div class="login">
      <h1>注册用户</h1>
      <form method="post" action="" data-validator-option="{theme:'yellow_right'}">
        <p><input type="text" name="username" placeholder="用户名"
          data-rule="用户名:required; username; remote[check_username]"></p>
        <p><input type="password" name="password" placeholder="密码"
          data-rule="密码:required; password"></p>
        <p><input type="password" name="confirmPwd" placeholder="确认密码"
          data-rule="确认密码:required; match(password)"></p>
        <p><input type="text" name="email" placeholder="Email"
          data-rule="邮箱地址:required; email"></p>
        <p><input type="text" name="phone" placeholder="手机号码"
          data-rule="手机号码:required; mobile"></p>
        <p class="remember_me">
          <label>性别：</label>
          <label><input type="radio" name="gender" value="male" data-rule="checked">男</label>&nbsp;
          <label><input type="radio" name="gender" value="female">女</label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="注册"></p>
      </form>
    </div>

    <div class="login-help">
      <p><s:property value="errorInfo"/></p>
    </div>
  </section>
</body>
</html>