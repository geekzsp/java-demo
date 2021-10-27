package xyz.moss.designpatterns.demo;

import org.springframework.stereotype.Repository;

/**
 * @author zhangshipeng
 * @date 2021/1/26
 */
@Repository
public class UserDao {
    public String getUser() {
        return "张三";
    }
}
