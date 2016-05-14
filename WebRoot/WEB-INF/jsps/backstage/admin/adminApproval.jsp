<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>吧务审批</title>
    <style type="text/css">
.head{
    border: 0;
}
.head h1{
    padding: 0 0 30px 0;
}
.head .tab{
    margin: 0 0 0 -30px;
}
.body .result-table .user-td{
    width: 14%
}
.body .result-table .duty-td{
    width:7%
}
.body .result-table .time-td{
    width: 15%
}
.body .result-table .information-td{
    width: 27%
}
.body .result-table .testimonials-td{
    width: 22%
}
.body .result-table .operation-td{
    width: 15%
}
.body .result-table td{
    vertical-align: top;
}
.result-table .post{
    height: 150px;
}
.body .result-table .information{
    text-align: left;
    line-height: 25px;
}
.body .result-table .testimonials{
    text-align: left;
    line-height: 25px;
}
.body .result-table .button{
    margin: 20px 10px 0 10px;
}


    </style>
</head>
<body>
    <div class="head">
        <h1>吧务审批</h1>
        <p class="terms"><span class="introduction"><i class="icomoon"></i>本吧申请吧主的基本条件：发言数不得少于<span class="important">1贴</span>，成为会员天数不得少于<span class="important">0天</span>会员等级不得低于<span class="important">3级</span>。</span><a href="#" class="button">设置吧主申请条件</a></p>
        <p class="terms"><span class="introduction"><i class="icomoon"></i>本吧申请小吧主的条件：发言数不得少于<span class="important">1贴</span>，成为会员天数不得少于<span class="important">0天</span>会员等级不得低于<span class="important">3级</span>。</span><a href="#" class="button">设置小吧主申请条件</a></p>
        <div class="tab">
        <div class="tab-buttons">
        <a class="button-focus" href="#">待审批吧务</a>
        <a class="button-unfocus" href="#">已审批吧务</a>
        </div>
        </div>
    </div>
    <div class="body">
        <table class="result-table">
            <thead>
                <tr>
                    <td class="user-td">用户名</td>
                    <td class="duty-td">职务</td>
                    <td class="time-td">申请时间</td>
                    <td class="information-td">申请人资料</td>
                    <td class="testimonials-td">申请感言</td>
                    <td class="operation-td">操作</td>
                </tr>
            </thead>
            <tbody>
                <tr class="post">
                    <td>
                        <a href="#" class="username-icon"><i class="icomoon"></i>asda傻傻的</a>
                    </td>
                    <td>小吧主</td>
                    <td>2016-01-12 10:11</td>
                    <td class="information">
                        <p>注册天数：232</p>
                        <p>加入本吧会员时长：31天</p>
                        <p>本吧发言：4</p>
                        <p>会员等级：9级</p>
                        <p>现任吧主：</p>
                    </td>
                    <td class="testimonials">
                        多哈开设的贺卡收到卡还是看大回馈库哈斯快点哈开始觉得哈科技时代科技卡仕达卡仕达卡还是恐惧的哈科技时代和会卡沙科技时代卡上的夸奖哈空间卡上的卡号是看得见哈萨克觉得好卡刷卡的和卡仕达卡仕达卡还是开机动画
                    </td>
                    <td>
                        <a href="#" class="button">批准</a>
                        <a href="#" class="button">拒绝</a>
                    </td>
                </tr>
                                <tr class="post">
                    <td>
                        <a href="#" class="username-icon"><i class="icomoon"></i>asda傻傻的</a>
                    </td>
                    <td>小吧主</td>
                    <td>2016-01-12 10:11</td>
                    <td class="information">
                        <p>注册天数：232</p>
                        <p>加入本吧会员时长：31天</p>
                        <p>本吧发言：4</p>
                        <p>会员等级：9级</p>
                        <p>现任吧主：</p>
                    </td>
                    <td class="testimonials">
                        多哈开设的贺卡收到卡还是看大回馈库哈斯快点哈开始觉得哈科技时
                    </td>
                    <td>
                        <a href="#" class="button">批准</a>
                        <a href="#" class="button">拒绝</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>