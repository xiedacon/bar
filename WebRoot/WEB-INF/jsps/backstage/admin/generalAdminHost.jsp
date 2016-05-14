<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>普通吧主管理</title>
    <style type="text/css">
.head{
    border: 0;
}
.body .result-table .user-td{
    width: 23%;
}
.body .result-table .applyTime-td{
    width: 30%;
}
.body .result-table .enterTime-td{
    width: 30%;
}
.body .result-table .operation-td{
    width: 17%;
}



    </style>
</head>
<body>
    <div class="head">
        <h1>普通吧主管理</h1>
        <div class="tab">
        <div class="tab-buttons">
        <a class="button-focus" href="#">现任吧主</a>
        <a class="button-unfocus" href="#">审核状态</a>
        <a class="button-unfocus" href="#">合作已结束</a>
        </div>
        </div>
    </div>
    <div class="body">
        <table class="result-table">
            <thead>
                <tr>
                    <td class="user-td">用户名</td>
                    <td class="applyTime-td">申请时间</td>
                    <td class="enterTime-td">入驻时间</td>
                    <td class="operation-td">操作</td>
                </tr>
            </thead>
            <tbody>
                <tr class="post">
                    <td>开会估计都是</td>
                    <td>-</td>
                    <td>-</td>
                    <td><a href="#">下线吧主</a></td>
                </tr>
                <tr class="post">
                    <td>开会估计都是</td>
                    <td>2015-10-12 11:32:31</td>
                    <td>2015-10-12 11:32:31</td>
                    <td><a href="#">下线吧主</a></td>
                </tr>
                <tr class="post">
                    <td>开会估计都是</td>
                    <td>2015-10-12 11:32:31</td>
                    <td>2015-10-12 11:32:31</td>
                    <td><a href="#">下线吧主</a></td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>