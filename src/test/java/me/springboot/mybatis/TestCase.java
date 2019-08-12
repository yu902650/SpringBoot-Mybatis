/**     
 * @Title: TestCase.java   
 * @Package me.springboot.mybatis   
 * @Description: TODO
 * @author weiwei 
 * @date 2017年8月10日 下午4:25:17   
 * @version V1.0     
 */
package me.springboot.mybatis;

import me.springboot.mybatis.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: TestCase
 * @Description: 单元测试继承该类即可
 * @author weiwei
 * @date 2017年8月10日 下午4:25:17
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
@Rollback
public abstract class TestCase {
	
}
