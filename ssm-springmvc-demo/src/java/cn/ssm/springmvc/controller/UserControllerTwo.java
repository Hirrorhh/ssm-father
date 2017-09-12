package cn.ssm.springmvc.controller;

import cn.ssm.springmvc.bean.User;
import cn.ssm.springmvc.bean.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@RequestMapping("user/t")
@Controller
public class UserControllerTwo {

	
	


	/**
	 * 绑定servlet内置对象
	 */
	@RequestMapping(value="servlet",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView bindServletObject(HttpServletRequest request,HttpServletResponse response,
			HttpSession session){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "request:"+request+"==response:"+response + "==session:"+session);
		return mv;
	}
	
	/**
	 * 
	 * 占位符传参  ：
	 *    参数定义在RequestMapping的value属性中，使用一对大括号{参数名称}
	 *    在Handler的参数列表中，使用@PathVariable("参数名称") 来获取
	 * @param id
	 * @return
	 */
	@RequestMapping(value="{name}/{id}")
	public ModelAndView pathVariableGetParam(@PathVariable("name") String name,@PathVariable("id") Long id){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "name="+name);
		return mv;
	}
	
	
	/**
	 * 接收基本类型的参数
	 */
	@RequestMapping("basetype")
	public ModelAndView getBaseParam(String name,Integer age,Double income,
			Boolean isMarried,String[] interests){
		
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "name:"+name+"==age:"+age+"==income:"+income
				+"==isMarried:"+isMarried+"==interests:"+interests.length);
		return mv;
	}
	
	/**
	 * 参数为引用类型  POJO对象
	 * @param user
	 * @return
	 */
	@RequestMapping("paramuser")
	public ModelAndView getPojoParam(User user){
	
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", user);
		return mv;
	}
	
	
	
	/**
	 * @RequestParam : 用来定义一个必须的参数
	 *  value属性指定参数的名称
	 *  required参数是否必须，默认true(必须)
	 *  defaultValue为该参数指定一个默认值，当请求中未携带该参数时，使用默认值，携带则覆盖默认值
	 *   当指定了defaultValue时，required属性自动被修改为false
	 * 分页查询
	 */
	@RequestMapping(value="page")
	public  ModelAndView  pageList(@RequestParam(value="pageNum") Integer pageNum
			,@RequestParam(value="pageSize",defaultValue="10") Integer pageSize){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "pageNum:"+pageNum + "===pageSize:"+pageSize);
		return mv;
		
	}
	/**
	 * 获取cookie中的值
	 * @param jsessionid
	 * @return
	 */
	@RequestMapping(value="cookie")
	public  ModelAndView  getCookieValue(@CookieValue("JSESSIONID") String jsessionid){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "jsessionid:"+jsessionid);
		return mv;
		
	}
	
	/**
	 * 接收集合类型的参数
	 * @param users
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(UserList users){
		
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "list:"+users.getUsers().size());
		return mv;
		
	}
	
	/**
	 * @ResponseBody : 将java对象转json
	 * @return
	 */
	@RequestMapping(value="rsjson")
	@ResponseBody
	public User rsJsonUser(){
		User user = new User();
		user.setId(1L);
		user.setuserName("zhangsan");
		user.setName("lisi");
		user.setAge(18);
		user.setPassword("123456");
		user.setSex(1);
		return user;
	}
	/**
	 * 接收json格式的User对象
	 * @RequestBody ：将json格式的参数转成java对象
	 * @param user
	 * @return
	 */
	@RequestMapping(value="json")
	public ModelAndView getJsonUser(@RequestBody User user){
		
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "user === :"+user);
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
}
