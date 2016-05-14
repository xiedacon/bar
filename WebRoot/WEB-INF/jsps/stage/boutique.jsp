<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="material_posts fl">
	<ul class="nav">
		<li class="nav_li"><span class="nav_element">全部</span></li>
		<li class="nav_li"><a href="#" class="nav_element">师傅好</a></li>
		<li class="nav_li"><a href="#" class="nav_element">哈考试的</a></li>
		<li class="nav_li"><a href="#" class="nav_element">收到贺卡</a></li>
		<li class="nav_li"><a href="#" class="nav_element">给大家啊是</a></li>
		<li class="nav_li"><a href="#" class="nav_element">电话卡</a></li>
	</ul>
	<ul>
		<s:iterator value="pageBean.beanList" var="post">
			<li class="post">
				<div class="post_top">
					<div class="num fl">
						<div class="num_div">
							<span class="num_span"><s:property value="#post.num" /> </span>
						</div>
					</div>
					<div class="title fl">
						<div class="title_div">
							<a href="${pageContext.request.contextPath }/post_findByPidAndPage?post.pid=<s:property value="#post.pid"/>" class="title_a" title="<s:property value="#post.title"/>"><s:property value="#post.title" /> </a>
						</div>
					</div>
					<div class="user fr">
						<div class="user_div">
							<a href="#" class="user_a"><s:property value="#post.owner.name" /> </a>
						</div>
						<div class="img">
							<img src="">
						</div>
					</div>
				</div>
				<div class="post_bottom">
					<div class="desc">
						<div class="desc_top">
							<span class="desc_span fl"><s:property value="#post.content" /> </span>
							<div class="user fr">
								<div class="user_div">
									<a href="#" class="user_a fl"><s:property value="#post.lastUser.name" /> </a> <span class="user_span fr" title="最后回复时间"> <s:date name="#post.ldate" format="HH：mm" /> </span>
								</div>
								<div class="img">
									<img src="">
								</div>
							</div>
						</div>
						<div class="desc_bottom">
							<img src="">
						</div>
					</div>
				</div>
			</li>
		</s:iterator>
	</ul>
	<div class="posts_bottom">
		<div class="page">
			<ul>
				<s:if test="pageBean.page!=1">
					<li class="fl page_first page_div" onclick="loadMaterial('posts','post_boutique',1)">首页</li>
					<li class="fl page_previous page_div" onclick="loadMaterial('posts','post_boutique',<s:property value='pageBean.page - 1'/>)">上一页</li>
				</s:if>
				<s:set name="begin" value="pageBean.page-4"></s:set>
				<s:set name="end" value="pageBean.page+5"></s:set>
				<s:if test="pageBean.page <5">
					<s:set name="begin" value="1"></s:set>
				</s:if>
				<s:if test="pageBean.totalPage < 10">
					<s:set name="end" value="pageBean.totalPage"></s:set>
				</s:if>
				<s:elseif test="pageBean.page < 5">
					<s:set name="end" value="10"></s:set>
				</s:elseif>
				<s:iterator begin="#begin" end="#end" step="1" var="i">
					<s:if test="#i == pageBean.page">
						<li class="fl page_now"><s:property value='#i' /></li>
					</s:if>
					<s:else>
						<li class="fl page_div" onclick="loadMaterial('posts','post_boutique',<s:property value='#i'/>)"><s:property value='#i' /></li>
					</s:else>
				</s:iterator>
				<s:if test="pageBean.page != pageBean.totalPage">
					<li class="fl page_next page_div" onclick="loadMaterial('posts','post_boutique',<s:property value='pageBean.page + 1'/>)">下一页</li>
					<li class="fl page_end page_div" onclick="loadMaterial('posts','post_boutique',<s:property value='pageBean.totalPage'/>)">尾页</li>
				</s:if>
			</ul>
		</div>
		<div class="desc">
			<p>
				共有帖子<span class="red">12312</span>篇，<span class="blue">会员</span><span class="red">3123</span>名
			</p>
		</div>
	</div>
</div>
<jsp:include page="right.jsp"></jsp:include>
