<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>会员列表</title>
    <style type="text/css">
.body .result-table .user-td{
    width: 30%;
}
.body .result-table .experience-td{
    width: 9%;
}
.body .result-table .level-td{
    width: 9%;
}
.body .result-table .postNum-td{
    width: 12%;
}
.body .result-table .qualityPost-td{
    width: 9%;
}
.body .result-table .time-td{
    width: 19%;
}
.body .result-table .operation-td{
    width: 12%;
}
.body .result-table .operation{
    text-align: left;
}


    </style>
</head>
<script type="text/javascript">
function forbiddenUser(uid){
	var height = $("body").height()-80;
	$(".iframe").load("${pageContext.request.contextPath}/admin/adminUser_forbiddenUser",{"uid":uid},function(data){
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
		$(".forbiddenUser").click(function(){
			var uid = $(this).parents(".post").attr("id");
			forbiddenUser(uid);
		})
	})
</script>
<body>
    <div class="head">
        <h1>会员列表</h1>
        <div class="form-bottom">
            <span>用户名</span>
            <input class="condition" type="text">
            <a class="button" href="#">搜索</a>
        </div>
    </div>
    <div class="body">
        <p class="result">共<span class="result-count"><s:property value="pageBean.totalCount"/></span>条记录</p>
        <table class="result-table">
            <thead>
                <tr>
                    <td class="user-td">头像和用户名</td>
                    <td class="experience -td">经验值</td>
                    <td class="level-td">等级</td>
                    <td class="postNum-td">本吧发帖数</td>
                    <td class="qualityPost-td">精品贴</td>
                    <td class="time-td">加入时间</td>
                    <td class="operation-td">操作</td>
                </tr>
            </thead>
            <tbody>
				<s:iterator value="pageBean.beanList" var="user">            
                <tr id="<s:property value='#user.uid'/>" class="post">
                    <td class="user"><img class="user-icon" src="${pageContext.request.contextPath}/image/<s:property value='#user.icon'/>"><a href="#" class="username"><s:property value='#user.name'/></a></td>
                    <td>0</td>
                    <td><s:property value='#user.level.lid'/></td>
                    <td><s:property value='#user.postNum'/></td>
                    <td><s:property value='#user.boutiqueNum'/></td>
                    <td><s:date name='#user.registDate' format="yyyy-MM-dd HH:mm"></s:date></td>
                    <td class="operation">
                        <a href="#" class="button forbiddenUser">封禁</a>
                        <a href="#" class="button addToBlackList">加入黑名单</a>
                    </td>
                </tr>
                </s:iterator>
            </tbody>
            <tfoot class="table-foot">
            	<tr>
            		<td colspan="5">
            		<s:if test="pageBean.page!=1">
						<span class="page fl" onclick="skip('user_findAllUser',1);">首页</span>
						<span class="page fl" onclick="skip('user_findAllUser',<s:property value='pageBean.page - 1'/>);">上一页</span>
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
							<span class="page fl" onclick="skip('user_findAllUser',<s:property value='#i'/>);"><s:property value="#i" /> </span>
						</s:else>
					</s:iterator>
					<s:if test="pageBean.page != pageBean.totalPage">
						<span class="page fl" onclick="skip('user_findAllUser',<s:property value='pageBean.page + 1'/>);">下一页</span>
						<span class="page fl" onclick="skip('user_findAllUser',<s:property value='pageBean.totalPage'/>);">尾页</span>
					</s:if>
            		</td>
            	</tr>
            </tfoot>
        </table>
    </div>
</body>
</html>