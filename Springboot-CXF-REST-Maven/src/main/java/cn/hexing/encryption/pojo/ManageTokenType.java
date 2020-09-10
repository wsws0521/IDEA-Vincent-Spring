package cn.hexing.encryption.pojo;

/**
 * 管理码Token类型定义
 */
public enum ManageTokenType {
    /**
     * 变更秘钥
     */
    KEY_CHANGE("3"),
    /**
     * 清事件
     */
    CLEAR_EVENT("5"),
    /**
     * 清余额
     */
    CLEAR_BALANCE("1"),
    /**
     * 最大功率控制
     */
    MAX_POWER_LIMIT("0"),
    /**
     * 友好模式
     */
    FRIEND_MODE("10"),
    /**
     * 设置囤积余额
     */
    SET_CREDIT_MODE("12"),
    /**
     * 电表模式转换
     */
    CHANGE_METER_MODE("12"),
    /**
     * 节假日
     */
    HOLIDAY_MODE("10"),
    /**
     * 低余额告警
     */
    BALANCE_AMOUT_ALERT("5"),
    /**
     * 阶梯费率下发
     */
    STEP_TARIFF("2"),
    /**
     * TOU分时费率下发
     */
    TOU_TARIFF("2"),
    /**
     * 注销
     */
    LOGOFF("14");

    private String subclass;

    public String getSubclass() {
        return subclass;
    }

    ManageTokenType(String subclass) {
        this.subclass = subclass;
    }
}
