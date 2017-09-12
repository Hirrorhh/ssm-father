package cn.ssm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/hello/")
@Controller
public class HelloController {

	
	@RequestMapping(value="/first")
	public ModelAndView hello(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "第一个注解程序");
		return mv;
	}
	
	@RequestMapping(value="hello1")
	public ModelAndView hello1(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "第二个程序测试");
		return mv;
	}
	
	/**
	 * Ant风格映射
	 * 问号： 问号是通配符的配置，代表单层单个字符,不能省略
	 */
	@RequestMapping(value="?/ant")
	public ModelAndView ant1(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "Ant风格映射之一 ： 问号的使用");
		return mv;
	}
	
	
	/**
	 * Ant风格映射
	 * 星号： 星号是通配符的配置，代表单层N个字符,不能省略
	 */
	@RequestMapping(value="*/ant2")
	public ModelAndView ant2(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "Ant风格映射之一 ： *号的使用");
		return mv;
	}
	
	
	/**
	 * Ant风格映射
	 * 双星号： 双星号是通配符的配置，代表任意层N个字符，可以省略
	 */
	@RequestMapping(value="**/ant3")
	public ModelAndView ant3(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "Ant风格映射之一 ： **号的使用");
		return mv;
	}
	/**
	 * 占位符映射
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="query/{id}/{username}/{age}")
	public ModelAndView queryUserById(@PathVariable("id") Long userId,
			@PathVariable("age") Integer age,@PathVariable("username") String userName){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "占位符映射 ： 占位符传参 用户id=" + userId + "=age:"+age + "==userName:"+userName);
		return mv;
	}
	
	/**
	 * 请求方式限定
	 * 
	 */
	@RequestMapping(value="only/post",method={RequestMethod.POST,RequestMethod.PUT})
	public ModelAndView hello4(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "请求方式限定，只允许Post请求来访问");
		return mv;
	}
	/**
	 * 限定请求参数
	 * 1.必须携带某个参数
	 * 2.必须不准携带某个参数
	 * 3.某个参数必须等于某个值
	 * 4.某个参数必须不等于某个值
	 * @param id
	 * @return
	 */
	@RequestMapping(value="param",params={"id","!age","sex=1","name!=zs"})
	public ModelAndView hello5(Long id){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "请求参数限定，必须携带某个参数  id=" + id);
		return mv;
	}
	
	
	/**
	 * 重定向
	 * 1.URL发生改变
	 * 2.请求参数丢失
	 * @param name
	 * @return
	 */
	@RequestMapping(value="redirect")
	public String hello5(String name){
		return "redirect:/user/login.do?name="+name;
	}
	/**
	 * 请求转发
	 * 1.URL无变化
	 * 2.参数未丢失
	 * @param name
	 * @return
	 */
	@RequestMapping(value="forward")
	public String hello6(String name){
		return "forward:/user/login2.do";
	}
	
	
	
	
	
	
	
}
