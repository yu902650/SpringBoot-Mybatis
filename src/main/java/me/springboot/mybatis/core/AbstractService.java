/**     
 * @Title: AbstractService.java   
 * @Package me.springboot.mybatis.core   
 * @Description: TODO
 * @author weiwei 
 * @date 2017年8月10日 下午4:15:15   
 * @version V1.0     
 */
package me.springboot.mybatis.core;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Condition;

/**
 * @ClassName: AbstractService
 * @Description: 基于通用MyBatis Mapper插件的Service接口的实现
 * @author weiwei
 * @date 2017年8月10日 下午4:15:15
 * 
 */
public abstract class AbstractService<T> implements Service<T> {

	@Autowired
	protected Mapper<T> mapper;

	private Class<T> modelClass; // 当前泛型真实类型的Class

	@SuppressWarnings("unchecked")
	public AbstractService() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		modelClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public void save(T model) {
		mapper.insertSelective(model);
	}

	public void save(List<T> models) {
		mapper.insertList(models);
	}

	public void deleteById(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void deleteByIds(String ids) {
		mapper.deleteByIds(ids);
	}

	public void update(T model) {
		mapper.updateByPrimaryKeySelective(model);
	}

	public T findById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public T findBy(String fieldName, Object value) throws TooManyResultsException {
		try {
			T model = modelClass.newInstance();
			Field field = modelClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(model, value);
			return mapper.selectOne(model);
		} catch (ReflectiveOperationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	public List<T> findListBy(String fieldName, Object value)  {
		try {
			T model = modelClass.newInstance();
			Field field = modelClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(model, value);
			return mapper.select(model);
		} catch (ReflectiveOperationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<T> findByIds(String ids) {
		return mapper.selectByIds(ids);
	}

	public List<T> findByCondition(Condition condition) {
		return mapper.selectByCondition(condition);
	}

	public List<T> findAll() {
		return mapper.selectAll();
	}
}