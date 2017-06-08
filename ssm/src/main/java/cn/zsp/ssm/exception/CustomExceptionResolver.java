package cn.zsp.ssm.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
   private static final Logger logger= LoggerFactory.getLogger(CustomExceptionResolver.class);
    /**
     * （非 Javadoc）
     * <p>Title: resolveException</p>
     * <p>Description: </p>
     *
     * @param request
     * @param response
     * @param handler
     * @param ex       系统 抛出的异常
     * @return
     * @see HandlerExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        //handler就是处理器适配器要执行Handler对象（只有method）
        //解析出异常类型
        //如果该 异常类型是自定义的异常，直接取出异常信息，在错误页面展示
        //如果该 异常类型不是 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）
        CustomException customException = null;
        if (ex instanceof CustomException) {
            customException = (CustomException) ex;
        } else {
            customException = new CustomException("未知错误");
            //打印控制台
            ex.printStackTrace();
            //写日志 需要log4j.properties 配置
            logger.error("系统发生异常={]",ex);
            //发短信 ，发邮件
        }
        //错误信息
        String message = customException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        //将错误信息传到页面
        modelAndView.addObject("message", message);
        //指向错误页面
        modelAndView.setViewName("error/500");
        return modelAndView;
    }

}
