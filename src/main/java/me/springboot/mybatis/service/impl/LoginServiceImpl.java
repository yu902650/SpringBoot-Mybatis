package me.springboot.mybatis.service.impl;

import me.springboot.mybatis.dao.ILoginMapper;
import me.springboot.mybatis.model.LoginUser;
import me.springboot.mybatis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author bo bo
 * @date 2019/8/12 13:31
 * @desc
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService{

    @Resource
    private ILoginMapper loginMapper;

    @Override
    public LoginUser findByObject(LoginUser loginUser) {
        return loginMapper.findByObject(loginUser);
    }
}
