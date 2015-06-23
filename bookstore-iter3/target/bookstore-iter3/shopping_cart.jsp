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
<title>购物车</title>
<script>
$(document).ready(function() {
  $(".zebra tbody tr td .add_one").click(function() {
    var TableRow = $(this).parent().parent();
    var TableCells = TableRow[0].cells;
    var number = parseInt(TableCells[6].innerHTML);
    var total = parseInt($("#total").text());
    $.post("/bookstore-iter3/add_to_cart", {"ISBN" : TableCells[0].innerHTML},
      function(data) {
        total += parseInt(TableCells[5].innerHTML.slice(1));
        $("#total").text(total.toString());
        TableCells[6].innerHTML=(number + 1).toString();
        alert(data);
    });
  });
  $(".zebra tbody tr td .remove_one").click(function() {
    var TableRow = $(this).parent().parent();
    var TableCells = TableRow[0].cells;
    var number = parseInt(TableCells[6].innerHTML);
    var total = parseInt($("#total").text());
    if (number == 1) {
      $.post("/bookstore-iter3/remove_from_cart",
        {"ISBN" : TableCells[0].innerHTML, "all" : "false"},
        function(data) {
          total -= parseInt(TableCells[5].innerHTML.slice(1));
          $("#total").text(total.toString());
          TableRow.remove();
          alert(data);
      });
    }
    else {
      $.post("/bookstore-iter3/remove_from_cart",
        {"ISBN" : TableCells[0].innerHTML, "all" : "false"},
        function(data) {
          total -= parseInt(TableCells[5].innerHTML.slice(1));
          $("#total").text(total.toString());
          TableCells[6].innerHTML=(number - 1).toString();
          alert(data);
      });
    }
  });
  $(".zebra tbody tr td .remove_all").click(function() {
    var TableRow = $(this).parent().parent();
    var TableCells = TableRow[0].cells;
    var total = parseInt($("#total").text());
    $.post("/bookstore-iter3/remove_from_cart",
      {"ISBN" : TableCells[0].innerHTML, "all" : "true"},
      function(data) {
        total -= parseInt(TableCells[5].innerHTML.slice(1)) * parseInt(TableCells[6].innerHTML);
        $("#total").text(total.toString());
        TableRow.remove();
        alert(data);
    });
  });
  $("form").submit(function(){
    if ($("#total").text().length > 0) {
      if (confirm("你确定要购买吗？") == true)
        return true;
      else
        return false;
    }
    else
      return false;
  });
});
</script>
</head>
<body>
  <c:set var="current" scope="request" value="user"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>  
  <br/><br/>
  <h1 style="text-align: center">我的购物车</h1>
  <table class="zebra">
    <thead>
      <tr>
        <th>ISBN</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版日期</th>
        <th>分类</th>
        <th>价格</th>
        <th>数量</th>
        <th>操作购物车</th>
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
        <td></td>
      </tr>
    </tfoot>
    <tbody>
    <s:iterator value="#session.user.cart">
      <tr>
        <td><s:property value="book.ISBN"/></td>
        <td><s:property value="book.title"/></td>
        <td><s:property value="book.author"/></td>
        <td><s:date name="book.publishDate" format="yyyy-MM-dd"/></td>
        <td><s:property value="book.category"/></td>
        <td>&yen;<s:property value="book.price"/></td>
        <td><s:property value="number"/></td>
        <td>
          <button type="button" class="add_one">增加一本</button>
          <button type="button" class="remove_one">移除一本</button>
          <button type="button" class="remove_all">移除全部</button>
        </td>
      </tr>
    </s:iterator>
    </tbody>
  </table>
  
  <div class="login-help">
      <p style="text-align:right; font-size:14px"><s:property value="errorInfo"/></p>
  </div>
  
  <p style = "text-align:right; font-size:14px; font-weight:bold">
    总计人民币&nbsp;<span id="total"><s:property value="total_price"/></span>&nbsp;元</p>
  <form method="post" action="" style="float:right">
    <input type="submit" name="pay" value="购买">
  </form>
</body>
</html>