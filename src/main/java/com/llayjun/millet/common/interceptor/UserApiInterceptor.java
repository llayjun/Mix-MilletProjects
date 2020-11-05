package com.llayjun.millet.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.llayjun.millet.common.annotation.PassToken;
import com.llayjun.millet.common.annotation.UserToken;
import com.llayjun.millet.common.exception.BusinessException;
import com.llayjun.millet.common.exception.TokenValidException;
import com.llayjun.millet.common.utils.BeanUtil;
import com.llayjun.millet.common.utils.JwtTokenUtil;
import com.llayjun.millet.module.user.entity.User;
import com.llayjun.millet.module.user.service.IUserService;
import com.llayjun.millet.module.user.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * zyl
 * 用户拦截器
 */
@Slf4j
@Component
public class UserApiInterceptor implements HandlerInterceptor {

    @Autowired
    IUserService iUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        log.info("请求地址[{}], 请求参数[{}]", request.getRequestURI(), JSONObject.toJSON(request.getParameterMap()));
        String token = request.getHeader(JwtTokenUtil.HEADER_STRING);

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        // 检查是否有passToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserToken.class)) {
            UserToken userToken = method.getAnnotation(UserToken.class);
            if (userToken.required()) {
                // 执行认证
                if (StringUtils.isEmpty(token)) {
                    throw new TokenValidException(300, "token校验失败！未获取到token");
                }
                Boolean valid = JwtTokenUtil.validateJWTToken(token);
                if (!valid) {
                    throw new TokenValidException(300, "token校验失败！请检查");
                }
                User user = iUserService.getById(JwtTokenUtil.getJwtUserId(request));
                if (user == null) {
                    throw new BusinessException(300, "用户信息为空");
                }
                UserInfoVO userInfoVO = new UserInfoVO();
                BeanUtils.copyProperties(user, userInfoVO);
                //我们将解析的用户结果先放入session中
                request.getSession().setAttribute("currentUser",userInfoVO);
            }
        }
        return true;
    }

}
