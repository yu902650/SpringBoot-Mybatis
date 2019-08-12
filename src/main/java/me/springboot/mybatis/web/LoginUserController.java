package me.springboot.mybatis.web;

import me.springboot.mybatis.core.req.Constants;
import me.springboot.mybatis.core.req.Result;
import me.springboot.mybatis.model.LoginUser;
import me.springboot.mybatis.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author bo bo
 * @date 2019/8/12 13:30
 * @desc
 */
@RestController
@RequestMapping("/login")
public class LoginUserController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/a")
    public String a(){
        return "welcome to west world!";
    }

    @PostMapping("/toLogin")
    public String toLigin(@RequestParam(required = false) String name,
                             @RequestParam(required = false) String password) {
        if (name != null && password != null) {
            LoginUser loginUser = new LoginUser();
            loginUser.setName(name);
            loginUser.setPassword(password);
            LoginUser result = loginService.findByObject(loginUser);
            if (result != null) {
                return Result.ok(Constants.SUCCESS,"","login success");
            }else {
                return Result.ok(Constants.UNKNOW_ERROR,"400","login fail");
            }
        }
         return null;
    }
}
