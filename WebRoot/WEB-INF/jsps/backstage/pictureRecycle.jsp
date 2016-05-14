<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>图册精品回收站</title>
    <style type="text/css">
.head{
    border: 0;
}
.form-top .space{
    display: inline-block;
    width: 137px;
}

    </style>
</head>
<body>
    <div class="head">
        <h1>图册精品回收站</h1>
        <div class="tab">
        <div class="tab-buttons">
        <a class="button-focus" href="#">图片</a>
        <a class="button-unfocus" href="#">图册</a>
        </div>
        </div>
        <form class="form">
            <div class="form-top">
            <span class=""><input name="initiatorOrOperator" type="radio" value="1" />操作人</span>
            <span class="space"></span>
            <span class=""><input name="initiatorOrOperator" type="radio" value="1" />操作时间</span>
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

    </div>
</body>
</html>