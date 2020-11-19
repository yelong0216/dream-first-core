/**
 * 
 */
package dream.first.core.queryinfo;

import dream.first.base.queryinfo.DFQueryOperator;

/**
 * 前端传递查询条件字典
 * 
 * @since 1.0.0
 * @see DFQueryOperator
 */
public enum QueryOperator {

	/** 包含 */
	LIKE(DFQueryOperator.LIKE),
	/** 不包含 */
	NLIKE(DFQueryOperator.NLIKE),
	/** 等与 */
	EQ(DFQueryOperator.EQ),
	/** 不等与 */
	NEQ(DFQueryOperator.NEQ),
	/** 为空 */
	IS(DFQueryOperator.IS),
	/** 不为空 */
	ISN(DFQueryOperator.ISN),
	/** 开始于 */
	STARTWITH(DFQueryOperator.STARTWITH),
	/** 结束于 */
	ENDWITH(DFQueryOperator.ENDWITH),
	/** 不早于 */
	GTE(DFQueryOperator.GTE),
	/** 不晚于 */
	LTE(DFQueryOperator.LTE),
	/** 介于 */
	BETWEEN(DFQueryOperator.BETWEEN),
	/** 在范围内 */
	IN(DFQueryOperator.IN),
	/** 不在范围内 */
	NIN(DFQueryOperator.NIN);

	public final DFQueryOperator dfQueryOperator;

	private QueryOperator(DFQueryOperator dfQueryOperator) {
		this.dfQueryOperator = dfQueryOperator;
	}

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
