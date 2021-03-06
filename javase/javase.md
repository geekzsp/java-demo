**Java基础**
# 第一章 Java语言概述
1. 高级语言按照程序的执行方式分为编译型和解释型两种。
解析型语言相当于把编译型语言中的编译和解释过程混合到一起同时完成。
2. `javac -d destdir srcFile`
3. `java Java类名`   
因为Java是严格区分大小写的 所以命令后面的Java类名也得区分大小写。
4. 1.5以上版本的JDK会自动搜索当前路径下的类文件，而且使用Java的编译和运行工具时，系统可以自动加载dt.jar和tool.jar文件中的Java类，因此不再需要设置CLASSPATH环境变量。
5. 由于Java程序源文件的文件名必须与public类的类名相同，因此一个Java源文件里最多只能定义一个public类。
6. windows系统不区分大小写，linux系统严格区分大小写
7. 垃圾回收（Garbage Colleciton，GC）。通常JRE会提供一个后台线程来进行检测和控制，
一般都是在CPU空闲或内存不足时自动进行垃圾回收。   
可以将不用的引用变量设置为null，可以调用Runtime.gc()或者System.gc()建议系统进行垃圾回收。
# 第二章 理解面向对象
1. 面向对象的三种基本特征：封装、继承、多态。
2. OOA（面向对象分析）、OOD（面向对象设计）、OOP（面向对象编程）。UML（统一建模语言）。
3. 结构化程序设计里最小的程序单元是函数，每个函数都负责完成一个功能。采用面向对象方式开发的软件系统，其最小的程序单元是类，这些类可以生成系统中的多个对象，而这些对象则直接映像成客观世界的各种事物。
4. 成员变量（状态数据）+方法（行为）=类定义
5. 吃（猪八戒，西瓜） 函数为中心。猪八戒.吃（西瓜） 对象为中心。
6. 对象的抽象化是类，类的具体化是对象
# 第三章 数据类型和运算符
1. Java是一门强类型语言
2. 单行注释//　多行注释/**/  文档注释/***/
3. 标识符必须以字母、下划线、$开头后面可以跟任意数目的字母、数字、下划线、$。此处的字母并不局限于26个字母，而且可以包含中文字符、日文字符。
4. 
数据类型 | 字节 |范围 有一个符号位
----|------|------|
byte | 1  | -128(-2^7)~-127(2^7-1)
short | 2  | -32768(-2^15)~-32767(2^15-1)
int | 4  | -2147483648(-2^31)~-2147483647(2^31-1)
long | 8  | （-2^63）~(2^63-1)
char | 2  | 16位65535个字符编号 java使用的是16位的unicode字符集作为编码方式
float | 4  |  3.402823e+38 ~ 1.401298e-45（e+38表示是乘以10的38次方
double | 8  | 1.797693e+308~ 4.9000000e-324
boolean | 1  | 
- 如果直接将一个较小的整数值（在byte或short类型的范围内）赋给一个byte或short变量，系统会自动把这个整数值当成byte或者short类型来处理。
- 如果使用一个巨大的整数值（超出了int类型的范围）时，Java不会自动把这个整数值当成long类型来处理。需要加L后缀。
`long a=11111111111155L`
- 可以把一个较小的值直接赋给long类型，这并不是因为Java会把这个较小的整数值当成long类型来处理，Java依然把这个整数值当成int类型来处理，只是因为int类型的值会自动转换到long类型。
`long a=1`
- 计算机以补码的形式保存所有整数。正数的补码等于原码 。负数的补码是其反码+1，反码等于原码按位取反，但最高位保持不变
  ```  
              原码 1 1 1 0 1 0 0 1
              反码 1 0 0 1 0 1 1 0
              补码 1 0 0 1 0 1 1 1 = -23
  
  ```
- 二进制0b 八进制0 十六进制0x 默认32位 首位是符号位
- 字符型值也可以采用十六进制编码方式来表示，范围是“\u0000-\uFFFF”,一共可以表示
65536个字符，其中前256个（“\u0000-\u00FF”）字符和ASCII码中的支付完全重合。
- 由于计算机底层保存字符时，实际是保存该支付对应的编号，因此 char类型的值也可以直接作为整型值来使用，它相当于一个16位的无符号整数，表述范围是0~65535。
- `char cha4=97;`//如果把一个范围在0~65535的整数赋给char类型变量，系统会自动把这个int整数当成char类型来处理
- 如果要表示一个数据是float型的，可以在数据后面加上“F”。 
  浮点型的数据是不能完全精确的，所以有的时候在计算的时候可能会在小数点最后几位出现浮动，这是正常的。 精确需要使用BigDecimal
- 正数除以0 正无穷(`POSITIVE_INFINITY`)，负数除以0 负无穷(`NEGATIVE_INFINITY`)。
 非数(`NaN`)
- Java7 数值中可以使用下划线
- boolean类型的数值只能是true或false，不能用0或者非0来表示。其他基本数据类型也不能转换成boolean类型。
- 自动类型转换图：

![mark](http://o7k6tx0fl.bkt.clouddn.com/images/170611/4cGfD62hL9.jpg?imageslim)
- 和字符串拼接 自动转成字符串 
- Java为8种基本数据类型都提供了包装类，都有一个parseXxx(String str)方法 将字符串转成基本数据类型。
- 当程序第一次使用某个字符串直接量时，Java会使用常量池（constant pool）来缓存改字符串直接量，如果程序后面的部分需要用该字符串直接量时，Java会直接使用常量池中的字符串直接量。
5. 除法/ 和求余数% 可以除0.0 不能除0   
6. ++a 先加后赋值 a++ 先赋值后加
7.位运算符(只能操作整数类型)： & 按位与、| 按位或、~ 按位非、^ 按位异或 相同返回0，不同返回1、<< 左移、>> 右移、>>> 无符号右移
8. 低于int类型的操作数总是先自动类型转换为int在进行移位
int 移位>32 或者long 移位>64 的先求余数 。不发生数字丢失的话 左移n位等于 乘与2的n次方，右移 除以2的n次方。
9. 逻辑运算符： &&、&、||、|、!、^。
# 第4章 流程控制和数组
1. switch语句后面的控制表达式的数据类型只能是byte、short、char、int、四种整数类型，枚举类型和String类型（Java7才允许），不能是boolean类型。
2. Java的数组既可以存储基本类型的数据，也可以存储引用类型的数据，只要所有的数组元素具有相同的类型即可。数组也是一种数据类型，他本身是一种引用类型。
3. `type[] arrayname;推荐` `type arrayName[]` 
4. 数组未指定初始值时，整数类型为0，浮点类型为0.0，字符类型为'\u0000'，布尔类型为false，引用类型为null。
5. `java.lang.ArrayIndexOutBoundsException:N` 数组越界异常
6. 需要改变数组元素的值，不能使用foreach循环
7. 一些基本类型的变量和对象的引用变量都是在函数的栈内存中分配，堆内存用于存放由new创建的对象和数组
8. 基本数据类型的初始化
 ![mark](http://o7k6tx0fl.bkt.clouddn.com/images/170612/Lh89aChH9J.png?imageslim)
9. 引用数据类型的初始化
 ![mark](http://o7k6tx0fl.bkt.clouddn.com/images/170612/k6fCmBgA7k.png?imageslim)
10. 二维数组 `int[][] values=new int[4][]`
  `int[][] values=new int[4][3]`
11.Arrays工具类：
   ```java
        //Arrays工具类
        Arrays.sort(arrs1);//排序
        System.out.println(Arrays.toString(arrs1));
        int i = Arrays.binarySearch(arrs1, 3);//二分法查找 要求必须升序 返回位置从0开始，不包含则返回负数
        System.out.println(i);
        int[] ints = Arrays.copyOf(arrs1, 7);//复制
        System.out.println(Arrays.toString(ints));
        Arrays.equals(arrs1, arrs2);//长度 和内容相同返回true
        Arrays.fill(arrs1, 99);//全部填充
        System.out.println(Arrays.toString(arrs1));
        int[] sarr1 = {1, 3, 5, 7};
        int[] sarr2 = {2, 4, 6, 8};
        System.arraycopy(sarr1, 3, sarr2, 0, 1);
        System.out.println(Arrays.toString(sarr2));
        Arrays.parallelSort(sarr2);//并行 排序
   ```
# 第5章面向对象
1. 定义成员变量的语法格式：`[修饰符] 类型 成员变量名 [=默认值]`
2. this关键字最大的作用就是让类中的一个方法，访问该类里的另一个方法或者实例变量。谁在调用这个方法 this就代表谁。
3. static修饰的方法不能使用this关键词调用。静态成员不能直接访问非静态成员
4. 构造器，成员变量，方法
5. **Java里方法传递的方式只有一种：值传递。所谓的值传递，就是将实际参数值的副本（复制品）传入方法内，而参数本身不会受到影响 ，参数是对象的话也是传递的引用副本**
6. JDK1.5之后引入了形参可变的方式，类型后加三个. 被当成数组传入。可变的参数只能有一个而且在最后
7. 递归要想已知方向递归
8. 重载：方法名相同，参数列表不同。和方法的返回值类型和修饰符无关。
9. 变量分步图 
![mark](http://o7k6tx0fl.bkt.clouddn.com/images/170613/DK3AdJaIbH.png?imageslim)
10. Java允许实例来访问static修饰的成员变量本身就是一种错误
11. 代码块局部变量作用范围，从定义 到代码块结束
12. Java允许局部变量和成员变量同名，如果方法里的局部变量和成员变量同名，局部变量会覆盖成员变量，
如果需要引用被覆盖的成员变量，这可使用this（对于实例变量）或者类名（对于类变量）调用
13. 成员变量，java会帮助你初始化，局部变量，则需要程序员自己初始化。
    对于成员变量。不管程序有没有显示的初始化，Java  虚拟机都会先自动给它初始化为默认值。
14. 局部变量保存在所在方法的栈内存中，如果是基本类型直接保存，引用类型保存的是地址，栈内存无需垃圾回收，随着方法或者代码块的运行结束而结束。因为局部变量只保存基本类型的值或者对象的引用，因此局部变量所占的内存区通常比较小
15. 比如眼睛的数量用类变量 ，身高体重不同可以用实例变量。
16. 封装：指的是净对象的状态信息隐藏在对象内部，不允许外部程序直接访问对象内部信息。
17. 访问控制级别表：
![mark](http://o7k6tx0fl.bkt.clouddn.com/images/170613/bDchLa5bHc.png?imageslim)
一般修饰成员变量使用private，如果使用protected来修饰一个方法，通常是希望其子类来重写这个方法。
外部类只能使用public和默认。如果一个Java源文件![横](/assets/横.jpg)里定义了一个public修饰的类，则这个源文件的文件名必须和public修饰的类的类名相同。
18. 关于访问控制符的使用，存在如下几条原则 
- 类里的绝大部分成员变量都应该使用private修饰，只有一些static修饰的，类型全局变量的成员变量，才可能考虑使用public修饰。除此之外，有些方法只用于辅助实现该类的其他方法，这些方法也应该使用private修饰。
- 如果某个类主要用作其他类的父类，该类里包含的大部分方法可能仅希望被其子类重写，而不想被外界直接调用，这应该使用protected修饰这些方法。
- 希望暴露出来给其他类自由调用的方法应该使用public修饰。因此，类的构造器通过使用public修饰，从而允许在其他地方创建该类的实例。因为外部类通常都希望被其他类自由使用，所以大部分外部类都使用public修饰。
19. import 中的*号表示该包下的所有类 但是不包含子包的类
20. Java默认为所有源文件导入了java.lang类
21. JDK1.5 引用 import static 静态导入静态成员变量或者静态方法
```java
    import  static  java.lang.Math.*;
    import  static  java.lang.System.*;
    //静态导入
        double sqrt = sqrt(256);
        out.print(sqrt);
        out.print(PI);
```
22. Java的常用包
![mark](http://o7k6tx0fl.bkt.clouddn.com/images/170613/17I0i6E6Gc.png?imageslim)
23. 使用构造器进行初始化。构造器重载。
24. 一个构造器完全包含另一个构造器 可以用this
![mark](http://o7k6tx0fl.bkt.clouddn.com/images/170613/mhCh3IdlF3.png?imageslim)
使用this调用另一个重载的构造器只能在构造器中使用，而且必须放在第一句。
25. 父类是大类，子类是小类。
26. 子类不能获得父类的构造器
27. java.lang.Object是所有类的父类，要么是其直接父类，要么是其间接父类。
28. 重写：**两同两小一大** 方法名相同，参数列表相同，子类返回值类型和抛出的异常类<=父类，
子类的方法访问权限>=父类的方法访问权限。可以通过super（被覆盖的是实例方法）或者父类类名（被覆盖的是类方法）调用父类方法。
29. 如果父类方法是private 的无法重写
30. 为了在子类方法中访问父类中定义的，被隐藏的实例变量，或为了在子类方法中调用父类中定义的，被覆盖（Override）的方法，可以通过super.作为限定来调用
31. 构造器从顶层类依次执行，如果一个父类通过this调用了同类的重载构造器，就是依次执行此父类的多个构造器
32. 多态 编译时类型，运行时类型。引用变量在编译阶段只能调用其编译时类型所具有的方法，但运行时则执行他运行时类型所具有的方法。
33. 方法行为总是表现出子类方法的行为特征，成员变量则不具备多态（ 通过引用变量来访问其包含的实例变量时，系统总是试图访问他编译时类型所定义的成员变量）。
34. 向上 转型 和强制转换
``` java
           Person person1=new Student(); //向上转型
           if (person1 instanceof Student){
               Student  student=(Student)person1;//强制转换
           }
```
![mark](http://o7k6tx0fl.bkt.clouddn.com/images/170613/7Kh0B05d9L.png?imageslim)
35. 初始化块总是在构造器执行之前执行 作用就是提取构造器相同部分。实际上编译之后就会消失，还原到每个构造器的第一行。
36. static修饰的初始化块叫做静态代码块
37. 普通初始化块负责对对象执行初始化，类初始化则负责对类进行初始化。
# 第六章 面向对象下
1. final用来修饰变量、方法和类，系统不允许为final变量重新赋值，子类不允许覆盖父类的final方法，final类不能派生子类。final修饰的变量不可被改变。**final修饰的成员变量必须由程序员显式的指定初始化值**，final修饰引用类型 这是这个地址不能改变
2. 字符串转基本类型 `构造器（String s） 或者包装类的parseXxx(String s)` 
3. 基本类型转字符串 ` String.valueOf()` 或者 直接+“”
4. `包装类.compare( )` 来进行基本类型的比较
5. **==和equals** 
  - ==：当是基本类型 而且是数值类型 比较的是值，如果是引用数据类型比较的地址，是否指向同一个对象
  - equals：
6. "hello" 是存储在常量池中的 ，new String("hello")是先存在常量池然后在创建一个新的对象 new String("hello")一共产生了两个对象。
7. JVM常量池保证相同的字符串直接量只有一个，不会产生多个副本。使用new String（）创建的字符串对象是运行时创建的，保存在堆内存中，不后悔放入常量池。
8. String重写了equals（）方法
9. 单例类 private修饰构造器 提供一个静态创建的方法  。只能创建一个实例。
10. 抽象方法和抽象类必须使用abstract修饰符来定义，有抽象方法的类只能被定义成抽象类，抽象类里可以没有抽象方法。
11. 接口里的成员变量（只能是静态常量） 默认 +`public static final`，
定义的方法 默认+ `public abstract`
12. 接口可以多继承、一个类可以实现多个接口
13. 接口：标准 、抽象类：模板式设计
14. 内部类、静态内部类、非静态内部类，匿名内部类
15. Lambda是匿名内部类的一种简化
16. 枚举类，一个类的对象是有限而且固定的。比如季节类。
17. 对象的状态转换示意图
![mark](http://o7k6tx0fl.bkt.clouddn.com/images/170616/DhFA3JajgD.png?imageslim)
18. 永远不用主动的调用某个对象的 `finaliez()`方法
19. Java修饰符使用范围总表
![mark](http://o7k6tx0fl.bkt.clouddn.com/images/170616/Bdh5i1IF7I.png?imageslim)
# 第七章 Java基础类库
1. [Scanner](src/main/java/chapter07/ScannerDemo.java)
2. [System](src/main/java/chapter07/SystemDemo.java)
