package com.hna.action;

import java.io.IOException;
import java.util.Arrays;

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

    // private Logger log = LoggerFactory.getLogger(this.getClass());
    public webFilter() {
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // log.debug("-----login Filter-----");
        // log.error("----test---");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 无需登录的接口
        // String[] whiteStrs = { "/login", "/pnrinfo", "/tktinfo" };
        String[] whiteStrs = { "/login" };
        // 检查是否需要登录
        boolean flag = false;
        for (String str : Arrays.asList(whiteStrs))
        {
            if (httpRequest.getServletPath().contains(str)) {
                flag = true;
                break;
            }
        }
        // boolean flag = httpRequest.getServletPath().contains("/login");

        if (!flag && StringUtils.isEmpty(httpRequest.getSession().getAttribute("login"))) {
            request.setAttribute("loginRs", "请先登录");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        // 登录成功，放行
        // log.debug("{}-{} 通过login过滤器...",
        // httpRequest.getSession().getAttribute("userId"),
        // httpRequest.getSession().getAttribute("userName"));
        chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

    @Override
    public void destroy() {
    }

}
