<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>帖子详情页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/post.css">
<style type="text/css">
</style>
<div class="right">
		<ul>
				<li title="回帖" class="right_div right_post" onclick="toReply();"></li>
				<li title="刷新" class="right_div right_reflash" onclick="reflash();"></li>
				<li title="分享" class="right_div right_share"></li>
				<li title="返回顶部" class="right_div right_top" onclick="toTop();"></li>
		</ul>
	</div>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/post.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var size = $(".content").size();
	for(var i = 0;i<size;i++){
		var contentEle = $(".content").eq(i);
		contentEle.html(contentEle.text());
	}
	$(".main_reply").click(function(event) {
		toReply()
	});
})
function toReply(){
	$('html, body').animate({scrollTop : $("body").height()}, 'slow');
	ue.focus();
}
function createFloor(){
	var content = $("#ueditor_textarea_editorValue").val();
	<s:if test="#session.user ==null">return showDiv("loginDiv");</s:if>
	if(content == undefined || content==""){
		toReply();
		return;
	}else{
		$("#floor").submit();
	}
}
function createReply(element){
	<s:if test="#session.user == null">return showDiv("loginDiv");</s:if>
	var content = $(element).siblings("textarea").val();
	var fid = $(element).parents(".floor").attr("id");
	if(content == undefined || content == ""){
		$(element).siblings("textarea").focus();
		return;
	}else{
		$.post(getUrl() + "/reply_createReply", {"fid" : fid,"content" : content}, function(data) {
			reflash();
		})
	}
}
</script>
<body>
	<span id="_top"></span>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="head">
		<img class="bar_logo" src="">
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
			</div>
		</div>
	</div>
	<div class="main">
		<div class="main_nav">
			<ul>
				<li id="posts" class="nav_element fl">看帖</li>
				<li id="picture" class="nav_element fl">图片</li>
				<li id="boutique" class="nav_element fl">精品</li>
				<li id="group" class="nav_element fl">群组</li>
			</ul>
		</div>
		<div class="main_material">
			<div class="material_top">
				<s:if test="post.pageBean.page!=1">
					<span class="top_page fl" onclick="skip(1);">首页</span>
					<span class="top_page fl" onclick="skip(<s:property value='post.pageBean.page - 1'/>);">上一页</span>
				</s:if>
				<s:set name="begin" value="post.pageBean.page-4"></s:set>
				<s:set name="end" value="post.pageBean.page+5"></s:set>
				<s:if test="post.pageBean.page <5">
					<s:set name="begin" value="1"></s:set>
				</s:if>
				<s:if test="post.pageBean.totalPage < 10">
					<s:set name="end" value="post.pageBean.totalPage"></s:set>
				</s:if>
				<s:elseif test="post.pageBean.page < 5">
					<s:set name="end" value="10"></s:set>
				</s:elseif>
				<s:elseif test="post.pageBean.page + 5 > post.pageBean.totalPage">
					<s:set name="end" value="post.pageBean.totalPage"></s:set>
				</s:elseif>
				<s:iterator begin="#begin" end="#end" step="1" var="i">
					<s:if test="#i == post.pageBean.page">
						<span class="now_page fl"><s:property value="#i" /> </span>
					</s:if>
					<s:else>
						<span class="top_page fl" onclick="skip(<s:property value='#i'/>);"><s:property value="#i" /> </span>
					</s:else>
				</s:iterator>
				<s:if test="post.pageBean.page != post.pageBean.totalPage">
					<span class="top_page fl" onclick="skip(<s:property value='post.pageBean.page + 1'/>);">下一页</span>
					<span class="top_page fl" onclick="skip(<s:property value='post.pageBean.totalPage'/>);">尾页</span>
				</s:if>
				<span class="top_span fl"><span class="top_num"><s:property value="post.pageBean.totalCount" /> </span>回复贴，共<span class="totalPage top_num"><s:property value="post.pageBean.totalPage" /> </span>页，跳到<input type="text" class="page span_text" />页<span class="span_button">确定</span> </span>
				<!-- 仅吧务可见 -->
				<div class="top_page administrativePosts-div">
					<a href="#" class="top_page">帖子管理</a>
					<ul class="administrativePosts">
						<li><a href="#">设为精华帖</a></li>
						<li><a href="#">取消精华帖</a></li>
						<li><a href="#">置顶主题</a></li>
						<li><a href="#">取消置顶</a></li>
						<li><a href="#">设为图片贴</a></li>
						<li><a href="#">取消图片贴</a></li>
					</ul>
				</div>
				<a href="${pageContext.request.contextPath }/admin/adminPost_deletePost?pid=<s:property value='post.pid'/>" class="top_page">删除主题</a>
				<a href="${pageContext.request.contextPath }/index?post_findByPage" class="return fr"><返回xx吧</a>
			</div>
			<div class="material_floors fl">
				<div class="floors_top">
					<span id="pid" style="display:none;"><s:property value="post.pid" /></span>
					<h2 class="title fl">
						<s:property value="post.title" />
					</h2>
					<div class="top_buttons fr">
						<div class="button_div fl">
							<a href="#" class="button_a">只看楼主</a>
						</div>
						<div class="button_div fl">
							<a href="#" class="button_a">收藏</a>
						</div>
						<div class="button_div fl main_reply">
							<span class="button_a">回复</span>
						</div>
					</div>
				</div>
				<s:iterator value="post.pageBean.beanList" var="floor">
					<div id="<s:property value='#floor.fid'/>" class="floor <s:if test="#floor.floorNum == 1">first_floor</s:if>">
						<div class="user fl">
							<s:if test="#floor.owner.uid == post.owner.uid">
								<s class="host_icon"></s>
							</s:if>
							<div class="user_img">
								<img class="user_img_img" src="${pageContext.request.contextPath}/image/<s:property value='#floor.owner.icon'/>" />
							</div>
							<div class="user_name">
								<a href="#" class="user_name_a"><s:property value='#floor.owner.name' /> </a>
							</div>
							<div class="honour">
								<img class="honour_icon fl" src="${pageContext.request.contextPath}/image/icons/1.png" /> <img class="honour_icon fl" src="${pageContext.request.contextPath}/image/icons/1.png" /> <img class="honour_icon fl" src="${pageContext.request.contextPath}/image/icons/1.png" /> <img class="honour_icon fl" src="${pageContext.request.contextPath}/image/icons/1.png" /> <img class="honour_icon fl" src="${pageContext.request.contextPath}/image/icons/1.png" />
							</div>
							<div class="title">
								<span class="title_span fl"><s:property value='#floor.owner.level.lname' /> </span> <img class="title_img fr" src="${pageContext.request.contextPath}/image/icons/1.png">
							</div>
						</div>
						<div class="floor_right fr">
							<div class="content">
								<s:property value='#floor.content' />
							</div>
							<div class="childs">
								<s:if test="#floor.floorNum == 1">
									<div class="childs_top" style="border: 0px;">
										<span class="top_right_button_close fr top_right_button main_reply">回复</span>
										<div class="top_left fr">
											<span class="top_left_span"><s:property value='#floor.floorNum' />楼</span><span class="top_left_span"><s:date name="#floor.date" format="yyyy-MM-dd HH:mm" /> </span>
										</div>
									</div>
								</s:if>
								<s:else>
									<div class="childs_top">
										<span class="top_right_button fr reply top_right_button_close">回复</span>
										<div class="top_left fr">
											<span class="top_left_span"><s:property value='#floor.floorNum' />楼</span><span class="top_left_span"><s:date name="#floor.date" format="yyyy-MM-dd HH:mm" /> </span>
										</div>
									</div>
									<div id="" class="loadMsg" style="text-align: center;height: 50px;line-height: 50px;">正在加载中。。</div>
									<div class="childs_bottom" style="display: none">
										<div class="idea " style="padding-top: 10px;display: block;">
											<textarea class="idea_text"></textarea>
											<span class="idea_button createReply">发表</span>
										</div>
									</div>
								</s:else>
							</div>
						</div>
					</div>
				</s:iterator>
			</div>
			<jsp:include page="right.jsp"></jsp:include>
		</div>
		<div class="material_bottom material_top">
			<s:if test="post.pageBean.page!=1">
				<span class="bottom_page fl" onclick="skip(1);">首页</span>
				<span class="bottom_page fl" onclick="skip(<s:property value='post.pageBean.page - 1'/>);">上一页</span>
			</s:if>
			<s:set name="begin" value="post.pageBean.page-4"></s:set>
			<s:set name="end" value="post.pageBean.page+5"></s:set>
			<s:if test="post.pageBean.page <5">
				<s:set name="begin" value="1"></s:set>
			</s:if>
			<s:if test="post.pageBean.totalPage < 10">
				<s:set name="end" value="post.pageBean.totalPage"></s:set>
			</s:if>
			<s:elseif test="post.pageBean.page < 5">
				<s:set name="end" value="10"></s:set>
			</s:elseif>
			<s:elseif test="post.pageBean.page + 5 > post.pageBean.totalPage">
				<s:set name="end" value="post.pageBean.totalPage"></s:set>
			</s:elseif>
			<s:iterator begin="#begin" end="#end" step="1" var="i">
				<s:if test="#i == post.pageBean.page">
					<span class="now_page fl"><s:property value="#i" /> </span>
				</s:if>
				<s:else>
					<span class="bottom_page fl" onclick="skip(<s:property value='#i'/>);"><s:property value="#i" /> </span>
				</s:else>
			</s:iterator>
			<s:if test="post.pageBean.page != post.pageBean.totalPage">
				<span class="bottom_page fl" onclick="skip(<s:property value='post.pageBean.page + 1'/>);">下一页</span>
				<span class="bottom_page fl" onclick="skip(<s:property value='post.pageBean.totalPage'/>);">尾页</span>
			</s:if>
			<span class="top_span fl"><span class="top_num"><s:property value="post.pageBean.totalCount" /> </span>回复贴，共<span class="totalPage top_num"><s:property value="post.pageBean.totalPage" /> </span>页，跳到 <input id="" type="text" class="page span_text" />页<span class="span_button">确定</span> </span> <a href="${pageContext.request.contextPath }/index?post_findByPage" class="return fr"><返回xx吧
			</a>
		</div>
	</div>
	<div class="foot">
		<div class="foot_top">
			<div class="top_head">
				<div class="chooses"></div>
			</div>
			<form id="floor" name="floor" action="${pageContext.request.contextPath }/floor_createFloor" method="post">
			<input type="hidden" value="<s:property value='post.pid'/>" name="post.pid">
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
				<span class="buttom_a" onclick="createFloor();">发 表</span>
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
