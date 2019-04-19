package com.zou;

import com.google.gson.Gson;
import com.util.Book;
import com.util.Constants;
import com.util.Uber;

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

        Connection connection = null;
        response.setContentType("text/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        /**
         * 设置响应内容类型
         */
        try {

 /*         Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?useSSL=false", "map", "maptest");

            Statement stmt = connect.createStatement(); //创建Statement对象
            String sql;
            sql = "SELECT * FROM admininfo";
            ResultSet rs = stmt.executeQuery(sql);
           JSONArray jsonarray = new JSONArray();
            JSONObject jsonobj = new JSONObject();*/

            //加载mysql的驱动类
            Class.forName(Constants.DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(Constants.URL_ZOU0306, Constants.USER_NAME, Constants.PASSWORD);
//            connection = DBUtils.getConnection();
            PreparedStatement prst = connection.prepareStatement(Constants.SQL_SELECT_UBER_UDID2);
            prst.setObject(1,"936250");
            //结果集
            ResultSet rs = prst.executeQuery();
            Gson gson = new Gson();
//            ArrayList<Book> list = new ArrayList<Book>();
            Uber book = new Uber();
            // 展开结果集数据库
            //    public int Id;
            //    public String UDID;
            //    public String Type;
            //    public String Departure;
            //    public String Destination;
            //    public String Time;
            //    public String Seat;
            //    public String Cost;
            //    public String NickName;
            //    public String Phone;
            //    public String Automobile;
            //    public String Experience;
            //    public String QQ;
            //    public String Remark;
            while (rs.next()) {
                book.setId(rs.getInt(1));
                book.setUDID(rs.getString(2));
                book.setType(rs.getString(3));
                book.setDeparture(rs.getString(4));
                book.setDestination(rs.getString(5));
                book.setTime(rs.getString(6));
                book.setSeat(rs.getString(7));
                book.setCost(rs.getString(8));
                book.setNickName(rs.getString(9));
                book.setPhone(rs.getString(10));
                book.setAutomobile(rs.getString(11));
                book.setExperience(rs.getString(12));
                book.setQQ(rs.getString(13));
                book.setRemark(rs.getString(14));
//                list.add(book);

/*              // 通过字段检索
                jsonobj.put("管理员", rs.getString("Aname"));
                jsonobj.put("密码", rs.getString("Apwd"));
                jsonobj.put("等级", rs.getString("Alevel"));
                jsonarray.add(jsonobj);*/

            }
            // 输出数据
            out = response.getWriter();

            out.println(gson.toJson(book));
            // 完成后关闭
            rs.close();
            prst.close();
            connection.close();
        } catch (Exception e) {
            out.print("get data error!");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
