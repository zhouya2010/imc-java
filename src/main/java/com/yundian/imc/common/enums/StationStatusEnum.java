package com.yundian.imc.common.enums;

/**
 * 站点状态
 */
public enum StationStatusEnum {
    /**
     * 未知
     */
    UNKNOWN(0),
    /**
     * 建设中.
     */
    UNDER_CONSTRUCT(1),
    /**
     * 关闭下线
     */
    CLOSE(5),
    /**
     * 维护
     */
    MAINTAIN(6),
    /**
     * 审核中
     */
    REVIEWING(10),
    /**
     * 审核未通过
     */
    REJECT(11),
    /**
     * 待审核
     */
    PENDING_REVIEW(12),
    /**
     * 正常使用中
     */
    USING(50);

    private int value;

    StationStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StationStatusEnum fromValue(int value) {
        switch (value) {
            case 0:
                return UNKNOWN;
            case 1:
                return UNDER_CONSTRUCT;
            case 5:
                return CLOSE;
            case 6:
                return MAINTAIN;
            case 10:
                return REVIEWING;
            case 11:
                return REJECT;
            case 12:
                return PENDING_REVIEW;
            case 50:
                return USING;
            default:
                return UNKNOWN;
        }
    }
}
