<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wz
  Date: 2016/6/16
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>好友 </title>
    <link rel="stylesheet" href="semantic-ui/semantic/dist/semantic.min.css">
    <link rel="stylesheet" href="Css/home.css">
</head>

<body>
<s:set name="user" value="#session['user']"/>
<s:set name="search" value="#session['search']"/>
<div class="ui fixed inverted menu">
    <a class="item"><s:property value="#user.userName"/>的主页</a>
    <a class="item" href="home.action?userId=<s:property value="#user.userId"/>">好友动态</a>
    <a class="item" href="person.action?userId=<s:property value="#user.userId"/>">个人动态</a>
    <a class="item  active" href="friend.action?userId=<s:property value="#user.userId"/>">好友</a>
    <a class="item">群组</a>
    <div class="right secondary menu">
        <div class="item">
            <form class="form" method="post" action="search.action">
                <div class="ui action left icon input">
                    <i class="search icon"></i>
                    <input name="userName" type="text" placeholder="用户名">
                    <button class="ui teal button submit">搜索</button>
                </div>
            </form>
        </div>
        <a class="item" href="exit.action">登出</a>
    </div>
</div>

<div class="container">
    <div class="main">
        <div class="ui top attached segment">
            <a class="ui primary ribbon label">我的好友</a>
        <table class="ui single line table">
            <thead>
            <tr>
                <th>用户名</th>
                <th>注册时间</th>
                <th>删除好友</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="#session['friend']" id="f">
            <tr>
                <td><s:property value="#f.userName"/></td>
                <td><s:property value="#f.userTime" /></td>
                <td><a href="">删除</a></td>
            </tr>
            </s:iterator>
            </tbody>
        </table>
        </div>
    </div>
    <div class="side">
        <div class="ui top attached segment">
            <a class="ui primary ribbon label">搜索结果</a>
            <table class="ui single line table">
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>注册时间</th>
                    <th>添加好友</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><s:property value="#search.userName"/></td>
                    <td><s:property value="#search.userTime"/> </td>
                    <td><a href="addfriend.action?userId=<s:property value="#user.userId"/>&friendId=<s:property value="#search.userId"/>">添加</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>



<script src="Js/jquery-2.2.3.min.js"></script>
<script src="semantic-ui/semantic/dist/semantic.min.js"></script>
<script>  $('.ui.dropdown').dropdown();  </script>
</body>
</html>

