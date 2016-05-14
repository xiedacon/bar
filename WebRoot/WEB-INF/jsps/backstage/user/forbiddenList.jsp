<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>用户封禁列表</title>
    <style type="text/css">
.body .result-table .select-td{
    width: 5%;
}
.body .result-table .user-td{
    width: 40%;
}
.body .result-table .forbiddenTime-td{
    width: 10%;
}
.body .result-table .time-td{
    width: 20%;
}
.body .result-table .people-td{
    width: 15%;
}
.body .result-table .operation-td{
    width: 10%;
}
    </style>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$(".removeForbiddenLog").click(function(){
			var id = $(this).parents(".post").attr("id");
			var height = $("body").height()-80;
			$(".iframe").load("${pageContext.request.contextPath}/admin/adminUser_removeForbiddenLog",{"id":id},function(data){
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
		})
	})
</script>
<body>
    <div class="head">
        <h1>用户封禁列表</h1>
        <div class="form-bottom">
            <span>用户名</span>
            <input class="condition" type="text">
            <a class="button" href="#">搜索</a>
        </div>
    </div>
    <div class="body">
        <p class="result"><a href="#" class="resultAll">全部记录</a>>5条搜索结果</p>
        <table class="result-table">
            <thead>
                <tr>
                    <td class="select-td"></td>
                    <td class="user-td">头像和用户名</td>
                    <td class="forbiddenTime-td">封禁时长</td>
                    <td class="time-td">操作时间</td>
                    <td class="people-td">全部操作人</td>
                    <td class="operation-td">操作</td>
                </tr>
            </thead>
            <tbody>
            	<s:iterator value="pageBean.beanList" var="userLog">
                <tr id="<s:property value='#userLog.id'/>" class="post">
                    <td><input type="checkbox"></td>
                    <td class="user"><img class="user-icon" src="${pageContext.request.contextPath}/image/<s:property value='#userLog.user.icon'/>"><a href="#" class="username"><s:property value='#userLog.user.name'/></a></td>
                    <td>...</td>
                    <td><s:date name="#userLog.lastTime" format="yyyy-MM-dd HH:mm"></s:date></td>
                    <td><s:property value='#userLog.lastoperator.name'/></td>
                    <td>
                        <a href="#" class="button removeForbiddenLog">解除封禁</a>
                    </td>
                </tr>
                </s:iterator>
            </tbody>
            <tfoot class="table-foot">
            	<tr>
            		<td colspan="5">
            		<s:if test="pageBean.page!=1">
						<span class="page fl" onclick="skip('user_findUnrecoverForbiddenLog',1);">首页</span>
						<span class="page fl" onclick="skip('user_findUnrecoverForbiddenLog',<s:property value='pageBean.page - 1'/>);">上一页</span>
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
							<span class="now_page page fl"><s:property value="#i" /> </span>
						</s:if>
						<s:else>
							<span class="page fl" onclick="skip('user_findUnrecoverForbiddenLog',<s:property value='#i'/>);"><s:property value="#i" /> </span>
						</s:else>
					</s:iterator>
					<s:if test="pageBean.page != pageBean.totalPage">
						<span class="page fl" onclick="skip('user_findUnrecoverForbiddenLog',<s:property value='pageBean.page + 1'/>);">下一页</span>
						<span class="page fl" onclick="skip('user_findUnrecoverForbiddenLog',<s:property value='pageBean.totalPage'/>);">尾页</span>
					</s:if>
            		</td>
            	</tr>
                <tr>
                    <td colspan="6">
                        <p class="selectAll"><input type="checkbox"><span>全选</span></p>
                        <a href="#" class="button">选中项解除封禁</a>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
</body>
</html>