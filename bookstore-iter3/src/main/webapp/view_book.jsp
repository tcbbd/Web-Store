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
<title>查看书籍</title>
<script>
$(document).ready(function() {
  $(".zebra tbody tr td button").click(function() {
    var TableCells = $(this).parent().parent()[0].cells;
    $.post("/bookstore-iter3/add_to_cart", {"ISBN" : TableCells[0].innerHTML}, function(data){
      alert(data);
    });
  });
});
</script>
</head>
<body>
  <c:set var="current" scope="request" value="view_book"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>
  <br/><br/><br/><br/>
  <table class="zebra">
    <thead>
      <tr>
        <th>ISBN</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版日期</th>
        <th>分类</th>
        <th>价格</th>
        <th>库存数量</th>
        <c:if test="${isLogin && !user.admin}">
        <th>加入购物车</th>
        </c:if>
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
        <c:if test="${isLogin && !user.admin}">
        <td></td>
        </c:if>
      </tr>
    </tfoot>
    <tbody>
    <s:iterator value="books">
      <tr>
        <td><s:property value="ISBN"/></td>
        <td><s:property value="title"/></td>
        <td><s:property value="author"/></td>
        <td><s:date name="publishDate" format="yyyy-MM-dd"/></td>
        <td><s:property value="category"/></td>
        <td>&yen;<s:property value="price"/></td>
        <td><s:property value="currentNumber"/></td>
        <c:if test="${isLogin && !user.admin}">
        <td><button type="button">加入购物车</button></td>
        </c:if>
      </tr>
    </s:iterator>
    </tbody>
  </table>
</body>
</html>