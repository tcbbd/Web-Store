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
  <h1 style="text-align: center">历史订单</h1>
  
  <p style = "text-align:right; font-size:14px; font-weight:bold">
    总计&nbsp;<s:property value="orders.size()"/>&nbsp;笔订单</p>
  <p style = "text-align:right; font-size:14px; font-weight:bold">
    总销量&nbsp;<s:property value="total_price"/>&nbsp;元</p>
    
  <table class="zebra">
    <thead>
      <tr>
        <th>下单时间</th>
        <th>下单用户</th>
        <th>支付金额</th>
        <th>明细</th>
      </tr>
    </thead>
    <tfoot>
      <tr>
        <td>&nbsp;</td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
    </tfoot>
    <tbody>
    <s:iterator value="orders">
      <tr>
        <td><s:property value="time"/></td>
        <td><s:property value="user.username"/><s:property value="user.removed ? ' [已删除]' : ''"/></td>
        <td>&yen;<s:property value="totalPrice"/></td>
        <td>
          <a href="?orderID=<s:property value="id"/>">查看订单详情</a>
        </td>
      </tr>
    </s:iterator>
    </tbody>
  </table>
</body>
</html>