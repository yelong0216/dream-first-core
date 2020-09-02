/**
 * 
 */
package dream.first.core.model.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.aop.TargetClassAware;
import org.springframework.transaction.annotation.Transactional;
import org.yelong.core.annotation.Nullable;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.service.SqlModelServiceAdapter;
import org.yelong.core.model.sql.SqlModel;

import com.github.pagehelper.PageInfo;

import dream.first.core.queryinfo.QueryInfo;
import dream.first.core.queryinfo.filter.QueryFilterInfo;
import dream.first.core.queryinfo.filter.QueryFilterInfoResolver;
import dream.first.core.queryinfo.sort.QuerySortInfo;

/**
 * dream first model service 提供对QueryInfo的查询
 * 
 * @since 1.0.0
 */
@Transactional
public interface DreamFirstModelService extends SqlModelServiceAdapter, TargetClassAware {

	/**
	 * 根据QueryInfo分页查询记录
	 * 
	 * @param <M>        model type
	 * @param modelClass 查询的model
	 * @param queryInfo  查询信息
	 * @return 分页数据
	 */
	default <M extends Modelable> PageInfo<M> findByQueryInfo(Class<M> modelClass, QueryInfo queryInfo) {
		return findByQueryInfo(modelClass, null, queryInfo);
	}

	/**
	 * 根据QueryInfo分页查询记录
	 * 
	 * @param <M>        model type
	 * @param modelClass 查询的model
	 * @param sql        SQL语句。如果不指定SQL，则通过模型生成默认的SQL
	 * @param queryInfo  查询信息
	 * @return 分页数据
	 */
	default <M extends Modelable> PageInfo<M> findByQueryInfo(Class<M> modelClass, @Nullable String sql,
			QueryInfo queryInfo) {
		SqlModel<M> sqlModel = new SqlModel<>(modelClass);
		List<QueryFilterInfo> filters = queryInfo.getFilters();
		if (CollectionUtils.isNotEmpty(filters)) {
			sqlModel.addConditions(getQueryFilterInfoResolver().resolve(filters));
		}
		List<QuerySortInfo> sorters = queryInfo.getSorters();
		if (CollectionUtils.isNotEmpty(sorters)) {
			sorters.forEach(x -> sqlModel.addSortField(x.getSortField(), x.getDirection()));
		}
		Integer pageNum = queryInfo.getPageNum();
		Integer pageSize = queryInfo.getPageSize();
		if (null == sql) {
			return new PageInfo<M>(findPageBySqlModel(modelClass, sqlModel, pageNum, pageSize));
		} else {
			return new PageInfo<M>(findPageBySqlModel(modelClass, sql, null, sqlModel, pageNum, pageSize));
		}
	}

	/**
	 * @return QueryFilterInfo 解析器
	 */
	QueryFilterInfoResolver getQueryFilterInfoResolver();

}
