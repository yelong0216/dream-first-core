/**
 * 
 */
package dream.first.core.queryinfo.sort;

import dream.first.base.queryinfo.sort.DFQuerySortInfo;

/**
 * 排序信息
 * 
 * @author PengFei
 * @since 1.0.0
 * @see DFQuerySortInfo
 */
public class QuerySortInfo extends DFQuerySortInfo {

	public QuerySortInfo() {
	}

	/**
	 * @param sortField 排序字段
	 * @param direction 排序方向
	 */
	public QuerySortInfo(String sortField, String direction) {
		super(sortField, direction);
	}

	public QuerySortInfo(DFQuerySortInfo querySortInfo) {
		this(querySortInfo.getSortField(), querySortInfo.getDirection());
	}

}
