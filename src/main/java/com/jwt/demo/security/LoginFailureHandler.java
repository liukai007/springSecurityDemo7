package com.jwt.demo.security;

import com.alibaba.fastjson.JSON;
import com.jwt.demo.pojo.Result;
import com.jwt.demo.pojo.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure (HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        returnFailure(response);
    }
    public void returnFailure(HttpServletResponse response) throws IOException{
        Result r = new Result();
        r.code(ResultCode.UNAUTHORIZED).message("认证失败");
        // 使用fastjson
        String json =  JSON.toJSONString(r);
        // 指定响应格式是json
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
