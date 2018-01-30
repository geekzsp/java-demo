package cn.zsp.ssm.service;

import cn.zsp.ssm.pojo.User;

import java.util.List;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/3/24
 */
public interface UserService {
    /**
     * 获取用户列表
     * @return
     */
    List<User> listUser();
}
