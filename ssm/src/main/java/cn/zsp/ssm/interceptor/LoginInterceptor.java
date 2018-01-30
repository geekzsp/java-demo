package cn.zsp.ssm.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2016/12/21
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //这里根据自己的逻辑是否放行
        ////获取token
        //TbUser user = (TbUser) request.getSession().getAttribute("user");
        //if (null == user) {
        //    //token未空 未登录
        //    response.sendRedirect("/user/login");
        //    return false;
        //}

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
