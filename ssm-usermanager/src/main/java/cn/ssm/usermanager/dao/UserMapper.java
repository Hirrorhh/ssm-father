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
public interface UserMapper {
	
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
	List<User> queryUserList();
	/**
	 * 添加用户
	 * @param user
	 * @return 
	 */
	Integer save(User user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return 
	 */
	Integer updateUser(User user);
	/**
	 * 根据ID删除用户
	 * @param ids
	 * @return 
	 */
	Integer deleteUserByIds(@Param("ids") String ids);



}
