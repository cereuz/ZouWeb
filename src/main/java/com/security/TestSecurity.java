package com.security;

import com.util.Constants;
import com.util.LogY;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/5/13 14:42.
 * @motto : To be, or not to be.
 */
public class TestSecurity {

    public static void main(String[]args){
         AEStest();
         System.out.println("===============================================================");
         DEStest();
    }

    /**
     * AES加密解密测试
     */
    public static void AEStest( ) {
        String content = "美女，约吗？美女，约吗？美女，约吗？";
        String password = "958802882010913257074332531189842634785729895880288201091325707433253118984263478572987735494687588750185795377577721630844788736994473060344662006164119605741224340594691002358927027368608729012471234569588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456958802882010913257074332531189842634785729877354946875887501857953775777216308447887369944730603446620061641196057412243405946910023589270273686087290124712345695880288201091325707433253118984263478572987735494687588750185795377577721630844788736994473060344662006164119605741224340594691002358927027368608729012471234569588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456958802882010913257074332531189842634785729877354946875887501857953775777216308447887369944730603446620061641196057412243405946910023589270273686087290124712345695880288201091325707433253118984263478572987735494687588750185795377577721630844788736994473060344662006164119605741224340594691002358927027368608729012471234569588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456958802882010913257074332531189842634785729877354946875887501857953775777216308447887369944730603446620061641196057412243405946910023589270273686087290124712345695880288201091325707433253118984263478572987735494687588750185795377577721630844788736994473060344662006164119605741224340594691002358927027368608729012471234567735494687588750185795377577721630844788736994473060344662006164119605741224340594691002358927027368608729012471234569588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456958802882010913257074332531189842634785729877354946875887501857953775777216308447887369944730603446620061641196057412243405946910023589270273686087290124712345695880288201091325707433253118984263478572987735494687588750185795377577721630844788736994473060344662006164119605741224340594691002358927027368608729012471234569588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";
        LogY.error("加密之前：" + content);
        // 加密
        byte[] encrypt = AES.encrypt(content, password);
        LogY.error("Base64解析后："+ ParseSystemUtil.jdkBase64String(encrypt));
        LogY.error("加密后的内容：" + new String(encrypt));

        //如果想要加密内容不显示乱码，可以先将密文转换为16进制
        String hexStrResult = ParseSystemUtil.parseByte2HexStr(encrypt);
        LogY.error("16进制的密文："  + hexStrResult);

        //如果得到的是16进制密文，别忘了先转为2进制再解密
        byte[] twoStrResult = ParseSystemUtil.parseHexStr2Byte(hexStrResult);

        // 解密
        byte[] decrypt = AES.decrypt(encrypt, password);
        LogY.error("解密后的内容：" + new String(decrypt));
    }


    /**
     * DES加密解密测试
     */
    public static void DEStest( ) {
        //待加密内容
        String str = "美女，约吗？美女，约吗？美女，约吗？";
        //密码，长度要是8的倍数
        String password = "95880288201091325707433253118984263478572987735494687588750185795377577721630844788736994473060344662006164119605741224340594691002358927027368608729012471234569588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456958802882010913257074332531189842634785729877354946875887501857953775777216308447887369944730603446620061641196057412243405946910023589270273686087290124712345695880288201091325707433253118984263478572987735494687588750185795377577721630844788736994473060344662006164119605741224340594691002358927027368608729012471234569588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";

        byte[] result = DES.encrypt(str.getBytes(),password);
        LogY.error("加密后："+ ParseSystemUtil.jdkBase64String(result));
        //直接将如上内容解密
        try {
            byte[] decryResult = DES.decrypt(result, password);
            LogY.error("解密后："+new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
