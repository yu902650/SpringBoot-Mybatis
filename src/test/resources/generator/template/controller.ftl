/**     
* @Title: ${modelNameUpperCamel}Controller.java
* @Package ${basePackageController}
* @Description: TODO
* @author ${author} 
* @date ${date}
* @version V1.0     
*/
package ${basePackageController};

import ${basePackage}.core.RetResult;
import ${basePackage}.core.RetResponse;
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
	* @Reutrn RetResult<Object>
	*/
    @PostMapping("/add")
    public RetResult<Object> add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return RetResponse.makeOKRsp();
    }
    
    /**
	* @Title: add2   
	* @Description: 传入参数为JSON格式
	* @param ${modelNameLowerCamel}
	* @Reutrn RetResult<Object>
	*/
	@PostMapping("/add2")
	public RetResult<Object> add2(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
		${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
		return RetResponse.makeOKRsp();
	}

    /**
	* @Title: delete   
	* @Description: 删除
	* @param ${modelNameLowerCamel}
	* @Reutrn RetResult<Object>
	*/
    @PostMapping("/delete")
    public RetResult<Object> delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return RetResponse.makeOKRsp();
    }

    /**
	* @Title: update   
	* @Description: 更新
	* @param ${modelNameLowerCamel}
	* @Reutrn RetResult<Object>
	*/
    @PostMapping("/update")
    public RetResult<Object> update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return RetResponse.makeOKRsp();
    }
    
    /**
	* @Title: update   
	* @Description: 更新(传入参数为JSON格式)
	* @param ${modelNameLowerCamel}
	* @Reutrn RetResult<Object>
	*/
    @PostMapping("/update2")
    public RetResult<Object> update2(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return RetResponse.makeOKRsp();
    }

    /**
	* @Title: detail   
	* @Description: 根据ID查询详情
	* @param ${modelNameLowerCamel}
	* @Reutrn RetResult<${modelNameUpperCamel}>
	*/
    @PostMapping("/detail")
    public RetResult<${modelNameUpperCamel}> detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return RetResponse.makeOKRsp(${modelNameLowerCamel});
    }
    
    /**
	* @Title: detail   
	* @Description: 传入参数为JSON格式
	* @param reqMap
	* @Reutrn RetResult<${modelNameUpperCamel}>
	*/
	@PostMapping("/detail2")
	public RetResult<${modelNameUpperCamel}> detail(@RequestBody Map<String, Object> reqMap) {
		Integer id = Integer.valueOf(reqMap.get("id").toString());
		${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return RetResponse.makeOKRsp(${modelNameLowerCamel});
	}

    /**
	* @Title: list   
	* @Description: 分页查询
	* @param page 页码
	* @param size 每页条数
	* @Reutrn RetResult<PageInfo<${modelNameUpperCamel}>>
	*/
    @PostMapping("/list")
    public RetResult<PageInfo<${modelNameUpperCamel}>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<${modelNameUpperCamel}>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }  
}