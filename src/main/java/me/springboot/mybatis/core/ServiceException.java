package me.springboot.mybatis.core;

/**
 * @ClassName: ServiceException
 * @Description: TODO
 * @author bo bo
 * @date 2019年8月10日 下午4:11:13
 *
 */
public class ServiceException extends RuntimeException {

	/**
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = -9046362194677293871L;

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
