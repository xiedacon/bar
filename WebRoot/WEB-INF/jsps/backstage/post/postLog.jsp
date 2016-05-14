<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>帖子管理日志</title>
    <style type="text/css">
.body .result-table td{
    vertical-align: top;
}
.body .result-table .operation-td{
    width: 15%;
}
.body .result-table .content-td{
    width: 55%;
}
.body .result-table .people-td{
    width: 15%;
}
.body .result-table .operationTime-td{
    width: 15%;
}
.result-table .content-top{
    padding: 0 15px 0 15px;
}
.result-table .content-top:after{
    display: block;
    height: 0;
    content: "";
    visibility: hidden;
    clear: both;
}
.result-table .content-top .title{
    color: #398BFC;
    font-size: 18px;
}
.result-table .content-top .username{
    color: #398BFC;
    font-size: 16px;
}
 .content-top .username i{
    color: #398BFC;
    font-size: 16px;
    font-family: "icomoon";
}
.result-table .content-bottom{
    padding: 0 15px 0 15px;
}
.body .result-table .post{
    height: 200px;
}
    </style>
</head>
<body>
    <div class="head">
        <h1>帖子管理日志</h1>
        <form>
            <div class="form-top">
            <span><input name="initiator" type="radio" value="0" />发起人</span>
            <span><input name="operator" type="radio" value="1" />操作人</span>
            </div>
            <div class="form-bottom">
                <input class="condition" name="username" type="text" />
                <div class="operationTime">
                <input class="operationTime-after" name="operationTime_begin" type="date">至
                <input class="operationTime-before" name="operationTime_end" type="date">
                <a id="search" href="#" class="button">搜索</a>
                <a id="searchAll" href="#" class="searchAll">显示全部记录</a>
                </div>
            </div>
        </form>
    </div>
    <div class="body">
        <p class="result">共<span class="result-count"><s:property value="pageBean.totalCount"/></span>条记录</p>
        <table class="result-table">
            <thead>
                <tr>
                    <td class="content-td">帖子内容</td>
                    <td class="operation-td">全部操作</td>
                    <td class="people-td">全部操作人</td>
                    <td class="operationTime-td">操作时间</td>
                </tr>
            </thead>
            <tbody>
            	<s:iterator value="pageBean.beanList" var="postLog">
                <tr id="<s:property value="#postLog.id"/>" class="post">
                    <td><div class="content-top"><a href="#" class="fl title"><s:property value="#postLog.post.title"/></a><p class="fr"><a class="username"><i> </i><s:property value="#postLog.post.owner.name"/></a> <span class="date"><s:date name="#postLog.post.ldate" format="MM月dd日 HH:mm"></s:date></span></p></div>
                    <div class="content-bottom">
                            <div class="desc">
                                <div class="desc_top">
                                    <span class="desc_span fl"><s:property value="#postLog.post.content"/></span>
                                </div>
                                <div class="desc_bottom">
                                    <img src="">
                                </div>
                            </div>
                    </div></td>
                    <s:if test="#postLog.lastOperation.equals('delete')">
                    	<td>删除</td>
                    </s:if>
                    <s:elseif test="#postLog.lastOperation.equals('recover')">
                    	<td>已恢复</td>
                    </s:elseif>
                    <td><s:property value="#postLog.lastOperator.name"/></td>
                    <td><s:date name="#postLog.lastTime" format="yyyy-MM-dd"></s:date><br/><s:date name="#postLog.lastTime" format="HH:mm"></s:date></td>
                </tr>
                </s:iterator>
            </tbody>
            <tfoot class="table-foot">
            	<tr>
            		<td colspan="5">
            		<s:if test="pageBean.page!=1">
						<span class="page fl" onclick="skip('admin/adminPost_findAllLog',1);">首页</span>
						<span class="page fl" onclick="skip('admin/adminPost_findAllLog',<s:property value='pageBean.page - 1'/>);">上一页</span>
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
							<span class="page fl" onclick="skip('admin/adminPost_findAllLog',<s:property value='#i'/>);"><s:property value="#i" /> </span>
						</s:else>
					</s:iterator>
					<s:if test="pageBean.page != pageBean.totalPage">
						<span class="page fl" onclick="skip('admin/adminPost_findAllLog',<s:property value='pageBean.page + 1'/>);">下一页</span>
						<span class="page fl" onclick="skip('admin/adminPost_findAllLog',<s:property value='pageBean.totalPage'/>);">尾页</span>
					</s:if>
            		</td>
            	</tr>
            </tfoot>
        </table>
    </div>
</body>
</html>