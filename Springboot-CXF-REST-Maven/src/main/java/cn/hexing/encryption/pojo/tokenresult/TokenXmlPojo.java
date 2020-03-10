package cn.hexing.encryption.pojo.tokenresult;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * 用于直接转换第三方厂商生产结果xml字符串的简单java类
 */
@XmlRootElement(name = "result")
public class TokenXmlPojo {
    @XmlElement(name = "errorCode")
    private String errorCode;

    @XmlElementWrapper(name = "tokens")
    @XmlElement(name = "token")
    private List<String> tokens;

    @XmlTransient
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @XmlTransient
    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }
}
