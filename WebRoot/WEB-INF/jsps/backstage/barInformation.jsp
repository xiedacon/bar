<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>本吧数据</title>
    <style type="text/css">
.head{
    border: 0;
}
.body .result-table .time-td{
    width: 15%;
}
.body .result-table .user-td{
    width: 15%;
}
.body .result-table .itemNum-td{
    width: 10%;
}
.body .result-table .replyNum-td{
    width: 10%;
}
.body .result-table .attendanceNum-td{
    width: 10%;
}
.body .result-table .attendancePro-td{
    width: 10%;
}
.body .result-table .memberAdd-td{
    width: 15%;
}
.body .result-table .memberNum-td{
    width: 15%;
}
    </style>
</head>
<body>
    <div class="head">
        <h1>本吧数据</h1>
        <h2>近日数据</h2>
        <div class="tab">
        <div class="tab-buttons">
        <a class="button-focus" href="#">所有端</a>
        <a class="button-unfocus" href="#">用户端</a>
        </div>
        </div>
    </div>
    <div class="body">
        <table class="result-table">
            <thead>
                <tr>
                    <td class="time-td"></td>
                    <td class="user-td">访问用户</td>
                    <td class="itemNum-td">主题数</td>
                    <td class="replyNum-td">回复数</td>
                    <td class="attendanceNum-td">签到数</td>
                    <td class="attendancePro-td">签到率</td>
                    <td class="memberAdd-td">新增会员数</td>
                    <td class="memberNum-td">总会员数</td>
                </tr>
            </thead>
            <tbody>
                <tr class="post">
                    <td>4月12日</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>12%</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
                <tr class="post">
                    <td>4月13日</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>12%</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
                <tr class="post">
                    <td>7天平均</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>12%</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>