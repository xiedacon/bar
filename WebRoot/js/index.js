// 加载内容
function loadMaterial(name, method, page, flag) {
	var method1 = window.location.search;
	if(method1 == "" || method1 == "?" + method){
		window.history.replaceState({},0,"index?"+method);
	}else{
		window.history.pushState({},0,"index?"+method);
	}
	$("#material").load(getUrl() + "/" + method
			+ "?page=" + page);
	$("#" + name).siblings().removeClass("opt");
	$("#" + name).addClass('opt');
	if (!flag) {
		$('html, body').animate({scrollTop : $("body > .top").height() + $(".head").height()}, 'slow');
	}
}

$(document).ready(

function() {
	// 初始化开始
	var method = window.location.search;
	method = method.substring(1);
	if(method==""){
		method = "post_findByPage";
	}
	var name = method.substring(method.indexOf("_")+1);
	if(name=="findByPage"){
		name = "posts";
	}
	loadMaterial(name, method, 1, true);
	// 初始化结束
	// 索引开始
	$("#index").click(function() {
				$(this).parent().siblings().slideToggle(500);
				if ($("#index i").hasClass('arrows_button')) {
					$(this).html("收起索引<i class='arrows_top'></i>");
				} else {
					$(this).html("展开索引<i class='arrows_button'></i>");
				}
			})
	// 索引结束

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
	})