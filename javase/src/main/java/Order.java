/**
 * 类描述
 *
 * @author zhangshipeng
 * @date 2017/12/11 下午7:53
 */
public class Order {
    private Status Status;

    public Status getStatus() {

        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Order [Status=" + Status + "]";
    }
}
