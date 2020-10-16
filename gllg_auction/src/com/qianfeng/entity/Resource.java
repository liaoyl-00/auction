package com.qianfeng.entity;

import java.io.Serializable;

public class Resource implements Serializable {
	
	private int id;
	private String resourceName;
	private String resourcePath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourcePath() {
		return resourcePath;
	}
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", resourceName=" + resourceName
				+ ", resourcePath=" + resourcePath + "]";
	}
	
	
}
