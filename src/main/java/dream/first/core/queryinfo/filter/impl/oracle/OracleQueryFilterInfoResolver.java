/**
 * 
 */
package dream.first.core.queryinfo.filter.impl.oracle;

import dream.first.base.queryinfo.filter.impl.oracle.DFOracleQueryFilterInfoResolver;
import dream.first.core.queryinfo.filter.QueryFilterInfoResolver;

/**
 * oracle 查询过滤信息解析器
 * 
 * @since 1.0.0
 */
public class OracleQueryFilterInfoResolver extends DFOracleQueryFilterInfoResolver implements QueryFilterInfoResolver {

	public static final OracleQueryFilterInfoResolver INSTANCE = new OracleQueryFilterInfoResolver();
	
}
