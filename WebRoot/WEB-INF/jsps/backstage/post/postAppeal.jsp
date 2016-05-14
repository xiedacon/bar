<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>吧务帖子申诉</title>
    <style type="text/css">
.body .result-table .appealUser-td{
    width: 20%;
}
.body .result-table .deleteTime-td{
    width: 20%;
}
.body .result-table .deleteUser-td{
    width: 20%;
}
.body .result-table .appealTime-td{
    width: 20%;
}
.body .result-table .operation-td{
    width: 20%;
}
.result-table .username{
    color: #398BFC;
    font-size: 16px;
}
.result-table .username i{
    color: #398BFC;
    font-size: 16px;
    font-family: "icomoon";
}
    </style>
</head>
<body>
    <div class="head">
        <h1>吧务帖子申诉</h1>
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
                    <td class="appealUser-td">申诉用户</td>
                    <td class="deleteTime-td">删帖时间</td>
                    <td class="deleteUser-td">删帖操作人</td>
                    <td class="appealTime-td">申诉时间</td>
                    <td class="operation-td">操作</td>
                </tr>
            </thead>
            <tbody>
                <tr class="post">
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>2013-12-3 01:16:32</td>
                    <td>啊实打实的</td>
                    <td>2013-12-3 01:16:32</td>
                    <td><a class="button" href="#">开始处理</a></td>
                </tr>
                <tr class="post">
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>2013-12-3 01:16:32</td>
                    <td>啊实打实的</td>
                    <td>2013-12-3 01:16:32</td>
                    <td><a class="button" href="#">开始处理</a></td>
                </tr>
                <tr class="post">
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>2013-12-3 01:16:32</td>
                    <td>啊实打实的</td>
                    <td>2013-12-3 01:16:32</td>
                    <td><a class="button" href="#">开始处理</a></td>
                </tr>
                <tr class="post">
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>2013-12-3 01:16:32</td>
                    <td>啊实打实的</td>
                    <td>2013-12-3 01:16:32</td>
                    <td><a class="button" href="#">开始处理</a></td>
                </tr>
                <tr class="post">
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>2013-12-3 01:16:32</td>
                    <td>啊实打实的</td>
                    <td>2013-12-3 01:16:32</td>
                    <td><a class="button" href="#">开始处理</a></td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="body">
        <p class="result"><a href="#" class="resultAll">全部记录</a>>5条搜索结果</p>
        <table class="result-table">
            <thead>
                <tr>
                    <td class="appealUser-td">申诉用户</td>
                    <td class="deleteTime-td">删帖时间</td>
                    <td class="deleteUser-td">删帖操作人</td>
                    <td class="appealTime-td">申诉时间</td>
                    <td class="operation-td">操作</td>
                </tr>
            </thead>
            <tbody>
                <tr class="post">
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>2013-12-3 01:16:32</td>
                    <td>啊实打实的</td>
                    <td>2013-12-3 01:16:32</td>
                    <td>已恢复</td>
                </tr>
                <tr class="post">
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>2013-12-3 01:16:32</td>
                    <td>啊实打实的</td>
                    <td>2013-12-3 01:16:32</td>
                    <td>删除</td>
                </tr>
                <tr class="post">
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>2013-12-3 01:16:32</td>
                    <td>啊实打实的</td>
                    <td>2013-12-3 01:16:32</td>
                    <td>删除</td>
                </tr>
                <tr class="post">
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>2013-12-3 01:16:32</td>
                    <td>啊实打实的</td>
                    <td>2013-12-3 01:16:32</td>
                    <td>删除</td>
                </tr>
                <tr class="post">
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>2013-12-3 01:16:32</td>
                    <td>啊实打实的</td>
                    <td>2013-12-3 01:16:32</td>
                    <td>删除</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>