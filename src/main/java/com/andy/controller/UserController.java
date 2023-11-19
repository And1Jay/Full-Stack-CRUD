package com.andy.controller;


import com.andy.entity.User;
import com.andy.mapper.UserMapper;
import com.andy.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
/*    @Autowired
    private UserMapper userMapper;*/

    @Autowired
    private UserService userService;

    @PostMapping//create and update
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping//retrieve
    public List<User> findAll(){
        return userService.list();
        /*List<User> all = userMapper.findAll();
        return all;*/
    }

    @DeleteMapping("/{id}")//delete
    public /*Integer*/boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
//        return userMapper.deleteById(id);
    }

    @DeleteMapping("/del/batch")//delete
    public /*Integer*/boolean deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeByIds(ids);
    }

    // 分页查询 Mybatis-Plus
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String nickname,
                                @RequestParam(defaultValue = "") String address){
        IPage<User> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(username), User::getUsername, username);
        lqw.like(Strings.isNotEmpty(nickname), User::getNickname, nickname);
        lqw.like(Strings.isNotEmpty(address), User::getAddress, address);
        /*QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)){
            queryWrapper.like("username", username);
        }
        if (!"".equals(nickname)) {
            queryWrapper.like("nickname", nickname);
        }
        if (!"".equals(address)){
            queryWrapper.like("address", address);
        }
        queryWrapper.orderByDesc("id");*/      //倒序
        return userService.page(page, lqw);
    }
    /*@GetMapping("/page") // 分页查询 接口路径：/user/page?pageNum=1&pageSize=10
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String username){
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userMapper.selectPage(pageNum, pageSize, username);
        Integer total = userMapper.selectTotal(username);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }*/
}
