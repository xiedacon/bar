<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
<!--
//查找富文本中的所有图片
function findImages(content,images){
	var begin = content.indexOf("<img");
	if(begin<0){
		return content;
	}
	var content1 = content.substring(begin);
	var end = content1.indexOf(">")+1;
	var image = content1.substring(0,end);
	images[images.length] = image;
	content1 = content.substring(0,begin) + content1.substring(end);
	return findImages(content1,images);
}
//使图片适应尺寸
function changeImage(image){
	var height = $(image).height();
	var width = $(image).width();
	var ratio = 90/height;
	$(image).height(90);
	$(image).width(width*ratio);
}
$(document).ready(function(){
	var size = $(".desc_span").size();
	for(var i = 0;i<size;i++){
		var span = $(".desc_span").eq(i);
		var content = span.text();
		var images = new  Array();
		var content1 = findImages(content,images);
		//将富文本转换为文本
		content1 = span.html(content1).text();
		//设置文本最长显示长度
		if(content1.length > 35){
			span.text(content1.substring(0,35) + "...")
		}
		if(images.length>0){
			var imagesBox = span.parents(".desc").append("<div class='desc_bottom'></div>").find(".desc_bottom");
			//对图片进行调整
			//数量
			if(images.length > 3){
				images = new Array(images[0],images[1],images[2]);
			}
			//将图片添加至指定位置
			imagesBox.html(images);
			//尺寸
			for(var j = 0;j<imagesBox.children().size();j++){
				changeImage(imagesBox.children()[j]);
			}
		}
	}
})
//-->
</script>
<div id="1" class="material_posts fl">
	<ul>
		<s:iterator value="pageBean.beanList" var="post">
			<li class="post">
				<div class="post_top">
					<div class="num fl">
						<div class="num_div">
							<span class="num_span"><s:property value="#post.num" />
							</span>
						</div>
					</div>
					<div class="title fl">
						<div class="title_div">
							<a target="_blank" href="${pageContext.request.contextPath }/post_findByPidAndPage?post.pid=<s:property value="#post.pid"/>" class="title_a" title="<s:property value="#post.title"/>"><s:property value="#post.title" /> </a>
						</div>
					</div>
					<div class="user fr">
						<div class="user_div">
							<a href="#" class="user_a"><s:property value="#post.owner.name" />
							</a>
						</div>
						<div class="img">
							<img src="">
						</div>
					</div>
				</div>
				<div class="post_bottom">
					<div class="desc">
						<div class="desc_top">
							<span class="desc_span fl"><s:property value="#post.content" /></span>
							<div class="user fr">
								<div class="user_div">
									<a href="#" class="user_a fl"><s:property value="#post.lastUser.name" />
									</a> <span class="user_span fr" title="最后回复时间"><s:date name="#post.ldate" format="HH：mm" /> </span>
								</div>
								<div class="img">
									<img src="">
								</div>
							</div>
						</div>
						
					</div>
				</div></li>
		</s:iterator>
	</ul>
	<div class="posts_bottom">
		<div class="page">
			<ul>
				<s:if test="pageBean.page!=1">
					<li class="fl page_first page_div" onclick="loadMaterial('posts','post_findByPage',1)">首页</li>
					<li class="fl page_previous page_div" onclick="loadMaterial('posts','post_findByPage',<s:property value='pageBean.page - 1'/>)">上一页</li>
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
				<s:elseif test="pageBean.page + 5 > pageBean.totalPage">
					<s:set name="end" value="pageBean.totalPage"></s:set>
				</s:elseif>
				<s:iterator begin="#begin" end="#end" step="1" var="i">
					<s:if test="#i == pageBean.page">
						<li class="fl page_now"><s:property value='#i' />
						</li>
					</s:if>
					<s:else>
						<li class="fl page_div" onclick="loadMaterial('posts','post_findByPage',<s:property value='#i'/>)"><s:property value='#i' />
						</li>
					</s:else>
				</s:iterator>
				<s:if test="pageBean.page != pageBean.totalPage">
					<li class="fl page_next page_div" onclick="loadMaterial('posts','post_findByPage',<s:property value='pageBean.page + 1'/>)">下一页</li>
					<li class="fl page_end page_div" onclick="loadMaterial('posts','post_findByPage',<s:property value='pageBean.totalPage'/>)">尾页</li>
				</s:if>
			</ul>
		</div>
		<div class="desc">
			<p>
				共有帖子<span class="red"><s:property value="pageBean.totalCount"/></span>篇，<span class="blue">会员</span><span class="red">3123</span>名
			</p>
		</div>
	</div>
</div>
<jsp:include page="right.jsp"></jsp:include>
