/**
 * 
 */
package org.yelong.dream.first.core.platform.dict.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;
import org.yelong.dream.first.core.model.BaseModel;

/**
 * 字典
 * 
 * @author PengFei
 * @since 1.0.0
 */
@Table(value = "CO_DICT",alias = "dict",desc = "字典")
public class Dict extends BaseModel implements Comparable<Dict>{

	private static final long serialVersionUID = -2071619377428135699L;

	@Column(columnName = "字典类型")
	private String dictType;
	
	@Column(columnName = "字典值")
	private String dictValue;
	
	@Column(columnName = "字典显示文本")
	private String dictText;
	
	@Column(columnName = "字典排序")
	private Integer dictOrder;

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public String getDictText() {
		return dictText;
	}

	public void setDictText(String dictText) {
		this.dictText = dictText;
	}

	public Integer getDictOrder() {
		return dictOrder;
	}

	public void setDictOrder(Integer dictOrder) {
		this.dictOrder = dictOrder;
	}

	@Override
	public String toString() {
		return "Dict [dictType=" + dictType + ", dictValue=" + dictValue + ", dictText=" + dictText + ", dictOrder="
				+ dictOrder + "]";
	}

	@Override
	public int compareTo(Dict o) {
		if( o.dictOrder == null ) {
			return 1;
		} else if( this.dictOrder == null ) {
			return -1;
		} else {
			return Integer.compare(this.dictOrder,o.dictOrder);
		}
	}
	
}
