package cn.xiedacon.bar.interceptors;

import org.apache.struts2.ServletActionContext;

import cn.xiedacon.bar.user.domain.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user == null || !user.isAdmin()) {
			return "index";
		} else {
			return invocation.invoke();
		}
	}

}
