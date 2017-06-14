package com.yundian.imc.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "t_station")
public class Station extends BaseEntity<Long>{

//    @NotNull(message = "充电桩 ID 不能为空")
//    @Size(max = 20, message = "充电桩 ID 最多20个字符")
    private String stationId;

    @NotNull(message = "运营商 ID 不能为空")
    @Size(min = 9, max = 9, message = "运营商 ID 为9个字符")
    private String operatorId;

    @NotNull(message = "设备所属方 ID 不能为空")
    @Size(min = 9, max = 9, message = "设备所属方 ID 为9个字符")
    private String equipmentOwnerId;

    @NotNull(message = "充电站名称不能为空")
    @Size(max = 50, message = "充电站名称最多50个字符")
    private String stationName;

    @NotNull(message = "充电站国家代码不能为空")
    @Size(max = 2, message = "充电站国家代码最多2个字符")
    private String countryCode;

    @NotNull(message = "地区编码不能为空")
    @Size(max = 6, message ="地区编码最多6个字符" )
    @Pattern(regexp = "\\d{6}$", message = "地区编码错误（充电站省市辖区编码 内容参照：GBT 2206-2007\\r\\n比如 南京：320100）")
    private String areaCode;

    @NotEmpty(message = "充电站详细地址不能为空")
    @Size(max = 50,message = "充电站详细地址最多50个字符")
    private String address;

    @NotEmpty(message = "站点电话不能为空")
    @Pattern(regexp = "((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)",
            message = "电话格式不正确")
    private String stationTel;

    @NotEmpty(message = "平台服务电话不能为空")
    @Pattern(regexp = "((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)",
            message = "平台服务电话格式不正确")
    private String serviceTel;

    @NotNull(message = "站点类型不能为空")
    private Byte stationType;

    @NotNull(message = "站点状态不能为空")
    private Byte stationStatus;

    @NotNull(message = "车位数量不能为空")
    private Short parkNums;

    @NotNull(message = "站点经度不能为空")
    @Digits(integer = 3,fraction = 6,message = "经度保留6位小数")
    private Double stationLng;

    @NotNull(message = "站点纬度不能为空")
    @Digits(integer = 3,fraction = 6,message = "纬度保留6位小数")
    private Double stationLat;

    @NotNull(message = "站点引导内容不能为空")
    @NotEmpty(message = "站点引导内容不能为空")
    private String siteGuide;

    @NotNull(message = "建设场所不能为空")
    @Max(value = 255,message = "建设场所描述错误")
    private Byte construction;

    @NotNull(message = "使用车型描述不能为空")
    @NotEmpty(message = "使用车型描述不能为空")
    @Size(max = 100,message = "使用车型描述最多100个字符")
    private String matchCarsDesc;

    @NotNull(message = "车位楼层以及数量信息不能为空")
    @NotEmpty(message = "车位楼层以及数量信息不能为空")
    @Size(max = 100,message = "使用车型描述最多100个字符")
    private String parkInfo;

    @NotNull(message = "营业时间不能为空")
    @NotEmpty(message = "营业时间不能为空")
    @Size(max = 100,message = "使用车型描述最多100个字符")
    private String busineHours;

    @NotNull(message = "电费描述不能为空")
    @NotEmpty(message = "电费描述不能为空")
    @Size(max = 255,message = "电费描述最多255个字符")
    private String electricityFeeDesc;

    @NotNull(message = "服务费描述不能为空")
    @Size(max = 100,message = "服务费描述最多100个字符")
    private String serviceFeeDesc;

    @NotNull(message = "停车费描述不能为空")
    @NotEmpty(message = "停车费描述不能为空")
    @Size(max = 100,message = "停车费描述最多100个字符")
    private String parkFeeDesc;

    @NotNull(message = "支付方式描述不能为空")
    @NotEmpty(message = "支付方式描述不能为空")
    @Size(max = 20,message = "支付方式描述最多20个字符")
    private String paymentType;

    @NotNull(message = "是否支持预约不能为空")
    private Boolean supportOrder;

    @NotNull(message = "备注信息不能为空")
    @Size(max = 100, message = "备注信息最多100个字符")
    private String remark;

//    private List<Pole> poles;

//    private List<String> pictures;

    @Column(name = "station_id")
    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    @Column(name = "operator_id")
    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    @Column(name = "equipment_owner_id")
    public String getEquipmentOwnerId() {
        return equipmentOwnerId;
    }

    public void setEquipmentOwnerId(String equipmentOwnerId) {
        this.equipmentOwnerId = equipmentOwnerId == null ? null : equipmentOwnerId.trim();
    }

    @Column(name = "station_name")
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    @Column(name = "area_code")
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @Column(name = "station_tel")
    public String getStationTel() {
        return stationTel;
    }

    public void setStationTel(String stationTel) {
        this.stationTel = stationTel == null ? null : stationTel.trim();
    }

    @Column(name = "service_tel")
    public String getServiceTel() {
        return serviceTel;
    }

    public void setServiceTel(String serviceTel) {
        this.serviceTel = serviceTel == null ? null : serviceTel.trim();
    }

    @Column(name = "station_type")
    public Byte getStationType() {
        return stationType;
    }

    public void setStationType(Byte stationType) {
        this.stationType = stationType;
    }

    @Column(name = "station_status")
    public Byte getStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(Byte stationStatus) {
        this.stationStatus = stationStatus;
    }

    @Column(name = "park_nums")
    public Short getParkNums() {
        return parkNums;
    }

    public void setParkNums(Short parkNums) {
        this.parkNums = parkNums;
    }

    @Column(name = "station_lng")
    public Double getStationLng() {
        return stationLng;
    }

    public void setStationLng(Double stationLng) {
        this.stationLng = stationLng;
    }

    @Column(name = "station_lat")
    public Double getStationLat() {
        return stationLat;
    }

    public void setStationLat(Double stationLat) {
        this.stationLat = stationLat;
    }

    @Column(name = "site_guide")
    public String getSiteGuide() {
        return siteGuide;
    }

    public void setSiteGuide(String siteGuide) {
        this.siteGuide = siteGuide == null ? null : siteGuide.trim();
    }

    @Column(name = "construction")
    public Byte getConstruction() {
        return construction;
    }

    public void setConstruction(Byte construction) {
        this.construction = construction;
    }

    @Column(name = "match_cars_desc")
    public String getMatchCarsDesc() {
        return matchCarsDesc;
    }

    public void setMatchCarsDesc(String matchCarsDesc) {
        this.matchCarsDesc = matchCarsDesc == null ? null : matchCarsDesc.trim();
    }

    @Column(name = "park_info")
    public String getParkInfo() {
        return parkInfo;
    }

    public void setParkInfo(String parkInfo) {
        this.parkInfo = parkInfo == null ? null : parkInfo.trim();
    }

    @Column(name = "busine_hours")
    public String getBusineHours() {
        return busineHours;
    }

    public void setBusineHours(String busineHours) {
        this.busineHours = busineHours == null ? null : busineHours.trim();
    }

    @Column(name = "electricity_fee_desc")
    public String getElectricityFeeDesc() {
        return electricityFeeDesc;
    }

    public void setElectricityFeeDesc(String electricityFeeDesc) {
        this.electricityFeeDesc = electricityFeeDesc == null ? null : electricityFeeDesc.trim();
    }

    @Column(name = "service_fee_desc")
    public String getServiceFeeDesc() {
        return serviceFeeDesc;
    }

    public void setServiceFeeDesc(String serviceFeeDesc) {
        this.serviceFeeDesc = serviceFeeDesc == null ? null : serviceFeeDesc.trim();
    }

    @Column(name = "park_fee_desc")
    public String getParkFeeDesc() {
        return parkFeeDesc;
    }

    public void setParkFeeDesc(String parkFeeDesc) {
        this.parkFeeDesc = parkFeeDesc == null ? null : parkFeeDesc.trim();
    }

    @Column(name = "payment_type")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    @Column(name = "support_order")
    public Boolean getSupportOrder() {
        return supportOrder;
    }

    public void setSupportOrder(Boolean supportOrder) {
        this.supportOrder = supportOrder;
    }

    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

//    public List<Pole> getPoles() {
//        return poles;
//    }
//
//    public void setPoles(List<Pole> poles) {
//        this.poles = poles;
//    }

//    public List<String> getPictures() {
//        return pictures;
//    }
//
//    public void setPictures(List<String> pictures) {
//        this.pictures = pictures;
//    }
}