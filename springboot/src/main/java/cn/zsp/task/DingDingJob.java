package cn.zsp.task;

import cn.zsp.pojo.DingDingRequest;
import cn.zsp.util.DateUtils;
import cn.zsp.util.HttpClientUtils;
import com.alibaba.fastjson.JSON;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 类描述
 *
 * @author zhangshipeng
 * @date 2017/11/27 上午11:55
 */
@Component
class DingDingJob {
    private static final String BASE_URL = "https://oapi.dingtalk.com/robot/send?access_token=216c4581020624dcd3494c453f0a899e82a73aa308174b79bd817de8a104f189";

    /**
     * 工作日 9点 和9点半 下班提醒
     */
    @Scheduled(cron = "0 0,30 21 ? * 1,2,3,4,5")
    void dingDingGoHomeJob() {
        String nowDate = DateUtils.DateToString(new Date(), DateUtils.DATE_TO_STRING_DETAIAL_PATTERN);
        dingDingSendMsg("当前时间：" + nowDate);
    }

    /**
     * 工作日 2点10分 工作提醒
     */
    @Scheduled(cron = "0 10 14 ? * 1,2,3,4,5")
    private void dingDingWorkJob() {
        dingDingSendMsg("开始工作了！！！");
    }


    /**
     * 发送消息
     */
    private void dingDingSendMsg(String msg) {
        DingDingRequest dingDingRequest = new DingDingRequest().setMsgtype("text");
        DingDingRequest.DingDingText dingDingText = dingDingRequest.new DingDingText().setContent(msg);
        dingDingRequest.setText(dingDingText);
        System.out.println("========请求参数：" + JSON.toJSONString(dingDingRequest));
        String response = HttpClientUtils.doPostJson(BASE_URL, JSON.toJSONString(dingDingRequest));
        System.out.println("========响应结果：" + JSON.toJSONString(response));
    }

    public static void main(String[] args) {

        String nowDate = DateUtils.DateToString(new Date(), DateUtils.DATE_TO_STRING_DETAIAL_PATTERN);
        new DingDingJob().dingDingSendMsg(nowDate);
    }
}
