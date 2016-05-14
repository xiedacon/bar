<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="material_message fr">
	<div class="message_div">
		<div class="vip">会员相关</div>
	</div>
	<div class="message_div">
		<div class="user">
			<s:if test="#session.user !=null">
				<div class="message_sort">我在贴吧</div>
				<img class="user_img fl" src="${pageContext.request.contextPath }/image/<s:property value='#session.user.icon'/>">
				<div class="details fl">
					<ul>
						<li class="user_name"><a href="#" class="user_name_a"><s:property value="#session.user.username" /> </a></li>
						<li class=""><a href="#" class="user_property"><s:property value="#session.user.position.name" /> </a></li>
						<li class=""><a href="#" class="user_property"><s:property value="#session.user.level.lname" /> </a></li>
						<li class="user_money"><span class="user_money_span">12</span><a href="#" class="user_money_a">[获取]</a></li>
						<li><a href="#" class="user_property appealPost">帖子申诉</a></li>
					</ul>
				</div>
			</s:if>
		</div>
	</div>
	<div class="message_div">
		<div class="bar">
			<div class="message_sort">本吧信息</div>
			<a href="#" class="bar_details">查看详情>></a>
			<div class="bar_admins">
				<ul>
					<li class="bar_admin fl"><img class="admin_img" src="" /> <a class="admin_name" href="#">a</a>
					</li>
					<li class="bar_admin fl"><img class="admin_img" src="" /> <a class="admin_name" href="#">b</a>
					</li>
					<li class="bar_admin fl"><img class="admin_img" src="" /> <a class="admin_name" href="#">c</a>
					</li>
				</ul>
			</div>
			<div class="informations">
				<div class="information">小吧：小吧主共3人</div>
				<div class="information">
					会员：<a class="information_a" href="#">呵呵</a>
				</div>
				<div class="information">
					目录：<a class="information_a" href="#">哈哈</a>
				</div>
			</div>
			<div class="methods">
				<a class="method" href="#">申请小吧主</a> <a class="method" href="#">阅读本吧吧刊</a>
			</div>
		</div>
	</div>
	<div class="message_div">
		<div>吧主选择</div>
	</div>
	<div class="message_div">
		<div class="friends">友情贴吧</div>
	</div>
	<div class="message_div">
		<div class="message_sort">吧务管理</div>
		<ul class="list">
			<li class="list_button" onclick="alert('暂未加入该功能');">职业吧主后台</li>
			<li class="list_button" onclick="toAdmin();">吧务后台</li>
			<li class="list_button" onclick="alert('暂未加入该功能');">会员中心</li>
			<li class="list_button" onclick="alert('暂未加入该功能');">管理模式</li>
			<li class="list_button">设置吧名片</li>
			<li class="list_button" onclick="alert('暂未加入该功能');">吧主制度</li>
			<li class="list_button" onclick="">设置头图</li>
			<li class="list_button" onclick="alert('暂未加入该功能');">会员专属置顶</li>
		</ul>
	</div>
<<<<<<< HEAD
	<div class="backgroundImage" style="display: none;">
=======
	<div class="backgroundImage">
>>>>>>> origin/master
		aaaaaaaaaaaaaaaaaa
	</div>
</div>
