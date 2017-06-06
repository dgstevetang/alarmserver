package com.cws.alarm.model.base;

import com.easyj.core.model.BaseModel;
import com.jfinal.plugin.activerecord.Model;

/**
 * 表名：qood_user_vehicle <br>
 *
 * 该文件系统自动生成!请勿修改<br>
 * Model请继承该表模型!<br>
 * @author Mr.Can
 *
 */
public abstract class BaseQoodUserVehicle<M extends Model<M>,PK> extends BaseModel<M,PK>{
	public static final String TB_NAME="qood_user_vehicle";

	/** 获取 Qood设备的车辆ID */
	public Long getQoodVehicleId(){
		return getT("qoodVehicleId");
	}

	/** 设置 Qood设备的车辆ID */
	public BaseQoodUserVehicle setQoodVehicleId(Long qoodVehicleId){
		set("qoodVehicleId",qoodVehicleId);
		return this;
	}

	/** 获取 QOOD用户ID */
	public Long getQoodUserId(){
		return getT("qoodUserId");
	}

	/** 设置 QOOD用户ID */
	public BaseQoodUserVehicle setQoodUserId(Long qoodUserId){
		set("qoodUserId",qoodUserId);
		return this;
	}

	/** 获取 渠道ID */
	public Integer getChannelId(){
		return getT("channel_id");
	}

	/** 设置 渠道ID */
	public BaseQoodUserVehicle setChannelId(Integer channelId){
		set("channel_id",channelId);
		return this;
	}

	/** 获取 设备序列号 */
	public String getSn(){
		return getT("sn");
	}

	/** 设置 设备序列号 */
	public BaseQoodUserVehicle setSn(String sn){
		set("sn",sn);
		return this;
	}

	/** 获取 硬件ID */
	public String getHwId(){
		return getT("hw_id");
	}

	/** 设置 硬件ID */
	public BaseQoodUserVehicle setHwId(String hwId){
		set("hw_id",hwId);
		return this;
	}

	/** 获取 设备ID */
	public String getDeviceId(){
		return getT("device_id");
	}

	/** 设置 设备ID */
	public BaseQoodUserVehicle setDeviceId(String deviceId){
		set("device_id",deviceId);
		return this;
	}

	/** 获取 设备类型 */
	public String getDeviceType(){
		return getT("deviceType");
	}

	/** 设置 设备类型 */
	public BaseQoodUserVehicle setDeviceType(String deviceType){
		set("deviceType",deviceType);
		return this;
	}

	/** 获取 车牌号码 */
	public String getPlate(){
		return getT("plate");
	}

	/** 设置 车牌号码 */
	public BaseQoodUserVehicle setPlate(String plate){
		set("plate",plate);
		return this;
	}

	/** 获取 发动机 */
	public String getEngineNo(){
		return getT("engineNo");
	}

	/** 设置 发动机 */
	public BaseQoodUserVehicle setEngineNo(String engineNo){
		set("engineNo",engineNo);
		return this;
	}

	/** 获取 车辆识别代号 */
	public String getVin(){
		return getT("vin");
	}

	/** 设置 车辆识别代号 */
	public BaseQoodUserVehicle setVin(String vin){
		set("vin",vin);
		return this;
	}

	/** 获取 车辆登记证书号 */
	public String getCertId(){
		return getT("certId");
	}

	/** 设置 车辆登记证书号 */
	public BaseQoodUserVehicle setCertId(String certId){
		set("certId",certId);
		return this;
	}

	/** 获取 车辆型号ID */
	public String getVehicleModelId(){
		return getT("vehicleModelId");
	}

	/** 设置 车辆型号ID */
	public BaseQoodUserVehicle setVehicleModelId(String vehicleModelId){
		set("vehicleModelId",vehicleModelId);
		return this;
	}

	/** 获取 购车日期 */
	public java.util.Date getPurchaseDate(){
		return getT("purchaseDate");
	}

	/** 设置 购车日期 */
	public BaseQoodUserVehicle setPurchaseDate(java.util.Date purchaseDate){
		set("purchaseDate",purchaseDate);
		return this;
	}

	/** 获取 保险到期日期 */
	public java.util.Date getExpireDate(){
		return getT("expireDate");
	}

	/** 设置 保险到期日期 */
	public BaseQoodUserVehicle setExpireDate(java.util.Date expireDate){
		set("expireDate",expireDate);
		return this;
	}

	/** 获取 行驶证图片路径 */
	public String getDrivingLicenseImage(){
		return getT("drivingLicenseImage");
	}

	/** 设置 行驶证图片路径 */
	public BaseQoodUserVehicle setDrivingLicenseImage(String drivingLicenseImage){
		set("drivingLicenseImage",drivingLicenseImage);
		return this;
	}

	/** 获取 车牌照片 */
	public String getPlateImage(){
		return getT("plateImage");
	}

	/** 设置 车牌照片 */
	public BaseQoodUserVehicle setPlateImage(String plateImage){
		set("plateImage",plateImage);
		return this;
	}

	/** 获取 核审状态(1.未审，2.审核失败，3.审核通过) */
	public Integer getChecked(){
		return getT("checked");
	}

	/** 设置 核审状态(1.未审，2.审核失败，3.审核通过) */
	public BaseQoodUserVehicle setChecked(Integer checked){
		set("checked",checked);
		return this;
	}

	/** 获取 创建时间 */
	public java.util.Date getCreatetime(){
		return getT("createtime");
	}

	/** 设置 创建时间 */
	public BaseQoodUserVehicle setCreatetime(java.util.Date createtime){
		set("createtime",createtime);
		return this;
	}

	/** 获取 更新时间 */
	public java.util.Date getUpdatetime(){
		return getT("updatetime");
	}

	/** 设置 更新时间 */
	public BaseQoodUserVehicle setUpdatetime(java.util.Date updatetime){
		set("updatetime",updatetime);
		return this;
	}

	/** 获取 是否默认 */
	public Boolean getIsDefault(){
		return getT("isDefault");
	}

	/** 设置 是否默认 */
	public BaseQoodUserVehicle setIsDefault(Boolean isDefault){
		set("isDefault",isDefault);
		return this;
	}

	/** 获取 是否绑定HDX设备 */
	public Boolean getIsHdx(){
		return getT("isHdx");
	}

	/** 设置 是否绑定HDX设备 */
	public BaseQoodUserVehicle setIsHdx(Boolean isHdx){
		set("isHdx",isHdx);
		return this;
	}

	/** 获取 是否绑定Qood设备 */
	public Boolean getIsQood(){
		return getT("isQood");
	}

	/** 设置 是否绑定Qood设备 */
	public BaseQoodUserVehicle setIsQood(Boolean isQood){
		set("isQood",isQood);
		return this;
	}

	/** 获取 总行驶里程(km) */
	public java.math.BigDecimal getTripDistance(){
		return getT("tripDistance");
	}

	/** 设置 总行驶里程(km) */
	public BaseQoodUserVehicle setTripDistance(java.math.BigDecimal tripDistance){
		set("tripDistance",tripDistance);
		return this;
	}

	/** 获取 仪表盘里程(km) */
	public java.math.BigDecimal getCustomDistSum(){
		return getT("custom_dist_sum");
	}

	/** 设置 仪表盘里程(km) */
	public BaseQoodUserVehicle setCustomDistSum(java.math.BigDecimal customDistSum){
		set("custom_dist_sum",customDistSum);
		return this;
	}

	/** 获取 保养－里程周期(km) */
	public Integer getMaintainMile(){
		return getT("maintain_mile");
	}

	/** 设置 保养－里程周期(km) */
	public BaseQoodUserVehicle setMaintainMile(Integer maintainMile){
		set("maintain_mile",maintainMile);
		return this;
	}

	/** 获取 保养－月份周期 */
	public Integer getMaintainMonth(){
		return getT("maintain_month");
	}

	/** 设置 保养－月份周期 */
	public BaseQoodUserVehicle setMaintainMonth(Integer maintainMonth){
		set("maintain_month",maintainMonth);
		return this;
	}

	/** 获取 qood 纪录的里程(km) */
	public java.math.BigDecimal getQoodMileage(){
		return getT("qood_mileage");
	}

	/** 设置 qood 纪录的里程(km) */
	public BaseQoodUserVehicle setQoodMileage(java.math.BigDecimal qoodMileage){
		set("qood_mileage",qoodMileage);
		return this;
	}

	/** 获取 里程同步日期 */
	public java.util.Date getMileageSyncDate(){
		return getT("mileageSyncDate");
	}

	/** 设置 里程同步日期 */
	public BaseQoodUserVehicle setMileageSyncDate(java.util.Date mileageSyncDate){
		set("mileageSyncDate",mileageSyncDate);
		return this;
	}

	/** 获取 车管所注册日期 */
	public java.util.Date getLicenseRegTime(){
		return getT("licenseRegTime");
	}

	/** 设置 车管所注册日期 */
	public BaseQoodUserVehicle setLicenseRegTime(java.util.Date licenseRegTime){
		set("licenseRegTime",licenseRegTime);
		return this;
	}

	/** 获取 审核人 */
	public Long getReviewerId(){
		return getT("reviewerId");
	}

	/** 设置 审核人 */
	public BaseQoodUserVehicle setReviewerId(Long reviewerId){
		set("reviewerId",reviewerId);
		return this;
	}

	/** 获取 车辆来源(qood,hdx) */
	public String getVehicleSource(){
		return getT("vehicleSource");
	}

	/** 设置 车辆来源(qood,hdx) */
	public BaseQoodUserVehicle setVehicleSource(String vehicleSource){
		set("vehicleSource",vehicleSource);
		return this;
	}

	/** 获取 违章查询城市ID列表 */
	public String getQueryCityIds(){
		return getT("queryCityIds");
	}

	/** 设置 违章查询城市ID列表 */
	public BaseQoodUserVehicle setQueryCityIds(String queryCityIds){
		set("queryCityIds",queryCityIds);
		return this;
	}

	/** 获取 违章查询城市名称 */
	public String getQueryCityNames(){
		return getT("queryCityNames");
	}

	/** 设置 违章查询城市名称 */
	public BaseQoodUserVehicle setQueryCityNames(String queryCityNames){
		set("queryCityNames",queryCityNames);
		return this;
	}

	/** 获取 最后查询时间 */
	public java.util.Date getLastQueryTime(){
		return getT("lastQueryTime");
	}

	/** 设置 最后查询时间 */
	public BaseQoodUserVehicle setLastQueryTime(java.util.Date lastQueryTime){
		set("lastQueryTime",lastQueryTime);
		return this;
	}

	public Long getErpUser(){
		return getT("erpUser");
	}
	public BaseQoodUserVehicle setErpUser(Long erpUser){
		set("erpUser",erpUser);
		return this;
	}
	/**
	 * 表名：qood_user_vehicle 常量接口 <br>
	 *
	 */
	public interface FIELD {
		String id = "id";

		/**Qood设备的车辆ID */
		String qoodVehicleId = "qoodVehicleId";

		/**QOOD用户ID */
		String qoodUserId = "qoodUserId";

		/**渠道ID */
		String channelId = "channel_id";

		/**设备序列号 */
		String sn = "sn";

		/**硬件ID */
		String hwId = "hw_id";

		/**设备ID */
		String deviceId = "device_id";

		/**设备类型 */
		String deviceType = "deviceType";

		/**车牌号码 */
		String plate = "plate";

		/**发动机 */
		String engineNo = "engineNo";

		/**车辆识别代号 */
		String vin = "vin";

		/**车辆登记证书号 */
		String certId = "certId";

		/**车辆型号ID */
		String vehicleModelId = "vehicleModelId";

		/**购车日期 */
		String purchaseDate = "purchaseDate";

		/**保险到期日期 */
		String expireDate = "expireDate";

		/**行驶证图片路径 */
		String drivingLicenseImage = "drivingLicenseImage";

		/**车牌照片 */
		String plateImage = "plateImage";

		/**核审状态(1.未审，2.审核失败，3.审核通过) */
		String checked = "checked";

		/**创建时间 */
		String createtime = "createtime";

		/**更新时间 */
		String updatetime = "updatetime";

		/**是否默认 */
		String isDefault = "isDefault";

		/**是否绑定HDX设备 */
		String isHdx = "isHdx";

		/**是否绑定Qood设备 */
		String isQood = "isQood";

		/**总行驶里程(km) */
		String tripDistance = "tripDistance";

		/**仪表盘里程(km) */
		String customDistSum = "custom_dist_sum";

		/**保养－里程周期(km) */
		String maintainMile = "maintain_mile";

		/**保养－月份周期 */
		String maintainMonth = "maintain_month";

		/**qood 纪录的里程(km) */
		String qoodMileage = "qood_mileage";

		/**里程同步日期 */
		String mileageSyncDate = "mileageSyncDate";

		/**车管所注册日期 */
		String licenseRegTime = "licenseRegTime";

		/**审核人 */
		String reviewerId = "reviewerId";

		/**车辆来源(qood,hdx) */
		String vehicleSource = "vehicleSource";

		/**违章查询城市ID列表 */
		String queryCityIds = "queryCityIds";

		/**违章查询城市名称 */
		String queryCityNames = "queryCityNames";

		/**最后查询时间 */
		String lastQueryTime = "lastQueryTime";

		String erpUser = "erpUser";

		String[] all={
			id,
			qoodVehicleId,
			qoodUserId,
			channelId,
			sn,
			hwId,
			deviceId,
			deviceType,
			plate,
			engineNo,
			vin,
			certId,
			vehicleModelId,
			purchaseDate,
			expireDate,
			drivingLicenseImage,
			plateImage,
			checked,
			createtime,
			updatetime,
			isDefault,
			isHdx,
			isQood,
			tripDistance,
			customDistSum,
			maintainMile,
			maintainMonth,
			qoodMileage,
			mileageSyncDate,
			licenseRegTime,
			reviewerId,
			vehicleSource,
			queryCityIds,
			queryCityNames,
			lastQueryTime,
			erpUser
		};
		Integer fieldSize=36;
	}
}
