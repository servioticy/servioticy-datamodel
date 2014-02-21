package com.servioticy.datamodel;

public class UpdateDescriptor {
	String opid;
	String soid;
	String streamid;
	SensorUpdate su;
	/**
	 * @return the opid
	 */
	public String getOpid() {
		return opid;
	}
	/**
	 * @param opid the opid to set
	 */
	public void setOpid(String opid) {
		this.opid = opid;
	}
	/**
	 * @return the soid
	 */
	public String getSoid() {
		return soid;
	}
	/**
	 * @param soid the soid to set
	 */
	public void setSoid(String soid) {
		this.soid = soid;
	}
	/**
	 * @return the streamid
	 */
	public String getStreamid() {
		return streamid;
	}
	/**
	 * @param streamid the streamid to set
	 */
	public void setStreamid(String streamid) {
		this.streamid = streamid;
	}
	/**
	 * @return the su
	 */
	public SensorUpdate getSu() {
		return su;
	}
	/**
	 * @param su the su to set
	 */
	public void setSu(SensorUpdate su) {
		this.su = su;
	}
	
	
}
