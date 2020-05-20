/**
 * 
 */
package org.yelong.dream.first.core.queryinfo.filter;

/**
 * 查询过滤信息解析异常
 * 
 * @author PengFei
 * @since 1.0.0
 */
public class QueryFilterInfoResolveException extends RuntimeException{

	private static final long serialVersionUID = -4047959333586376642L;

	public QueryFilterInfoResolveException() {
		
	}
	
	public QueryFilterInfoResolveException(String message) {
		super(message);
	}

	public QueryFilterInfoResolveException(Throwable t) {
		super(t);
	}
	
}
