/**
 * 
 */
package org.yelong.dream.first.core.platform.user.model;

import java.util.Date;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;
import org.yelong.core.model.annotation.Transient;
import org.yelong.dream.first.core.model.BaseModel;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2019年12月5日下午2:04:40
 */
@Table(value = "CO_USER",alias = "usr")
public class User extends BaseModel{

	private static final long serialVersionUID = 4722398860035012945L;

	@Column(columnName = "用户名称")
	private String username;
	
	@Column(columnName = "密码")
	private String password;

	@Column(columnName = "用户真实名称")
    private String realName;

	@Column(columnName = "性别")
    private String gender;

	@Column(columnName = "组织id")
    private String orgId;

	@Column(columnName = "")
    private String post;

	@Column(columnName = "")
    private String title;

	@Column(columnName = "手机号")
    private String tel;

	@Column(columnName = "电话号")
    private String mobile;

	@Column(columnName = "传真号")
    private String fax;

	@Column(columnName = "E-mail")
    private String email;

	@Column(columnName = "")
    private String office;
	
	@Column(columnName = "")
    private String workState;

	@Column(columnName = "备注")
    private String remark;
    
	@Column(columnName = "用户编码")
    private String nameCode;

	@Column(columnName = "初始化状态")
    private String initState;

	@Column(columnName = "是否锁定")
    private String isLock;

	@Column(columnName = "登录失败次数")
    private Integer loginFailTimes;

	@Column(columnName = "是否时超级管理员")
    private String isSuper;

	@Column(columnName = "密码签名")
    private String pwdSign;

	@Column(columnName = "密码修改日期")
    private Date pwdUpdateTime;

	@Column(columnName = "")
    private Integer pwdExpireDuration;

	@Column(columnName = "锁定时间")
    private Date lockTime;

	@Column(columnName = "身份证")
    private String idCard;

	@Column(columnName = "最后登录时间")
    private Date lastLoginTime;
	
    /**
     * @since 1.0.7
     */
	@Deprecated
    @Column(columnName = "人员ID")
	@Transient
    private String employeeId;
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNameCode() {
		return nameCode;
	}

	public void setNameCode(String nameCode) {
		this.nameCode = nameCode;
	}

	public String getInitState() {
		return initState;
	}

	public void setInitState(String initState) {
		this.initState = initState;
	}

	public String getIsLock() {
		return isLock;
	}

	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}

	public Integer getLoginFailTimes() {
		return loginFailTimes;
	}

	public void setLoginFailTimes(Integer loginFailTimes) {
		this.loginFailTimes = loginFailTimes;
	}

	public String getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(String isSuper) {
		this.isSuper = isSuper;
	}

	public String getPwdSign() {
		return pwdSign;
	}

	public void setPwdSign(String pwdSign) {
		this.pwdSign = pwdSign;
	}

	public Date getPwdUpdateTime() {
		return pwdUpdateTime;
	}

	public void setPwdUpdateTime(Date pwdUpdateTime) {
		this.pwdUpdateTime = pwdUpdateTime;
	}

	public Integer getPwdExpireDuration() {
		return pwdExpireDuration;
	}

	public void setPwdExpireDuration(Integer pwdExpireDuration) {
		this.pwdExpireDuration = pwdExpireDuration;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
}
