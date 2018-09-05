<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/9/5
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix= "spring" uri= "http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试基于浏览器请求的国际化</title>
</head>
<body>
<spring:message code="welcome" arguments="${requestScope.user.username}"/>
</body>
</html>
