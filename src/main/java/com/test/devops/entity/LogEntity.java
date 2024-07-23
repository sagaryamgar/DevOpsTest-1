package com.test.devops.entity;

public class LogEntity {
	
	String id;
	String host;
	String type;
	String state;
	String timestamp;
	
	public LogEntity() {
		// TODO Auto-generated constructor stub
	}

	public LogEntity(String id, String host, String type, String state, String timestamp) {
		super();
		this.id = id;
		this.host = host;
		this.type = type;
		this.state = state;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "LogEntity [id=" + id + ", host=" + host + ", type=" + type + ", state=" + state + ", timestamp="
				+ timestamp + "]";
	}
	
	

}
