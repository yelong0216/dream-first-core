/**
 * 
 */
package org.yelong.dream.first.core.queryinfo.filter;

import org.yelong.core.jdbc.sql.condition.support.Condition;

/**
 * 查询过滤信息解析器
 * 
 * @author PengFei
 * @since 1.0.0
 */
public interface QueryFilterInfoResolver {
	
	/**
	 * 解析查询过滤信息为条件信息
	 * @param queryFilterInfo 查询过滤信息
	 * @return 条件信息
	 * @throws QueryFilterInfoResolveException 如果查询过滤信息解析异常
	 */
	Condition resolve(QueryFilterInfo queryFilterInfo) throws QueryFilterInfoResolveException;
	
}
