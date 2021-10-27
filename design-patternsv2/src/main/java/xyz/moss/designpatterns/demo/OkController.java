package xyz.moss.designpatterns.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangshipeng
 * @date 2021/1/26
 */
@RestController
@RequiredArgsConstructor
public class OkController {
    private final UserDao userDao;

    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

    @GetMapping("/user")
    public String user() {
        return userDao.getUser();
    }
}
