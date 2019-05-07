package com.util;

import com.bean.Request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/4/22 13:51.
 * @motto : To be, or not to be.
 */
public class ParseString {
    public static Request parse(String str){
        Request request = new Request();
        System.out.println("hello , Let's Go");
//      String http = "get http://127.0.0.1:8080/NewWeb/login?name=guoyasoft&password=123456 HTTP1.1";

        String[] fenGeHang=str.split(" ");//驼峰命名法（变量首字母小写，后面的每个单词首字母大写）
        String method = fenGeHang[0];
        request.setMethod(method);
        String url  = fenGeHang[1];
        request.setUrl(url);
        String xieYiBanBen = fenGeHang[2];
        request.setXieYiBanBen(xieYiBanBen);
        System.out.println("方法："+method);
//        System.out.println("url:"+url);
        System.out.println("版本："+xieYiBanBen);

        int index = url.indexOf("://");
        String xieYi = url.substring(0, index);
        request.setXieYi(xieYi);
        System.out.println("协议:"+xieYi);
        url = url.substring(index+3);
        //System.out.println(url);

        index=url.indexOf(":");
        String ip=url.substring(0,index);
        request.setIp(ip);
        System.out.println("ip="+ip);
        url=url.substring(index+1);
        //System.out.println(url);

        index=url.indexOf("/");
        String port=url.substring(0,index);
        request.setPort(port);
        System.out.println("port=" + port);
        url=url.substring(index+1);
        //System.out.println(url);

        index=url.indexOf("/");
        String prjName=url.substring(0,index);
        request.setPrjName(prjName);
        System.out.println("prjName="+prjName);
        url=url.substring(index+1);
        //System.out.println(url);

        if(url.contains("?")){
            index=url.indexOf("?");
            String resource=url.substring(0,index);
            request.setResource(resource);
            System.out.println("resource=" + resource);
        }
        String queryString=url.substring(index+1);


        //parameter:意思是参数
        String[] parameters = queryString.split("&");
        if (parameters.length <= 1){
            for (String s : parameters) {
                System.out.println(parameters.length + "--" + s);
            }
        } else {
            Map<String, String> map = new HashMap<String, String>();
            for (String s : parameters) {
                printParam(map, s);
            }
            request.setMap(map);
        }
        return request ;
    }

    /**
     * yiZu[0]：下标的第一个值（数组里面的第一个值）；yiZu[1]：下标的的第二个值（数组里面的第二个值）
     * @param map
     * @param s
     */
    private static void printParam(Map<String, String> map, String s) {
        String[] yiZu = s.split("=");//根据"="分割，放在一个数组"yiZu"里面
        map.put(yiZu[0], yiZu[1]);//put（放）到map里面

        //Url编码的解码
        if(yiZu[0].equals("time")){
              yiZu[1] = DateUtil.times(Long.valueOf(yiZu[1]));
              System.out.println(yiZu[0] + "=" + yiZu[1]);
        } else if(yiZu[0].equals("Book") || yiZu[0].equals("Poem")){
            try {
                yiZu[1] = URLDecoder.decode(yiZu[1],   "utf-8");
                System.out.println(yiZu[0] + "=" + yiZu[1]);
            }  catch (UnsupportedEncodingException e){
                LogZ.error(e.toString());
            }
        } else {
            System.out.println(yiZu[0] + "=" + yiZu[1]);
        }
    }
}