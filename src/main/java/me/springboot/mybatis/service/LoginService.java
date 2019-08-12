package me.springboot.mybatis.service;

import me.springboot.mybatis.model.LoginUser;

/**
 * @author bo bo
 * @date 2019/8/12 13:31
 * @desc
 */
public interface LoginService {
    LoginUser findByObject(LoginUser loginUser);
}
