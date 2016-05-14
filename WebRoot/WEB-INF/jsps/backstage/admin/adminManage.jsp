<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>团队人员管理</title>
    <style type="text/css">

    </style>
</head>
<script type="text/javascript">
function addAdmin(id,username){
	var height = $("body").height()-80;
	$(".iframe").load("${pageContext.request.contextPath}/admin/adminUser_addAdmin",{"id":id,"username":username},function(data){
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
        $('html, body').animate({scrollTop : $(".result-table").offset().top}, 'slow');
    });
}
function removeAdmin(uid){
	var height = $("body").height()-80;
	$(".iframe").load("${pageContext.request.contextPath}/admin/adminUser_removeAdmin",{"uid":uid},function(data){
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
        $('html, body').animate({scrollTop : $(".result-table").offset().top}, 'slow');
    });
}
	$(document).ready(function(){
		$("#addAdmin").click(function(){
			var id = $(this).siblings("select").val();
			var username = $(this).siblings("input").val();
			if(!username || username==""){
				$(this).siblings("input").focus();
				return;
			}
			addAdmin(id,username);
		})
		$(".removeAdmin").click(function(){
			var uid = $(this).parents(".user").attr("id");
			removeAdmin(uid);
		})
	})
</script>
<body>
    <div class="head">
        <h1>团队人员管理</h1>
        <h2>添加吧务成员</h2>
        <form class="form-bottom">
            <select name="id" class="select">
            	<s:iterator value="positionList" var="position">
            	<s:if test="#position.id==1"></s:if>
            	<s:else>
                <option value="<s:property value='#position.id'/>"><s:property value='#position.name'/></option>
                </s:else>
                </s:iterator>
            </select>
            <input name="username" class="condition" type="text">
            <a id="addAdmin" href="#" class="button">添加</a>
        </form>
    </div>
    <div class="body">
    <ul class="list">
        <li class="list-li fl">
            <span class="subtitle"><i></i>小吧主</span>
            <ul class="listItem">
            <s:iterator value="userList" var="user">
                <li id="<s:property value='#user.uid'/>" class="listItem-li user">
                    <a href="#" class="adminUser"><s:property value='#user.name'/></a>
                    <a href="#" class="delete removeAdmin"></a>
                </li>
            </s:iterator>
            </ul>
        </li>
        <li class="list-li fl">
            <span class="subtitle"><i></i>图片小编</span>
            <ul class="listItem">
                <li class="listItem-li">
                    <i class="new">new<i></i></i>
                    <a href="#" class="adminUser">哈哈</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">大</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <i class="new">new<i></i></i>
                    <a href="#" class="adminUser">大苏打</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">齐威王</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">初心者</a>
                    <a href="#" class="delete"></a>
                </li>
            </ul>
        </li>
        <li class="list-li fl">
            <span class="subtitle"><i></i>语音小编</span>
            <ul class="listItem">
                <li class="listItem-li">
                    <i class="new">new<i></i></i>
                    <a href="#" class="adminUser">哈哈</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">大</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <i class="new">new<i></i></i>
                    <a href="#" class="adminUser">大苏打</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">齐威王</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">初心者</a>
                    <a href="#" class="delete"></a>
                </li>
            </ul>
        </li>
        <li class="list-li fl">
            <span class="subtitle"><i></i>视频小编</span>
            <ul class="listItem">
                <li class="listItem-li">
                    <i class="new">new<i></i></i>
                    <a href="#" class="adminUser">哈哈</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">大</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <i class="new">new<i></i></i>
                    <a href="#" class="adminUser">大苏打</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">齐威王</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">初心者</a>
                    <a href="#" class="delete"></a>
                </li>
            </ul>
        </li>
        <li class="list-li fl">
            <span class="subtitle"><i></i>广播小编</span>
            <ul class="listItem">
                <li class="listItem-li">
                    <i class="new">new<i></i></i>
                    <a href="#" class="adminUser">哈哈</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">大</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <i class="new">new<i></i></i>
                    <a href="#" class="adminUser">大苏打</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">齐威王</a>
                    <a href="#" class="delete"></a>
                </li>
                <li class="listItem-li">
                    <a href="#" class="adminUser">初心者</a>
                    <a href="#" class="delete"></a>
                </li>
            </ul>
        </li>
    </ul>
    </div>
</body>
</html>