/**
 * @Title: Application.java
 * @Package me.springboot.mybatis
 * @Description: TODO
 * @author bo bo
 * @date 2019年8月10日 下午4:00:41
 * @version V1.0
 */
package me.springboot.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: Application
 * @Description: TODO
 * @author bobo
 * @date 2019年8月12日 下午16:00:41
 *
 */
@SpringBootApplication
public class Application {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @Reutrn void
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
