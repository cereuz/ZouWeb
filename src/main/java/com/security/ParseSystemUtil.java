package com.security;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/5/13 14:43.
 * @motto : To be, or not to be.
 */
import java.util.Base64;

/**
 * 进制转换工具类
 */
public class ParseSystemUtil {
    /**将二进制转换成16进制
     * @param buf
     * @return
     *
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 使用Java自动的  编码 解码
     * @param secretKey
     * @return
     */
    public static String Base64Encode(byte[] secretKey) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(secretKey);
    }

    public static byte[] Base64Decoder(String str) {
        Base64.Decoder decoder = Base64.getDecoder();
        return decoder.decode(str);
    }
}
