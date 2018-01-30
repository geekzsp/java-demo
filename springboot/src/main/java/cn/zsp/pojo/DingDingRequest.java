package cn.zsp.pojo;

import java.io.Serializable;

/**
 * 钉钉机器人api 请求参数
 *
 * @author zhangshipeng
 * @date 2017/11/27 上午11:58
 */
public class DingDingRequest implements Serializable {
    private static final long serialVersionUID = -2661327583912641412L;

    private String msgtype;

    private DingDingText text;

    public class DingDingText {
        private String content;

        public String getContent() {
            return content;
        }

        public DingDingText setContent(String content) {
            this.content = content;
            return this;
        }
    }

    public String getMsgtype() {
        return msgtype;
    }

    public DingDingRequest setMsgtype(String msgtype) {
        this.msgtype = msgtype;
        return this;
    }

    public DingDingText getText() {
        return text;
    }

    public DingDingRequest setText(DingDingText text) {
        this.text = text;
        return this;
    }
}
