/**
* @Title: userServiceImpl.java
* @Package me.springboot.mybatis.service.impl
* @Description: TODO
* @author weiwei
* @date 2019/08/12
* @version V1.0
*/
package me.springboot.mybatis.service.impl;

import me.springboot.mybatis.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @ClassName: userService
* @Description: TODO
* @author weiwei
* @date 2019/08/12
*/
@Service
@Transactional
public class userServiceImpl extends AbstractService<user> implements me.springboot.mybatis.core.Service<user> {

    @Resource
    private userMapper userMapper;

}
