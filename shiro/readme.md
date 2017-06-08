# Shiro
[跟我学Shiro](http://jinnianshilongnian.iteye.com/blog/2018398)
* Subject：主体
* SecurityManager: 安全管理器
* Realm 域 （数据源）
## 身份认证 Authentication
在shiro中，用户需要提供principals （身份）和credentials（证明）给shiro，从而应用验证用户身份。最常见的principals和credentials组合就是用户名/密码。   
2.1、首先通过new IniSecurityManagerFactory并指定一个ini配置文件来创建一个SecurityManager工厂add

2.2、接着获取SecurityManager并绑定到SecurityUtils，这是一个全局设置，设置一次即可；

2.3、通过SecurityUtils得到Subject，其会自动绑定到当前线程；如果在web环境在请求结束时需要解除绑定；然后获取身份验证的Token，如用户名/密码；

2.4、调用subject.login方法进行登录，其会自动委托给SecurityManager.login方法进行登录；
    
2.5、如果身份验证失败请捕获AuthenticationException或其子类，常见的如： DisabledAccountException（禁用的帐号）、LockedAccountException（锁定的帐号）、UnknownAccountException（错误的帐号）、ExcessiveAttemptsException（登录失败次数过多）、IncorrectCredentialsException （错误的凭证）、ExpiredCredentialsException（过期的凭证）等，具体请查看其继承关系；对于页面的错误消息展示，最好使用如“用户名/密码错误”而不是“用户名错误”/“密码错误”，防止一些恶意用户非法扫描帐号库；      
   
2.6、最后可以调用subject.logout退出，其会自动委托给SecurityManager.logout方法退出。


流程如下：

1、首先调用Subject.login(token)进行登录，其会自动委托给Security Manager，调用之前必须通过SecurityUtils. setSecurityManager()设置；

2、SecurityManager负责真正的身份验证逻辑；它会委托给Authenticator进行身份验证；

3、Authenticator才是真正的身份验证者，Shiro API中核心的身份认证入口点，此处可以自定义插入自己的实现；

4、Authenticator可能会委托给相应的AuthenticationStrategy进行多Realm身份验证，默认ModularRealmAuthenticator会调用AuthenticationStrategy进行多Realm身份验证；

5、Authenticator会把相应的token传入Realm，从Realm获取身份验证信息，如果没有返回/抛出异常表示身份验证失败了。此处可以配置多个Realm，将按照相应的顺序及策略进行访问。

**单Realm**

**多Realm**
```ini
#声明一个realm  
myRealm1=com.github.zhangkaitao.shiro.chapter2.realm.MyRealm1  
myRealm2=com.github.zhangkaitao.shiro.chapter2.realm.MyRealm2  
#指定securityManager的realms实现  
securityManager.realms=$myRealm1,$myRealm2   
```
securityManager会按照realms指定的顺序进行身份认证。此处我们使用显示指定顺序的方式指定了Realm的顺序，如果删除“securityManager.realms=$myRealm1,$myRealm2”，那么securityManager会按照realm声明的顺序进行使用（即无需设置realms属性，其会自动发现），当我们显示指定realm后，其他没有指定realm将被忽略，如“securityManager.realms=$myRealm1”，那么myRealm2不会被自动设置进去。
![](http://i4.buimg.com/4851/7bfa3dd1948d6344.png)

以后一般继承AuthorizingRealm（授权）即可；其继承了AuthenticatingRealm（即身份验证），而且也间接继承了CachingRealm（带有缓存实现）。其中主要默认实现如下：
org.apache.shiro.realm.text.IniRealm：[users]部分指定用户名/密码及其角色；[roles]部分指定角色即权限信息；
org.apache.shiro.realm.text.PropertiesRealm： user.username=password,role1,role2指定用户名/密码及其角色；role.role1=permission1,permission2指定角色及权限信息；
org.apache.shiro.realm.jdbc.JdbcRealm：通过sql查询相应的信息，如“select password from users where username = ?”获取用户密码，“select password, password_salt from users where username = ?”获取用户密码及盐；“select role_name from user_roles where username = ?”获取用户角色；“select permission from roles_permissions where role_name = ?”获取角色对应的权限信息；也可以调用相应的api进行自定义sql；
## Authenticator及AuthenticationStrategy
SecurityManager接口继承了Authenticator
，另外还有一个ModularRealmAuthenticator实现，其委托给多个Realm进行验证，验证规则通过AuthenticationStrategy接口指定，默认提供的实现：
FirstSuccessfulStrategy：只要有一个Realm验证成功即可，只返回第一个Realm身份验证成功的认证信息，其他的忽略；
AtLeastOneSuccessfulStrategy：只要有一个Realm验证成功即可，和FirstSuccessfulStrategy不同，返回所有Realm身份验证成功的认证信息；
AllSuccessfulStrategy：所有Realm验证成功才算成功，且返回所有Realm身份验证成功的认证信息，如果有一个失败就失败了。
 
ModularRealmAuthenticator默认使用AtLeastOneSuccessfulStrategy策略。
**自定义AuthenticationStrategy**
```java
//在所有Realm验证之前调用  
AuthenticationInfo beforeAllAttempts(  
Collection<? extends Realm> realms, AuthenticationToken token)   
throws AuthenticationException;  
//在每个Realm之前调用  
AuthenticationInfo beforeAttempt(  
Realm realm, AuthenticationToken token, AuthenticationInfo aggregate)   
throws AuthenticationException;  
//在每个Realm之后调用  
AuthenticationInfo afterAttempt(  
Realm realm, AuthenticationToken token,   
AuthenticationInfo singleRealmInfo, AuthenticationInfo aggregateInfo, Throwable t)  
throws AuthenticationException;  
//在所有Realm之后调用  
AuthenticationInfo afterAllAttempts(  
AuthenticationToken token, AuthenticationInfo aggregate)   
throws AuthenticationException;   
```
------------------------------------------
## 授权 Authorization

隐式角色：即直接通过角色来验证用户有没有操作权限，如在应用中CTO、技术总监、开发工程师可以使用打印机，假设某天不允许开发工程师使用打印机，此时需要从应用中删除相应代码；再如在应用中CTO、技术总监可以查看用户、查看权限；突然有一天不允许技术总监查看用户、查看权限了，需要在相关代码中把技术总监角色从判断逻辑中删除掉；即粒度是以角色为单位进行访问控制的，粒度较粗；如果进行修改可能造成多处代码修改。

显示角色：在程序中通过权限控制谁能访问某个资源，角色聚合一组权限集合；这样假设哪个角色不能访问某个资源，只需要从角色代表的权限集合中移除即可；无须修改多处代码；即粒度是以资源/实例为单位的；粒度较细。

```java
        Assert.assertEquals(true, subject.isAuthenticated());
        Assert.assertEquals(true, subject.hasRole("role2"));
        Assert.assertEquals(true, subject.isPermitted("user:delete"));
        Assert.assertEquals(false, subject.isPermitted("user:update"));
        try {
            subject.checkPermissions("user:update");//失败会报出相应异常
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }
```

**通配符**
如：system:user:update,delete   
    system:user:*       
    *:view    
    *:*:view          
    user:*:1
    “user:view”等价于“user:view:*”；

## INI配置
```ini
   [main]
   #提供了对根对象securityManager及其依赖的配置  
   securityManager=org.apache.shiro.mgt.DefaultSecurityManager  
   …………  
   securityManager.realms=$jdbcRealm  
     
   [users]  
   #提供了对用户/密码及其角色的配置，用户名=密码，角色1，角色2  
   username=password,role1,role2  
     
   [roles]  
   #提供了角色及权限之间关系的配置，角色=权限1，权限2  
   role1=permission1,permission2  
     
   [urls]  
   #用于web，提供了对web url拦截相关的配置，url=拦截器[参数]，拦截器  
   /index.html = anon  
   /admin/** = authc, roles[admin], perms["permission1"]  
```
## 编码/加密
**编码/解码** 
Base64
```java
String str = "hello";  
String base64Encoded = Base64.encodeToString(str.getBytes());  
String str2 = Base64.decodeToString(base64Encoded);  
Assert.assertEquals(str, str2);   
```
16进制
```java
String str = "hello";  
String base64Encoded = Hex.encodeToString(str.getBytes());  
String str2 = new String(Hex.decode(base64Encoded.getBytes()));  
Assert.assertEquals(str, str2);  

```
还有一个可能经常用到的类CodecSupport，提供了toBytes(str, "utf-8") / toString(bytes, "utf-8")用于在byte数组/String之间转换。
**散列算法**
散列算法一般用于生成数据的摘要信息，是一种**不可逆**的算法，一般适合存储密码之类的数据，常见的散列算法如MD5、SHA等。一般进行散列时最好提供一个salt（盐），比如加密密码“admin”，产生的散列值是“21232f297a57a5a743894a0e4a801fc3”，可以到一些md5解密网站很容易的通过散列值得到密码“admin”，即如果直接对密码进行散列相对来说破解更容易，此时我们可以加一些只有系统知道的干扰数据，如用户名和ID（即盐）；这样散列的对象是“密码+用户名+ID”，这样生成的散列值相对来说更难破解。  

```java
String str = "hello";  
String salt = "123";  
String md5 = new Md5Hash(str, salt).toString();//还可以转换为 toBase64()/toHex()   
String sha1 = new Sha256Hash(str, salt).toString();   //使用SHA256算法生成相应的散列数据，另外还有如SHA1、SHA512算法
//内部使用MessageDigest  //通用的散列支持：
String simpleHash = new SimpleHash("SHA-1", str, salt).toString();   
//生成随机数
SecureRandomNumberGenerator randomNumberGenerator =
new SecureRandomNumberGenerator();
String hex = randomNumberGenerator.nextBytes().toHex();
```
**加密/解密**
Shiro还提供对称式加密/解密算法的支持，如AES、Blowfish等；当前还没有提供对非对称加密/解密算法支持，未来版本可能提供。
```java
AesCipherService aesCipherService = new AesCipherService();  
aesCipherService.setKeySize(128); //设置key长度  
//生成key  
Key key = aesCipherService.generateNewKey();  
String text = "hello";  
//加密  
String encrptText =   
aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();  
//解密  
String text2 =  
 new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());  
  
Assert.assertEquals(text, text2);   
```
Shiro提供了PasswordService及CredentialsMatcher用于提供加密密码及验证密码服务。
Shiro默认提供了PasswordService实现DefaultPasswordService；CredentialsMatcher实现PasswordMatcher及HashedCredentialsMatcher（更强大）。
**密码重试次数限制**
如在1个小时内密码最多重试5次，如果尝试次数超过5次就锁定1小时，1小时后可再次重试，如果还是重试失败，可以锁定如1天，以此类推，防止密码被暴力破解。我们通过继承HashedCredentialsMatcher，且使用Ehcache记录重试次数和超时时间。