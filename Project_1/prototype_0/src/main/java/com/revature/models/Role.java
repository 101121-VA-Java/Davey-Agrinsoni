package com.revature.models;

public class Role {
	private int userRoleId;
	private String role;
	
	public Role(int userRoleId, String role) {
		super();
		this.userRoleId = userRoleId;
		this.role = role;
	}

	public Role(int userRoleId) {
		super();
		this.userRoleId = userRoleId;
	}
	
	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [userRoleId=" + userRoleId + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + userRoleId;
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
		Role other = (Role) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}
}


