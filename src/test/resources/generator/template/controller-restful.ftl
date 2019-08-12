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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**   
* @ClassName: ${modelNameUpperCamel}Controller   
* @Description: //TODO
* @author ${author}
* @date ${date}
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping
    public RetResult<Object> add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
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

    @DeleteMapping("/{id}")
    public RetResult<Object> delete(@PathVariable Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return RetResponse.makeOKRsp();
    }

    @PutMapping
    public RetResult<Object> update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return RetResponse.makeOKRsp();
    }

    @GetMapping("/{id}")
    public RetResult<${modelNameUpperCamel}> detail(@PathVariable Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return RetResponse.makeOKRsp(${modelNameLowerCamel});
    }
    
    /**
	* @Title: json   
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

    @GetMapping
    public RetResult<PageInfo<${modelNameUpperCamel}>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<${modelNameUpperCamel}>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
}