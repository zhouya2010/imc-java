package com.yundian.imc.common.enums;

/**
 * 充电桩类型
 */
public enum PoleTypeEnum {

    /**
     * 直流桩
     */
    DC(1),
    /**
     * 交流桩
     */
    AC(2),
    /**
     * 交直流一体设备
     */
    DC_AND_AC(3),
    /**
     * 无线设备
     */
    WIRELESS(4),
    /**
     * 其他
     */
    OTHER(5);

    private int value;

    PoleTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PoleTypeEnum fromValue(int value) {
        switch (value) {
            case 1:
                return DC;
            case 2:
                return AC;
            case 3:
                return DC_AND_AC;
            case 4:
                return WIRELESS;
            default:
                return OTHER;
        }
    }
}
