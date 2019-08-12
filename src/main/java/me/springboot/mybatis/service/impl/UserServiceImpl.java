/**     
* @Title: UserServiceImpl.java
* @Package me.springboot.mybatis.service.impl 
* @Description: TODO
* @author bobo 
* @date 2019/08/12
* @version V1.0     
*/
package me.springboot.mybatis.service.impl;

import me.springboot.mybatis.dao.UserMapper;
import me.springboot.mybatis.model.User;
import me.springboot.mybatis.service.UserService;
import me.springboot.mybatis.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**   
* @ClassName: UserService   
* @Description: TODO
* @author bobo
* @date 2019/08/12
*/
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Resource
    private UserMapper userMapper;

}