package me.springboot.mybatis.core;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @ClassName: Mapper
 * @Description: 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
 * @author bo bo
 * @date 2019年8月10日 下午4:14:32
 *
 */
public interface Mapper<T> extends BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {
}
