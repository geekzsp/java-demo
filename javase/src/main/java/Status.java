/**
 * 类描述
 *
 * @author zhangshipeng
 * @date 2017/12/11 下午7:53
 */
public class Status {
    private String Id;
    private String content;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Status [Id=" + Id + ", content=" + content + "]";
    }
}
