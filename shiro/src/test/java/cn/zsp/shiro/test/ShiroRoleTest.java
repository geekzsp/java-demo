package cn.zsp.shiro.test;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Test;

/**
 * @Description: 授权（权限认证） 简单入门
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/4/26
 */
public class ShiroRoleTest {

    @Test
    public void testHelloWorld() {
        //1.获取SecurityFactory工厂，此处使用ini配置文件初始化SecurityManager
        //iniRealm方式获取数据源
        //Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-role.ini");
        //jdbcRealm方式获取数据源
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("wang", "456");
        try {
            //4、登录
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
            e.printStackTrace();
        }
        Assert.assertEquals(true, subject.isAuthenticated());
        Assert.assertEquals(true, subject.hasRole("role2"));
        Assert.assertEquals(true, subject.isPermitted("user:delete"));
        Assert.assertEquals(false, subject.isPermitted("user:update"));
        try {
            subject.checkPermissions("user:update");//失败会报出相应异常
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }
        //6、退出
        subject.logout();
    }

    @After
    public void tearDown() {
        //退出时请解除绑定Subject到线程，否则对下次测试造成影响
        ThreadContext.unbindSubject();
    }
}
