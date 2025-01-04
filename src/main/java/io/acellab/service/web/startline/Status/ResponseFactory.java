package io.acellab.service.web.startline.Status;

import java.util.List;

public class ResponseFactory<T> {
	
	private Status status;
	private List<T> returnDataList = null;
	private Object[] returnDataObjects = null;
	
	
	//Example access: Status.ERROR.getStatusCode()
	public void setStatus(Status status) {this.status = status;}
	public int getStatusCode() {return this.status.getStatusCode();}
	public String getStatusMessage() {return this.status.getStatusMessage();}

	public void setReturnDataList(List<T> returnDataList) {this.returnDataList = returnDataList;}
	public List<T> getReturnDataList() {return this.returnDataList;}
	
	public void setReturnDataObjects(Object[] objects) {this.returnDataObjects = objects;}
	public Object[] getReturnDataObjects() {return this.returnDataObjects;}
	
}