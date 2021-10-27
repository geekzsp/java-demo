package xyz.mosss.spring.examples.springboot.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mybatis")
public class HeroController {
    //@Autowired
    //private HeroDao heroDao;
    //
    //@GetMapping
    //public Hero get() {
    //    return heroDao.selectHeroByNumber(1);
    //}
}