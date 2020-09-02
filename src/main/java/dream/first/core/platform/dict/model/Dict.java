/**
 * 
 */
package dream.first.core.platform.dict.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;
import org.yelong.core.support.Dictionary.DictionaryAttribute;

import dream.first.core.model.BaseModel;

/**
 * 字典
 * 
 * @since 1.0.0
 */
@Table(value = "CO_DICT", alias = "dict", desc = "字典")
public class Dict extends BaseModel<Dict> implements Comparable<Dict>, DictionaryAttribute<String, String> {

	private static final long serialVersionUID = -2071619377428135699L;

	@Column(column = "dictType", maxLength = 128, columnName = "字典类型")
	private String dictType;

	@Column(column = "dictValue", maxLength = 128, columnName = "字典值")
	private String dictValue;

	@Column(column = "dictText", maxLength = 128, columnName = "显示内容")
	private String dictText;

	@Column(column = "dictOrder", columnName = "顺序")
	private Integer dictOrder;

	/**
	 * @return 字典类型
	 */
	public String getDictType() {
		return dictType;
	}

	/**
	 * @param dictType 字典类型
	 */
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	/**
	 * @return 字典值
	 */
	public String getDictValue() {
		return dictValue;
	}

	/**
	 * @param dictValue 字典值
	 */
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	/**
	 * @return 显示内容
	 */
	public String getDictText() {
		return dictText;
	}

	/**
	 * @param dictText 显示内容
	 */
	public void setDictText(String dictText) {
		this.dictText = dictText;
	}

	/**
	 * @return 顺序
	 */
	public Integer getDictOrder() {
		return dictOrder;
	}

	/**
	 * @param dictOrder 顺序
	 */
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
		if (o.dictOrder == null) {
			return 1;
		} else if (this.dictOrder == null) {
			return -1;
		} else {
			return Integer.compare(this.dictOrder, o.dictOrder);
		}
	}

	@Override
	public String getValue() {
		return getDictValue();
	}

	@Override
	public String getContent() {
		return getDictText();
	}

	@Override
	public int getOrder() {
		return getDictOrder() == null ? LOWEST_PRECEDENCE : getDictOrder();
	}

}
