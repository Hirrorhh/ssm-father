package cn.ssm.springmvc.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver {

	//异常处理的方法
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		
		String msg = null;
		// 判断是否是自定义异常
		if(ex instanceof MyException){
			msg = ex.getMessage();
		}else{
			// 如果不是，则获取栈信息 
			StringWriter out = new StringWriter();
			PrintWriter pw = new PrintWriter(out);
			ex.printStackTrace(pw);
			msg = out.toString();
		}
		// 添加异常信息到Model
		mv.addObject("msg", msg);
		return mv;
	}

}