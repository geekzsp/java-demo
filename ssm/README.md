[源码地址](https://github.com/geekzsp/JavaDemo/tree/master/SSM)
# 乱码解决
* post乱码
web.xml
```xml
     <!-- 解决post乱码 -->
        <filter>
            <filter-name>CharacterEncodingFilter</filter-name>
            <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
            <init-param>
                <param-name>encoding</param-name>
                <param-value>utf-8</param-value>
            </init-param>
        </filter>
        <filter-mapping>
            <filter-name>CharacterEncodingFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
```
* get乱码              
方式一：设置tomcat 编码为utf-8 （一劳永逸）           
方式二：手动解码再编码
```java
  String string=new String(result.getBytes("iso8859-1"),"utf-8");
```
* response乱码   
方式一：推荐
springmvc.xml 头文件一定要是4.0及以上才可以
```xml
 <mvc:annotation-driven >
        <!-- 消息转换器 -->
        <mvc:message-converters register-defaults="true">
            <!--解决respnse乱码-->
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <property name="supportedMediaTypes" value="text/html;charset=UTF-8"/>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
```
方式二：自己指定相应格式
```java
  @RequestMapping(value = "/test",produces = "text/html;charset=utf-8")
    @ResponseBody
    public   String test()
    {
        return "测试中文乱码";
    }
```
方式三： 

         解决办法：

                   a、更改服务器发送数据的默认编码

                            response.setCharacterEncoding("UTF-8");

                            还要通知客户端解码方式

                            response.setHeader("Content-Type","text/html;charset=UTF-8");

 

                   b、因为经常要变动编码方式，因此SerlvetResponse提供了一个更好用的方法

                            response.setContentType("text/html;charset=UTF-8");

                            此方法的功效等同于a中的两行代码
                            
# mybatis相关
# maven mybatis自动生成插件
pom.xml
```xml
 <!--mybatis逆向工程插件-->
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.2</version>
                <configuration>
                    <verbose>true</verbose>
                    <overwrite>true</overwrite>
                </configuration>
            </plugin>
```
generatorConfig.xml 放到根目录
设置驱动位置 数据库 用户名 密码 需要生成的表
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <!-- 制定mysql的驱动包的路径 千万别放中文路径下 -->
    <classPathEntry location="C:\Users\Administrator\.m2\repository\mysql\mysql-connector-java\5.1.32\mysql-connector-java-5.1.32.jar"/>
    <context id="testTables" targetRuntime="MyBatis3">
        <commentGenerator>
            <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
            <property name="suppressAllComments" value="true"/>
        </commentGenerator>
        <!--数据库连接的信息：驱动类、连接地址、用户名、密码 -->
        <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/demo" userId="root"
                        password="root">
        </jdbcConnection>
        <!-- 默认false，把JDBC DECIMAL 和 NUMERIC 类型解析为 Integer，为 true时把JDBC DECIMAL 和
            NUMERIC 类型解析为java.math.BigDecimal -->
        <javaTypeResolver>
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>

        <!-- targetProject:生成PO类的位置 -->
        <javaModelGenerator targetPackage="cn.zsp.ssm.pojo"
                            targetProject="./src">
            <!-- enableSubPackages:是否让schema作为包的后缀 -->
            <property name="enableSubPackages" value="false"/>
            <!-- 从数据库返回的值被清理前后的空格 -->
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>
        <!-- targetProject:mapper映射文件生成的位置 -->
        <sqlMapGenerator targetPackage="cn.zsp.ssm.mapper"
                         targetProject="./src">
            <!-- enableSubPackages:是否让schema作为包的后缀 -->
            <property name="enableSubPackages" value="false"/>
        </sqlMapGenerator>
        <!-- targetPackage：mapper接口生成的位置 -->
        <javaClientGenerator type="XMLMAPPER"
                             targetPackage="cn.zsp.ssm.mapper"
                             targetProject="./src">
            <!-- enableSubPackages:是否让schema作为包的后缀 -->
            <property name="enableSubPackages" value="false"/>
        </javaClientGenerator>
        <!-- 指定数据库表 -->
        <table schema="" tableName="user"></table>

    </context>
</generatorConfiguration>

```
运行：
>mybatis-generator:generate -e 运行
# 分页插件
[pageHelper](https://github.com/pagehelper/Mybatis-PageHelper)
基本使用
```java
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TbUserMapper userMapper;
    @Override
    public PageResult list(int page, int rows) {
        //设置当前页 和行数
        PageHelper.startPage(page,rows);
        List<TbUser> tbUsers = userMapper.selectByExample(new TbUserExample());
        //从pageinfo中取结果
        PageInfo<TbUser> pageInfo=new PageInfo<TbUser>(tbUsers);
       return  PageResult.buid(page,pageInfo.getList(),pageInfo.getPages());
    }
}

```
# 模板引擎
# 使用freemarker代替jsp
1.添加依赖
```xml
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>${freemarker.version}</version>
        </dependency>
```
2.springmvc.xml 相关配置 取消jsp的视图 并添加如下内容
```xml
  <!-- freemarker的配置 -->
    <bean id="freemarkerConfig"
          class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
        <property name="templateLoaderPath" value="/WEB-INF/ftl/"/>
        <property name="defaultEncoding" value="utf-8"/>
        <property name="freemarkerSettings">
            <props>
                <prop key="template_update_delay">10</prop>
                <prop key="locale">zh_CN</prop>
                <prop key="datetime_format">yyyy-MM-dd</prop><!-- 时间格式化 -->
                <prop key="date_format">yyyy-MM-dd</prop>
                <prop key="number_format">#.##</prop>
            </props>
        </property>
    </bean>

    <!-- 配置freeMarker视图解析器 -->
    <bean
            class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
        <property name="cache" value="true"/>
        <property name="prefix" value=""/><!-- 上面已经配了，这里就不用配啦 -->
        <property name="suffix" value=".ftl"/>
        <property name="contentType" value="text/html;charset=UTF-8"/>
        <property name="viewClass"
                  value="org.springframework.web.servlet.view.freemarker.FreeMarkerView"/>
        <property name="allowSessionOverride" value="true"/>
        <property name="allowRequestOverride" value="true"/>
        <property name="exposeSpringMacroHelpers" value="false"/>
        <property name="exposeRequestAttributes" value="true"/>
        <property name="exposeSessionAttributes" value="true"/>
        <property name="requestContextAttribute" value="request"/>
    </bean>

```
# druid监控设置
[官方中文文档](https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98)
