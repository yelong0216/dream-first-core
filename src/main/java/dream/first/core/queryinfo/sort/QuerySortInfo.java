/**
 * 
 */
package dream.first.core.queryinfo.sort;

/**
 * 排序信息
 * 
 * @author PengFei
 * @since 1.0.0
 */
public class QuerySortInfo {

	private String sortField;

	private String direction;

	public QuerySortInfo() {

	}

	/**
	 * @param sortField 排序字段
	 * @param direction 排序方向
	 */
	public QuerySortInfo(String sortField, String direction) {
		this.sortField = sortField;
		this.direction = direction;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
