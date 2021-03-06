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
<title>修改个人信息</title>
</head>
<body>
  <c:set var="current" scope="request" value="user"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>
  <section class="container">
    <div class="login">
      <h1>修改个人信息</h1>
      <form method="post" action="" data-validator-option="{theme:'yellow_right'}">
        <p><input type="text" name="email" placeholder="Email" value="${user.email}"
          data-rule="邮箱地址:required; email"></p>
        <p><input type="text" name="phone" placeholder="手机号码" value="${user.phone}"
          data-rule="手机号码:required; mobile"></p>
        <p class="remember_me">
          <label>性别：</label>
          <label><input type="radio" name="gender" value="male" data-rule="checked"
            ${user.male ? 'checked="checked"' : ''} >男</label>&nbsp;
          <label><input type="radio" name="gender" value="female"
            ${user.male ? '' : 'checked="checked"'} >女</label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="修改"></p>
      </form>
    </div>

    <div class="login-help">
      <p><s:property value="errorInfo"/></p>
    </div>
  </section>
</body>
</html>