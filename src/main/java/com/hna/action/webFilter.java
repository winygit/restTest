package com.hna.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

@WebFilter(value = { "/api/*", "/app/*" })
public class webFilter implements Filter {

    public webFilter() {
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //
        // System.out.println("检查登录！！！");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 未登录 ，先去登录
        boolean flag = httpRequest.getServletPath().contains("/login");
        if (!flag && StringUtils.isEmpty(httpRequest.getSession().getAttribute("login"))) {
            request.setAttribute("loginRs", "请先登录");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        // 登录成功，放行
        chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

    @Override
    public void destroy() {
    }

}
