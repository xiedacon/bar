<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css">
    <title>吧务删帖</title>
    <style type="text/css">
.body .result-table td{
    vertical-align: top;
}
.body .result-table .select-td{
    width: 5%;
}
.body .result-table .content-td{
    width: 50%;
}
.body .result-table .people-td{
    width: 15%;
}
.body .result-table .operationTime-td{
    width: 15%;
}
.body .result-table .recover-td{
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
.result-table .content-top .date{

}
.result-table .content-bottom{
    padding: 0 15px 0 15px;
}
.body .result-table .post{
    height: 200px;
}

    </style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/admin.js"></script>
<script type="text/javascript">

	function recoverPost(id){
		var height = $("body").height()-80;
		$.post("${pageContext.request.contextPath}/admin/adminPost_recoverPost",{"id":id},function(data){
			//!!!!!!!!!!!!
			if(size<1){
				$(".iframe").html(data);
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
			}
        },"html");
	}
	$(document).ready(function(){
		$(".recoverPost").click(function(e){
			var id = $(this).parents(".post").attr("id");
			size = 1;
			recoverPost(id);
		})
		var flag = true;
		$(".selectAll input").click(function(){
			if(flag){
				$("tbody input").attr({"checked":"checked"});
				flag = false;
			}else{
				$("tbody input").removeAttr("checked");
				flag = true;
			}
		})
		$("tbody input").click(function(){
			if($(this).attr("checked")){
				$(this).removeAttr("checked");
			}else{
				$(this).attr({"checked":"checked"});
			}
		})
		$(".recoverSelected").click(function(){
			var checkboxs = $("tbody input[checked]");
			size = checkboxs.size();
			for(var i=0;i<checkboxs.size();i++){
				recoverPost(checkboxs.eq(i).parents(".post").attr("id"));
			}
		})
	})
</script>
</head>
<body>
    <div class="head">
        <h1>吧务删帖</h1>
        <form>
            <div class="form-top">
            <span class="initiatorOrOperator"><input name="initiatorOrOperator" type="radio" value="0" />发起人</span>
            <span class="initiatorOrOperator"><input name="initiatorOrOperator" type="radio" value="1" />操作人</span>
            </div>
            <div class="form-bottom">
                <input class="condition" name="username" type="text" />
                <div class="operationTime">
                <input class="operationTime-after" name="operationTime-after" type="date">至
                <input class="operationTime-before" name="operationTime-before" type="date">
                <a href="#" class="button">搜索</a>
                <a href="#" class="searchAll">显示全部记录</a>
                </div>
            </div>
        </form>
    </div>
    <div class="body">
        <p class="result">共<span class="result-count"><s:property value="pageBean.totalCount"/></span>条记录</p>
        <table class="result-table">
            <thead>
                <tr>
                    <td class="select-td">&nbsp;</td>
                    <td class="content-td">帖子内容</td>
                    <td class="people-td">全部操作人</td>
                    <td class="operationTime-td">操作时间</td>
                    <td class="recover-td">恢复帖子</td>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="pageBean.beanList" var="postLog">
                <tr id="<s:property value='#postLog.id'/>" class="post">
                    <td><input type="checkbox"  /></td>
                    <td><div class="content-top"><a href="#" class="fl title"><s:property value="#postLog.post.title"/></a><p class="fr"><a class="username"><i> </i><s:property value="#postLog.post.owner.name"/></a> <span class="date"><s:date name="#postLog.post.ldate" format="MM月dd日 HH:mm"></s:date></span></p></div>
                    <div class="content-bottom">
                            <div class="desc">
                                <div class="desc_top">
                                    <span class="desc_span fl"><!--<s:property value="#postLog.post.content"/>--></span>
                                </div>
                                <div class="desc_bottom">
                                    <img src="">
                                </div>
                            </div>
                    </div></td>
                    <td><s:property value="#postLog.lastOperator.name"/></td>
                    <td><s:date format="yy-MM-dd" name="#postLog.lastTime"></s:date></td>
                    <td><a class="button recoverPost" href="#">恢复帖子</a></td>
                </tr>
                </s:iterator>
            </tbody>
            <tfoot class="table-foot">
            	<tr>
            		<td colspan="5">
            		<s:if test="pageBean.page!=1">
						<span class="page fl" onclick="skip('admin/adminPost_findUnRecoverDeleteLog',1);">首页</span>
						<span class="page fl" onclick="skip('admin/adminPost_findUnRecoverDeleteLog',<s:property value='pageBean.page - 1'/>);">上一页</span>
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
							<span class="page fl" onclick="skip('admin/adminPost_findUnRecoverDeleteLog',<s:property value='#i'/>);"><s:property value="#i" /> </span>
						</s:else>
					</s:iterator>
					<s:if test="pageBean.page != pageBean.totalPage">
						<span class="page fl" onclick="skip('admin/adminPost_findUnRecoverDeleteLog',<s:property value='pageBean.page + 1'/>);">下一页</span>
						<span class="page fl" onclick="skip('admin/adminPost_findUnRecoverDeleteLog',<s:property value='pageBean.totalPage'/>);">尾页</span>
					</s:if>
            		</td>
            	</tr>
            	<tr>
                    <td colspan="5">
                        <p class="selectAll"><input type="checkbox"><span>全选</span></p>
                        <a href="#" class="button recoverSelected">选中项恢复</a>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
</body>
</html>