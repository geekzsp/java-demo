package cn.zsp.ssm.util;

import java.util.Random;

/**
 * @Description: 生成短信验证码数字
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/3/16
 */
public class VcodeUtils {
    /**
     * @param count 数字个数
     * @return
     */
    public  static  String gentVcode(int count){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<count;i++){
            sb.append(random.nextInt(10)+"");
        }
        return  sb.toString();
    }
}
