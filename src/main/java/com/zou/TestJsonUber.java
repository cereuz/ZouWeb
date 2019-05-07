package com.zou;

import com.bean.Uber;
import com.google.gson.Gson;
import com.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/4/16 13:50.
 * @motto : To be, or not to be.
 */

@WebServlet("/TestJsonUber")
public class TestJsonUber extends HttpServlet {

    public TestJsonUber() {
       super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        initRequest(request);

        Connection connection = null;
        response.setContentType("text/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        /**
         * 设置响应内容类型
         */
        try {
            //加载mysql的驱动类
            Class.forName(Constants.DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(Constants.URL_ZOU0306, Constants.USER_NAME, Constants.PASSWORD);
//            connection = DBUtils.getConnection();
            PreparedStatement prst = connection.prepareStatement(Constants.SQL_SELECT_UBER_UDID2);
            for (int i = 1; i <= 10; i++){
                prst.setObject(i,DBUtils.selectUberOne());
            }
            //结果集
            ResultSet rs = prst.executeQuery();
            Gson gson = new Gson();
            ArrayList<Uber> list = new ArrayList<Uber>();
            // 展开结果集数据库
            while (rs.next()) {
                Uber uber = new Uber();
                uber.setId(rs.getInt(1));
                uber.setUDID(rs.getString(2));
                uber.setType(rs.getString(3));
                uber.setDeparture(rs.getString(4));
                uber.setDestination(rs.getString(5));
                uber.setTime(rs.getString(6));
                uber.setSeat(rs.getString(7));
                uber.setCost(rs.getString(8));
                uber.setNickName(rs.getString(9));
                uber.setPhone(rs.getString(10));
                uber.setAutomobile(rs.getString(11));
                uber.setExperience(rs.getString(12));
                uber.setQQ(rs.getString(13));
                uber.setRemark(rs.getString(14));
                list.add(uber);
            }
            // 输出数据
            out = response.getWriter();

            out.println(gson.toJson(list));
            // 完成后关闭
            rs.close();
            prst.close();
            connection.close();
        } catch (Exception e) {
            out.print("get data error!");
            e.printStackTrace();
        }
    }

    /**
     * 打印请求的参数
     */
    private void initRequest(HttpServletRequest request) {
        String body = HttpServletRequestReader.ReadAsChars(request);
        String str;
        if(body.length() == 0){
            str = "POST " + request.getRequestURL() + " HTTP1.1";
        }  else {
            str = "POST " + request.getRequestURL() + "?" + body +  " HTTP1.1";
        }
        System.out.println(str);
        ParseString.parse(str);
        System.out.println("=============================================================================");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
