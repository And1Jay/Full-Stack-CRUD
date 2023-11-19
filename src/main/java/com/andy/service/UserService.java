package com.andy.service;


import com.andy.entity.User;
import com.andy.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    public boolean saveUser(User user) {
/*        if (user.getId() == null){
            return save(user);//mybatis-plus提供的方法表示插入数据
        } else {
            return updateById(user);
        }*/
        return saveOrUpdate(user);
    }
/*
    @Autowired
    private UserMapper userMapper;

    public int save(User user){
        if (user.getId() == null) { //user无id表示新增，否则为update
            return userMapper.Insert(user);
        } else {
            return userMapper.update(user);
        }
    }
*/

}
