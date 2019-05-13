package com.security;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/5/13 14:43.
 * @motto : To be, or not to be.
 */

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

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
     * 使用base64解决乱码
     *
     * @param secretKey
     * 加密后的字节码
     */
    public static String jdkBase64String(byte[] secretKey) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(secretKey);
    }

    /**
     * 使用jdk的base64 解密字符串 返回为null表示解密失败
     *
     * @throws IOException
     */
    public static byte[] jdkBase64Decoder(String str) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return decoder.decodeBuffer(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }
}
