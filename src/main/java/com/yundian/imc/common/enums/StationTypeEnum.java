package com.yundian.imc.common.enums;

/**
 * 站点类型
 */
public enum StationTypeEnum {

    SOCIETY(1, "公共"),
    INDIVIDUAL(50, "个人"),
    BUS(100, "公交"),
    SANITATION(101, "环卫（专用）"),
    LOGISTICS(102, "物流（专用）"),
    TAXI(103, "出租车（专用）"),
    OTHER(255, "其他");

    private int value;
    private String name;

    StationTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }


    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static StationTypeEnum fromValue(int value) {
        StationTypeEnum stationType = null;
        switch (value) {
            case 1:
                stationType = SOCIETY;
                break;
            case 50:
                stationType = INDIVIDUAL;
                break;
            case 100:
                stationType = BUS;
                break;
            case 101:
                stationType = SANITATION;
                break;
            case 102:
                stationType = LOGISTICS;
                break;
            case 103:
                stationType = TAXI;
                break;
            case 255:
                stationType = OTHER;
                break;
            default:
                stationType = OTHER;
        }
        return stationType;
    }

}
