package cn.zsp.ssm.controller;

import cn.zsp.ssm.pojo.User;
import cn.zsp.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/3/24
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public List<User> listUser(){
        return userService.listUser();
    }
}
