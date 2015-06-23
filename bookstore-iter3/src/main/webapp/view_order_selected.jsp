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
<title>历史订单</title>
</head>
<body>
  <c:set var="current" scope="request" value="user"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>
  <br/><br/>
  <h1 style="text-align: center">于<s:property value="order.time"/>下单的订单</h1>
  <table class="zebra">
    <thead>
      <tr>
        <th>ISBN</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版日期</th>
        <th>分类</th>
        <th>价格</th>
        <th>购买数量</th>
      </tr>
    </thead>
    <tfoot>
      <tr>
        <td>&nbsp;</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
    </tfoot>
    <tbody>
    <s:iterator value="order.entries">
      <tr>
        <td><s:property value="book.ISBN"/></td>
        <td><s:property value="book.title"/></td>
        <td><s:property value="book.author"/></td>
        <td><s:date name="book.publishDate" format="yyyy-MM-dd"/></td>
        <td><s:property value="book.category"/></td>
        <td>&yen;<s:property value="book.price"/></td>
        <td><s:property value="number"/></td>
      </tr>
    </s:iterator>
    </tbody>
  </table>
  <form method="post" action="/bookstore-iter3/view_orders" style="float:right">
    <input type="submit" value="返回">
  </form>
</body>
</html>