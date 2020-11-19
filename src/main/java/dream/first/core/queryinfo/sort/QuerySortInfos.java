/**
 * 
 */
package dream.first.core.queryinfo.sort;

import java.util.List;

import org.yelong.core.jdbc.sql.sort.support.Sort;

import dream.first.base.queryinfo.sort.DFQuerySortInfos;

/**
 * 排序工具类
 * 
 * @since 2.0
 */
public final class QuerySortInfos {

	private QuerySortInfos() {
	}

	/**
	 * @param querySortInfo 查询排序信息
	 * @return 排序信息
	 */
	public static Sort toSort(QuerySortInfo querySortInfo) {
		return DFQuerySortInfos.toSort(querySortInfo);
	}

	/**
	 * @param querySortInfo 查询排序信息集合
	 * @return 排序信息集合
	 */
	public static List<Sort> toSort(List<QuerySortInfo> querySortInfos) {
		return DFQuerySortInfos.toSort(querySortInfos);
	}

}
