package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.domain.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Description
 * @Author RuYuFeng
 * @Date 2018/8/8 0008
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void test() throws Exception{
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userDao.save(new User(null,"aa", "aa123456", "aa@126.com","aa1", formattedDate));
        userDao.save(new User(null,"bb", "bb123456", "bb@126.com","bb2", formattedDate));
        userDao.save(new User(null,"cc", "cc123456", "cc@126.com","cc3", formattedDate));

        Assert.assertEquals(9, userDao.findAll().size());
        Assert.assertEquals("bb", userDao.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
        userDao.delete(userDao.findByUserName("aa"));
    }
}
