package me.springboot.mybatis.dao;

import me.springboot.mybatis.model.LoginUser;
import org.springframework.stereotype.Repository;

/**
 * @author bo bo
 * @date 2019/8/12 13:40
 * @desc
 */
public interface ILoginMapper {
    LoginUser findByObject(LoginUser loginUser);
}
