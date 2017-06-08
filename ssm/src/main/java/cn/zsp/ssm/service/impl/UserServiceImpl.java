package cn.zsp.ssm.service.impl;

import cn.zsp.ssm.mapper.UserMapper;
import cn.zsp.ssm.pojo.User;
import cn.zsp.ssm.pojo.UserExample;
import cn.zsp.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/3/24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> listUser() {
        UserExample userExample = new UserExample();
        return userMapper.selectByExample(userExample);

    }
}
