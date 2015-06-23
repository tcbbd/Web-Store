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
<script>
$(document).ready(function() {
  $(".zebra tbody tr td .remove").click(function() {
    if (confirm("你确定要删除吗？") == false)
      return;
    
    var ThisButton = $(this);
    var TableRow = ThisButton.parent().parent();
    var TableCells = TableRow[0].cells;
    var valid_count = parseInt($("#valid_count").text());
    $.post("/bookstore-iter3/delete_user",
      {"username" : TableCells[0].innerHTML},
      function(data) {
        valid_count -= 1;
        $("#valid_count").text(valid_count.toString());
        TableCells[0].innerHTML = TableCells[0].innerHTML.concat(" [已删除]");
        $(ThisButton).attr("disabled", "disabled");
        alert(data);
    });
  });
});
</script>
<title>查看用户</title>
</head>
<body>
  <c:set var="current" scope="request" value="user_management"></c:set>
  <jsp:include page="nav.jsp"></jsp:include>
  <br/><br/>
  <h1 style="text-align: center">总计<span id="total_count"><s:property value="users.size()"/></span>名用户
    （其中<span id="valid_count"><s:property value="valid_count"/></span>名有效）</h1>
  <table class="zebra">
    <thead>
      <tr>
        <th>用户名</th>
        <th>邮箱</th>
        <th>手机号码</th>
        <th>性别</th>
        <th>余额</th>
        <th>删除用户</th>
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
      </tr>
    </tfoot>
    <tbody>
    <s:iterator value="users">
      <tr>
        <td><s:property value="username"/><s:property value="admin ? ' [管理员]' : ''"/><s:property value="removed ? ' [已删除]' : ''"/></td>
        <td><s:property value="email"/></td>
        <td><s:property value="phone"/></td>
        <td><s:property value="male ? '男' : '女'"/></td>
        <td>&yen;<s:property value="balance"/></td>
        <td>
          <button type="button" <s:property value="(admin || removed) ? 'disabled=disabled' : 'class=remove'"/>>删除</button>
        </td>
      </tr>
    </s:iterator>
    </tbody>
  </table>
</body>
</html>