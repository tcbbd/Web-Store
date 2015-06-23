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
<title>BookStore</title>
</head>
<body>
  <c:set var="current" scope="request" value="index"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <h1 style="text-align:center">欢迎光临，${isLogin ? session.user.username : "请先登录或注册"}</h1>
</body>
</html>