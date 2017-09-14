package cn.ssm.usermanager.service;

import cn.ssm.usermanager.dao.UserMapper;
import cn.ssm.usermanager.pojo.UiDataResult;
import cn.ssm.usermanager.pojo.User;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.sql.Date;
import java.util.List;

/**
 * Created by hirror on 2017/9/12.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UiDataResult<User> queryAllUserList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<User> users = this.userMapper.select(null);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        UiDataResult<User> result = new UiDataResult(pageInfo.getList(), pageInfo.getTotal());
        return result;
    }

    public Boolean insert(User user) {
        user.setCreated(new Date(System.currentTimeMillis()));
        user.setUpdated(user.getCreated());
        Integer number = this.userMapper.insertSelective(user);
        return number == 1 ? true : false;
    }

    public Boolean deleteUserByIds(String ids) {
        List<Object> list = new ArrayList<>();
        Collections.addAll(list,ids);
        Example example = new Example(User.class);
       Example.Criteria criteria = example.createCriteria();
       criteria.andIn("id",list);

        return userMapper.deleteByExample(example) > 0 ? true : false;
    }


    public Boolean update(User user) {
        Integer number = this.userMapper.updateByPrimaryKeySelective(user);
        return number == 1 ? true : false;
    }
}
