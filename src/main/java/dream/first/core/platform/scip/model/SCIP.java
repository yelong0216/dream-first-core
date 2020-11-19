package dream.first.core.platform.scip.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import dream.first.core.model.BaseModel;

/**
 * co_sc_ip 系统访问IP地址配置
 */
@Table(value = "co_sc_ip", alias = "sCIP", desc = "系统访问IP地址配置")
public class SCIP extends BaseModel<SCIP> {

	private static final long serialVersionUID = -6210825643424943919L;

	@Column(column = "ipType", maxLength = 2, allowNull = true, columnName = "地址类型")
	private String ipType;

	@Column(column = "startIp", maxLength = 32, allowNull = true, columnName = "起始地址")
	private String startIp;

	@Column(column = "endIp", maxLength = 32, allowNull = true, columnName = "结束地址")
	private String endIp;

	@Column(column = "remark", maxLength = 256, columnName = "说明")
	private String remark;

	/**
	 * @return 地址类型
	 */
	public String getIpType() {
		return ipType;
	}

	/**
	 * @param ipType 地址类型
	 */
	public void setIpType(String ipType) {
		this.ipType = ipType;
	}

	/**
	 * @return 起始地址
	 */
	public String getStartIp() {
		return startIp;
	}

	/**
	 * @param startIp 起始地址
	 */
	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}

	/**
	 * @return 结束地址
	 */
	public String getEndIp() {
		return endIp;
	}

	/**
	 * @param endIp 结束地址
	 */
	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}

	/**
	 * @return 说明
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark 说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
