/**
 * 
 */
package com.rewards.program.model;

/**
 * @author abhir
 * Model class for maintaining Generic Response and align across the API requests
 */
public class GenericResponse {
	
	private String timeStamp;
	private String status;
	private String error;
	private String message;
	private String path;
	
	
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "GenericResponse [timeStamp=" + timeStamp + ", status=" + status + ", error=" + error + ", message="
				+ message + ", path=" + path + "]";
	}
	
	
	

}
