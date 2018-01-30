package cn.zsp.controller;

import cn.zsp.service.DingDingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DingDing
 *
 * @author zhangshipeng
 * @date 2017/11/28 上午10:02
 */
@RestController
public class DingDingController {

    @Autowired
    DingDingService dingDingService;

    /**
     * 发送消息
     */
    @RequestMapping("/sendMsg/{msg}")
    public String sendMsg(@PathVariable String msg) {
        dingDingService.dingDingSendMsg(msg);
        return "ok";
    }
}
