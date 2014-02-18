package com.servioticy.datamodel;

import java.util.LinkedHashMap;

public class HttpSubscription extends ExternalSubscription {
	private class HSCustomFields extends ExternalSubscription.ESCustomFields{
		private LinkedHashMap <String, String> headers;
		private String method;
		public LinkedHashMap<String, String> getHeaders() {
			return headers;
		}
		public void setHeaders(LinkedHashMap<String, String> headers) {
			this.headers = headers;
		}
		public String getMethod() {
			return method;
		}
		public void setMethod(String method) {
			this.method = method;
		}
	}
	private HSCustomFields customFields;

	public HSCustomFields getCustomFields() {
		return customFields;
	}
	public void setCustomFields(HSCustomFields customFields) {
		this.customFields = customFields;
	}
	public LinkedHashMap<String, String> getHeaders() {
		if(this.getCustomFields() == null){
			return null;
		}
		return this.getCustomFields().getHeaders();
	}
	public void setHeaders(LinkedHashMap<String, String> headers) {
		if(this.getCustomFields() == null){
			this.setCustomFields(new HSCustomFields());
		}
		this.getCustomFields().setHeaders(headers);
	}
	public String getMethod(){
		if(this.getCustomFields() == null){
			return null;
		}
		return this.getCustomFields().getMethod();
	}
	public void setMethod(String method){
		if(this.getCustomFields() == null){
			this.setCustomFields(new HSCustomFields());
		}
		this.getCustomFields().setMethod(method);
	}
}
