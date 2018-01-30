package cn.zsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/3/23
 */
@Controller
public class TemplatesController {
    @RequestMapping("/")
    public  String index(ModelMap modelMap){
        modelMap.addAttribute("host","http://www.baidu.com");
        return  "index";
    }
}
