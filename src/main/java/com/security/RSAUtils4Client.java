package com.security;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

/** */

/**
 * <p>
 * RSA公钥/私钥/签名工具包
 * </p>
 * <p>
 * 罗纳德·李维斯特（Ron [R]ivest）、阿迪·萨莫尔（Adi [S]hamir）和伦纳德·阿德曼（Leonard [A]dleman）
 * </p>
 * <p>
 * 字符串格式的密钥在未在特殊说明情况下都为BASE64编码格式<br/>
 * 由于非对称加密速度极其缓慢，一般文件不使用它来加密而是使用对称加密，<br/>
 * 非对称加密算法可以用来对对称加密的密钥加密，这样保证密钥的安全也就保证了数据的安全
 * </p>
 *
 * @author IceWee
 * @date 2012-4-26
 * @version 1.0
 */
/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/5/13 15:57.
 * @motto : To be, or not to be.
 */
public class RSAUtils4Client {
    static String privateKey="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJEq5BlUar57utzY+9Tha8GLK/ufni6qdhKZYmCdA6ES8tRvE2sBu4+9nKyK/lgv5QqWh19ygoWhDPmnZvoPGcbeGcHbMZ4YlXGyEgOjmIR33NqG9BrqixOcNPWEfme7Jn5f35iL2pkmMeGZd8aeGYdxDUjpIUgLkctrdyvt3NVhAgMBAAECgYBUaKcnH1HOHq3B2p1b5BM+/8h8UAyvP8jV+cAdQ08n6pet9ERLNT+1TeB653sLFhZM+MgQNMo2HzYnODKFdiBa/bBCjiDFft0xUXlbtXUSBsTFQEiepGii5ILRnSDqEvcpcQ/3sbhZ5q8RKXXcZBignzGN3rcizFJRxodMiFTQAQJBAPiiDY3g4XsAr4KiuLwzjeWKMUnFcabZLQdZ2z0ky82zk7Qr6KnaSMP0tJDqmqtZuset4iNq+2lYE3XMFQd25OECQQCVeAZuyeI33fgh6enl9U7YoJoye0JtHaQKF6MVOVrfN/9rvpeE3RS95E/t8sSStan8IS36JvZVB2u7e95l44CBAkEA1Tyu4ULAP20MGb8TLx4MEZRex0VWPuG987MGC7+WJzpfcEPETIBQrfceMbdzpYfUYFLqQrQLIYMPVZUNaBR5IQJBAIT2F2rYhjdCaufoSFx7Ip+MBn9frJCabIFZ04Ye1lp5WurCydC0Ri5B+mRmsDz+A2+5KEg9/qVXC5vlLcqfXYECQH77xj2FjxWJJR3j2Dwxdq9XTFzVwVjFxqoH25K9YvpFj1cfJc3SdSKxUs8++i2KMIuWugSSA0VCGSQG4GwNWKs=";

    /** *//**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";


    /** *//**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;



    /** *//**
     * <p>
     * 公钥加密
     * </p>
     *
     * @param data 源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey)
            throws Exception {
        byte[] keyBytes = ParseUtil.Base64Decoder(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    public static void main(String[] args) throws Exception {
        String source = "这是一行测试RSA数字签名的无意义文字";
        System.out.println("原文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSA.encryptByPrivateKey(data, privateKey);
        System.out.println("加密后：\r\n" + new String(encodedData));
        String base64EncodedData = ParseUtil.Base64Encode(encodedData);
        //System.out.println("加密后BASE64：\r\n" + base64EncodedData);
        System.out.println("加密后BASE64：\r\n" + ParseUtil.Base64Encode(encodedData));
    }
}
