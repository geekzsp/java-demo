package xyz.mosss.spring.examples.springboot.temp;

/**
 * @author zhangshipeng
 * @date 2020/12/14
 */
public class Demo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Demo de = new Demo();
        de.exec(dog);
    }
    public void exec(Animal animal){
        System.out.println(animal);
    }
}
