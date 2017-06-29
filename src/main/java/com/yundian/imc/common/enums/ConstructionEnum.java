package com.yundian.imc.common.enums;

/**
 * 建设场所
 */
public enum ConstructionEnum {

    /**
     * 居民区
     */
    RESIDENTIAL_ARE(1),
    /**
     * 公共机构
     */
    PUBLIC_INSTITUTIONS(2),
    /**
     * 企事业单位
     */
    ENTERPRISES_AND_INSTITUTIONS(3),
    /**
     * 写字楼
     */
    OFFICE_BUILDING(4),
    /**
     * 工业园区
     */
    INDUSTRIAL_PARK(5),
    /**
     * 交通枢纽
     */
    TRANSPORTATION_HUB(6),
    /**
     * 大型文体设施
     */
    CULTURAL_AND_SPORTS(7),
    /**
     * 城市绿地
     */
    URBAN_GREEN_SPACE(8),
    /**
     * 大型建筑配建停车场
     */
    BUILDING_PARKING(9),
    /**
     * 路边停车位
     */
    ROADSIDE(10),
    /**
     * 城际高速服务区
     */
    SERVICE_ARE(11),
    /**
     * 其他
     */
    OTHER(255);

    private int value;

    ConstructionEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ConstructionEnum fromValue(int value) {
        switch (value) {
            case 1:
                return RESIDENTIAL_ARE;
            case 2:
                return PUBLIC_INSTITUTIONS;
            case 3:
                return ENTERPRISES_AND_INSTITUTIONS;
            case 4:
                return OFFICE_BUILDING;
            case 5:
                return INDUSTRIAL_PARK;
            case 6:
                return TRANSPORTATION_HUB;
            case 7:
                return CULTURAL_AND_SPORTS;
            case 8:
                return URBAN_GREEN_SPACE;
            case 9:
                return BUILDING_PARKING;
            case 10:
                return ROADSIDE;
            case 11:
                return SERVICE_ARE;
            default:
                return OTHER;

        }
    }
}
