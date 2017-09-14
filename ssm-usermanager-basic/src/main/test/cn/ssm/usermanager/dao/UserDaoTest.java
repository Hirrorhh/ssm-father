package cn.ssm.usermanager.dao;

import cn.ssm.usermanager.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.tools.java.ClassPath;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hirror on 2017/9/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext*.xml")
public class UserDaoTest {


    @Autowired
    private UserMapper userDao;

  /*  @Before
    public void setUp() throws Exception {
        // 获取Session
        SqlSession session = this.sqlSessionFactory.openSession(true);
        // 获取Mapper
        userDao = session.getMapper(UserDao.class);
    }*/

  /*  @Test
    public void testQueryUserById() {
        User user = userDao.queryUserById(1L);
        System.out.println(user);
    }*/


}