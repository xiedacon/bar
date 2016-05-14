// 打开
function showDiv(name) {
	var height = $(window).height();
	$(".hidden").css({'display' : 'block','height' : height});
	$("." + name).css({'display' : 'block'});
	$("." + name + " .username")[0].focus();
	show = name;
}
// 最前显示的窗口，默认undefined
var show;
// 隐藏
function hiddenDiv() {
	$(".hidden").css({
				'display' : 'none'
			})
	$(".formDiv").css({
				'display' : 'none'
			})
	$(".formDiv input").val("");
	$(".formDiv .msg").text("");
	$(".formDiv .eMsg").text("").css("display", "none");
	show = undefined;
}
// 登录表单前台校验
function verifyLoginForm() {
	var username = $("#login_username").val();
	var password = $("#login_password").val();
	return verifyUsername(username, ".msg") && verifyPassword(password, ".msg")
}
// 注册表单前台校验
function verifyRegistForm() {
	var username = $("#regist_username").val();
	var password = $("#regist_password").val();
	var repassword = $("#regist_repassword").val();
	var name = $("#regist_name").val();
	var email = $("#regist_email").val();
	return verifyUsername(username, "#usernameMsg")
			&& verifyPassword(password, "#passwordMsg")
			&& verifyRepassword(password, repassword, "#repasswordMsg")
			&& verifyName(name, "#nameMsg") && verifyEmail(email, "#emailMsg")
}
// 校验用户名
function verifyUsername(username, name) {
	return required(username, "用户名不能为空!", name)
			&& length(username, 5, 10, "用户名长度应在5~10之间!", name)
}
// 校验密码
function verifyPassword(password, name) {
	return required(password, "密码不能为空!", name)
			&& length(password, 5, 10, "密码长度应在5~10之间!", name)
}
// 校验确认密码
function verifyRepassword(password, repassword, name) {
	return required(repassword, "再次密码不能为空!", name)
			&& than(password, repassword, "两次输入的密码不一致!", name)
}
// 校验昵称
function verifyName(name, name1) {
	return required(name, "昵称不能为空!", name1)
			&& length(name, 0, 10, "昵称长度不能超过10个字符!", name1)
}
// 校验email
function verifyEmail(email1, name) {
	return required(email1, "邮箱不能为空!", name) && email(email1, "邮箱格式错误!", name);
}
// 必须性校验
function required(verifyValue, result, name) {
	if (verifyValue == "") {
		msg(result, name);
		return false;
	} else {
		return true;
	}
}
// 长度校验
function length(verifyValue, min, max, result, name) {
	if (verifyValue.length < min || verifyValue.length > max) {
		msg(result, name);
		return false;
	} else {
		return true;
	}
}
// 相同性校验
function than(verifyValue1, verifyValue2, result, name) {
	if (verifyValue1 == verifyValue2) {
		return true;
	} else {
		msg(result, name);
		return false;
	}
}
// email格式校验
function email(verifyValue, result, name) {
	reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;
	if (reg.test(verifyValue)) {
		return true;
	} else {
		msg(result, name);
		return false;
	}
}
// 信息提示
function msg(date, name) {
	$(".formDiv " + name).text(date);
	$(".formDiv " + name).css("display", "block");
}
// 注册校验处理器
function verify(name, element) {
	if (name == "username") {
		if (verifyUsername(element.value, "#usernameMsg")) {
			hiddenMsg("#usernameMsg");
		}
	} else if (name == "password") {
		if (verifyPassword(element.value, "#passwordMsg")) {
			hiddenMsg("#passwordMsg");
		}
	} else if (name == "repassword") {
		var password = $(element).siblings(".password").val();
		if (verifyRepassword(password, element.value, "#repasswordMsg")) {
			hiddenMsg("#repasswordMsg");
		}
	} else if (name == "name") {
		if (verifyName(element.value, "#nameMsg")) {
			hiddenMsg("#nameMsg");
		}
	} else if (name == "email") {
		if (verifyEmail(element.value, "#emailMsg")) {
			hiddenMsg("#emailMsg");
		}
	} else {
		return "尚不支持的方法";
	}
}
function hiddenMsg(name) {
	$(".formDiv " + name).text("");
	$(".formDiv " + name).css("display", "none");
}
function reflash() {
	location.reload(true);
}
function toTop() {
	$("html,body").animate({scrollTop : 0}, 'slow');
}
function toPost() {
	$("#post .title").focus();
}
function getUrl(){
	var pathname = window.location.pathname.substring(1);
	return window.location.protocol + "//" + window.location.host + "/" + pathname.substring(0,pathname.indexOf("/"));
}
function toAdmin(){
	$.post(getUrl()+"/admin/admin_toBackStage",{}, function(data) {
		if(!data || data==""){
			alert("没有足够的权限");
			return;
		}
		window.location.href = data;
	})
}
$(document).ready(function() {
	// 登录/注册开始
	// 打开
	$("#login").click(function() {showDiv("loginDiv")});
	$("#regist").click(function() {showDiv("registDiv")});
	// 关闭按钮
	$(".formDiv .top i").click(function() {hiddenDiv()});
	//键盘事件
	$(document).keydown(function(e){
		if(e && show && e.keyCode == 27){//Esc
			hiddenDiv();
		}
		if(e && show && e.keyCode == 13){//Enter
			var inputs = $("." + show).find("input[type!='checkbox']");
			for(var i = 0;i<inputs.length;i++){
				if(!inputs.eq(i).val() || inputs.eq(i).val() == ""){
					inputs.eq(i).focus();
					return;
				}
			}
			$("." + show).find(".button").click();
		}
	});
	// 登录提交
	$("#login_submit").click(function() {
		if (verifyLoginForm()) {
			$.post(getUrl()+"/user_login",$("#login_form").serialize(), function(data) {
						if (data == "") {
							reflash();
						} else {
							msg(data, ".msg");
						}
					})
		}
	})
	// 注册提交
	$("#regist_submit").click(function() {
		var usernameMsg = $("#usernameMsg").text();
		if((usernameMsg == undefined || usernameMsg == "") && verifyRegistForm()){
			$.post(getUrl()+"/user_regist",
					$("#regist_form").serialize(), function(data) {
				if (data == "") {
					reflash();
				} else {
					msg(data, ".msg");
				}
			})
			return;
		}
		alert(usernameMsg);
	})

	// 后台返回消息提示

	$(".formDiv .input").focus(function() {
				msg("", ".msg");
			})
	$(".registDiv .input").blur(function() {
				var name = $(this).attr("name");
				verify(name, $(this)[0]);
			})

	// ajax校验用户名
	$("#regist_username").blur(function() {
				$
						.post(
								getUrl()+"/user_verifyUsernameAjax",
								{
									"username" : $("#regist_username").val()
								}, function(date) {
									if (date == "") {
									} else {
										msg(date, "#usernameMsg");
									}
								})
			})
	// 登录/注册结束

	// 退出开始
	$("#exit").click(function() {
		$.post(getUrl()+"/user_exit", {}, function(date) {location.reload(true);})
	})
	// 退出结束
	
})