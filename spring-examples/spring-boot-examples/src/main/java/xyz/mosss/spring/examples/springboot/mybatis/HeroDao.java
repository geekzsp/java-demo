package xyz.mosss.spring.examples.springboot.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface HeroDao {
    @Select("select * from hero where number=#{number}")
    Hero selectHeroByNumber(@Param("number") int number);
}