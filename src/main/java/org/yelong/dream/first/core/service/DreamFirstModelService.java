/**
 * 
 */
package org.yelong.dream.first.core.service;

import org.yelong.core.model.Modelable;
import org.yelong.core.model.service.SqlModelService;
import org.yelong.dream.first.core.queryinfo.QueryInfo;
import org.yelong.dream.first.core.queryinfo.filter.QueryFilterInfoResolver;

import com.github.pagehelper.PageInfo;

/**
 * labbol model service
 * 提供对QueryInfo的查询
 * 
 * @author PengFei
 * @since 1.0.0
 */
public interface DreamFirstModelService extends SqlModelService{
	
	/**
	 * 根据QueryInfo分页查询记录
	 * @param <M>
	 * @param modelClass 查询的model
	 * @param queryInfo 查询信息
	 * @return 分页数据
	 */
	<M extends Modelable> PageInfo<M> findByQueryInfo(Class<M> modelClass,QueryInfo queryInfo);
	
	/**
	 * 根据QueryInfo分页查询记录
	 * @param <M>
	 * @param modelClass 查询的model
	 * @param sql sql语句
	 * @param queryInfo 查询信息
	 * @return 分页数据
	 */
	<M extends Modelable> PageInfo<M> findByQueryInfo(Class<M> modelClass , String sql ,QueryInfo queryInfo);
	
	/**
	 * @return QueryFilterInfo 解析器
	 */
	QueryFilterInfoResolver getQueryFilterInfoResolver();
	
}
