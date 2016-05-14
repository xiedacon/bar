<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>吧务管理日志</title>
    <style type="text/css">
.time{
    padding: 0 0 0 76px;
}
    </style>
</head>
<body>
    <div class="head">
        <h1>吧务管理日志</h1>
        <form>
            <div class="form-top">
            <span><input name="initiator" type="radio" value="0" />发起人</span>
            <span><input name="operator" type="radio" value="1" />操作人</span>
            <span class="time">操作时间</span>
            </div>
            <div class="form-bottom">
                <input class="condition" name="username" type="text" />
                <div class="operationTime">
                <input class="operationTime-after" name="operationTime-after" type="date">至
                <input class="operationTime-before" name="operationTime-before" type="date">
                <a href="#" class="button">搜索</a>
                <a href="#" class="searchAll">显示全部记录</a>
                </div>
            </div>
        </form>
    </div>
    <div class="body">
        <p class="result">共<span class="result-count">12312</span>条记录</p>
        <table class="result-table">
            <thead>
                <tr>
                    <td class="content-td">用户名</td>
                    <td class="operation-td">操作</td>
                    <td class="people-td">全部操作人</td>
                    <td class="operationTime-td">操作时间</td>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="adminLogPageBean.beanList" var="adminLog">
                <tr id="<s:property value='#adminLog.id'/>" class="post">
                    <td class="user">
                        <img src="${pageContext.request.contextPath}/image/<s:property value='#adminLog.adminUser.icon'/>" class="user-icon">
                        <a href="#" class="username"><s:property value='#adminLog.adminUser.name'/></a>
                    </td>
                    <td><s:property value='#adminLog.operation'/></td>
                    <td><s:property value='#adminLog.operator.name'/></td>
                    <td><s:date name='#adminLog.time' format="yyyy-MM-dd HH:mm"></s:date></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>
</body>
</html>