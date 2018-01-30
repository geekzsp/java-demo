package cn.zsp.task;

import cn.zsp.service.DingDingService;
import cn.zsp.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    DingDingService dingDingService;

    /**
     * 工作日 9点 和9点半 下班提醒
     */
  //  @Scheduled(cron = "0 0,30 21 ? * 1,2,3,4,5")
    void dingDingGoHomeJob() {
        String nowDate = DateUtils.DateToString(new Date(), DateUtils.DATE_TO_STRING_DETAIAL_PATTERN);
        dingDingService.dingDingSendMsg("当前时间：" + nowDate);
    }

    /**
     * 工作日 2点10分 工作提醒
     */
    //@Scheduled(cron = "0 05 14 ? * 1,2,3,4,5")
    private void dingDingWorkJob() {
        String nowDate = DateUtils.DateToString(new Date(), DateUtils.DATE_TO_STRING_DETAIAL_PATTERN);
        dingDingService.dingDingSendMsg("当前时间：" + nowDate);
    }


}
