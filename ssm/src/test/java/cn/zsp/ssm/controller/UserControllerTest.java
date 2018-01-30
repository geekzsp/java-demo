package cn.zsp.ssm.controller;

import cn.zsp.ssm.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/4/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml", "classpath:spring/springmvc.xml"})
public class UserControllerTest {
    private static final Logger logger= LoggerFactory.getLogger(UserControllerTest.class);
    @Value("${ip}")
    private String ip;
    @Value("${port}")
    private int port;
    // 模拟request,response
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    // 注入loginController
    @Autowired
    private UserController userController;

    // 执行测试方法之前初始化模拟request,response
    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }

    /**
     * @Title：testLogin
     * @Description: 测试用户登录
     */
    @Test
    public void testListUser() {
        try {
            request.setParameter("userName", "admin");
            request.setParameter("password", "2");
            String s = JsonUtils.objectToJson(userController.listUser());
            System.out.println(s);
            logger.info(ip+":"+port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}