package com.myideaway.server.framework.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Description:用户实体（use to demo）
 * </p>
 * 
 * @author charles.chen on 2012-7-16
 **/
public class EntityUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6504236188401035974L;
	private String entityId;
	private String loginName;
	private String loginPassword;
	private String nickName;
	private Date createDate;

	public EntityUser(String entityId, String loginName, String loginPassword, String nickName, Date createDate) {
		this.entityId = entityId;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.nickName = nickName;
		this.createDate = createDate;
	}

	public EntityUser() {
	}

	public EntityUser(String entityId) {
		this.entityId = entityId;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
		result = prime * result + ((loginPassword == null) ? 0 : loginPassword.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityUser other = (EntityUser) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		if (loginPassword == null) {
			if (other.loginPassword != null)
				return false;
		} else if (!loginPassword.equals(other.loginPassword))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntityUser [entityId=" + entityId + ", loginName=" + loginName + ", loginPassword=" + loginPassword + ", nickName="
				+ nickName + ", createDate=" + createDate + ", getEntityId()=" + getEntityId() + ", getLoginName()=" + getLoginName()
				+ ", getLoginPassword()=" + getLoginPassword() + ", getNickName()=" + getNickName() + ", getCreateDate()="
				+ getCreateDate() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}
