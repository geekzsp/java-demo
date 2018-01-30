package cn.zsp.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 *
 * @author zhangshipeng
 * @date 2017/12/29 上午10:41
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 支持跨域请求
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
                .allowCredentials(false).maxAge(3600);
    }
}