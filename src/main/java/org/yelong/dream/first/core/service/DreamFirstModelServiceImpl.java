/**
 * 
 */
package org.yelong.dream.first.core.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.yelong.core.jdbc.sql.condition.support.Condition;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.ModelConfiguration;
import org.yelong.core.model.sql.SqlModel;
import org.yelong.dream.first.core.queryinfo.QueryInfo;
import org.yelong.dream.first.core.queryinfo.filter.QueryFilterInfo;
import org.yelong.dream.first.core.queryinfo.filter.QueryFilterInfoResolver;
import org.yelong.dream.first.core.queryinfo.sort.QuerySortInfo;
import org.yelong.mybatis.spring.MyBatisModelService;
import org.yelong.support.orm.mybaits.mapper.MyBatisBaseDataBaseOperation;

import com.github.pagehelper.PageInfo;

/**
 * @author PengFei
 * @since 1.0.0
 */
public class DreamFirstModelServiceImpl extends MyBatisModelService implements DreamFirstModelService{

	private QueryFilterInfoResolver queryFilterInfoResolver;
	
	public DreamFirstModelServiceImpl(ModelConfiguration modelConfiguration,
			MyBatisBaseDataBaseOperation myBatisBaseDataBaseOperation,
			QueryFilterInfoResolver queryFilterInfoResolver) {
		super(modelConfiguration, myBatisBaseDataBaseOperation);
		this.queryFilterInfoResolver = queryFilterInfoResolver;
	}

	@Override
	public <M extends Modelable> PageInfo<M> findByQueryInfo(Class<M> modelClass, QueryInfo queryInfo) {
		SqlModel sqlModel = new SqlModel(modelClass);
		List<QueryFilterInfo> filters = queryInfo.getFilters();
		if(CollectionUtils.isNotEmpty(filters)) {
			for (QueryFilterInfo queryFilterInfo : filters) {
				Condition condition = queryFilterInfoResolver.resolve(queryFilterInfo);
				sqlModel.addCondition(condition);
			}
		}
		List<QuerySortInfo> sorters = queryInfo.getSorters();
		if(CollectionUtils.isNotEmpty(sorters)) {
			for (QuerySortInfo querySortInfo : sorters) {
				sqlModel.addSortField(querySortInfo.getSortField(), querySortInfo.getDirection());
			}
		}
		Integer pageNum = queryInfo.getPageNum();
		Integer pageSize = queryInfo.getPageSize();
		return new PageInfo<M>(super.findPageBySqlModel(modelClass, sqlModel, pageNum, pageSize));
	}

	@Override
	public <M extends Modelable> PageInfo<M> findByQueryInfo(Class<M> modelClass, String sql, QueryInfo queryInfo) {
		SqlModel sqlModel = new SqlModel(modelClass);
		List<QueryFilterInfo> filters = queryInfo.getFilters();
		if(CollectionUtils.isNotEmpty(filters)) {
			for (QueryFilterInfo queryFilterInfo : filters) {
				Condition condition = queryFilterInfoResolver.resolve(queryFilterInfo);
				sqlModel.addCondition(condition);
			}
		}
		List<QuerySortInfo> sorters = queryInfo.getSorters();
		if(CollectionUtils.isNotEmpty(sorters)) {
			for (QuerySortInfo querySortInfo : sorters) {
				sqlModel.addSortField(querySortInfo.getSortField(), querySortInfo.getDirection());
			}
		}
		Integer pageNum = queryInfo.getPageNum();
		Integer pageSize = queryInfo.getPageSize();
		return new PageInfo<M>(super.findPageBySqlModel(modelClass,sql, sqlModel, pageNum, pageSize));
	}
	
	public QueryFilterInfoResolver getQueryFilterInfoResolver() {
		return queryFilterInfoResolver;
	}

	public void setQueryFilterInfoResolver(QueryFilterInfoResolver queryFilterInfoResolver) {
		this.queryFilterInfoResolver = queryFilterInfoResolver;
	}

}
