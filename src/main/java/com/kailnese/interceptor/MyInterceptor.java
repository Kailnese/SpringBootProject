package com.kailnese.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //determine if user is login or not
        Object user = request.getSession().getAttribute("user");
        if(user == null){
            request.setAttribute("msg", "You need Login First");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }else{
            return true;
        }
    }
}
