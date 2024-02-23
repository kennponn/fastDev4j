package com.fastDev4j.system.web.filter;

import com.fastDev4j.core.domain.Result;
import com.fastDev4j.system.web.utils.RedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
@Component
public class TokenFilter implements Filter {

    @Autowired
    private RedisUtils redisUtils;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //登录接口跳过验证
        if (request.getRequestURI().contains("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        /** token+redis验证 */
        String token = request.getHeader("Authorization");

        if (!redisUtils.hasKey(token)) {
            response.setStatus(401);
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.println( new ObjectMapper().writeValueAsString(Result.error("token失效")));
            writer.close();
            return;
        }
        //刷新token有效期
        redisUtils.expire(token, 1, TimeUnit.HOURS);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
