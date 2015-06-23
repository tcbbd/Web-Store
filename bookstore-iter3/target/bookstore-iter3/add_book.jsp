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
<title>添加书籍</title>
</head>
<body>
  <c:set var="current" scope="request" value="add_book"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>
  <section class="container">
    <div class="login">
      <h1>添加书籍</h1>
      <form method="post" action="" data-validator-option="{theme:'yellow_right'}">
        <p><input type="text" name="ISBN" placeholder="ISBN"
          data-rule="ISBN:required; isbn; remote[check_ISBN]" data-rule-isbn="[/^\d+(-\d+)+$/, 'ISBN格式不正确']"></p>
        <p><input type="text" name="title" placeholder="书名"
          data-rule="书名:required;"></p>
        <p><input type="text" name="author" placeholder="作者"
          data-rule="作者:required;"></p>
        <p><input type="text" name="publish_date" placeholder="出版日期"
          data-rule="出版日期:required; date"></p>
        <p><input type="text" name="category" placeholder="分类"
          data-rule="分类:required; "></p>
        <p><input type="text" name="price" placeholder="价格"
          data-rule="价格:required; digits"></p>
        <p><input type="text" name="number" placeholder="数量"
          data-rule="数量:required; digits"></p>
        <p class="submit"><input type="submit" name="commit" value="添加"></p>
      </form>
    </div>

    <div class="login-help">
      <p><s:property value="errorInfo"/></p>
    </div>
  </section>
</body>
</html>