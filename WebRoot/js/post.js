function skip(page) {
	var pid = $("#pid").text();
	window.location.href = getUrl() + "/post_findByPidAndPage?post.pid=" + pid
			+ "&page=" + page;
}
function loadReplies() {
	// 多次ajax请求获取reply，得到后进行相关操作
	var size = $(".loadMsg").length;
	for (var i = 0; i < size; i++) {
		var fid = $(".loadMsg").parents(".floor").eq(i).attr("id");
		loadReply(fid, 1,true);
	}
}
function loadReply(fid, page, firstFlag) {
	$.post(getUrl() + "/reply_findByFidAndPage", {"fid" : fid,"page" : page}
		, function(data) {
				// 无数据：清除loadMsg
				// 有数据：清除childs_top以外的所有子元素，将数据解析为dom元素添加到childs下
				var json = eval("(" + data + ")");
				if (firstFlag && json.beanList == "") {
					$("#" + fid).find(".loadMsg").remove();
				} else {	//将获得的json解析为DOM
					var childs = $("#" + fid).find(".childs");
					if(firstFlag){	//创建回复的父元素
						childs.children().not(".childs_top").remove();
						childs.append("<div class='childs_middle'><ul></ul><div>").append("<div class='childs_bottom'></div>");
						var span = "<span class='num fl'>";
						if(json.totalCount > 10){
							span += "还有" + json.totalCount + "条回复，<span class='show'>点击查看</span>";
						}
						span += " </span> <span class='myidea fr'>我也说一句</span>";
						childs.find(".childs_bottom").append(span).append("<div class='idea'><textarea class='idea_text'></textarea><span class='idea_button createReply'>发表</span></div>");
						childs.find(".reply").removeClass('top_right_button_close').text('收起回复')
							.parent().css({"border-width" : '1px'});
						//绑定事件
						childs.find(".myidea").click(function(event) {
							$(this).siblings('.idea').slideToggle(0).find(".idea_text").text("").focus();
						});
						childs.find(".createReply").click(function(){createReply($(this)[0])});
					}else{	//清空回复的父元素
						childs.find(".childs_middle ul").empty();
					}
					//每一个回复开始
					for (var i = 0; i < json.beanList.length; i++) {
						var reply = json.beanList[i];
						childs.find(".childs_middle ul")
							.append("<li id='reply_" + reply.rid + "' class='child'></li>");
						childs.find("#reply_" + reply.rid)
							.append("<div class='child_left fl'></div>")
							.append("<div class='child_right'></div>");
						childs.find("#reply_" + reply.rid + " .child_left")
							.append("<img class='child_left_img' src='" + getUrl() + "/image/" + reply.owner.icon + "'>");
						childs.find("#reply_" + reply.rid + " .child_right")
							.append("<a href='#' class='child_user'>" + reply.owner.name + "</a> <span>" + reply.content + "</span>")
							.append("<div class='date'><span class='date_span'> </span> <span class='date_a'>回复</span></div>");
					}
					//每一个回复结束
					//绑定回复相关事件
					if(firstFlag){
						if(json.totalCount > 10){
							var child = childs.find(".child").slice(5);
							childs.find(".childs_middle ul").append("<li><ul class='hiddenChilds' style='display:none;'></ul></li>");
							childs.find(".hiddenChilds").append(child);
							childs.find(".show").click(function(e){
								$(this).parents(".childs").find(".hiddenChilds").slideDown(500);
								var pageBox = $(this).parent();
								pageBox.empty();
								appendPages(pageBox[0],json);
							})
						}else{
						}
					}else{
						var pageBox =  childs.find(".num");
						pageBox.empty();
						appendPages(pageBox[0],json);
						$("html,body").scrollTop($("#"+fid + " .childs").offset().top);
					}
				}
			})
}

function appendPages(element,json){
	var pageBox = $(element);
	var page = json.page;
	if(page!=1){
		pageBox.append("<span id='1' class='num_page fl'>首页</span>");
		pageBox.append("<span id='"+ (page-1) +"' class='num_page fl'>上一页</span>");
	}
	var begin = page - 4;
	var end = page + 5;
	//修正begin
	if(page < 5){
		begin = 1;
	}
	//修正end
	if(json.totalPage < 10){
		end = json.totalPage; 
	}else if(page < 5){
		end = 10;
	}else{
		end = json.totalPage;
	}
	for(var i=begin;i<end+1;i++){
		if(i == page){
			pageBox.append("<span class='now_page fl'>"+i+"</span>");
		}else{
			pageBox.append("<span id='"+ i +"' class='num_page fl'>"+i+"</span>");
		}
	}
	if(page!=json.totalPage){
		pageBox.append("<span id='"+ (page+1) +"' class='num_page fl'>下一页</span>");
		pageBox.append("<span id='"+ json.totalPage +"' class='num_page fl'>尾页</span>");
	}
	pageBox.children().not(".now_page").click(function(){
		var fid = $(this).parents(".floor").attr("id");
		var page = $(this).attr("id");
		loadReply(fid, page);
	})
}
function loadMaterial(name, method, page) {
	window.location.href = getUrl() + "/index?" + method;
}
$(document).ready(function(e) {
	// 导航栏开始
	$("#posts").click(function() {
				loadMaterial("posts", "post_findByPage", 1);
			})
	$("#picture").click(function() {
				alert("暂未加入该功能");
			})
	$("#boutique").click(function() {
				loadMaterial("boutique", "post_boutique", 1);
			})
	$("#group").click(function() {
				alert("暂未加入该功能");
			})
	// 导航栏结束
	$(".administrativePosts-div").hover(function() {
				$(".administrativePosts").stop().slideToggle(500);
			}, function() {
				$(".administrativePosts").stop().slideToggle(500);
			});
	$(".first_floor").find('.floor_right').css({
				'min-height' : $(".first_floor").find('.user').height()
				,
			});
	loadReplies();
	$(".reply").click(function(event) {
		var floor_right = $(this).parents('.floor_right');
		floor_right.css({
					'min-height' : floor_right.siblings('.user').height()
					,
				});
		var temp = $(this);
		if (temp.hasClass('top_right_button_close')) {
			$(this).removeClass('top_right_button_close').text('收起回复').parent()
					.siblings().slideDown(300);
			temp.parent().css({
						"border-width" : '1px'
						,
					});
			$(this).parents(".floor").find(".idea_text").text("").focus();
		} else {
			$(this).parent().siblings().slideUp(300, function() {
				temp.parent().css({
							"border-width" : '0px'
							,
						});
				var size = temp.parent().siblings('.childs_middle').find('li')
						.size();
				if (size == 0) {
					temp.addClass('top_right_button_close').text('回复');
				} else {
					temp.addClass('top_right_button_close').text('回复（' + size
							+ "）");
				}
			});
		}
	});
	$(".date_a").click(function(event) {
		var name = $(this).parents(".child_right").find(".child_user").text();
		$(this).parents(".childs").find('.idea').slideDown(0);
		$(this).parents(".childs").find('.idea_text').text("回复 " + name + ":")
				.focus();
	});
	$(".span_button").click(function() {
				var page = $(this).siblings(".page").val();
				var totalPage = $(this).siblings(".totalPage").text();
				if (page == "" || page > totalPage) {
					return;
				} else {
					skip(page);
				}
			})
	$(".createReply").click(function(){
		createReply($(this)[0]);
	})
})