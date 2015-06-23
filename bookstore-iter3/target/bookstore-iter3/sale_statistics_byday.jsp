<%@page import="com.opensymphony.xwork2.ognl.OgnlValueStack"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
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
<title>销售统计</title>
</head>
<body>
  <c:set var="current" scope="request" value="sale_statistics"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>
  <br/><br/>
  <h1 style="text-align: center">每日销售情况</h1>
  <table class="zebra">
    <thead>
      <tr>
        <th>日期</th>
        <th>销售额</th>
        <th>销售量</th>
      </tr>
    </thead>
    <tfoot>
      <tr>
        <td>&nbsp;</td>
        <td></td>
        <td></td>
      </tr>
    </tfoot>
    <tbody>
    <s:iterator value="result" var="row">
      <tr>
        <td>${row["day"]}</td>
        <td>&yen;${row["total"]}</td>
        <td>${row["number"]}&nbsp;本</td>
      </tr>
    </s:iterator>
    </tbody>
  </table>
</body>
</html>