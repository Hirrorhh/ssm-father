package cn.ssm.springmvc.controller;
import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class FileUploadController {
	
	
	
		// 演示：文件上传
		// 通过参数：MultipartFile file来接收上传的文件，这个是SpringMVC中定义的类，会被自动注入
		@RequestMapping("upload")
		public ModelAndView show21(@RequestParam("file") MultipartFile file) throws Exception {
			ModelAndView mv = new ModelAndView("hello");
			if(file != null){
				// 将上传得到的文件 转移到指定文件。
				file.transferTo(new File("D:/test/" + file.getOriginalFilename()));
			}
			mv.addObject("msg", "上传成功！" + file.getOriginalFilename());
			return mv;
		}
}
