package cn.zsp.service.impl;

import cn.zsp.pojo.DingDingRequest;
import cn.zsp.service.DingDingService;
import cn.zsp.util.HttpClientUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

/**
 * 类描述
 *
 * @author zhangshipeng
 * @date 2017/11/28 上午9:54
 */
@Service
public class DingDingServiceImpl implements DingDingService {
    private static final String BASE_URL = "https://oapi.dingtalk.com/robot/send?access_token=216c4581020624dcd3494c453f0a899e82a73aa308174b79bd817de8a104f189";

    /**
     * 发送消息
     */
    @Override
    public void dingDingSendMsg(String msg) {
        DingDingRequest dingDingRequest = new DingDingRequest().setMsgtype("text");
        DingDingRequest.DingDingText dingDingText = dingDingRequest.new DingDingText().setContent(msg);
        dingDingRequest.setText(dingDingText);
        System.out.println("========请求参数：" + JSON.toJSONString(dingDingRequest));
        String response = HttpClientUtils.doPostJson(BASE_URL, JSON.toJSONString(dingDingRequest));
        System.out.println("========响应结果：" + JSON.toJSONString(response));
    }
}
