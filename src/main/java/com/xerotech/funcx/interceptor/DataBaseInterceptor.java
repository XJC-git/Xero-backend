package com.xerotech.funcx.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xerotech.funcx.annotation.Login;
import com.xerotech.funcx.entity.User;
import com.xerotech.funcx.entity.UserRole;
import com.xerotech.funcx.service.impl.RelInterfaceRoleServiceImpl;
import com.xerotech.funcx.service.impl.UserRoleServiceImpl;
import com.xerotech.funcx.service.impl.UserServiceImpl;
import com.xerotech.funcx.utils.TokenUtils;
import com.xerotech.funcx.service.impl.UserLoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DataBaseInterceptor implements HandlerInterceptor {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Autowired
    private RelInterfaceRoleServiceImpl relInterfaceRoleService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        HandlerMethod method = (HandlerMethod) handler;
        LOGGER.info(String.format("执行了拦截器 %s",path));
        String token = request.getHeader("Authorization");

        //验证是否登录
        var login = method.getMethod().getAnnotation(Login.class);
        if(login!=null){
            if(token==null||token.length()==0){
                response.sendError(HttpServletResponse.SC_FORBIDDEN,"缺失token");
                return false;
            }
            if(!TokenUtils.verify(token)){
                response.sendError(HttpServletResponse.SC_FORBIDDEN,"无效token");
                return false;
            }
        }

        //验证当前用户是否有权限
        String username = "unauthorized";
        String realName = TokenUtils.getUserName(token);
        if(realName!=null&&realName.length()>0){
            username = realName;
        }
        var role_id = userService.getOne(
                Wrappers.<User>lambdaQuery()
                        .eq(User::getUserName, username)
        );


//        boolean aut = userLoginService.checkPath(username,path);
//        if(!aut){
//            response.sendError(HttpServletResponse.SC_FORBIDDEN,"角色无权限");
//            return false;
//        }
        return true;
    }


}
