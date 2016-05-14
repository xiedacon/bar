<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>用户申诉列表</title>
    <style type="text/css">
.body .result-table .user-td{
    width: 40%;
}
.body .result-table .operation-td{
    width: 10%;
}
.body .result-table .people-td{
    width: 20%;
}
.body .result-table .time-td{
    width: 20%;
}
</style>
</head>
<body>
    <div class="head">
        <h1>用户申诉列表</h1>
        <div class="tab">
        <div class="tab-buttons">
        <a class="button-focus" href="#">未处理申诉</a>
        <a class="button-unfocus" href="#">已处理申诉</a>
        </div>
        </div>
        <div class="form-bottom">
            <span>申诉用户</span>
            <input class="condition" type="text">
            <a class="button" href="#">搜索</a>
        </div>
    </div>
    <div class="body">
        <p class="result"><a href="#" class="resultAll">全部记录</a>>5条搜索结果</p>
        <table class="result-table">
            <thead>
                <tr>
                    <td class="user-td">头像和用户名</td>
                    <td class="operation-td">全部操作</td>
                    <td class="people-td">操作人</td>
                    <td class="time-td">申诉时间</td>
                    <td class="operation-td">操作</td>
                </tr>
            </thead>
            <tbody>
                <tr class="post">
                    <td class="user"><img class="user-icon" src="${pageContext.request.contextPath}/1.jpg"><a href="#" class="username">看看京东卡了就</a></td>
                    <td>封禁</td>
                    <td>id骄傲山东黄金</td>
                    <td>2014-01-31 20:32</td>
                    <td>
                        <a href="#" class="button">开始处理</a>
                    </td>
                </tr>
                <tr class="post">
                    <td class="user"><img class="user-icon" src="${pageContext.request.contextPath}/1.jpg"><a href="#" class="username">看看京东卡了就</a></td>
                    <td>加入黑名单</td>
                    <td>id骄傲山东黄金</td>
                    <td>2014-01-31 20:32</td>
                    <td>
                        <a href="#" class="button">开始处理</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>