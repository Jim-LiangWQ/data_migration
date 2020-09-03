package com.pccw.data.migration.entity.ams;

import com.pccw.data.migration.constants.DataSourceSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:23
 **/

/**
 * The persistent class for the COMMON_USER database table.
 * 
 */
@Entity
@Table(name="COMMON_USER",schema = DataSourceSchema.SCHEMA_GOLD_RESOURCE)
//@NamedQuery(name="AmsUser.findAll", query="SELECT c FROM CommonUser c")
public class AmsUser implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String STATUS_PENDING = "P";
	public static final String STATUS_ACTIVE = "A";
	public static final String STATUS_DELETE = "D";
	public static final String STATUS_BLOCK = "B";
	public static final String STATUS_ALL = "ALL";
	public static final int ID_GENERATION_LENGTH = 10;

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	private String id;

	@Column(name="COUNT")
	private Integer count;

	@Column(name="CREATE_STAFF")
	private String createStaff;

	@Column(name="CREATE_TIMESTAMP")
	private Timestamp createTimestamp;

	private String email;

	@Column(name="EMPLOYEE_ID")
	private String employeeId;

	private String enabled;

	@Column(name="HASH_PASSWORD")
	private String hashPassword;

	@Column(name="LAST_LOGIN_TIME")
	private Timestamp lastLoginTime;

	@Column(name="LOGIN_NAME")
	private String loginName;

	private String mobile;

	@Column(name="MODIFY_STAFF")
	private String modifyStaff;

	@Column(name="NICK_NAME")
	private String nickName;

	private String remark;

	@Column(name="UPDATE_TIMESTAMP")
	private Timestamp updateTimestamp;

	private String username;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "LOGIN_STATE")
	private String loginState;

	@Column(name = "EXTERNAL_ID")
	private Long externalId;

	public AmsUser() {
	}

	@Override
	public String toString() {
		return "AmsUser{" +
				"id='" + id + '\'' +
				", count=" + count +
				", createStaff='" + createStaff + '\'' +
				", createTimestamp=" + createTimestamp +
				", email='" + email + '\'' +
				", employeeId='" + employeeId + '\'' +
				", enabled='" + enabled + '\'' +
				", hashPassword='" + hashPassword + '\'' +
				", lastLoginTime=" + lastLoginTime +
				", loginName='" + loginName + '\'' +
				", mobile='" + mobile + '\'' +
				", modifyStaff='" + modifyStaff + '\'' +
				", nickName='" + nickName + '\'' +
				", remark='" + remark + '\'' +
				", updateTimestamp=" + updateTimestamp +
				", username='" + username + '\'' +
				", status='" + status + '\'' +
				", loginState='" + loginState + '\'' +
				", externalId=" + externalId +
				'}';
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCreateStaff() {
		return this.createStaff;
	}

	public void setCreateStaff(String createStaff) {
		this.createStaff = createStaff;
	}

	public Timestamp getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getHashPassword() {
		return this.hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getModifyStaff() {
		return this.modifyStaff;
	}

	public void setModifyStaff(String modifyStaff) {
		this.modifyStaff = modifyStaff;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginState() {
		return loginState;
	}

	public void setLoginState(String loginState) {
		this.loginState = loginState;
	}

	public Long getExternalId() {
		return externalId;
	}

	public void setExternalId(Long externalId) {
		this.externalId = externalId;
	}
}