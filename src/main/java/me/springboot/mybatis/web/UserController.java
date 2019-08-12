/**
* @Title: UserController.java
* @Package me.springboot.mybatis.web
* @Description: TODO
* @author bobo
* @date 2019/08/12
* @version V1.0
*/
package me.springboot.mybatis.web;

//import me.springboot.mybatis.core.String;
//import me.springboot.mybatis.core.RetResponse;
import me.springboot.mybatis.core.req.Constants;
import me.springboot.mybatis.core.req.Result;
import me.springboot.mybatis.model.User;
import me.springboot.mybatis.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* @ClassName: UserController
* @Description: TODO
* @author bobo
* @date 2019/08/12
*/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
	* @Title: add
	* @Description: 添加
	* @param user
	* @Reutrn
	*/
    @PostMapping("/add")
    public String add (User user) {
        userService.save(user);
		return Result.ok(Constants.SUCCESS,"","add success");
    }

    /**
	* @Title: add2
	* @Description: 传入参数为JSON格式
	* @param user
	* @Reutrn
	*/
	@PostMapping("/add2")
	public String add2(@RequestBody User user) {
		userService.save(user);
		return Result.ok(Constants.SUCCESS,"","add2 success");
	}

    /**
	* @Title: delete
	* @Description: 删除
	* @param
	* @Reutrn
	*/
    @PostMapping("/delete")
    public String deleteById (@RequestParam Integer id) {
        userService.deleteById(id);
        return Result.ok(Constants.SUCCESS,"","del success");
    }

    /**
	* @Title: update
	* @Description: 更新
	* @param user
	* @Reutrn
	*/
    @PostMapping("/update")
    public String update(User user) {
        userService.update(user);
		return Result.ok(Constants.SUCCESS,"","update success");
    }

    /**
	* @Title: update
	* @Description: 更新(传入参数为JSON格式)
	* @param user
	* @Reutrn
	*/
    @PostMapping("/update2")
    public String update2 (@RequestBody User user) {
        userService.update(user);
		return Result.ok(Constants.SUCCESS,"","update success");
    }

    /**
	* @Title: detail
	* @Description: 根据ID查询详情
	* @param
	* @Reutrn
	*/
    @PostMapping("/detail")
    public String detailUser (@RequestParam Integer id) {
        User user = userService.findById(id);
		if(user!=null){
			return Result.ok(Constants.SUCCESS,"","detail success");
		}else{
			return Result.error(Constants.UNKNOW_ERROR,"","detail fail");
		}
    }

    /**
	* @Title: detail
	* @Description: 传入参数为JSON格式
	* @param reqMap
	* @Reutrn
	*/
	@PostMapping("/detail2")
	public String detailUser (@RequestBody Map<String, Object> reqMap) {
		Integer id = Integer.valueOf(reqMap.get("id").toString());
		User user = userService.findById(id);
		if(user!=null){
			return Result.ok(Constants.SUCCESS,"","detail success");
		}else{
			return Result.error(Constants.UNKNOW_ERROR,"","detail fail");
		}
	}

    /**
	* @Title: list
	* @Description: 分页查询
	* @param page 页码
	* @param size 每页条数
	* @Reutrn
	*/
    @PostMapping("/list")
    public String PageInfoUserlist(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
		return Result.ok(Constants.SUCCESS,"",pageInfo);
    }
}
