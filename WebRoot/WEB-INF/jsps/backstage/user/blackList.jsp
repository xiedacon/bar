<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>黑名单列表</title>
    <style type="text/css">
.body .result-table .select-td{
    width: 5%;
}
.body .result-table .user-td{
    width: 40%;
}
.body .result-table .time-td{
    width: 25%;
}
.body .result-table .people-td{
    width: 15%;
}
.body .result-table .operation-td{
    width: 15%;
}



    </style>
</head>
<body>
    <div class="head">
        <h1>黑名单列表</h1>
        <div class="form-bottom">
            <span>用户名</span>
            <input class="condition" type="text">
            <a class="button" href="#">搜索</a>
        </div>
    </div>
    <div class="body">
        <p class="result"><a href="#" class="resultAll">全部记录</a>>5条搜索结果</p>
        <table class="result-table">
            <thead>
                <tr>
                    <td class="select-td"></td>
                    <td class="user-td">头像和用户名</td>
                    <td class="time-td">加入黑名单时间</td>
                    <td class="people-td">操作人</td>
                    <td class="operation-td">操作</td>
                </tr>
            </thead>
            <tbody>
                <tr class="post">
                    <td><input type="checkbox"></td>
                    <td class="user"><img class="user-icon" src="${pageContext.request.contextPath}/1.jpg"><a href="#" class="username">看看京东卡了就</a></td>
                    <td>2014-01-31 20:32</td>
                    <td>id骄傲山东黄金</td>
                    <td>
                        <a href="#" class="button">移除黑名单</a>
                    </td>
                </tr>
            </tbody>
            <tfoot class="table-foot">
                <tr>
                    <td colspan="5">
                        <p class="selectAll"><input type="checkbox"><span>全选</span></p>
                        <a href="#" class="fr button">选中项移除黑名单</a>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
</body>
</html>