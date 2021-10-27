package xyz.mosss.spring.examples.springboot.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author zhangshipeng
 * @date 2020/12/11
 */
@Entity
@Data
public class User {
    @Id
    private int id;
    private String name;
    private int age;
    private int status;
}
