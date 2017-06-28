package com.yundian.imc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_connector")
public class Connector extends BaseEntity<Long>{

    @NotNull(message = "充电枪 ID 不能为空")
    @Size(max = 26, message = "充电枪 ID 最多26个字符")
    private String connectorId;

    @NotNull(message = "充电枪名称不能为空")
    @Size(max = 30, message = "充电枪名称最多30个字符")
    private String connectorName;

    @NotNull(message = "充电枪接口类型不能为空")
    private byte connectorType;

    @NotNull(message = "额定电压上限不能为空")
    private Short voltageUpperLimits;

    @NotNull(message = "额定电压下限不能为空")
    private Short voltageLowerLimits;

    @NotNull(message = "额定电流不能为空")
    private Short current;

    @NotNull(message = "额定功率不能为空")
    private Double power;

    @NotNull(message = "停车场编号（车位号）不能为空")
    private String parkNo;

    @NotNull(message = "国家标准不能为空")
    private byte nationalStandard;

    private Pole pole;

    @Column(name = "connector_id")
    public String getConnectorId() {
        return connectorId;
    }

    public void setConnectorId(String connectorId) {
        this.connectorId = connectorId == null ? null : connectorId.trim();
    }

    @Column(name = "connector_name")
    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName == null ? null : connectorName.trim();
    }

    @Column(name = "connector_type")
    public byte getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(byte connectorType) {
        this.connectorType = connectorType;
    }

    @Column(name = "voltage_upper_limits")
    public Short getVoltageUpperLimits() {
        return voltageUpperLimits;
    }

    public void setVoltageUpperLimits(Short voltageUpperLimits) {
        this.voltageUpperLimits = voltageUpperLimits;
    }

    @Column(name = "voltage_lower_limits")
    public Short getVoltageLowerLimits() {
        return voltageLowerLimits;
    }

    public void setVoltageLowerLimits(Short voltageLowerLimits) {
        this.voltageLowerLimits = voltageLowerLimits;
    }

    @Column(name = "current")
    public Short getCurrent() {
        return current;
    }

    public void setCurrent(Short current) {
        this.current = current;
    }

    @Column(name = "power")
    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    @Column(name = "park_no")
    public String getParkNo() {
        return parkNo;
    }

    public void setParkNo(String parkNo) {
        this.parkNo = parkNo == null ? null : parkNo.trim();
    }

    @Column(name = "national_standard")
    public byte getNationalStandard() {
        return nationalStandard;
    }

    public void setNationalStandard(byte nationalStandard) {
        this.nationalStandard = nationalStandard;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pole_id",referencedColumnName = "pole_id")
    public Pole getPole() {
        return pole;
    }

    public void setPole(Pole pole) {
        this.pole = pole;
    }
}