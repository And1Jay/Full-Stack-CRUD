package com.andy.mapper;

import com.andy.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface UserMapper extends BaseMapper<User> {

/*    @Select("select * from user")
    List<User> findAll();

    @Insert("INSERT into user(username, password, nickname, email, phone, address) VALUE " +
            "(#{username}, #{password}, #{nickname}, #{email}, #{phone}, #{address})")
    int Insert(User user);


    int update(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select * from user where username like concat('%', #{username}, '%') limit #{pageNum}, #{pageSize}")
    List<User> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("username") String username);

    @Select("select count(*) from user where username like concat('%', #{username}, '%')")
    Integer selectTotal(@Param("username") String username);*/
}
