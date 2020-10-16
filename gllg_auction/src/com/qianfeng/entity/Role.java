package com.qianfeng.entity;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

	private int id;
	private String roleName;
	private List<Resource> resource;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<Resource> getResource() {
		return resource;
	}
	public void setResource(List<Resource> resource) {
		this.resource = resource;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", resource="
				+ resource + "]";
	}
	
	
}
