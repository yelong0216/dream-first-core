/**
 * 
 */
package dream.first.core.queryinfo.filter.impl.oracle;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.sql.condition.ConditionConnectWay;
import org.yelong.core.jdbc.sql.condition.support.Condition;
import org.yelong.support.database.oracle.OracleConditionOperator;

import dream.first.core.queryinfo.QueryOperator;
import dream.first.core.queryinfo.filter.QueryFilterInfo;
import dream.first.core.queryinfo.filter.QueryFilterInfoResolveException;
import dream.first.core.queryinfo.filter.QueryFilterInfoResolver;

/**
 * oracle 查询过滤信息解析器
 * 
 * @since 1.0.0
 */
public class OracleQueryFilterInfoResolver implements QueryFilterInfoResolver {

	public static final OracleQueryFilterInfoResolver INSTANCE = new OracleQueryFilterInfoResolver();
	
	@SuppressWarnings("unchecked")
	@Override
	public Condition resolve(QueryFilterInfo queryFilterInfo) throws QueryFilterInfoResolveException {
		Objects.requireNonNull(queryFilterInfo);
		String fieldName = queryFilterInfo.getFieldName();
		String operator = queryFilterInfo.getOperator();
		Object value = queryFilterInfo.getFieldValue();
		QueryOperator queryOperator = QueryOperator.parse(operator);
		// 解析为oracle的运算符
		OracleConditionOperator oracleConditionOperator = QueryOperatorMapperOracleOperator
				.mapperOracleConditionOperator(queryOperator);
		if (null == oracleConditionOperator) {
			throw new QueryFilterInfoResolveException("非法的运算符：" + operator);
		}
		operator = oracleConditionOperator.getOperator();

		Integer needValueNum = oracleConditionOperator.getNeedValueNum();
		Condition condition = null;
		if (needValueNum == 0) {
			condition = new Condition(fieldName, operator);
		} else if (needValueNum == 2) {
			if (!value.getClass().isArray() && !(value instanceof List)) {// 如果value不是数组也不是集合
				throw new QueryFilterInfoResolveException("当前运算符（" + operator + "）需要集合或者数组类型的参数。但是value=" + value);
			}
			List<Object> valueList = null;
			if (value.getClass().isArray()) {
				valueList = Arrays.asList(value);
			} else {
				valueList = (List<Object>) value;
			}
			condition = new Condition(fieldName, operator, valueList.get(0), valueList.get(1));
		} else {
			if (value instanceof CharSequence) {
				String valueStr = value.toString();
				if (queryOperator == QueryOperator.LIKE || queryOperator == QueryOperator.NLIKE) {
					if (valueStr.startsWith("%") || valueStr.endsWith("%")) {

					} else {
						if (!valueStr.startsWith("%")) {
							valueStr = "%" + valueStr;
						}
						if (!valueStr.endsWith("%")) {
							valueStr = valueStr + "%";
						}
					}
				}
				value = valueStr;
			}
			condition = new Condition(fieldName, operator, value);
		}
		condition.setGroupName(queryFilterInfo.getGroupName());
		if (StringUtils.isNotEmpty(queryFilterInfo.getConnectOperator())) {
			condition.setConnectWay(ConditionConnectWay.valueOf(queryFilterInfo.getConnectOperator().toUpperCase()));
		}
		return condition;
	}

}
