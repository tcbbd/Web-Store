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
<title>查找用户</title>
</head>
<body>
  <c:set var="current" scope="request" value="user_management"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>  
  <br/><br/>
  <s:if test="search">
    <br/><br/><br/><br/><br/><br/><br/>
  </s:if>
  <s:else>
    <h1 style="text-align: center; color: red; font-size:32px">未找到与<s:property value="username"/>类似的用户名</h1>
    <br/><br/><br/><br/>
  </s:else>
  <form method="post" action="">
    <p style="text-align:center">
      <input type="text" name="username" placeholder="请输入用户名" style="width:512px">
      <input type="submit" name="commit" value="查询">
    </p>
  </form>
  <s:property value="#action.username = null"/>
</body>
</html>