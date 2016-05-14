<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<span id="_top"></span>
<div class="hidden"></div>
<div class="loginDiv formDiv">
	<form action="" id="login_form">
		<span class="top">登陆账号<i></i> </span> <input id="login_username" class="username  input" name="username" type="text" placeholder="账号"> <input id="login_password" class="password  input" name="password" type="password" placeholder="密码">
		<div class="middle">
			<input class="fl check" type="checkbox"><span class="middle_left fl">下次自动登陆</span> <a class="middle_right fr" href="#">登陆遇到问题</a>
		</div>
		<div class="bottom">
			<span id="login_submit" class="button">登录</span> <a class="fr" href="#">立即注册</a>
		</div>
		<span id="msg" class="msg"></span>
	</form>
</div>
<div class="registDiv formDiv">
	<form action="" id="regist_form">
		<span class="top">注册账号<i></i> </span> <input id="regist_username" class="username input" name="username" type="text" placeholder="账号"><span id="usernameMsg" class="eMsg"></span> <input id="regist_password" class="password input" name="password" type="password" placeholder="密码"><span id="passwordMsg" class="eMsg"></span> <input id="regist_repassword" class="username input" name="repassword" type="password" placeholder="确认密码"><span id="repasswordMsg" class="eMsg"></span> <input id="regist_name" class="name input" name="name" type="text" placeholder="昵称"><span id="nameMsg" class="eMsg"></span> <input id="regist_email" class="email input" name="email" type="text" placeholder="邮箱"><span id="emailMsg" class="eMsg"></span>
		<div class="middle">
			<input class="fl check" type="checkbox" checked="checked"><span class="middle_left fl">阅读并接受</span> <a class="middle_right fl" href="#">《贴吧协议》</a>
		</div>
		<div class="bottom">
			<span id="regist_submit" class="button">注册</span>
		</div>
		<span id="msg" class="msg"></span>
	</form>
</div>
<div class="top">
		<ul class="top_head fr">
			<s:if test="#session.user == null">
				<li class="login fl">
					<div class="head_div">
						<a id="login" href="#">登陆</a>
					</div></li>
				<li class="regist fl">
					<div class="head_div">
						<a id="regist" class="" href="#">注册</a>
					</div></li>
			</s:if>
			<s:else>
				<li class="login fl">
					<div class="head_div">
						<a>欢迎 <s:property value="#session.user.username" /> </a>
					</div></li>
				<li class="regist fl">
					<div class="head_div">
						<a id="exit" class="" href="#">退出</a>
					</div></li>
			</s:else>
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
		<div class="search">
			<div class="search_top"></div>
			<div class="search_bottom">
				<from> <input class="search_text fl" type="text"> <input class="search_bar fl" type="button" value="进入贴吧"> <input class="search_all fl" type="button" value="全吧搜索"> <a class="search_high fl" href="#">高级搜索</a> </from>
			</div>
		</div>
	</div>
