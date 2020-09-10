package cn.hexing.encryption.exception;

/**
 * 第三方加密异常
 */
public class ThirdPartyException extends EncryptionServiceException {
    public ThirdPartyException(String message) {
        super(message);
    }
}
