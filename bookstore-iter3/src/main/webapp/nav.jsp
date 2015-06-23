<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul id="nav">
  <li ${current == 'index' ? 'class="current"' : ''}>
    <a href="/bookstore-iter3">主页</a>
  </li>
  
  <c:if test="${isLogin && user.admin}">
    <li ${current == 'user_management' ? 'class="current"' : ''}>
      <a>用户管理</a>
      <ul>
        <li><a href="/bookstore-iter3/view_user">查看用户</a></li>
        <li><a href="/bookstore-iter3/query_user">查找用户</a></li>
      </ul>
    </li>
  </c:if>
  
  <li ${current == 'view_book' ? 'class="current"' : ''}>
    <a>查看书籍</a>
    <ul>
      <li><a href="/bookstore-iter3/view_book">查看所有书籍</a></li>
      <li><a href="/bookstore-iter3/query_book">查找书籍</a></li>
    </ul>
  </li>
  
  <c:if test="${isLogin && user.admin}">
    <li ${current == 'add_book' ? 'class="current"' : ''}>
      <a href="/bookstore-iter3/add_book">添加书籍</a>
    </li>
    <li ${current == 'sale_statistics' ? 'class="current"' : ''}>
      <a href="/bookstore-iter3/sale_statistics">销售统计</a>
      <ul>
        <li><a href="/bookstore-iter3/sale_statistics?method=byuser">按用户统计</a></li>
        <li>
          <a>按销售日期统计</a>
          <ul>
            <li><a href="/bookstore-iter3/sale_statistics?method=byday">按日统计</a></li>
            <li><a href="/bookstore-iter3/sale_statistics?method=bymonth">按月统计</a></li>
            <li><a href="/bookstore-iter3/sale_statistics?method=byyear">按年统计</a></li>
          </ul>
        </li>
        <li><a href="/bookstore-iter3/sale_statistics?method=bycategory">按分类统计</a></li>
      </ul>
    </li>
  </c:if>
  
  <c:choose>
    <c:when test="${isLogin}">
      <li class="nav_right ${current == 'user' ? 'current' : ''}">
        <a href="#">${user.username}${user.admin ? "[管理员]" : ""}</a>
        <ul>
          <c:if test="${!user.admin}"><li><a href="/bookstore-iter3/shopping_cart">购物车</a></li></c:if>
          <c:if test="${!user.admin}"><li><a href="/bookstore-iter3/view_orders">历史订单</a></li></c:if>
          <c:if test="${!user.admin}"><li><a href="/bookstore-iter3/add_balance">充值
            &nbsp;&nbsp;[余额：${user.balance}元]</a></li></c:if>
          <li><a href="/bookstore-iter3/modify_password">修改密码</a></li>
          <li><a href="/bookstore-iter3/modify_userinfo">修改个人信息</a></li>
          <c:if test="${!user.admin}"><li><a href="/bookstore-iter3/delete_current_user">删除用户</a></li></c:if>
          <li><a href="/bookstore-iter3/exit">退出登录</a></li>
        </ul>
      </li>
    </c:when>
    <c:otherwise>
      <li class="nav_right ${current == 'register' ? 'current' : ''}">
        <a href="/bookstore-iter3/register">注册</a>
      </li>
      <li class="nav_right ${current == 'login' ? 'current' : ''}">
        <a href="/bookstore-iter3/login">登录</a>
      </li>
    </c:otherwise>
  </c:choose>
</ul>