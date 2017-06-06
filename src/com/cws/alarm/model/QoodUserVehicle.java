package com.cws.alarm.model;

import com.cws.alarm.model.base.BaseQoodUserVehicle;

import java.util.List;

/**
 * 用户车辆
 * Created by Can on 2015/6/29.
 */
public class QoodUserVehicle extends BaseQoodUserVehicle<QoodUserVehicle, Long> {
    /**
     * 行驶证照片宽度
     */
    public static final int DRIVING_LICENSE_WIDTH = 500;

    /**
     * 行驶证照片高度
     */
    public static final int DRIVING_LICENSE_HEIGHT = 500;

    /**
     * 车牌照片宽度
     */
    public static final int PLATE_IMAGE_WIDTH = 500;

    /**
     * 车牌照片高度
     */
    public static final int PLATE_IMAGE_HEIGHT = 500;

    /**
     * 是否存在车辆
     *
     * @param plate
     * @return
     */
    public boolean isExistVehicle(Long qoodUserId,String plate) {
        QoodUserVehicle vehicle = findFirst("select id from qood_user_vehicle where qoodUserId = ? and plate=?",qoodUserId, plate);
        return vehicle != null;
    }

    /**
     * 根据用户ID查询车辆列表
     *
     * @param qoodUserId
     * @return
     */
    public List<QoodUserVehicle> findByUserId(Long qoodUserId) {
        List<QoodUserVehicle> vehicleList = find("select * from qood_user_vehicle where qoodUserId=? ORDER BY isDefault DESC", qoodUserId);
        return vehicleList;
    }


    /**
     * 根据用户ID 渠道ID 查询车辆列表
     *
     * @param qoodUserId
     * @return
     */
    public List<QoodUserVehicle> findByUserIdAndChannelId(Long qoodUserId) {
        List<QoodUserVehicle> vehicleList = find("select * from qood_user_vehicle where qoodUserId=?  and channel_id=?  ORDER BY isHdx DESC,isDefault DESC,createtime desc", qoodUserId, CHANNEL.aichebao.value());
        return vehicleList;
    }



    /**
     * 根据车牌查询车辆列表
     * @param plate
     * @return
     */
    public List<QoodUserVehicle> findByPlate(String plate){
        List<QoodUserVehicle> vehicleList = find("select * from qood_user_vehicle where plate=?", plate);
        return vehicleList;
    }

    /**
     * 根据车牌号查询车辆信息
     *
     * @param plate
     * @return
     */
    public QoodUserVehicle findByPlate(Long qoodUserId,String plate) {
        QoodUserVehicle vehicle = findFirst("select * from qood_user_vehicle where qoodUserId = ? and plate=?", qoodUserId,plate);
        return vehicle;
    }

    /**
     * 根据用户ID 查询默认车牌号
     *
     * @param qoodUserId
     * @return
     */
    public QoodUserVehicle findDefaultPlateByUserId(Long qoodUserId) {
        QoodUserVehicle vehicle = findFirst("select * from qood_user_vehicle where qoodUserId = ? order by isdefault desc limit 1", qoodUserId);
        return vehicle;
    }

    /**
     * 审核状态
     */
    public enum CHECKED {
        /**
         * 未审核
         */
        unchecked(1),
        /**
         * 审核失败
         */
        checkFail(2),
        /**
         * 审核成功
         */
        checked(3);
        private Integer ck;

        private CHECKED(Integer ck) {
            this.ck = ck;
        }

        public Integer value() {
            return this.ck;
        }
    }

    /**
     * 车辆来源
     */
    public enum VEHICLE_SOURCE {
        /**QOOD设备*/
        qood,
        /**爱车保来源*/
        ichebao,
        /**微信来源*/
        wechat;

        @Override
        public String toString() {
            return this.name();
        }
    }

    /**
     * 车辆渠道
     */
   public  enum  CHANNEL{

        aichebao(11);
        private Integer channel;
        CHANNEL(Integer channel) {
            this.channel = channel;
        }

        public Integer value() {
            return this.channel;
        }
    }
}
