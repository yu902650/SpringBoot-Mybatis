/**
* @Title: ${modelNameUpperCamel}Controller.java
* @Package ${basePackageController}
* @Description: TODO
* @author ${author}
* @date ${date}
* @version V1.0
*/
package ${basePackageController};

//import me.springboot.mybatis.core.String;
//import me.springboot.mybatis.core.RetResponse;
import ${basePackageModel}.${modelNameUpperCamel};
import ${basePackageService}.${modelNameUpperCamel}Service;
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
* @ClassName: ${modelNameUpperCamel}Controller
* @Description: TODO
* @author ${author}
* @date ${date}
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    /**
	* @Title: add
	* @Description: 添加
	* @param ${modelNameLowerCamel}
	* @Reutrn
	*/
    @PostMapping("/add")
    public String add (${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
		return Result.ok(Constants.SUCCESS,"","add success");
    }

    /**
	* @Title: add2
	* @Description: 传入参数为JSON格式
	* @param ${modelNameLowerCamel}
	* @Reutrn
	*/
	@PostMapping("/add2")
	public String add2(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
		${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
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
        ${modelNameLowerCamel}Service.deleteById(id);
        return Result.ok(Constants.SUCCESS,"","del success");
    }

    /**
	* @Title: update
	* @Description: 更新
	* @param ${modelNameLowerCamel}
	* @Reutrn
	*/
    @PostMapping("/update")
    public String update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
		return Result.ok(Constants.SUCCESS,"","update success");
    }

    /**
	* @Title: update
	* @Description: 更新(传入参数为JSON格式)
	* @param ${modelNameLowerCamel}
	* @Reutrn
	*/
    @PostMapping("/update2")
    public String update2 (@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
		return Result.ok(Constants.SUCCESS,"","update success");
    }

    /**
	* @Title: detail
	* @Description: 根据ID查询详情
	* @param
	* @Reutrn
	*/
    @PostMapping("/detail")
    public String detail${modelNameUpperCamel} (@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
		if(${modelNameLowerCamel}!=null){
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
	public String detail${modelNameUpperCamel} (@RequestBody Map<String, Object> reqMap) {
		Integer id = Integer.valueOf(reqMap.get("id").toString());
		${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
		if(${modelNameLowerCamel}!=null){
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
    public String PageInfo${modelNameUpperCamel}list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<${modelNameUpperCamel}>(list);
		return Result.ok(Constants.SUCCESS,"",pageInfo);
    }
}
