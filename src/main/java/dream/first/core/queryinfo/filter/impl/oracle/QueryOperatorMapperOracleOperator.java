/**
 * 
 */
package dream.first.core.queryinfo.filter.impl.oracle;

import org.yelong.support.database.oracle.OracleConditionOperator;

import dream.first.base.queryinfo.filter.impl.oracle.DFQueryOperatorMapperOracleOperator;
import dream.first.core.queryinfo.QueryOperator;

/**
 * QueryOperator与Oracle条件运算符的映射
 * 
 * @since 1.0.0
 */
public class QueryOperatorMapperOracleOperator {

	/**
	 * 获取查询条件映射的oracle条件运算符
	 * 
	 * @param queryOperator 查询运算符
	 * @return oracle运算符
	 */
	public static final OracleConditionOperator mapperOracleConditionOperator(QueryOperator queryOperator) {
		return DFQueryOperatorMapperOracleOperator.mapperOracleConditionOperator(queryOperator.dfQueryOperator);
	}

}
