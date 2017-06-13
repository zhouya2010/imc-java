package com.yundian.imc.entity;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class Connector extends BaseEntity<Long>{

    @NotNull(message = "充电枪 ID 不能为空")
    @Size(max = 26, message = "充电枪 ID 最多26个字符")
    private String connectorId;

    @NotNull(message = "充电桩 ID 不能为空")
    @Size(max = 23, message = "充电桩 ID 最多23个字符")
    private String poleId;

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


    public String getConnectorId() {
        return connectorId;
    }

    public void setConnectorId(String connectorId) {
        this.connectorId = connectorId == null ? null : connectorId.trim();
    }

    public String getPoleId() {
        return poleId;
    }

    public void setPoleId(String poleId) {
        this.poleId = poleId == null ? null : poleId.trim();
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName == null ? null : connectorName.trim();
    }

    public byte getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(byte connectorType) {
        this.connectorType = connectorType;
    }

    public Short getVoltageUpperLimits() {
        return voltageUpperLimits;
    }

    public void setVoltageUpperLimits(Short voltageUpperLimits) {
        this.voltageUpperLimits = voltageUpperLimits;
    }

    public Short getVoltageLowerLimits() {
        return voltageLowerLimits;
    }

    public void setVoltageLowerLimits(Short voltageLowerLimits) {
        this.voltageLowerLimits = voltageLowerLimits;
    }

    public Short getCurrent() {
        return current;
    }

    public void setCurrent(Short current) {
        this.current = current;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String getParkNo() {
        return parkNo;
    }

    public void setParkNo(String parkNo) {
        this.parkNo = parkNo == null ? null : parkNo.trim();
    }

    public byte getNationalStandard() {
        return nationalStandard;
    }

    public void setNationalStandard(byte nationalStandard) {
        this.nationalStandard = nationalStandard;
    }
}