/**
 * 
 */
package dream.first.core.queryinfo;

/**
 * 前端传递查询条件字典
 * 
 * @since 1.0.0
 */
public enum QueryOperator {

	/** 包含 */
	LIKE,
	/** 不包含 */
	NLIKE,
	/** 等与 */
	EQ,
	/** 不等与 */
	NEQ,
	/** 为空 */
	IS,
	/** 不为空 */
	ISN,
	/** 开始于 */
	STARTWITH,
	/** 结束于 */
	ENDWITH,
	/** 不早于 */
	GTE,
	/** 不晚于 */
	LTE,
	/** 介于 */
	BETWEEN,
	/** 在范围内 */
	IN,
	/** 不在范围内 */
	NIN;

	/**
	 * 解析queryOperator为QueryOperator对象。规则：如果queryOperator于QueryOperator常量名字相同
	 * 
	 * @param queryOperator 查询运算符
	 * @return 查询运算符
	 */
	public static QueryOperator parse(String queryOperator) {
		try {
			return QueryOperator.valueOf(queryOperator.toUpperCase());
		} catch (Exception e) {
			return null;
		}
	}

}
