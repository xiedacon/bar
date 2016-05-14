<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <title>吧务中心</title>
    <style type="text/css">
html{
    background: #fff;
}
.top{
    height: 50px;
    border-bottom: 30px #7A8DA0 solid;
}
.top h1{
    padding-left: 1%;
}
.top h1 a{
    line-height: 50px;
    font-size: 20px;
    color: #C2C2C2;
}
.material-left{
    width: 15%;
    background: #282D45;
    overflow: hidden;
}
.material:after{
    display: block;
    visibility: hidden;
    content: "";
    height: 0;
    clear: both;
}
.material-right{
    width: 85%;
}
.material-left .user{
    background:#414A73;
    height: 30.15%
}

.material-left .index-user-icon{
    margin: 5.56% 25.6% 0 25.6%;
    width: 48.8%;
    height: 55.56%;
    border-radius: 50px;
    overflow: hidden;
}
.material-left .index-user-name{
    margin: 1% 0 0 0;
    display: block;
    font-size: 1.25em;
    text-align: center;
    color: #fff;
}
.material-left .user-location{
    margin: 1% 0 7% 0;
    display: block;
    font-size: 1em;
    text-align: center;
    color: #fff;
}
.material-left .nav{
    height: 50%;
}
.material-left .nav-button{
    display: block;
    width: 100%;
    height: 16.67%;
    line-height: 50px;
    color: #fff;
    font-size: 1.2em;
}
.material-left .nav-button span{
    margin: -2% 0 0 0;
    display: inline-block;
    height: 50px;
    width: 5%;
    vertical-align: middle;
}
.material-left .nav-li:hover span{
    background: #D1402F;
}
.material-left .nav-button i{
    font-family: "icomoon";
    color: #8686B7;
}
.material-left .nav-button-a{
    display: inline-block;
    color: #fff;
    line-height: 30px;
    font-size: 0.8em;
    width: 100%;
}
.material-left .nav-button-a i{
    display: inline-block;
    background: #fff;
    width: 3px;
    height: 3px;
    vertical-align: middle;
    margin: -5px 10px 0 27px;
}
.material-left .nav ul{
    display: none;
}
.material-left .now{
    border: 5px #282D45 solid;
    border-right-color: #fff;
    background: #fff;
    margin: 10px 0;
}

    </style>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.js"></script>
<script type="text/javascript">
    $(document).ready(function($) {
        var height = $("body").height()-80;
        $(".material-left").css({
            'min-height': height,
        });
        $(".material-left .nav-button").click(function(event) {
            $(this).siblings().stop().slideToggle(300);
            $(this).parent().siblings().children('ul').stop().slideUp(300);
        });
        $(".material-left .nav-button-a").click(function(event) {
            $(this).css({color: '#D1402F'}).children("i").css({background: '#D1402F'});
            $(this).children("div").attr({class: 'now fr'});
            var a = $(this).parent().siblings().children("a");
            a.css({color: '#fff'}).children("i").css({background: '#fff'});
            a.children("div").attr({class: 'fr'});
            var a = $(this).parent().parent().parent().siblings().children('ul').children().children("a");
            a.css({color: '#fff'}).children("i").css({background: '#fff'});
            a.children("div").attr({class: 'fr'});
        });
        var top_height = $(".top").outerHeight();
        var _height;
        $(window).scroll(function () {
            _height = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
            var left = $(".material-left");
            if(_height>top_height){
                left.css({
                    position: 'fixed',
                    top:'0',
                    left:'0',
                });
            }else{
                left.css({
                    position: 'static',
                });
            }
        });
        function loadDiv(name){
            $(".iframe").load("${pageContext.request.contextPath}/"+name,{},function(data){
                var _height = $(".iframe").height();
                if(_height>height){
                    $(".material-left").css({
                        'min-height': _height,
                    });
                }else{
                    $(".material-left").css({
                        'min-height': height,
                    });
                }
            });
        }
        $(".deletePost").click(function(e){
            loadDiv("admin/adminPost_findUnRecoverDeleteLog");
        })
        $(".postLog").click(function(e){
            loadDiv("admin/adminPost_findAllLog");
        })
        $(".postAppeal").click(function(e){
<<<<<<< HEAD
        	alert("暂未添加该功能");
        	return;
=======
>>>>>>> origin/master
            loadDiv("admin/adminPost_findUnprocessAppealLogAll");
        })
        $(".userList").click(function(e){
            loadDiv("user_findAllUser");
        })
        $(".forbiddenList").click(function(e){
            loadDiv("admin/adminUser_findUnrecoverForbiddenLog");
        })
        $(".blackList").click(function(e){
<<<<<<< HEAD
        	alert("暂未添加该功能");
        	return;
            loadDiv("admin/adminUser_findUnrecoverBlackListLog");
        })
        $(".userAppeal").click(function(e){
        	alert("暂未添加该功能");
        	return;
=======
            loadDiv("admin/adminUser_findUnrecoverBlackListLog");
        })
        $(".userAppeal").click(function(e){
>>>>>>> origin/master
            loadDiv("admin/adminUser_findUnprocessAppealLog");
        })
        $(".userLog").click(function(e){
            loadDiv("admin/adminUser_findAllLog");
        })
        $(".barInformation").click(function(e){
<<<<<<< HEAD
        	alert("暂未添加该功能");
        	return;
            loadDiv("admin/load_barInformation");
        })
        $(".pictureRecycle").click(function(e){
        	alert("暂未添加该功能");
        	return;
            loadDiv("admin/load_pictureRecycle");
        })
        $(".adminAttendance").click(function(e){
        	alert("暂未添加该功能");
        	return;
=======
            loadDiv("admin/load_barInformation");
        })
        $(".pictureRecycle").click(function(e){
            loadDiv("admin/load_pictureRecycle");
        })
        $(".adminAttendance").click(function(e){
>>>>>>> origin/master
            loadDiv("admin/load_adminAttendance");
        })
        $(".adminManage").click(function(e){
            loadDiv("admin/adminUser_findAdminAll");
        })
        $(".adminLog").click(function(e){
            loadDiv("admin/adminUser_findAdminLog");
        })
        $(".adminApproval").click(function(e){
<<<<<<< HEAD
        	alert("暂未添加该功能");
        	return;
            loadDiv("admin/load_adminApproval");
        })
        $(".generalAdminHost").click(function(e){
        	alert("暂未添加该功能");
        	return;
            loadDiv("admin/load_generalAdminHost");
        })
        $(".barSettings").click(function(e){
        	alert("暂未添加该功能");
        	return;
=======
            loadDiv("admin/load_adminApproval");
        })
        $(".generalAdminHost").click(function(e){
            loadDiv("admin/load_generalAdminHost");
        })
        $(".barSettings").click(function(e){
>>>>>>> origin/master
            loadDiv("admin/load_barSettings");
        })
    })

</script>
<body>
    <div class="top">
        <ul class="top_head fr">
			<li class="login fl">
				<div class="head_div">
<<<<<<< HEAD
					<a>欢迎 <s:property value="#session.user.name" /> </a>
=======
					<a>欢迎 <s:property value="#session.user.username" /> </a>
>>>>>>> origin/master
				</div></li>
			<li class="regist fl">
				<div class="head_div">
					<a id="" class="" href="${pageContext.request.contextPath }/admin/admin_toStage">退出后台</a>
				</div>
			</li>
			<li class="buy fl">
				<div class="head_div">
					<a class="buy_a" href="#" title="购买商品"></a>
				</div></li>
			<li class="app fl">
				<div class="head_div">
					<a class="app_a" href="#" title="下载手机端"></a>
				</div>
			</li>
			<li class="separator fl">|</li>
			<li class="center fl">
				<div class="head_div">
					<a class="center_a" href="#">应用中心</a>
				</div>
			</li>
			<li class="vip fl">
				<div class="head_div">
					<a class="vip_a" href="#">会员官网</a>
				</div>
			</li>
			<li class="index fl">
				<div class="head_div">
					<a class="index_a" href="${pageContext.request.contextPath }/index">首页</a>
				</div>
			</li>
		</ul>
            </div>
            <div class="material">
            <div class="material-left fl">
                <div class="user">
                    <img class="index-user-icon" src="${pageContext.request.contextPath }/image/<s:property value='#session.user.icon'/>">
                    <span class="index-user-name"><s:property value="#session.user.username"/></span>
                    <span class="user-location">所在吧：我的吧</span>
                </div>
                <ul class="nav">
                    <li class="nav-li"><a href="#" class="nav-button"><span></span><i> </i>帖子管理</a>
                        <ul class="a">
                        <li><a href="#" class="nav-button-a deletePost"><i></i>吧务删帖<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a postLog"><i></i>帖子管理日志<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a postAppeal"><i></i>用户帖子申诉<div class=" fr"></div></a></li>
                        </ul>
                    </li>
                    <li class="nav-li"><a href="#" class="nav-button"><span> </span><i> </i>用户管理</a>
                        <ul>
                        <li><a href="#" class="nav-button-a userList"><i></i>会员列表<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a forbiddenList"><i></i>用户封禁列表<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a blackList"><i></i>黑名单列表<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a userAppeal"><i></i>用户申诉列表<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a userLog"><i></i>用户管理日志<div class=" fr"></div></a></li>
                        </ul>
                    </li>
                    <li class="nav-li"><a href="#" class="nav-button"><span> </span><i> </i>数据统计</a>
                        <ul>
                        <li><a href="#" class="nav-button-a barInformation"><i></i>本吧数据<div class=" fr"></div></a></li>
                        </ul>
                    </li>
                    <li class="nav-li"><a href="#" class="nav-button"><span> </span><i> </i>资源区管理</a>
                        <ul>
                        <li><a href="#" class="nav-button-a pictureRecycle"><i></i>图册精品回收站<div class=" fr"></div></a></li>
                        </ul>
                    </li>
                    <li class="nav-li"><a href="#" class="nav-button"><span> </span><i> </i>吧务团队</a>
                        <ul>
                        <li><a href="#" class="nav-button-a adminAttendance"><i></i>吧务考勤<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a adminManage"><i></i>团队人员管理<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a adminLog"><i></i>吧务管理日志<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a adminApproval"><i></i>吧务审批<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a"><i></i>吧务群<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a generalAdminHost"><i></i>普通吧主管理<div class=" fr"></div></a></li>
                        </ul>
                    </li>
                    <li class="nav-li"><a href="#" class="nav-button"><span> </span><i> </i>工具及设置</a>
                        <ul>
                        <li><a href="#" class="nav-button-a"><i></i>贴吧神兽<div class=" fr"></div></a></li>
                        <li><a href="#" class="nav-button-a barSettings"><i></i>本吧设置<div class=" fr barSettings"></div></a></li>
                        </ul>
                    </li>
                </ul>
            </div>
                <div class="material-right fr iframe">
                	<jsp:include page="index.jsp"></jsp:include>
                </div>
            </div>
</body>
</html>
