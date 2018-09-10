package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author RuYuFeng
 * @Date 2018/8/7 0007
 */
@Service()
public class UserService {

    @Autowired
    private UserDao userDao;

    private UserMapper userMapper;

    //public User findByUserName(String userName){
    //    User user = userDao.findByUserName(userName);
    //    return user;
    //}
    //
    //public User findByUserName(String username, String email){
    //    User user = userDao.findByUserNameOrEmail(username,  email);
    //    return user;
    //}

    public int deleteByPrimaryKey(Integer id){
        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record){
        return userMapper.insert(record);
    }

    public int insertSelective(User record){
        return userMapper.insertSelective(record);
    }

    public User selectByPrimaryKey (Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record){
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record){
        return userMapper.updateByPrimaryKey(record);
    }





}
