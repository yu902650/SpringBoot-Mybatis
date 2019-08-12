package me.springboot.mybatis.core;

/**
 * @ClassName: RetCode
 * @Description: 响应码枚举，参考HTTP状态码的语义
 * @author bo bo
 * @date 2019年8月10日 下午4:10:21
 *
 */
public enum RetCode {

	SUCCESS(200), // 成功

	FAIL(400), // 失败

	UNAUTHORIZED(401), // 未认证（签名错误）

	NOT_FOUND(404), // 接口不存在

	INTERNAL_SERVER_ERROR(500);// 服务器内部错误

	public int code;

	RetCode(int code) {
		this.code = code;
	}
}
