package cn.zsp.controller;

import cn.zsp.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 *
 请求类型	URL	功能说明
 GET	/users	查询用户列表
 POST	/users	创建一个用户
 GET	/users/id	根据id查询一个用户
 PUT	/users/id	根据id更新一个用户
 DELETE	/users/id	根据id删除一个用户
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/3/22
 */
@RequestMapping("/users")
@RestController
public class UserController {
    // 创建线程安全的Map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    //@RequestMapping(value="", method= RequestMethod.GET)
    @GetMapping("")
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping
    public String postUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        //@ModelAttribute 可以省略
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId(), user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }
    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }
}
