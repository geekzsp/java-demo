import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 类描述
 *
 * @author zhangshipeng
 * @date 2017/12/11 下午7:42
 */
@XStreamAlias("cat")
public class User {
    @XStreamAsAttribute
    private String name;
    private int age;


    private String idNo;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getIdNo() {
        return idNo;
    }

    public User setIdNo(String idNo) {
        this.idNo = idNo;
        return this;
    }
}
