package com.llayjun.millet.common.utils;

import com.llayjun.millet.common.annotation.CurrentUser;
import com.llayjun.millet.module.user.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * zyl
 * 当前用户信息获取
 */
@Slf4j
@Component
public class CurrentUserHandlerMethodArgResolver implements HandlerMethodArgumentResolver {

    /**
     * 判断是否支持使用@CurrentUser注解的参数
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        // 如果该参数注解有@CurrentUser且参数类型是User
        return methodParameter.getParameterAnnotation(CurrentUser.class) != null && methodParameter.getParameterType() == UserInfoVO.class;
    }

    /**
     * 注入参数值
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // 取得HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        // 取出session中的User
        UserInfoVO userInfoVO = (UserInfoVO) request.getSession().getAttribute("currentUser");
        log.info("currentUser id：{}", userInfoVO.getId());
        return userInfoVO;
    }

}
