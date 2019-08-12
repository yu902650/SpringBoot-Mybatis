package me.springboot.mybatis.core.req;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import me.springboot.mybatis.util.RandomUtil;

public class Result {

	private enum Status{
		OK,ERROR
	}
	private static SerializeConfig config = new SerializeConfig();
	private String status;
	private String message;
	private Object result;
	private Integer code;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

	Result(int code, String status , String message, Object result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
		this.code = code;
	}

	Result(int code, String status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.code = code;
	}

	public Result() {
	}

	public static String error(Integer code,String msg){
		return new Result(code, Status.ERROR.name(), msg, null).toString();
	}

	public static String error(Integer code,String msg,Object result){
		return new Result(code, Status.ERROR.name(), msg, result).toString();
	}

	public static String error(String errMsg,Object result){
		return new Result(1000, Status.ERROR.name(), errMsg, result).toString();
	}

	public static String ok(Integer code,String msg,Object result){
		return new Result(code, Status.OK.name(), msg, result).toString();
	}


	public static String ok(String msg,Object result) {
		return new Result(200, Status.OK.name(), msg, result).toString();
	}

	/*private static String getMessage(Integer code){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String message = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()).getMessage(code+"", null, Locale.CHINA);
		return message;
	}*/

	/*private static Locale getLocale(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Locale locale;
		Cookie cookie = WebUtils.getCookie(request, I18NCOOKIE_NAME);

		if (cookie != null) {
			locale = StringUtils.parseLocaleString(cookie.getValue());
			if (locale != null) {
				return locale;
			}
		}
		locale = (Locale) request.getLocale();
		if (locale != null) {
			return locale;
		}

		return locale;
	}*/

	@Override
	public String toString() {
		return JSONObject.toJSONString(this,config, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty);
	}

	public static void main(String[] args) {
		System.err.println(RandomUtil.randomStr(32,false));
	}

}
