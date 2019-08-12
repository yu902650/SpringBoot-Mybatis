package me.springboot.mybatis.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;


/**
 * @author bo bo
 * @date 2019/8/12 14:50
 * @desc
 */
@Api(value="/test", tags="测试接口模块")
@RestController
@RequestMapping("/test")
public class TestSwaggerController {
    @ApiOperation(value="展示首页信息", notes = "展示首页信息")
    @GetMapping("/show")
    public Object showInfo(){
        return "hello world";
    }

    @ApiOperation(value="添加用户信息", notes = "添加用户信息")
    @ApiImplicitParam(name="user", value="User", required = true, dataType = "User")
    @PostMapping("/addUser")
    public Object addUser(@RequestBody User user){
        return "success";
    }
}
