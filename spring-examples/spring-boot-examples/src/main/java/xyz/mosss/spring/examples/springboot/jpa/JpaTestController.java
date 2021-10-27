package xyz.mosss.spring.examples.springboot.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangshipeng
 * @date 2020/12/11
 */
@RestController
@RequestMapping("jpa")
@RequiredArgsConstructor
public class JpaTestController {
    private final UserRepository userRepository;

    @GetMapping("user/byAge/{age}")
    public User getUserByAge(@PathVariable int age) {
        return userRepository.findFirstByAge(age);
    }

    @GetMapping("complex/query")
    public List<User> complexQuery() {
        Specification<User> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("age"), 12));

            CriteriaBuilder.In<Object> in = criteriaBuilder.in(root.get("age"));
            in.value(12);
            in.value(13);
            predicates.add(criteriaBuilder.or(in.not(), criteriaBuilder.equal(root.get("name"), "张三")));
            return query.where(predicates.toArray(new Predicate[0])).getRestriction();
        };
        return userRepository.findAll(specification);
    }

    @GetMapping("complex/page-query/")
    public Page<User> complexPageQuery() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Specification<User> specification = (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.equal(root.get("age"), 12);
            return query.where(predicate).getRestriction();
        };
        return userRepository.findAll(specification, pageRequest);
    }
}
