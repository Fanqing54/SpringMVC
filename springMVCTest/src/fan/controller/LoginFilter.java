package fan.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fan.model.User;





public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsq = (HttpServletRequest)req;
		//因为Filter本来设计成为多种协议服务，http协议仅仅是其中一部分
		User u = (User)hsq.getSession().getAttribute("loginUser");
		if(u==null) {
			((HttpServletResponse)resp).sendRedirect(hsq.getContextPath()+"/login");
		}
		
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
