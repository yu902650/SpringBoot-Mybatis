/**     
 * @Title: MybatisConfigurer.java   
 * @Package me.springboot.mybatis.configurer   
 * @Description: TODO
 * @author weiwei 
 * @date 2017年8月10日 下午4:03:46   
 * @version V1.0     
 */
package me.springboot.mybatis.configurer;

import java.util.Properties;

import javax.sql.DataSource;

import me.springboot.mybatis.core.ProjectConstant;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import com.github.pagehelper.PageHelper;

/**
 * @ClassName: MybatisConfigurer
 * @Description: Mybatis翻页插件配置和XML文件配置等
 * @author weiwei
 * @date 2017年8月10日 下午4:03:46
 * 
 */
@Configuration
public class MybatisConfigurer {

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		factory.setTypeAliasesPackage(ProjectConstant.MODEL_PACKAGE);
		// 配置分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		// 分页尺寸为0时查询所有纪录不再执行分页
		properties.setProperty("pageSizeZero", "true");
		// 页码<=0 查询第一页，页码>=总页数查询最后一页
		properties.setProperty("reasonable", "true");
		// 支持通过 Mapper接口参数来传递分页参数
		properties.setProperty("supportMethodsArguments", "true");
		pageHelper.setProperties(properties);
		// 添加插件
		factory.setPlugins(new Interceptor[] { pageHelper });
		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		return factory.getObject();
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		mapperScannerConfigurer.setBasePackage(ProjectConstant.MAPPER_PACKAGE);
		// 配置通用Mapper，详情请查阅官方文档
		Properties properties = new Properties();
		properties.setProperty("mappers", ProjectConstant.MAPPER_INTERFACE_REFERENCE);
		// insert、update是否判断字符串类型!='' 即test="str != null"表达式内是否追加and str != ''
		properties.setProperty("notEmpty", "false");
		properties.setProperty("IDENTITY", "MYSQL");
		mapperScannerConfigurer.setProperties(properties);
		return mapperScannerConfigurer;
	}
}
