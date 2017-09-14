package cn.ssm.usermanager.controller;

import cn.ssm.usermanager.pojo.UiDataResult;
import cn.ssm.usermanager.pojo.User;
import cn.ssm.usermanager.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Response;
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
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UiDataResult<User>> queryAllUserList(
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows){

        try {
            UiDataResult<User> result = userService.queryAllUserList(page, rows);

            if (result.getRows() != null && !result.getRows().isEmpty()){
                return new ResponseEntity<>(result,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 通过ID删除
     * @param ids
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUsersByIds(@RequestParam(value = "ids")String ids){

        try {
            Boolean flag = this.userService.deleteUserByIds(ids);
            if(flag){
                //删除成功
                //测试得出方法是delete时候,第一种方式得不到值是因为状态码是NO_content时,确定无返回值
                 return new ResponseEntity<>("204",HttpStatus.NO_CONTENT);
                //return ResponseEntity.status(HttpStatus.CREATED).body("204");
            }
            return new ResponseEntity<>("417",HttpStatus.EXPECTATION_FAILED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("500",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * 添加用户
     * @param user
     * @return
     */

    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(User user){

        try {
            if (user.getId()== null) {
                Boolean flag = this.userService.insert(user);
                if (flag) {
                    //新增成功
                    //return new ResponseEntity<>("204",HttpStatus.CREATED);
                    return ResponseEntity.status(HttpStatus.CREATED).body("204");
                }
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);

            }else{
                Boolean flag = this.userService.update(user);
                if (flag) {
                    //修改成功
                    return  ResponseEntity.status(HttpStatus.ACCEPTED).body("202");
                }
                return new ResponseEntity<>("417",HttpStatus.EXPECTATION_FAILED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("500",HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
