/**
 * 
 */
package dream.first.core.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * 请求异常
 * 
 * 这个异常由 拦截器、Controller 中进行抛出。
 * 必须定义 {@link HandlerExceptionResolver}来捕获这个异常
 * 
 * @since 1.0.0
 */
public class RequestException extends RuntimeException{

	private static final long serialVersionUID = -905174023153735694L;
	
	/**
	 * 默认的状态码
	 */
	public static final int DEFAULT_STATUS = 500;
	
	private final int status;
	
	public RequestException() {
		this(DEFAULT_STATUS);
	}
	
	public RequestException(int status) {
		this.status = status;
	}
	
	public RequestException(String message) {
		this(DEFAULT_STATUS,message);
	}
	
	public RequestException(int status ,String message) {
		super(message);
		this.status = status;
	}
	
	public RequestException(String message ,Throwable t) {
		this(DEFAULT_STATUS,message,t);
	}

	public RequestException(int status ,String message , Throwable t) {
		super(message,t);
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}

}
