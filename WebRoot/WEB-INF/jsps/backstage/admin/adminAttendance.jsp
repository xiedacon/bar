<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>吧务考勤</title>
    <style type="text/css">
.head{
    border: 0;
}
.body{
    margin: -50px 0 0 0;
}
.body .result-table .time-td{
    width: 15%;
}
.body .result-table .registrationNum-td{
    width: 15%;
}
.body .result-table .registrationNum-client-td{
    width: 15%;
}
.body .result-table .deletePostNum-td{
    width: 15%;
}
.body .result-table .itemPostNum-td{
    width: 15%;
}
.body .result-table .replyPostNum-td{
    width: 15%;
}
.body .result-table .user-td{
    width: 15%;
}
.body .result-table .registration-td{
    width: 15%;
}
.body .result-table .registration-client-td{
    width: 15%;
}
.body h2{
    padding: 20px 0 0 40px;
}
.body .form-bottom{
    padding: 20px 0 20px 30px;
}
.body .form-bottom .select{
    margin: 0 25px 0 5px;
}
.body .form-bottom .condition{
    margin: 0 25px 0 5px;
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
        <h1>吧务考勤</h1>
        <h2>考勤概况</h2>
    </div>
    <div class="body">
        <table class="result-table overview">
            <thead>
                <tr>
                    <td class="time-td"></td>
                    <td class="registrationNum-td">签到人数</td>
                    <td class="registrationNum-client-td">客户端签到人数</td>
                    <td class="deletePostNum-td">删帖</td>
                    <td class="itemPostNum-td">主题帖</td>
                    <td class="replyPostNum-td">回帖</td>
                </tr>
            </thead>
            <tbody>
                <tr class="post">
                    <td>01-22</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
                <tr class="post">
                    <td>01-23</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
                <tr class="post">
                    <td>01-24</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
                <tr class="post">
                    <td>01-25</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
                <tr class="post">
                    <td>01-26</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
                <tr class="post">
                    <td>01-27</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
                <tr class="post">
                    <td>01-28</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
            </tbody>
        </table>
        <h2>考勤明细</h2>
        <form>
            <div class="form-bottom">
                <span>时间</span>
                <select class="select">
                    <option>近7天</option>
                    <option>近一个月</option>
                    <option>近三个月</option>
                </select>
                <span>吧务名称</span>
                <input type="text" class="condition">
                <a href="#" class="button">搜索</a>
            </div>
        </form>
        <table class="result-table desc">
            <thead>
                <tr>
                    <td class="time-td"></td>
                    <td class="user-td">吧务名称</td>
                    <td class="registration-td">是否签到</td>
                    <td class="registration-client-td">是否客户端签到</td>
                    <td class="deletePostNum-td">删帖</td>
                    <td class="itemPostNum-td">主题帖</td>
                    <td class="replyPostNum-td">回帖</td>
                </tr>
            </thead>
            <tbody>
                <tr class="post">
                    <td>01-22</td>
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>是</td>
                    <td>是</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
                <tr class="post">
                    <td>01-22</td>
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>是</td>
                    <td>是</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
                <tr class="post">
                    <td>01-22</td>
                    <td><a href="#" class="username"><i></i>看看京东卡了就</a></td>
                    <td>是</td>
                    <td>是</td>
                    <td>123</td>
                    <td>123</td>
                    <td>123</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>