/**
 * 
 */
package dream.first.core.queryinfo.filter;

import java.util.Arrays;

import dream.first.base.queryinfo.filter.DFQueryFilterInfo;

/**
 * @since 1.0.0
 * @see DFQueryFilterInfo
 */
public class QueryFilterInfo extends DFQueryFilterInfo {

	public QueryFilterInfo(String fieldName, String operator) {
		this.fieldName = fieldName;
		this.operator = operator;
	}

	public QueryFilterInfo(String fieldName, String operator, Object value) {
		this.fieldName = fieldName;
		this.operator = operator;
		this.fieldValue = value;
	}

	public QueryFilterInfo(String fieldName, String operator, Object value, Object secondValue) {
		this.fieldName = fieldName;
		this.operator = operator;
		this.fieldValue = Arrays.asList(value, secondValue);
	}

	public QueryFilterInfo(DFQueryFilterInfo queryFilterInfo) {
		this.connectOperator = queryFilterInfo.getConnectOperator();
		this.fieldName = queryFilterInfo.getFieldName();
		this.fieldType = queryFilterInfo.getFieldType();
		this.fieldTypeStr = queryFilterInfo.getFieldTypeStr();
		this.fieldValue = queryFilterInfo.getFieldValue();
		this.groupName = queryFilterInfo.getGroupName();
		this.operator = queryFilterInfo.getOperator();
	}

}
