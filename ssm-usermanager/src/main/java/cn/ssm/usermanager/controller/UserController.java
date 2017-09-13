package cn.ssm.usermanager.controller;

import cn.ssm.usermanager.pojo.UiDataResult;
import cn.ssm.usermanager.pojo.User;
import cn.ssm.usermanager.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hirror on 2017/9/12.
 */
@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("user/{url}")
    public String toSomeWebs(@PathVariable("url")String url) {

        return url;
    }

    /**
     * 分页查询所有
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public UiDataResult<User> queryAllUserList(
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows){

        return userService.queryAllUserList(page,rows);
    }

    /**
     * 通过ID删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Map<String,Object > deleteUsersByIds(@RequestParam(value = "ids")String ids){
        Map<String,Object> resultMap = new HashMap<>();

        Boolean flag = this.userService.deleteUserByIds(ids);
        if(flag){
            //新增成功
            resultMap.put("status", 200);
        }

        return resultMap;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Map<String,Object > saveUser(User user){
        Map<String,Object> resultMap = new HashMap<>();
        if (user.getId()== null) {
            Boolean flag = this.userService.insert(user);
            if (flag) {
                //新增成功
                resultMap.put("status", 200);
            }


        }else{
            Boolean flag = this.userService.update(user);
            if (flag) {
                //新增成功
                resultMap.put("status", 200);
            }
        }
        return resultMap;
    }

    /**
     * excel 导出
     * 1.查询出数据
     * 2.将数据写入到excel
     * 3.生成完整的excel后，供用户下载
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="export/excel",method=RequestMethod.POST)
    public ModelAndView exportExcel(@RequestParam("page") Integer pageNum,
                                    @RequestParam("rows") Integer pageSize){
        ModelAndView mv = new ModelAndView("excelView");
        UiDataResult result = this.userService.queryAllUserList(pageNum, pageSize);
        mv.addObject("userList", result.getRows());
        return mv;
    }


}
