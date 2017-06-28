package com.yundian.imc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_pole")
public class Pole extends BaseEntity<Long> {

    @NotNull(message = "充电桩 ID 不能为空")
    @Size(max = 23, message = "充电桩 ID 最多为23个字符")
    private String poleId;

//    @NotNull(message = "充电站 ID 不能为空")
//    @Size( max = 20, message = "充电站 ID 最多为20个字符")
//    private String stationId;

    @NotNull(message = "充电桩生产商组织机构代码不能为空")
    @Size(min = 9, max = 9, message = "充电桩生产商组织机构代码为9个字符")
    private String manufacturerId;

    @NotNull(message = "充电桩生产商不能为空")
    @Size(max = 30, message = "充电桩生产商最多为30个字符")
    private String manufacturerName;

    @NotNull(message = "充电桩型号不能为空")
    @Size(max = 20, message = "充电桩型号最多为20个字符")
    private String poleModel;

    @NotNull(message = "充电桩生产日期不能为空")
    @Past(message = "生产日期为过去某个时间")
    private Date productionDate;

    @NotNull(message = "充电桩类型不能为空")
    private Byte poleType;

    @NotNull(message = "充电桩经度不能为空")
    private Double poleLng;

    @NotNull(message = "充电桩纬度不能为空")
    private Double poleLat;

    @NotNull(message = "充电桩总功率不能为空")
    private Double power;

    @NotNull(message = "充电桩名称不能为空")
    private String poleName;

    private List<Connector> connectors;

    private Station station;

    @Column(name = "pole_id")
    public String getPoleId() {
        return poleId;
    }

    public void setPoleId(String poleId) {
        this.poleId = poleId == null ? null : poleId.trim();
    }

    @Column(name = "manufacturer_id")
    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId == null ? null : manufacturerId.trim();
    }

    @Column(name = "manufacturer_name")
    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName == null ? null : manufacturerName.trim();
    }

    @Column(name = "pole_model")
    public String getPoleModel() {
        return poleModel;
    }

    public void setPoleModel(String poleModel) {
        this.poleModel = poleModel == null ? null : poleModel.trim();
    }

    @Column(name = "production_date")
    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Column(name = "pole_type")
    public Byte getPoleType() {
        return poleType;
    }

    public void setPoleType(Byte poleType) {
        this.poleType = poleType;
    }

    @Column(name = "pole_lng")
    public Double getPoleLng() {
        return poleLng;
    }

    public void setPoleLng(Double poleLng) {
        this.poleLng = poleLng;
    }

    @Column(name = "pole_lat")
    public Double getPoleLat() {
        return poleLat;
    }

    public void setPoleLat(Double poleLat) {
        this.poleLat = poleLat;
    }

    @Column(name = "power")
    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    @Column(name = "pole_name")
    public String getPoleName() {
        return poleName;
    }

    public void setPoleName(String poleName) {
        this.poleName = poleName == null ? null : poleName.trim();
    }

    @OneToMany(mappedBy = "pole", fetch = FetchType.LAZY)
    public List<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id", referencedColumnName = "station_id")
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}