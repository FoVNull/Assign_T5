package sz.nuist.appassignment.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    public String SHA256(final String strText) {
        return SHA(strText, "SHA-256");
    }

    public String SHA512(final String strText) {
        return SHA(strText, "SHA-512");
    }


    private String SHA(final String strText, final String strType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte
                byte byteBuffer[] = messageDigest.digest();

                // 將 byte 转换 string
                StringBuffer strHexString = new StringBuffer();
                // 遍历 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                strResult = strHexString.toString();
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }
}
