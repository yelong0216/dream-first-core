/**
 * 
 */
package dream.first.core.queryinfo;

import java.util.List;

import dream.first.base.queryinfo.DFQueryInfo;
import dream.first.core.queryinfo.filter.QueryFilterInfo;
import dream.first.core.queryinfo.sort.QuerySortInfo;

/**
 * 查询信息 与前端交互的一个POJO
 * 
 * @since 1.0.0
 */
public class QueryInfo extends DFQueryInfo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<QueryFilterInfo> getFilters() {
		return (List) filters;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<QuerySortInfo> getSorters() {
		return (List) sorters;
	}

}
