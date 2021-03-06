package com.example.demo.dao;


import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author RuYuFeng
 * @Date 2018/8/7 0007
 */
public interface UserDao extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);

}
