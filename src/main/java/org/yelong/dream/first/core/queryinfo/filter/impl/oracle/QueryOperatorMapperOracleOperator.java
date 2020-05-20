/**
 * 
 */
package org.yelong.dream.first.core.queryinfo.filter.impl.oracle;

import java.util.HashMap;
import java.util.Map;

import org.yelong.dream.first.core.queryinfo.QueryOperator;
import org.yelong.support.database.oracle.OracleConditionOperator;

/**
 * QueryOperator与Oracle条件运算符的映射
 * @author PengFei
 * @since 1.0.0
 */
public class QueryOperatorMapperOracleOperator {

	public static final Map<QueryOperator,OracleConditionOperator> MAPPER = new HashMap<QueryOperator,OracleConditionOperator>();
	
	static {
		MAPPER.put(QueryOperator.ENDWITH, OracleConditionOperator.LESS_THAN_OR_EQUAL);
		MAPPER.put(QueryOperator.EQ, OracleConditionOperator.EQUAL);
		MAPPER.put(QueryOperator.IS, OracleConditionOperator.IS_NULL);
		MAPPER.put(QueryOperator.ISN, OracleConditionOperator.IS_NOT_NULL);
		MAPPER.put(QueryOperator.LIKE, OracleConditionOperator.LIKE);
		MAPPER.put(QueryOperator.NEQ, OracleConditionOperator.NOT_EQUAL);
		MAPPER.put(QueryOperator.NLIKE, OracleConditionOperator.NOT_LIKE);
		MAPPER.put(QueryOperator.STARTWITH, OracleConditionOperator.GREATER_THAN_OR_EQUAL);
		MAPPER.put(QueryOperator.GTE, OracleConditionOperator.GREATER_THAN_OR_EQUAL);
		MAPPER.put(QueryOperator.LTE, OracleConditionOperator.LESS_THAN_OR_EQUAL);
		MAPPER.put(QueryOperator.BETWEEN, OracleConditionOperator.BETWEEN);
		MAPPER.put(QueryOperator.IN, OracleConditionOperator.IN);
		MAPPER.put(QueryOperator.NIN, OracleConditionOperator.NOT_IN);
	}
	
	/**
	 * 获取查询条件映射的oracle条件运算符
	 * @param queryOperator 查询运算符
	 * @return oracle运算符
	 */
	public static final OracleConditionOperator mapperOracleConditionOperator(QueryOperator queryOperator) {
		return MAPPER.get(queryOperator);
	}
	
}
