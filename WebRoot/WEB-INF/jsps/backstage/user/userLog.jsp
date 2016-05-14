<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>用户管理日志</title>
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
    </style>
</head>
<body>
    <div class="head">
        <h1>用户管理日志</h1>
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
                    <td class="content-td">头像和用户名</td>
                    <td class="operation-td">全部操作</td>
                    <td class="people-td">全部操作人</td>
                    <td class="operationTime-td">操作时间</td>
                </tr>
            </thead>
            <tbody>
            	<s:iterator value="pageBean.beanList" var="userLog">
                <tr class="post">
                    <td class="user"><img class="user-icon" src="${pageContext.request.contextPath}/image/<s:property value='#userLog.user.icon'/>"><a href="#" class="username"><s:property value='#userLog.user.name'/></a></td>
                    <td>
                    	<s:if test="#userLog.lastOperation == 'forbidden'">封禁</s:if>
                    	<s:elseif test="#userLog.lastOperation == 'removeForbidden'">解除封禁</s:elseif>
                    	<s:elseif test="#userLog.lastOperation == 'blackList'">加入黑名单</s:elseif>
                    	<s:elseif test="#userLog.lastOperation == 'removeBlackList'">移除黑名单</s:elseif>
                    </td>
                    <td><s:property value='#userLog.lastOperator.name'/></td>
                    <td><s:date name="#userLog.lastTime" format="yyyy-MM-dd HH:mm"></s:date></td>
                </tr>
                </s:iterator>
            </tbody>
                        <tfoot class="table-foot">
            	<tr>
            		<td colspan="5">
            		<s:if test="pageBean.page!=1">
						<span class="page fl" onclick="skip('user_findAllLog',1);">首页</span>
						<span class="page fl" onclick="skip('user_findAllLog',<s:property value='pageBean.page - 1'/>);">上一页</span>
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
							<span class="page fl" onclick="skip('user_findAllLog',<s:property value='#i'/>);"><s:property value="#i" /> </span>
						</s:else>
					</s:iterator>
					<s:if test="pageBean.page != pageBean.totalPage">
						<span class="page fl" onclick="skip('user_findAllLog',<s:property value='pageBean.page + 1'/>);">下一页</span>
						<span class="page fl" onclick="skip('user_findAllLog',<s:property value='pageBean.totalPage'/>);">尾页</span>
					</s:if>
            		</td>
            	</tr>
            </tfoot>
        </table>
    </div>
</body>
</html>