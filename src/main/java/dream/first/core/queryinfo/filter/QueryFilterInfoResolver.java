/**
 * 
 */
package dream.first.core.queryinfo.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.yelong.core.annotation.Nullable;
import org.yelong.core.jdbc.sql.condition.support.Condition;

/**
 * 查询过滤信息解析器
 * 
 * @since 1.0.0
 */
public interface QueryFilterInfoResolver {

	/**
	 * 解析多个查询过滤信息为多个条件信息
	 * 
	 * @param queryFilterInfos 查询过滤信息集合
	 * @return 条件信息集合
	 * @throws QueryFilterInfoResolveException 如果查询过滤信息解析异常
	 */
	default List<Condition> resolve(@Nullable List<QueryFilterInfo> queryFilterInfos)
			throws QueryFilterInfoResolveException {
		if (CollectionUtils.isEmpty(queryFilterInfos)) {
			return Collections.emptyList();
		}
		List<Condition> conditions = new ArrayList<Condition>(queryFilterInfos.size());
		queryFilterInfos.forEach(x -> conditions.add(resolve(x)));
		return conditions;
	}

	/**
	 * 解析查询过滤信息为条件信息
	 * 
	 * @param queryFilterInfo 查询过滤信息
	 * @return 条件信息
	 * @throws QueryFilterInfoResolveException 如果查询过滤信息解析异常
	 */
	Condition resolve(QueryFilterInfo queryFilterInfo) throws QueryFilterInfoResolveException;

}
