package xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate;

/**
 * @author zhangshipeng
 * @date 2021/2/1
 */
public interface ActivityHandler {

    Integer getActivityType();


    /**
     * 优先级 越小越高
     */
    Integer order();
}
