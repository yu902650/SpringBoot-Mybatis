package me.springboot.mybatis.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.springboot.mybatis.core.RetResponse;
import me.springboot.mybatis.core.RetResult;
import me.springboot.mybatis.model.LoginUser;
import me.springboot.mybatis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @author bo bo
 * @date 2019/8/12 13:30
 * @desc
 */
@Api(value="/login", tags="login模块")
@RestController
@RequestMapping("/login")
public class LoginUserController {

    @Autowired
    private LoginService loginService;

    /**
     *
     * @return
     */
    @ApiOperation(value = "测试a",notes = "不需要传参只是测试接口是否可用")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public String a(){
        return "welcome to west world!";
    }

    @PostMapping("/toLogin")
    public RetResult toLigin(@RequestParam(required = false) String name,
                             @RequestParam(required = false) String password) {

        if (name != null && password != null) {
            LoginUser loginUser = new LoginUser();
            loginUser.setName(name);
            loginUser.setPassword(password);
            LoginUser result = loginService.findByObject(loginUser);
            if (result != null) {
                return RetResponse.makeRsp(200,"login success");
            }else {
                return RetResponse.makeRsp(400, "login fail");
            }
        }
         return null;
    }
}
