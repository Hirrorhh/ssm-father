package cn.ssm.usermanager.dao;

import cn.ssm.usermanager.pojo.User;
import com.github.abel533.entity.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by hirror on 2017/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext*.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectOne() throws Exception {
        User record = new User();
        record.setId(1L);
        User user = userMapper.selectOne(record);
        System.out.println(user);
    }

    @Test
    public void select() throws Exception {
        User record = new User();
        record.setSex(1);
        List<User> users = this.userMapper.select(record);
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void selectCount() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    //全字段设置,不推荐使用
    }

    @Test
    public void insertSelective() throws Exception {
    //相当于插入数据的时候,不为null的才会对其进行设值
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
//        this.userMapper.updateByPrimaryKeySelective()
    }

    @Test
    public void selectCountByExample() throws Exception {
    }

    @Test
    public void deleteByExample() throws Exception {
    }

    @Test
    public void selectByExample() throws Exception {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sex", 1);
        criteria.andBetween("age","23","26");
        example.setOrderByClause("created desc");
        List<User> users = this.userMapper.selectByExample(example);
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void updateByExampleSelective() throws Exception {
    }

    @Test
    public void updateByExample() throws Exception {
    }

}