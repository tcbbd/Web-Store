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
<title>删除用户</title>
</head>
<body>
  <c:set var="current" scope="request" value="user"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>
  <br/><br/><br/><br/><br/>
  <h1 style="text-align: center; color:red">警告！</h1>
  <p style="text-align: center; font-size:14px; font-weight: bold">
    一旦删除用户，您正在使用的用户包括其未使用完毕的余额将被永久冻结
    <br/>
    今后您将不能使用该用户名登录本网上书店，确定要删除吗？
  </p>
  <form method="post" action="">
    <p style="text-align:center">
      <input type="submit" name="yes" value="确定">&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="submit" name="no" value="取消">
    </p>
  </form>
</body>
</html>