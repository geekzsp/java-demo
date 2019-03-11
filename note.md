[TOC]
# Java基础
* 面向对象和面向过程对比。
    * 面向过程 性能好。
    * 面向对象 容易写出低耦合的代码。利于维护和扩展、复用
* 面向对象的4大特性 封装 继承 多态 抽象
    * 封装：把对象的属性私有化。同时提供一些可以让外界访问属性的方法。 对外屏蔽细节 可控
    * 继承：使用已存在的类作为基础创建新类。新类可以增加新的数据和功能 有能够使用一些父类的功能
    * 多态：在编译时不确定 在运行时确定类型
* Java语言的特点。简单易学  适合大型项目 多人协作  强类型  千人一面。 利于维护。 平台无关性  Write once, run anywhere 。可靠性 安全性 解决方案多。 开源社区活跃。
* JVM（ Java virtual machine）是运行Java字节码的虚拟机。
在一定程度上解决了传统解释型语言执行效率低的问题。同时又保留了解释型语言可移植的特点
* JDK是Java Development Kit，  java sdk 包括 jre和 一些java命令行工具。 JRE是Java运行时环境
* Oracle JDK 和Open JDK的区别。 协议不同。 Open JDK 是开源的 不完整 。大厂都有自己的Open JDK来避免Oracle JDK收费带来的风险
* Java 和C++的区别。 C++可以直接使用指针操作内存。响应的也比较晦涩难懂。 Java 有自己的内存管理机制 不需要自己释放内存。相对简单还是 灵活性相对较差
* 字符型常量和字符串常量的区别  char 和String  一个单引号 一个双引号   char 2个字节 可以参与运算
* 重载和重写的区别
    * 重写：发生在父子类中 方法名和参数列表必须相同。返回值返回小于等于父类 抛出异常范围小于等于父类 访问修饰符范围大于等于父类 private 不能重写
    * 重载： 一个类中。 方法名一样 参数列表不一样 返回值和访问修饰符可以不同 发生在编译时期
* String StringBuilder  StringBuffer
    * 可变性。    
    String类是使用 final关键词的字符数据来保存字符串 private  final char[]  其他两个都是继承AbstractStringBuilder 里面不带final的
    * 线程安全性。   
    String因为是不可变的 所以是线程安全的 StringBuffer 加了同步锁 也是线程安全的
    * 性能    
    每次对String类型的对象进行更改都会生成新的对象。 其他两个都是对自身进行操作。不会生成新的对象
    * 综合    
    少量数据用String  单线程大量用StringBuilder 多线程大量用StringBuffer
* 装箱 把基本类型转换成 对应的包装类型。 拆箱  包装类型转成基本数据类型  容易NPE
* 接口和抽象类有什么区别
    * 相同的：都不能被实例化
    * 不同点：类可以多实现 只能单继承    
           接口强调了是功能的实现 。抽象类强调的是从属关系  
           抽象是对类的抽象是一种模板设计，接口是行为的抽象 是一种行为的规范
           某些场合下，只靠纯粹的接口不能满足类和类之间的协调，还需要类中表示状态的变量来区别不同的关系。抽象类可以很好的做到这一点
           定义的接口。 但是有些接口 是共同的 和状态不关 可以共享 无需子类分别实现
* 成员变量和局部变量的区别
    * 语法形式上： 成员变量属于类 可以被 private public static 等修饰符修饰 而局部变量不行。 但是都可以被final修饰
    * 存储上：     成员变量是对象的一部分。对象存在于堆内存。 局部变量存在于栈内存
    * 生存时间：   局部变量随着方法的调用结束而结束
    * 成员变量     未被显式赋值可以有默认值（有final修饰符的必须显式赋值）。 局部变量必须显式赋值
* 构造方法的作用：完成对类对象的初始化 不显示声明也有默认的构造方法   名称与类名相同 没有返回值 生成类对象时自动执行
    在执行子类的构造方法之前，如果没有用 super 来调用父类特定的构造方法，则会调用父类中“没有参数的构造方法”。
* 静态方法和实例方法： 静态方法可以用 类.方法调用 无需创建对象。静态方法在访问本类成员时，只允许访问静态成员(静态成员变量和静态方法)
* 对象的相等比的是内存中存放的内容是否相等。而引用相等比较的是指向的内存地址是否相等
* == 比较的是内存地址 equals() 1 未覆盖equals()方法 等价于==  2. 覆盖 来比较对象的内容是否相等。
    ```java
     String a = new String("ab"); // a 为一个引用
     String b = new String("ab"); // b为另一个引用,对象的内容一样
     String aa = "ab"; // 放在常量池中
     String bb = "ab"; // 从常量池中查找```
     a!=b  aa==bb    a b  aa bb equals 都相等
* hashCode 和equals
    * hashCode  哈希 散列  目的是为了 快速查找 确定对象位置。
    * hashCode 来检查 重复  向hashSet 里面添加元素 先比较 hashcode  hashcode 一样 在进行equals  (减少equals 次数 来)

    从Object角度看，JVM每new一个Object，它都会将这个Object丢到一个Hash表中去，这样的话，下次做Object的比较或者取这个对象的时候（读取过程），它会根据   对象的HashCode再从Hash表中取这个对象。这样做的目的是提高取对象的效率。若HashCode相同再去调用equal。
    集合要添加新的元素时，先调用这个元素的HashCode方法，就一下子能定位到它应该放置的物理位置上。   
    （1）如果这个位置上没有元素，它就可以直接存储在这个位置上，不用再进行任何比较了；     
    （2）如果这个位置上已经有元素了，就调用它的equals方法与新元素进行比较，相同的话就不存了；    
    （3）不相同的话，也就是发生了Hash key相同导致冲突的情况，那么就在这个Hash key的地方产生一个链表，将所有产生相同HashCode的对象放到这个单链表上去，串在一起（很少出现）。这样一来实际调用equals方法的次数就大大降低了，几乎只需要一两次。

    （2）如果两个对象相同， equals方法一定返回true，并且这两个对象的HashCode一定相同；    
    （3）两个对象的HashCode相同，并不一定表示两个对象就相同，即equals()不一定为true，只能够说明这两个对象在一个散列存储结构中。
* final关键字 变量 不可更改 类 不可被继承  方法 不可被继承类修改
    static ： 修饰成员变量和成员方法  类名.静态变量名 类名.静态方法名
              静态代码块  执行顺序(静态代码块->非静态代码块->构造方法) 静态代码块只会在类加载的时候执行一次
              静态内部类(static修饰类的话只能修饰内部类)
              静态导包 import static
* JAVA异常体系：
    Throwable - Error    OutOfMemoryError
              - Exception  -RuntimeException  - NPE  数组越界  算术异常
                           -IOException
    异常能够程序本身处理，但是错误无法被处理

    finally: 无论是否捕获或处理异常,finally都会被执行 ，当在try或者catch块中 遇到return语句时 先执行finally 再return
* transient 修饰不参与序列化
* 获取键盘输入 Scanner  BufferReader （BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
）
* Servlet 接收用户请求 HttpServletRequest 在doGet() 或者doPost中做相应处理 返回HttpServletResponse
    init service destroy
    一个Servlet 只会有一个实例 所以不是线程安全的
* get 和 post
    * get 一般是从服务器获取资源 post 一般是提交数据
    * get 是在url ？后 以name=value &分割的形式传递数据  post是在body中
    * get 受到url长度限制（这个限制并不是http协议规定的 而是不同的浏览器限制不同 1kb 2kb ）
    * get 数据会显示在地址栏上。 敏感数据可以用post

    **深层次：**
    GET和POST本质上就是TCP链接，并无差别。但是由于HTTP的规定和浏览器/服务器的限制，导致他们在应用过程中体现出一些不同。
    GET产生一个TCP数据包；POST产生两个TCP数据包。

    restful 各自语义不要混用。k
* 转发(Forward) 和重定向(Redirect) 区别
    * 转发:服务器行为  重定向:客户端行为 302 +location
    * 转发 只能跳转 本web应用内页面
    * 地址栏 ：  转发 显示原来的地址
    * 数据共享： 转发页面和转发到的页面可以共享request里面的数据
    * 运用地方：forward:一般用于用户登陆的时候,根据角色转发到相应的模块. redirect:一般用于用户注销登陆时返回主页面和跳转到其它的网站等
    效率： 转发高
* JSP 侧重视图 Servlet侧重逻辑控制
    JSP 是在第一次请求的是时候被编译 work/Catalina/

    JSP 9大内置对象
    request response pageContext session application out config page exception

* Cookie 在客户端 Session在服务器端  因为Http协议是无状态的 会话跟踪 维持会话  现在Token用的比较多
* this 引用类的当前实例 super 用于从子类访问父类的变量和方法

# 集合相关
* ArrayList 和LinkedList
    都是线程不安全的
    ArrayList底层结构是数组  LinkedList 是双向链表（
    插入和删除是否受元素位置的影响：  ArrayList 受影响o(n)  LinkedList不受影响 o(1)
    是否支持快速访问 ArrayList 支持  LinkedList 不支持
    内存空间利用  ArrayList的空间浪费 主要是List列表末尾会预留一定的空间  LinkedList的空间浪费主要是 每个元素 都要有直接后继和直接前驱和数据
* Rule 1. 【推荐】底层数据结构是数组的集合，指定集合初始大小

    底层数据结构为数组的集合包括 ArrayList，HashMap，HashSet，ArrayDequeue等。

    数组有大小限制，当超过容量时，需要进行复制式扩容，新申请一个是原来容量150% or 200%的数组，将原来的内容复制过去，同时浪费了内存与性能。HashMap/HashSet的扩容，还需要所有键值对重新落位，消耗更大。

    默认构造函数使用默认的数组大小，比如ArrayList默认大小为10，HashMap为16。因此建议使用ArrayList(int initialCapacity)等构造函数，明确初始化大小。

    HashMap/HashSet的初始值还要考虑加载因子:

    为了降低哈希冲突的概率(Key的哈希值按数组大小取模后，如果落在同一个数组下标上，将组成一条需要遍历的Entry链)，默认当HashMap中的键值对达到数组大小的75%时，即会触发扩容。因此，如果预估容量是100，即需要设定100/0.75 +1＝135的数组大小。vjkit的MapUtil的Map创建函数封装了该计算。

    如果希望加快Key查找的时间，还可以进一步降低加载因子，加大初始大小，以降低哈希冲突的概率。

* HashMap的地层实现
     数组+链表  先通过 hash() 确定元素位置。 如果有元素 判断 新旧元素 hash 和key 是否相同 如果相同覆盖 如果不相同 （此位置建立链表)拉链法解决冲突
    1.8之后如果链表长度的大于阀值(默认8) 将链表转化为红黑树（平衡的二叉查找树 解决二叉查找树的缺陷，因为二叉查找树在某些情况下会退化成一个线性结构。） 减少搜索时间
* HashMap 和HashTable的区别
    线程安全： HashMap 不安全   HashTable 安全 (内部方法都经过synchronized修饰)
    效率:HashMap高一些。 HashTable 基本被淘汰
    HashMap支持 一个NULl的Key  ，元素值可以为NULL  so 判断一个key存不存在 应该用containsKey. HashTable不支持NULL 的键值
    初始容量 hashMap 默认 16 之后 每次是原来的2倍
* HashSet 的底层就是基于HashMap实现的
* ConcurrentHashMap  分段数组+链表
   Segment  分段锁 多线程访问容器里不同数据段的数据，就不会存在锁竞争，提高并发访问率。
   到了 JDK1.8 的时候已经摒弃了Segment的概念，而是直接用 Node 数组+链表+红黑树的数据结构来实现，并发控制使用 synchronized 和 CAS 来操作。

   ConcurrentHashMap取消了Segment分段锁，采用CAS和synchronized来保证并发安全。数据结构跟HashMap1.8的结构类似，数组+链表/红黑二叉树。
   synchronized只锁定当前链表或红黑二叉树的首节点，这样只要hash不冲突，就不会产生并发，效率又提升N倍。
* LinkedHashMap
   在HashMap的基础上。增加了一条双向链表，，使得上面的结构可以保持键值对的插入顺序
* System.arraycopy() 和 Arrays.copyOf()方法
    copyOf() 内部实际调用了 System.arraycopy() 方法
    arraycopy() 需要目标数组，将原数组拷贝到你自己定义的数组里或者原数组，而且可以选择拷贝的起点和长度以及放入新数组中的位置 copyOf() 是系统自动在内部新建一个数组，并返回该数组。

# JVM
* JVM参数设置
    -Xms 初始化堆大小
    -Xmx 最大堆大小

* JVM 内存结构 JDK8
   虚拟机栈
   堆 heap     新生代（Eden so s1） 老年代  字符串常量   Eden放不下 YGC   old放不下  YGC          Survivor
   元数据  常量池 类元数据  方法元数据 字段 静态属性 方法 常量   方法区  -perm -元数据
   本地方法栈 native
   程序计数器
* 类加载机制
虚拟机把描述类的数据从class文件加载到内存，并对数据进行校验、转换、解析和初始化。
* **java语言中类型的加载连接以及初始化过程都是在程序运行期间完成的**
这种策略虽然会使类加载时稍微增加一些性能开销，但是会为java应用程序提供高度的灵活性。java里天生就可以动态扩展语言特性就是依赖运行期间动态加载和动态连接这个特点实现的。比如，如果编写一个面向接口的程序，可以等到运行时再指定其具体实现类。
* 类加载过程
![enter image description here](https://mmbiz.qpic.cn/mmbiz_png/hvUCbRic69sAxRovHTCH3yyW1vpic22WVibSBjZicRXsFogpbuwicqugUaxFaIBQnXxwibQ0XTicKxxCVfb0L8sejJkjw/640?wx_fmt=png)
    * 加载
    1. 通过类型的完全限定名，产生一个代表该类型的二进制数据流
    2. 解析这个二进制数据流为方法区内的数据结构
    3. 创建一个表示该类型的java.lang.Class类的实例，作为方法区这个类的各种数据的访问入口。
    * 验证
    为了确保Class文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
    * 准备
    准备阶段是正式为类变量分配内存并设置类变量初始值的阶段，这些变量所使用的内存都将在方法区中进行分配。（备注：这时候进行内存分配的仅包括类变量（被static修饰的变量），而不包括实例变量，实例变量将会在对象实例化时随着对象一起分配在Java堆中）。
    初始值通常是数据类型的零值：
         > 对于：public static int value = 123;，那么变量value在准备阶段过后的初始值为0而不是123，这时候尚未开始执行任何java方法，把value赋值为123的动作将在初始化阶段才会被执行。
    一些特殊情况：
    对于：public static final int value = 123;编译时Javac将会为value生成ConstantValue属性，在准备阶段虚拟机就会根据ConstantValue的设置将value赋值为123。
    * 解析
    解析阶段是虚拟机将常量池内的符号引用替换为直接引用的过程。
    * 初始化
    到了初始化阶段，才真正开始执行类中定义的java程序代码（或者说是字节码）。
* 类初始化 
    虚拟机规范严格规定了有且只有五种情况必须立即对类进行“初始化”：
    * 使用new关键字实例化对象的时候、读取或设置一个类的静态字段的时候，已经调用一个类的静态方法的时候。

    * 使用java.lang.reflect包的方法对类进行反射调用的时候，如果类没有初始化，则需要先触发其初始化。

    * 当初始化一个类的时候，如果发现其父类没有被初始化就会先初始化它的父类。

    * 当虚拟机启动的时候，用户需要指定一个要执行的主类（就是包含main()方法的那个类），虚拟机会先初始化这个类；

    * 使用Jdk1.7动态语言支持的时候的一些情况。

    而对于接口，当一个接口在初始化时，并不要求其父接口全部都完成了初始化，只有在真正使用到父接口时（如引用父接口中定义的常量）才会初始化。
    其他情况不会进行初始化 如
    ①通过子类引用父类静态字段，不会导致子类初始化；②通过数组定义引用类，不会触发此类的初始化③常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用定义常量的类，因此不会触发定义常量的类的初始化

* 类初始化的加载顺序。
    (1) 父类静态代码块(包括静态初始化块，静态属性，但不包括静态方法)
    (2) 子类静态代码块(包括静态初始化块，静态属性，但不包括静态方法 )
    (3) 父类非静态代码块( 包括非静态初始化块，非静态属性 )
    (4) 父类构造函数
    (5) 子类非静态代码块 ( 包括非静态初始化块，非静态属性 )
    (6) 子类构造函数
* 类与类加载器
  对于任意一个类，都需要由加载它的类加载器和这个类本身一同确立其在Java虚拟机中的唯一性。**如果两个类来源于同一个Class文件，只要加载它们的类加载器不同，那么这两个类就必定不相等。**
* 类加载器分类
  * 启动类加载器（Bootstrap）
  C++实现 是虚拟机的一部分 加载 <Java_Runtime_Home>\lib目录中的，或者被-Xbootclasspath参数所指定的路径
  * 其他类加载器 java实现
    * 扩展类加载器 （Extension ClassLoader）
    加载 <Java_Runtime_Home>\lib\ext目录
    * 应用程序类加载器（Application ClassLoader）
    加载用户类路径（ClassPath）上所指定的类库 一般情况下这个就是程序中默认的类加载器。
* 双亲委派模型
    ![](https://mmbiz.qpic.cn/mmbiz_png/hvUCbRic69sAxRovHTCH3yyW1vpic22WVibsIR7t9TpI4LlxD1hewI5HEy12YhMNtaFohOVOxibnrxCWpXic8Aib9VibQ/640?wx_fmt=png)

    双亲委派模型（Pattern Delegation Model）,要求除了顶层的启动类加载器外，其余的类加载器都应该有自己的**父类加载器**。这里父子关系通常是子类通过**组合**关系而不是继承关系来复用父加载器的代码。

    如果一个类加载器收到了类加载的请求，先把这个**请求委派给父类加载器**去完成（所以所有的加载请求最终都应该传送到顶层的启动类加载器中），只有当父加载器反馈自己无法完成加载请求时，子加载器才会尝试自己去加载。

    使用双亲委派模型来组织类加载器之间的关系，有一个显而易见的好处就是java类随着它的类加载器一起具备了一种带有优先级的**层次**关系。

    **委托机制的意义 — 防止内存中出现多份同样的字节码**

* 能不能自己写个类叫java.lang.System？


    答案：不能
    解释：为了不让我们写System类，类加载采用委托机制，这样可以保证爸爸们优先，爸爸们能找到的类，儿子就没有机会加载。而System类是Bootstrap加载器加载的，就算自己重写，也总是使用Java系统提供的System，自己写的System类根本没有机会得到加载。

    即使我们自定义的类加载器也必须继承自ClassLoader，其loadClass()方法里调用了父类的defineClass()方法，并终究调到preDefineClass()方法，因此我们自定义的类加载器也是不能加载以“java.”开头的java类的。我们继续运行下ClassLoaderTest类，输出以下：
    不能自己写以"java."开头的类，其要末不能加载进内存，要末即便你用自定义的类加载器去强行加载，也会收到1个SecurityException。


    preDefineClass 不允许java开头的包名被defineClass方法构造

    ```java
        private ProtectionDomain preDefineClass(String name, ProtectionDomain pd)
    {
        // Note:  Checking logic in java.lang.invoke.MemberName.checkForTypeAlias
        // relies on the fact that spoofing is impossible if a class has a name
        // of the form "java.*"
        if ((name != null) && name.startsWith("java.")) {
            throw new SecurityException
                ("Prohibited package name: " +
                 name.substring(0, name.lastIndexOf('.')));
        }
    }
    ```
    不是hotspot
    如果使用的是自定义的虚拟机是可以的 比如android 自定义的
* 自定义类加载器步骤

    （1）继承ClassLoader  
    （2）重写findClass（）方法 
    （3）调用defineClass（）方法 （final修饰）
# 设计模式
* 单例的几种实现方式
    - 饿汉模式
    ```java
        public class MyEagerSingleton {
        private static MyEagerSingleton myEagerSingleton = new MyEagerSingleton();

        private MyEagerSingleton() {

        }

        public static MyEagerSingleton getInstance() {
            return myEagerSingleton;
        }
    }
    ```
    - 懒汉模式  粗暴 方法 synchronized

    ```java
           public class MyLazySingleton {
    private static MyLazySingleton myLazySingleton = null;

    private MyLazySingleton() {

    }

    public synchronized static MyLazySingleton getInstance() {
        if (myLazySingleton == null) {
            myLazySingleton = new MyLazySingleton();
        }
        return myLazySingleton;
    }
    }
    ```

    - 懒汉模式  双重检查锁+ volatile

    ```java
        public class MyLazySingleton02 {
        private static volatile MyLazySingleton02 myLazySingleton02 = null;

        private MyLazySingleton02() {
        }

        public static MyLazySingleton02 getInstance() {
            if (myLazySingleton02 == null) {
                synchronized (MyLazySingleton02.class) {
                    if (myLazySingleton02 == null) {
                        myLazySingleton02 = new MyLazySingleton02();
                    }
                }
            }
            return myLazySingleton02;
        }
    }
    ```

    - 懒汉模式  使用类 初始化一次的特性

    ```java
    public class MyLazySingleton03 {
    private MyLazySingleton03() {

    }
    static class MyLazySingleton03Holder {
        static MyLazySingleton03 myLazySingleton03 = new MyLazySingleton03();
    }
    public static MyLazySingleton03 getInstance() {
        return MyLazySingleton03Holder.myLazySingleton03;
    }

    }
    ```

# 多线程与并发
* 一个进程可以产生多个线程。  与进程不同的是 同类的多个线程可以共享同一块内存空间和同一组系统资源 。所以新建线程和线程切换 负担比进程小得多。
   线程(Thread)是进程的一个实体，是CPU调度和分派的基本单位。
* 线程状态：  初始 运行 阻塞 等待 超时等待 终止
* 线程的状态
    ![](https://user-gold-cdn.xitu.io/2018/3/25/1625c6841963873b?w=876&h=492&f=png&s=-1)
    * 新建(NEW)：新创建了一个线程对象
    * 就绪(RUNNABLE) 调用start方法之后
    * 运行(RUNNING) 获取到时间片 执行run方法
    * 阻塞(BLOCKED)
        * 等待阻塞 `object.wait`  进入等待队列  `notify` 进入锁池 
        * 同步阻塞 被其他线程占用。  运行(running)的线程在获取对象的同步锁时，若该同步锁 被别的线程占用，则JVM会把该线程放入锁池(lock pool)中。 `synchronized` 
        * 主动阻塞  主动让出CPU执行权`sleep join  io`
    * 死亡(DEAD)
        run执行结束，or 因异常退出  此状态不可逆转
* 多线程分类
    用户线程（执行具体的任务） 守护线程 （eg:垃圾回收线程）
   Thread setDaemon(true) 为守护线程
* 高并发   指标  响应时间  吞吐量 每秒处理率 qps
* 创建线程的几种方式。
    继承Thread  实现Runnable接口 实现Callable接口 线程池
* 线程优先级具有继承特性比如A线程启动B线程，则B线程的优先级和A是一样的。线程优先级具有随机性也就是说线程优先级高的不一定每一次都先执行完。
     优先级 1 5  10  默认 5
* join() 是阻塞的 “等待该线程终止”，换句话说就是：”当前线程等待子线程的终止“

如果一个线程A执行了thread.join()语句，其含义是：当前线程A等待thread线程终止之后才从thread.join()返回。
* 
    ![WX20190308-151925@2x](https://i.imgur.com/N0BbKOi.png)
    ![WX20190308-1512033@2x](https://i.imgur.com/10qKvBB.png)
    ![WX20190308-1031124@2x](https://i.imgur.com/VZwjHqT.png)

* Object wait notify
    ![WX20190308-103124@2x](https://i.imgur.com/AHjUMY7.png)
   
    wait()  使调用该方法的线程释放共享资源锁，然后从运行状态退出，进入等待队列。知道被再次唤醒
    notify() 随机唤醒等待队列中等待统一共享资源的“一个线程”，并使该线程退出等待队列，进入可运行状态。也就是notify()方法仅通知“一个线程”
* 通知等待的经典范式 

     (调用类的wait和notify方法，就要获取到类的锁。
     ```java
     synchronized(对象) {
       while(条件不满足) {
              对象.wait();
       }
       对应的处理逻辑
    }
    #----------------------
    synchronized(对象) {
       while(条件不满足) {
              对象.wait();
       }
       对应的处理逻辑
    }
     ```
* 当方法wait()被执行后，锁自动被释放，但执行完notify()方法后，锁不会自动释放。必须执行完notify()方法所在的synchronized代码块后才释放。
* 管道输入输出通信流 主要用于线程之间的数据传输 且传输的媒介为内存
  * 面向字节 PipedOutputStream PipedInputStream
  * 面向字符 PipedWriter PipedReader
* ThreadLocal 
    >ThreadLocal，即线程变量，是一个以ThreadLocal对象为键、任意对象为值的存储结构。

    适用于每个线程需要自己独立的实例且该实例需要在多个方法中被使用，也即变量在线程间隔离而在方法或类间共享的场景 ThreadLocal 变量通常被`private static`修饰
    * ThreadLocal 并不解决线程间共享数据的问题
    * ThreadLocal 通过隐式的在不同线程内创建独立实例副本避免了实例线程安全的问题
    * 每个线程持有一个 Map 并维护了 ThreadLocal 对象与具体实例的映射，该 Map 由于只被持有它的线程访问，故不存在线程安全以及锁的问题
    * ThreadMap中数据存储不是用HashMap实现的，而是用Entry[]数组实现，用ThreadLocal的hash值来&长度作为下标，模拟Map。
    * ThreadLocalMap 的 Entry 对 ThreadLocal 的引用为弱引用，避免了 ThreadLocal 对象无法被回收的问题
    * ThreadLocalMap 的 set 方法通过调用 replaceStaleEntry 方法回收键为 null 的 Entry 对象的值（即为具体实例）以及 Entry 对象本身从而防止内存泄漏
    * ThreadLocal 适用于变量在线程间隔离且在方法间共享的场景

* 线程安全性问题存在于实例变量。 访问同一实例的变量 可能会产生安全安全问题
*  volatile 从主存中读取 而不是拷贝到本地内存   保证了可见性 但是无法保证原子性  测试 一个count ++ 100次 主线程++ 新线程--
    1.获取
    2.操作
*  原子类  AtomicLong 和 LongAdder
* synchronized  jdk 1.6之后为了 减少 获取锁和释放锁带来的性能消耗引入了偏向锁和轻量级锁
* synchronized 底层原理 “同步块的实现使用了monitorenter和monitorexit指令，而同步方法则是依靠方法修饰符上的ACC_SYNCHRONIZED来完成的”
* synchronized 不具有继承性。
    如果父类有一个带synchronized关键字的方法，子类继承并重写了这个方法。
    但是同步不能继承，所以还是需要在子类方法中添加synchronized关键字。
    synchronized关键字加到static静态方法和synchronized(class)代码块上都是是给Class类上锁，而synchronized关键字加到非static静态方法上是给对象上锁。
* volatile 和synchronized 关键字的区别
   volatile 用于变量  synchronized修饰方法和代码块
   多线程访问volatile不会阻塞 synchronized 可能会发生阻塞
   volatile保证的数据的可见性不能保证数据的原子性。 synchronized两者都可以保证
   volatile关键字用于解决变量在多个线程之间的可见性，而synchronized关键字解决的是多个线程访问资源的同步性

   如果是一些写多读的并发场景 ， 使用 volatile 修饰变量则非常合适。 volatile 一写多读最典型的应用是 CopyOnWriteArrayList
* 锁 控制对共享资源的方法 。比Synchronized更加灵活
    ```java
     Lock lock=new ReentrantLock()；
        lock.lock();
     try{
     }finally{
        lock.unlock();
     }
    ```
    最好不要把获取锁的过程写在try语句块中，因为如果在获取锁时发生了异常，异常抛出的同时也会导致锁无法被释放
    **lock接口方法**
    ```java
        void lock() //尝试获取锁，如果锁不可用，则当前线程被禁止进行线程调度 进入休眠状态。知道获取锁
        boolean tryLock()	只有在调用时才可以获得锁。如果可用，则获取锁定，并立即返回值为true；如果锁不可用，则此方法将立即返回值为false 。
    ```
* Synchronized 和 ReenTrantLock 的对比
    * 都是可重入锁
    * synchronized 依赖于 JVM 而 ReenTrantLock 依赖于 API（（也就是 API 层面，需要 lock() 和 unlock 方法配合 try/finally 语句块来完成））
    * ReenTrantLock 比 synchronized 增加了一些高级功能 （可设置为公平锁  等待可中断 可实现选择性通知）
    * 性能已不是选择标准
* Java中的锁分类 以下分类不光是指锁的状态，有的指的是锁的特性，有的指的是锁的设计
    * 公平锁/非公平锁      
        是否按照线程申请锁的顺序获取锁，非公平锁的吞吐量大。`Synchronized` 非公平锁 。 `ReentrantLock` 默认非公平锁
    * 可重入锁    
        又名递归锁，是指在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。好处 一定程度避免死锁   `ReentrantLock` `Synchrozined`
        ```java
        synchronized void setA() throws Exception{
            Thread.sleep(1000);
            setB();
        }    
        synchronized void setB() throws Exception{
            Thread.sleep(1000);
        }
        ```
         当存在父子类继承关系时，子类是可以通过‘可重入锁’调用父类的同步方法
    * 独享锁/共享锁       
        独享锁是指该锁一次只能被一个线程所持有  `ReentrantLock` `Synchronized`
        共享锁是指该锁可被多个线程所持有      ReadWriteLock(读锁共享 写锁独享 并发读效率高 读写 写写 互斥)     
        独享锁与共享锁也是通过AQS来实现的，通过实现不同的方法，来实现独享或者共享。
    * 互斥锁/读写锁     
        上面讲的独享锁/共享锁就是一种广义的说法，互斥锁/读写锁就是具体的实现。
        互斥锁在Java中的具体实现就是`ReentrantLock`
        读写锁在Java中的具体实现就是`ReadWriteLock`
    * 乐观锁/悲观锁    
        悲观的认为，不加锁的并发操作一定会出问题。
        乐观的认为，不加锁的并发操作是没有事情的。        
        从上面的描述我们可以看出，悲观锁适合写操作非常多的场景，乐观锁适合读操作非常多的场景，不加锁会带来大量的性能提升。
        悲观锁在Java中的使用，就是利用各种锁。  
        乐观锁一般会使用版本号或CAS算法实现。
        乐观锁在Java中的使用，是无锁编程，常常采用的是CAS算法，典型的例子就是`java.util.concurrent.atomic`包下面的原子变量类 如: LongAdder，通过CAS自旋实现原子操作的更新。 
        CAS即compare and swap（比较与交换）
        CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。。一般情况下是一个自旋操作，即不断的重试 

        * ABA 问题： 如果一个变量V初次读取的时候是A值，并且在准备赋值的时候检查到它仍然是A值，那我们就能说明它的值没有被其他线程修改过了吗？很明显是不能的，因为在这段时间它的值可能被改为其他值，然后又改回A，那CAS操作就会误认为它从来没有被修改过。这个问题被称为CAS操作的 "ABA"问题。

    * 分段锁  
        是一种锁设计 不是一种具体的锁     
    * 偏向锁/轻量级锁/重量级锁      
        指的是锁状态，并且是针对的`Synchronized`
        偏向锁(一段同步代码一直被同一个线程访问该线程自动获取锁，降低获取锁的代价--锁清除--)-->轻量级锁(锁状态为偏向锁时 被另一个线程访问 锁升级为轻量级锁 。 自旋 非阻塞 提高性能 )-->重量级锁
        (自旋到达一定程度仍未获取到锁。锁升级为重量级锁 重量级锁会让其他申请的线程进入阻塞，性能降低。)
    * 自旋锁        
        在Java中，自旋锁是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程上下文切换的消耗，缺点是循环会消耗CPU。


* AQS(AbstractQueuedSynchronizer）)
    AQS核心思想是，如果被请求的共享资源空闲，则将当前请求资源的线程设置为有效的工作线程，并且将共享资源设置为锁定状态。如果被请求的共享资源被占用，那么就需要一套线程阻塞等待以及被唤醒时锁分配的机制，这个机制AQS是用CLH队列锁实现的，即将暂时获取不到锁的线程加入到队列中。
    AQS核心思想是，如果被请求的共享资源空闲，则将当前请求资源的线程设置为有效的工作线程，并且将共享资源设置为锁定状态。如果被请求的共享资源被占用，那么就需要一套线程注释
* Semaphore(信号量)-允许多个线程同时访问 
* CountDownLatch(倒计时器) 允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行        
    ①某一线程在开始运行前等待n个线程执行完毕。将 CountDownLatch 的计数器初始化为n ：`new CountDownLatch(n) `，每当一个任务线程执行完毕，就将计数器减1 `countdownlatch.countDown()`，当计数器的值变为0时，在`CountDownLatch上 await()` 的线程就会被唤醒。一个典型应用场景就是启动一个服务时，主线程需要等待多个组件加载完毕，之后再继续执行。        

    ②实现多个线程开始执行任务的最大并行性。注意是并行性，不是并发，强调的是多个线程在某一时刻同时开始执行。类似于赛跑，将多个线程放到起点，等待发令枪响，然后同时开跑。做法是初始化一个共享的 `CountDownLatch` 对象，将其计数器初始化为 1 ：`new CountDownLatch(1) `，多个线程在开始执行任务前首先 `coundownlatch.await()`，当主线程调用 countDown() 时，计数器变为0，多个线程同时被唤醒。
    
    ```
     取出来count 放入栈顶 0                
    栈顶值+1                            取出来count 放入栈顶  0
    结果返回给count    1                   栈顶值-1
                                     结果返回给count -1


    ```
    ③死锁检测：一个非常方便的使用场景是，你可以使用n个线程访问共享资源，在每次测试阶段的线程数目是不同的，并尝试产生死锁。
*  CyclicBarrier(循环栅栏)

CyclicBarrier 和 CountDownLatch 非常类似，它也可以实现线程间的技术等待，但是它的功能比 CountDownLatch 更加复杂和强大。主要应用场景和 CountDownLatch 类似。

CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。CyclicBarrier默认的构造方法是 `CyclicBarrier(int parties)`，其参数表示屏障拦截的线程数量，每个线程调用`await`方法告诉 CyclicBarrier 我已经到达了屏障，然后当前线程被阻塞。

* CyclicBarrier和CountDownLatch的区别

CountDownLatch是计数器，只能使用一次，而CyclicBarrier的计数器提供reset功能，可以多次使用。但是我不那么认为它们之间的区别仅仅就是这么简单的一点。我们来从jdk作者设计的目的来看，

对于CountDownLatch来说，重点是“一个线程（多个线程）等待”，而其他的N个线程在完成“某件事情”之后，可以终止，也可以等待。而对于CyclicBarrier，重点是多个线程，在任意一个线程没有完成，所有的线程都必须等待。
* happens-before

“两个操作之间具有happens-before关系，并不意味着前一个操作必须要在后一个操作之前执行！happens-before仅仅要求前一个操作（执行的结果）对后一个操作可见，且前一个操作按顺序排在第二个操作之前”

* 单例 双重检查锁 有问题
    ```java
        public class DoubleCheckedLocking {                      // 1
    private static Instance instance;                    // 2
    public static Instance getInstance() {               // 3
        if (instance == null) {                          // 4:第一次检查
            synchronized (DoubleCheckedLocking.class) {  // 5:加锁
                if (instance == null)                    // 6:第二次检查
                    instance = new Instance();           // 7:问题的根源出在这里
            }                                            // 8
        }                                                // 9
        return instance;                                 // 10
    }                                                    // 11
    }
    ```    
    instance=new Singleton();
        可以拆分为3步

        memory=allocate();//1.分配内存空间
        cotrInstance(memory);//2.初始化对象
        instance=memory;//3. 设置instance指向刚分配的内存地址

        2 3 可能会被重排序
     “双重检查锁定看起来似乎很完美，但这是一个错误的优化！在线程执行到第4行，代码读取到instance不为null时，instance引用的对象有可能还没有完成初始化。”
   
   **解决方案**
    1. volatile 禁止重排序
    2. “基于类初始化的解决方案”

## 线程池

* 线程池的好处
    * 降低资源消耗
    * 提高响应速度
    * 提高线程的可管理性
* 创建线程池的几个参数
    ```java
    new  ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
    milliseconds,runnableTaskQueue, handler);
    ```
    * corePoolSize: 核心线程   cpu密集型 cpu数+1  io密集型 2*cpu数
    * maximumPoolSize: 最大线程
    * runnableTaskQueue:空闲时 线程存货时间
    * TimeUnit:单位
    * runnableTaskQueue：任务队列 LinkedBlockingQueue、ArrayBlockingQueue、PriorityBlockingQueue、SynchronousQueue
    * RejectedExecutionHandler：饱和策略 
        * 直接抛出异常 AbortPolicy 
        * 丢弃队列里最近的一个任务，并执行当前任务 CallerRunsPolicy
        * 不处理 丢弃资源 DiscardOldestPolicy
        * 只有调用者所在的线程运行任务 DiscardPolicy
* 向线程池提交任务
    * execute 不带返回值
    * submit 带返回值 future
* 线程池监控
    * taskCount:线程池需要运行的任务数量
    * completedTaskCount:线程池在运行过程中已经完成的任务数量
    * largestPoolSize: 曾经创建过的最大线程数量
    * getPoolset:线程池的线程数量
    * getActiveCount:活动的线程数
* Executors
    * Executors.newWorkStealingPool: JDK8引入的方法 把CPU数量 设置为默认的并行度
    * Executors.newCachedThreadPool:maximumPoolSize 最大可以至 Integer.MAX_ VAL阻， 是高度可伸缩的线程池 OutOfMemoryError风险
    * Executors.newSingleThreadExecutor:创建个单线程的线程池，相当于单线 程串行执行所有任务 ， 保证接任务的提交顺序依次执行。
    * Executors.newFixedThreadPool : 输入的参数即是固定线程数，既是核心线程
数也是最大线程数 ， 不存在空闲线程，所以 keepAliveTime 等于 O
    
# JAVA IO

* 同步和异步 阻塞 非阻塞
    * 同步和异步关注的是消息通信机制
    * 同步：在发出一个调用时，在没有得到结果之前，该调用就不返回。但是一旦调用返回，就得到返回值了。
    异步：调用发出之后，这个调用就直接返回了，所以没有返回结果

    * 阻塞和非阻塞：程序在等待调用结果时的状态。
    * 阻塞调用是指调用结果返回之前，当前线程会被挂起。调用线程只有在得到结果之后才会返回。
    * 非阻塞调用指在不能立刻得到结果之前，该调用不会阻塞当前线程。
    * 阻塞：调用结果返回之前，当前线程会被挂起。调用线程只有在得到结果之后才会返回。
    * 非阻塞：在不能立刻得到结果之前。该调用不会阻塞当前线程
* IO 分类
    * BIO(Block-IO)阻塞IO
    * NIO(Non-Block-IO)非阻塞IO
    * AIO(Asynchronous I/O)异步非阻塞IO
* NIO和IO的区别
    1. IO是面向流的 NIO是面向缓存区的
    2. IO流是阻塞的 NIO流是非阻塞的
    3. NIO有选择器  IO没有
# Other
* Spring Aop （AOP为Aspect Oriented Programming）实现原理
    静态代理：AspectJ  编译时生成代理类 （静态性能好 但是需要特定的编译器）
    动态代理：JDK动态代理 （反射 以及必须实现接口（因为需要根据接口动态生成类）  Proxy类和 InvocationHandler接口） CGLIB动态代理 （没有实现接口 走这个方式 生成 需要代理类的子类来增强 被final标记的类不能使用此方法）
# 主流框架

## zookeeper
* ZooKeeper是一个分布式的，开放源码的分布式应用程序协调服务
* ZooKeeper 提供了文件系统和通知机制
* 包含 临时 持久化  顺序 非顺序 Znode
* Zookeeper做了什么？ 命名服务   2.配置管理   3.集群管理   4.分布式锁  5.队列管理
* 集群 选举机制： >n/2
* java client: zclient  curator 

## JDK自带的工具

* jstack [pid] 查询线程信息
* javap -v 类名  查看字节码
* jad 反编译
* jmap 生成dump信息 查看dump 信息

# 算法

## 排序算法

* 冒泡排序

![enter image description here](https://images2017.cnblogs.com/blog/849589/201710/849589-20171015223238449-2146169197.gif)

时间复杂度T(n) = O(n2)

```java
public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
```
* 选择排序

![enter image description here](https://images2017.cnblogs.com/blog/849589/201710/849589-20171015224719590-1433219824.gif)

时间复杂度T(n) = O(n2) 

```java
 public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
```

* 快速排序算法 TODO