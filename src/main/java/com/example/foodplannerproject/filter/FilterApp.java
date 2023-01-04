package com.example.foodplannerproject.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/app/*")
public class FilterApp implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        req.setCharacterEncoding("UTF-8");
        try {
            if (session.getAttribute("logged").toString().equals("true")) {
                chain.doFilter(req, res);
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            response.sendRedirect("/login");
        }
    }


}
