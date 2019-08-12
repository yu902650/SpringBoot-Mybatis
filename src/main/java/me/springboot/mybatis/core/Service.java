package me.springboot.mybatis.core;

import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;

import tk.mybatis.mapper.entity.Condition;

/**
 * @ClassName: Service
 * @Description: Service层基础接口，其他Service接口请继承该接口
 * @author bo bo
 * @date 2019年8月10日 下午4:12:23
 *
 */
public interface Service<T> {

	/**
	 * @Title: save
	 * @Description: 持久化
	 * @param model
	 * @Reutrn void
	 */
	void save(T model);

	/**
	 * @Title: save
	 * @Description: 批量持久化
	 * @param models
	 * @Reutrn void
	 */
	void save(List<T> models);

	/**
	 * @Title: deleteById
	 * @Description: 通过主鍵刪除
	 * @param id
	 * @Reutrn void
	 */
	void deleteById(Integer id);

	/**
	 * @Title: deleteByIds
	 * @Description: 批量刪除 eg：ids -> “1,2,3,4”
	 * @param ids
	 * @Reutrn void
	 */
	void deleteByIds(String ids);

	/**
	 * @Title: update
	 * @Description: 更新
	 * @param model
	 * @Reutrn void
	 */
	void update(T model);

	/**
	 * @Title: findById
	 * @Description: 通过ID查找
	 * @param id
	 * @Reutrn T
	 */
	T findById(Integer id);

	/**
	 * @Title: findBy
	 * @Description: 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
	 * @param fieldName
	 * @param value
	 * @throws TooManyResultsException
	 * @Reutrn T
	 */
	T findBy(String fieldName, Object value) throws TooManyResultsException;

	/**
	 * @Title: findListBy
	 * @Description: 通过Model中某个成员变量名称（非数据表中column的名称）查找
	 * @param fieldName
	 *            javabean定义的属性名，不是数据库里的属性名
	 * @param value
	 * @Reutrn List<T>
	 */
	List<T> findListBy(String fieldName, Object value);

	/**
	 * @Title: findByIds
	 * @Description: 通过多个ID查找//eg：ids -> “1,2,3,4”
	 * @param ids
	 * @Reutrn List<T>
	 */
	List<T> findByIds(String ids);

	/**
	 * @Title: findByCondition
	 * @Description: 根据条件查找
	 * @param condition
	 * @Reutrn List<T>
	 */
	List<T> findByCondition(Condition condition);

	/**
	 * @Title: findAll
	 * @Description: 获取所有
	 * @Reutrn List<T>
	 */
	List<T> findAll();
}
