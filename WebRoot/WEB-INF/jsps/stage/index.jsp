<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<title>我的贴吧主页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
function createPost(){
	var content = $("#ueditor_textarea_editorValue").val();
	var title = $("#title").val();
	<s:if test="#session.user ==null">return showDiv("loginDiv");</s:if>
	if(title == ""){
		$("#title").focus();
		return;
	}else if(content == undefined || content==""){
		ue.focus();
		return;
	}else{
		$("#post").submit();
	}
}

</script>
<body>
	<div class="right">
		<ul>
				<li title="发帖" class="right_div right_post" onclick="toPost();"></li>
				<li title="刷新" class="right_div right_reflash" onclick="reflash();"></li>
				<li title="分享" class="right_div right_share"></li>
				<li title="返回顶部" class="right_div right_top" onclick="toTop();"></li>
		</ul>
	</div>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="head">
		<img class="backgroundimg" src=""> <img class="bar_logo" src="">
		<div class="head_top">
			<div class="head_button fr">
				<a class="check" title="签到" href="#"><span class="check_top fl">02月24日</span><span class="check_bottom fl">漏签<spam class="day">0</spam>天</span> </a>
			</div>
			<div class="desc fl">
				<div class="desc_top">
					<h1 class="fl">我的吧</h1>
					<a class="attention fl" href="#" title="关注"></a>
					<div class="num fl">
						<span class="name">关注:</span> <span class="value">12312</span> <span class="name">&nbsp;帖子:</span> <span class="value">123123</span>
					</div>
				</div>
				<div class="desc_bottom">
					<p class="fl">这里，有我们的浪漫~</p>
					<div class="num fl">
						<span class="name">目录:</span> <span class="value">xxxx</span>
					</div>
				</div>
			</div>
		</div>
		<div class="head_bottom">
			<div class="bottom_nav fl">
				<span class="title">分类1</span>
				<div class="links">
					<ul>
						<li><div class="link_div">
								<a class="link_a" href="#"><span class="link_span">aaa</span>text1</a>
							</div></li>
						<li><div class="link_div">
								<a class="link_a" href="#"><span class="link_span">aaa</span>text2</a>
							</div></li>
						<li><div class="link_div">
								<a class="link_a" href="#"><span class="link_span">aaa</span>text3</a>
							</div></li>
						<li><div class="link_div">
								<a class="link_a" href="#"><span class="link_span">aaa</span>text4</a>
							</div></li>
					</ul>
				</div>
			</div>
			<div class="bottom_nav fl">
				<span class="title">分类2</span>
				<div class="links">
					<ul>
						<li><div class="link_div">
								<a class="link_a" href="#">text1</a>
							</div></li>
						<li><div class="link_div">
								<a class="link_a" href="#">text2</a>
							</div></li>
						<li><div class="link_div">
								<a class="link_a" href="#">text3</a>
							</div></li>
						<li><div class="link_div">
								<a class="link_a" href="#">text4</a>
							</div></li>
					</ul>
				</div>
			</div>
			<div class="bottom_nav fl">
				<span class="title">分类3</span>
				<div class="links">
					<ul>
						<li><div class="link_div">
								<a class="link_a" href="#">text1</a>
							</div></li>
						<li><div class="link_div">
								<a class="link_a" href="#">text2</a>
							</div></li>
						<li><div class="link_div">
								<a class="link_a" href="#">text3</a>
							</div></li>
						<li><div class="link_div">
								<a class="link_a" href="#">text4</a>
							</div></li>
					</ul>
				</div>
			</div>
			<div class="bottom_button">
				<a id="index" class="button_a">收起指引<i class="arrows_top"></i> </a>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="main_nav">
			<ul>
				<li id="posts" class="nav_element fl opt">看帖</li>
				<li id="picture" class="nav_element fl">图片</li>
				<li id="boutique" class="nav_element fl">精品</li>
				<li id="group" class="nav_element fl">群组</li>
			</ul>
		</div>
		<div id="material" class="main_material"></div>
	</div>
	<div class="foot">
		<div class="foot_top">
			<div class="top_head">
				<div class="chooses"></div>
			</div>
			<form id="post" name="post" action="${pageContext.request.contextPath }/post_createPost" method="post">
			<div class="top_title">
				<input type="text" id="title" name="title" placeholder="请填写标题" class="title" />
			</div>
			<div class="top_content">
				<script id="editor" type="text/plain" style="min-height:282px;"></script>
				<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/editor/ueditor.config.js"></script>
				<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/editor/ueditor.all.min.js"> </script>
				<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/editor/lang/zh-cn/zh-cn.js"></script>
				<script type="text/javascript" style="z-index:1;" >
					var ue = UE.getEditor('editor');
				</script>
			</div>
			</form>
			<div class="top_buttom">
				<span class="buttom_a" onclick="createPost();">发 表</span>
			</div>
		</div>
		<div class="foot_bottom">
			<p class="bottom_p">
				©2016 贴吧协议 | <a href="#" class="bottom_a">吧主制度</a> | 意见反馈 | 网络谣言警示
			</p>
		</div>
	</div>
</body>
</html>
