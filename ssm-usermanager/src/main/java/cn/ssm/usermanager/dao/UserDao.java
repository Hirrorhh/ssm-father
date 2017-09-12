/**
 * 
 */
package cn.ssm.usermanager.dao;

import java.util.List;

import cn.ssm.usermanager.pojo.User;
import org.apache.ibatis.annotations.Param;



/**
 * @author hirror
 *
 */
public interface UserDao {
	
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	User queryUserById(Long id);
	/**
	 * 查询全部用户
	 * @return
	 */
	List<User> queryAll();
	/**
	 * 添加用户
	 * @param user
	 * @return 
	 */
	Integer insertUser(User user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return 
	 */
	Integer updateUser(User user);
	/**
	 * 根据ID删除用户
	 * @param id
	 * @return 
	 */
	Integer deleteUserById(Long id);
	
	/**
	 * 根据用户名和密码查询
	 * @param userName
	 * @param passWord
	 * @return
	 */
	User queryUserByUserNameAndPassword(
            @Param("userName") String userName, @Param("passWord") String passWord);
	
	/**
	 * 根据用户名相似查询
	 * @param name
	 * @return
	 */
	List<User> queryUserByNameLike(@Param("name") String name);
	/**
	 * 排序查询所有用户
	 * @param name
	 * @return
	 */
	List<User> queryUserBySort(@Param("sortType") Integer sortType);
	/**
	 * 根据id查询多个用户
	 * @param name
	 * @return
	 */
	List<User> queryUserByIds(@Param("ids") List<Long> ids);
	
	List<User> queryUserByIdsString(@Param("ids") String ids);
	
	List<User> queryUserByNameLikeAndAge(@Param("name") String name, @Param("age") Integer age);
}
