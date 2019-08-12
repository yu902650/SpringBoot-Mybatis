/**     
* @Title: ${modelNameUpperCamel}ServiceImpl.java
* @Package ${basePackageServiceImpl} 
* @Description: TODO
* @author ${author} 
* @date ${date}
* @version V1.0     
*/
package ${basePackageServiceImpl};

import ${basePackageDao}.${modelNameUpperCamel}Mapper;
import ${basePackageModel}.${modelNameUpperCamel};
import ${basePackageService}.${modelNameUpperCamel}Service;
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**   
* @ClassName: ${modelNameUpperCamel}Service   
* @Description: TODO
* @author ${author}
* @date ${date}
*/
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}