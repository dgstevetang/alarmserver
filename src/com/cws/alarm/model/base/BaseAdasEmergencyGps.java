package com.cws.alarm.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseAdasEmergencyGps<M extends BaseAdasEmergencyGps<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Long id) {
		set("id", id);
		return (M)this;
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public M setDeviceSn(java.lang.String deviceSn) {
		set("deviceSn", deviceSn);
		return (M)this;
	}

	public java.lang.String getDeviceSn() {
		return get("deviceSn");
	}

	public M setEventid(java.lang.Long eventid) {
		set("eventid", eventid);
		return (M)this;
	}

	public java.lang.Long getEventid() {
		return get("eventid");
	}

	public M setOccurtime(java.util.Date occurtime) {
		set("occurtime", occurtime);
		return (M)this;
	}

	public java.util.Date getOccurtime() {
		return get("occurtime");
	}

	public M setLatitude(java.math.BigDecimal latitude) {
		set("latitude", latitude);
		return (M)this;
	}

	public java.math.BigDecimal getLatitude() {
		return get("latitude");
	}

	public M setLongitude(java.math.BigDecimal longitude) {
		set("longitude", longitude);
		return (M)this;
	}

	public java.math.BigDecimal getLongitude() {
		return get("longitude");
	}

	public M setAltitude(java.math.BigDecimal altitude) {
		set("altitude", altitude);
		return (M)this;
	}

	public java.math.BigDecimal getAltitude() {
		return get("altitude");
	}

	public M setStatus(java.lang.Integer status) {
		set("status", status);
		return (M)this;
	}

	public java.lang.Integer getStatus() {
		return get("status");
	}

	public M setDirect(java.lang.Integer direct) {
		set("direct", direct);
		return (M)this;
	}

	public java.lang.Integer getDirect() {
		return get("direct");
	}

	public M setSpeed(java.lang.Integer speed) {
		set("speed", speed);
		return (M)this;
	}

	public java.lang.Integer getSpeed() {
		return get("speed");
	}

	public M setStarNum(java.lang.Integer starNum) {
		set("starNum", starNum);
		return (M)this;
	}

	public java.lang.Integer getStarNum() {
		return get("starNum");
	}

	public M setStarInViewNum(java.lang.Integer StarInViewNum) {
		set("StarInViewNum", StarInViewNum);
		return (M)this;
	}

	public java.lang.Integer getStarInViewNum() {
		return get("StarInViewNum");
	}

}
