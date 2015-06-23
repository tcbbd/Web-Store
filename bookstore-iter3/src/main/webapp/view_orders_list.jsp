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
  <h1 style="text-align: center">我的订单记录</h1>
  <table class="zebra">
    <thead>
      <tr>
        <th>下单时间</th>
        <th>支付金额</th>
        <th>明细</th>
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
    <s:iterator value="#session.user.orders">
      <tr>
        <td><s:property value="time"/></td>
        <td>&yen;<s:property value="totalPrice"/></td>
        <td>
          <a href="?orderID=<s:property value="id"/>">查看订单详情</a>
        </td>
      </tr>
    </s:iterator>
    </tbody>
  </table>
  
  <p style = "text-align:right; font-size:14px; font-weight:bold">
    累计消费人民币&nbsp;<s:property value="total"/>&nbsp;元</p>
</body>
</html>