package cn.ssm.springmvc.controller;

import cn.ssm.springmvc.bean.User;
import cn.ssm.springmvc.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;



@RequestMapping("user")
@Controller
public class UserController {


	/**
	 *
	 * 返回集合
	 * 返回多个User对象
     * @return
     */
	@RequestMapping(value="list")
	public ModelAndView getUserList(){
		ModelAndView mv = new ModelAndView("user");
		try {
			List<User> list = new ArrayList<>();
			for(Long i = 1L;i<10L;i++){
				User user = new User();
				user.setId(i);
				user.setuserName("zhangsan"+i);
				user.setAge(18);
				user.setName("lisi"+i);
				list.add(user);
			}
			System.out.println("===================方法Handler执行");
			mv.addObject("users", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}


	/**
	 * 直接返回视图名称
	 * @return string
	 * @throws MyException
	 */
	@RequestMapping("teststr")
	public String test(Model model) throws MyException{
		List<User> list = new ArrayList<>();

		for(Long i = 1L;i<10L;i++){
			User user = new User();
			user.setId(i);
			user.setuserName("zhangsan"+i);
			user.setAge(18);
			user.setName("lisi"+i);
			list.add(user);

        }
	if(true){
		throw new MyException("自定义异常被抛出!");
		}
		model.addAttribute("users", list);
		return "";
	}
	
	
	
	
	/**
	 * 异步请求需要将返回值转成json
	 *
	 */
	@RequestMapping(value="ajax/list")
	@ResponseBody
	public  List<User> getUsers(){
		List<User> list = new ArrayList<>();
		for(Long i = 1L;i<10L;i++){
			User user = new User();
			user.setId(i);
			user.setuserName("zhangsan"+i);
			user.setAge(18);
			user.setName("lisi"+i);
			list.add(user);
		}
		
		return list;
	}
	
	
	@RequestMapping(value="login")
	public ModelAndView login(String name){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "重定向参数name = " + name);
		return mv;
		
	}
	
	@RequestMapping(value="login2")
	public ModelAndView login2(String name){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "请求转发参数name = " + name);
		return mv;
		
	}
	
	
	
	
	
	
}
