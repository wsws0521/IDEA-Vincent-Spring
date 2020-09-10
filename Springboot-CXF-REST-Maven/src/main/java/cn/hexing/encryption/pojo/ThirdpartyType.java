package cn.hexing.encryption.pojo;

public enum ThirdpartyType {
    hexing(0),
    NYN(95),
    INHE(33),
    KAIFA(66),
    WS(24),
    STAR(60),
    DELIXI(80),
    TTL(44),
    WISDOM(30),
    XJ(50),
    HND(91),
    ;

    private int code;

    public int getCode() {
        return code;
    }

    ThirdpartyType(int code) {
        this.code = code;
    }
}
