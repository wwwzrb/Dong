<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
    <link rel="stylesheet" href="semantic-ui/semantic/dist/semantic.min.css">
    <link rel="stylesheet" href="Css/home.css">
</head>

<body>
<s:set name="user" value="#session['user']"/>
    <div class="ui fixed inverted menu">
      <a class="item"><s:property value="#user.userName"/>的主页</a>
      <a class="item active" href="home.action?userId=<s:property value="#user.userId"/>">好友动态</a>
      <a class="item" href="person.action?userId=<s:property value="#user.userId"/>">个人动态</a>
      <a class="item" href="friend.action?userId=<s:property value="#user.userId"/>">好友</a>
      <a class="item">群组</a>
      <div class="right secondary menu">
        <a class="item" href="exit.action">登出</a>
      </div>
    </div>

    <div class="container">
        <div class="main">

            <s:iterator value="#session['home']" id="publish">
                <div class="ui feed">

                    <div class="ui top attached segment">
                        <div class="event">
                            <div class="content">
                                <a class="ui primary ribbon label "><s:property value="#publish.userName"/></a>
                                <span class="date"><s:property value="#publish.pubTime"/></span>
                                <div class="extra text"><s:property value="#publish.pubContent"/></div>
                            </div>
                        </div>

                        <div class="ui comments">
                            <div class="ui divider"></div>
                            <s:iterator value="#publish.reply" id="rep">
                                <div class="comment">
                                    <div class="content">
                                        <a class="author"><s:property value="#rep.userName"/></a>
                                        <div class="metadata">
                                            <span class="date"><s:property value="#rep.repTime"/></span>
                                        </div>
                                        <div class="text"><s:property value="#rep.repContents"/></div>
                                    </div>
                                </div>
                            </s:iterator>
                            <form class="ui form" method="post" action="replypub.action">
                                <div class="field">
                                    <input type="hidden" name="page" value="0"/>
                                    <input type="hidden" name="userId" value="<s:property value="#user.userId"/>"/>
                                    <input type="hidden" name="publishId" value="<s:property value="#publish.publishId"/>"/>
                                    <textarea name="repContents" rows="1"></textarea>
                                </div>
                                <button class="ui blue labeled submit icon button"><i class="icon edit"></i> Add Reply </button>
                            </form>
                        </div>
                    </div>

                </div>
            </s:iterator>

        </div>
      <div class="side">
          <div class="ui top attached segment">
              <a class="ui primary ribbon label">添加动态</a>
              <form class="ui form" method="post" action="publish.action">
                  <div class="field">
                      <textarea name="pubContent" rows="3"></textarea>
                  </div>
                  <button class="ui primary button submit">发表</button>
              </form>
          </div>
      </div>
    </div>



    <script src="Js/jquery-2.2.3.min.js"></script>  
    <script src="semantic-ui/semantic/dist/semantic.min.js"></script>
    <script>  $('.ui.dropdown').dropdown();  </script>
  </body>
</html>
