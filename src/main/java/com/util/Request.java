package com.util;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/4/22 13:51.
 * @motto : To be, or not to be.
 */
import java.util.Map;

public class Request {
    private String method;
    private String url;
    private String xieYiBanBen;
    private String xieYi;
    private String ip;
    private String port;
    private String prjName;
    private String resource;
    private Map<String, String> map;
    //在ParsString中有一个map数组，里面存放的内容都是根据key，value的方式来存放的。为了方便
    //取这个key，定义一个getParmameter的方法，在方法里面放一个key，返回一个key，以后就可以直接通过
    //map.get（key）的方法来取内容
    //key就等于是通讯录中需要寻找的人，这个人的手机号就是value
    public String getParmameter(String key){
        return map.get(key);
    }

    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getXieYiBanBen() {
        return xieYiBanBen;
    }
    public void setXieYiBanBen(String xieYiBanBen) {
        this.xieYiBanBen = xieYiBanBen;
    }
    public String getXieYi() {
        return xieYi;
    }
    public void setXieYi(String xieYi) {
        this.xieYi = xieYi;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getPrjName() {
        return prjName;
    }
    public void setPrjName(String prjName) {
        this.prjName = prjName;
    }
    public String getResource() {
        return resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }
    public Map<String, String> getMap() {
        return map;
    }
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    @Override
    public String toString() {
        return "Request [method=" + method + ", url=" + url + ", xieYiBanBen="
                + xieYiBanBen + ", xieYi=" + xieYi + ", ip=" + ip + ", port="
                + port + ", prjName=" + prjName + ", resource=" + resource
                + ", map=" + map + "]";
    }

}
