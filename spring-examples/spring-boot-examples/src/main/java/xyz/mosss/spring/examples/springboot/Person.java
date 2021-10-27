package xyz.mosss.spring.examples.springboot;


/**
 * @author moss
 * @date 2020/6/1
 */
public class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    private int idCard;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", idCard=" + idCard +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        int i = age.compareTo(person.getAge());
        if(i!=0){
            return i;
        }
        return name.compareTo(person.getName());
    }
}