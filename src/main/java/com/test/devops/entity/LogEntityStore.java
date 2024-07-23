package com.test.devops.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class LogEntityStore {
	@Id
	String eventId;
	String type;
	String host;
	Long timeInMillis;
	Boolean alert;
	
	
	public LogEntityStore() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LogEntityStore(String eventId, String type, String host, Long timeInMillis, Boolean alert) {
		super();
		this.eventId = eventId;
		this.type = type;
		this.host = host;
		this.timeInMillis = timeInMillis;
		this.alert = alert;
	}


	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Long getTimeInMillis() {
		return timeInMillis;
	}
	public void setTimeInMillis(Long timeInMillis) {
		this.timeInMillis = timeInMillis;
	}
	public Boolean getAlert() {
		return alert;
	}
	public void setAlert(Boolean alert) {
		this.alert = alert;
	}
	
	

}
