<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>本吧设置</title>
    <style type="text/css">
.head{
    border: 0;
}
.icons{
    padding: 20px 0 0 0;
}
.icons:after{
    content: "";
    display: block;
    height: 0px;
    visibility: hidden;
    clear: both;
}
.icons .icon-li{
    float: left;
}
.icons .icon-a{
    display: inline-block;
    width: 80px;
    height: 80px;
    margin: 0 20px 0 0;
    background: #3F7AC6;
    border-radius: 3px;
    color: #fff;
    font-size: 12px;
    line-height: 130px;
    text-align: center;
}
.categoryForm{
    padding: 25px 0 0 10px;
}
h2{
    font-size: 14px;
    background: #F8F8F8;
    height: 30px;
    line-height: 30px;
    margin: 0 0 0 -30px;
    padding:  0 0 0 30px;
    border-bottom: 1px #E6E6E6 solid;
}
.categoryForm .categoryName{
    display: inline-block;
    border: 1px #A9A9A9 solid;
    height: 25px;
    width: 150px;
    vertical-align: bottom;
}
.categoryForm .addCategory{
    display: inline-block;
    border: 1px #A9A9A9 solid;
    height: 25px;
    padding: 0 10px;
    font-size: 14px;
    line-height: 25px;
    text-align: center;
    color: #000;
    background: linear-gradient(to bottom,#F6F6F6,#DDDDDD);
    border-radius: 3px;
}
.categoryForm .categoryList{
}
.categoryList .category{
    padding: 0 0 0 10px;
    height: 20px;
    line-height: 20px;
}
.categoryList .deleteCategory{
    color: red;
    padding: 0 0 0 10px;

}

    </style>
</head>
<body>
    <div class="head">
        <h1>本吧设置</h1>
        <ul class="icons">
            <li class="icon-li"><a href="#" class="icon-a">设置本吧名片</a></li>
            <li class="icon-li"><a href="#" class="icon-a">设置发帖格式</a></li>
            <li class="icon-li"><a href="#" class="icon-a">提交目录</a></li>
            <li class="icon-li"><a href="#" class="icon-a">设置精品区</a></li>
            <li class="icon-li"><a href="#" class="icon-a">添加友情吧</a></li>
            <li class="icon-li"><a href="#" class="icon-a">设置吧头衔</a></li>
            <li class="icon-li"><a href="#" class="icon-a">提交辞职申请</a></li>
        </ul>
    </div>
    <div class="body">
        <h2>设置精品区分类</h2>
        <form class="categoryForm">
            <input class="categoryName" type="text">
            <a class="addCategory" href="#">添加分类</a>
            <p>最多可添加8个分类，每个分类名称不超过5个汉字</p>
            <ul class="categoryList">
                <li class="category">test1<a href="#" class="deleteCategory icomoon"></a></li>
                <li class="category">test2<a href="#" class="deleteCategory icomoon"></a></li>
                <li class="category">test3<a href="#" class="deleteCategory icomoon"></a></li>
            </ul>
        </form>
    </div>
</body>
</html>