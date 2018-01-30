package cn.zsp.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/3/7
 */
@Controller
public class ErrorController {

    @RequestMapping(value="/error_404")
    public String error_404(){

        return "error/404";
    }
}
