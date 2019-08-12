package me.springboot.mybatis.core;

/**
 * @ClassName: ProjectConstant
 * @Description: TODO
 * @author bo bo
 * @date 2019年8月10日 下午4:07:14
 *
 */
public class ProjectConstant {

	// 项目基础包名称，根据自己公司的项目修改
	public static final String BASE_PACKAGE = "me.springboot.mybatis";

	// Model所在包
	public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";

	// Mapper所在包
	public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";

	// Service所在包
	public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";

	// ServiceImpl所在包
	public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

	// Controller所在包
	public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";

	// Mapper插件基础接口的完全限定名
	public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";

}
