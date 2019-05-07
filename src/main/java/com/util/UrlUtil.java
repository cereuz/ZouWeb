package com.util;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/5/7 14:39.
 * @motto : To be, or not to be.
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lixk
 * @description url工具类
 * @date 2018/9/26 9:58
 * 作者：浅醉樱花雨
 * 原文：https://blog.csdn.net/u013314786/article/details/82851403
 */
public class UrlUtil {

    public static String sParams;

    public static class UrlEntity {
        /**
         * 基础url
         */
        public String baseUrl;
        /**
         * url参数
         */
        public Map<String, String> params;

    }

    /**
     * 解析url
     *
     * @param url
     * @return
     */
    public static UrlEntity parse(String url) {
        UrlEntity entity = new UrlEntity();
        if (url == null) {
            return entity;
        }
        url = url.trim();
        if (url.equals("")) {
            return entity;
        }
        String[] urlParts = url.split("\\?");
        entity.baseUrl = urlParts[0];
        //没有参数
        if (urlParts.length == 1) {
            return entity;
        }
        //有参数
        String[] params = urlParts[1].split("&");
        entity.params = new HashMap<>();
        for (String param : params) {
            String[] keyValue = param.split("=");
            entity.params.put(keyValue[0], keyValue[1]);
        }

        return entity;
    }

    public static void getPrint(String baseUrl){
            LogY.error(baseUrl);
        UrlEntity entity = parse(baseUrl);
        if (entity.params == null){
            LogY.error(entity.baseUrl + "\n" + null);
        } else {
            sParams = entity.params.toString();
            try {
                sParams = URLDecoder.decode(sParams,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            LogY.error(entity.baseUrl + "\n" + sParams);

            if(entity.params.containsKey("time")){
                LogY.info(DateUtil.times(Long.valueOf(entity.params.get("time"))));
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        UrlEntity entity = parse(null);
        LogY.error(entity.baseUrl + "\n" + entity.params);
        entity = parse("http://www.123.com");
        LogY.error(entity.baseUrl + "\n" + entity.params);
        entity = parse("http://www.123.com?id=1");
        LogY.error(entity.baseUrl + "\n" + entity.params);
        entity = parse("http://www.123.com?id=1&name=小明");
        LogY.error(entity.baseUrl + "\n" + entity.params);
        entity = parse("http://127.0.0.1:8080/NewWeb/login?name=guoyasoft&password=123456");
        LogY.error(entity.baseUrl + "\n" + entity.params);
    }
}

