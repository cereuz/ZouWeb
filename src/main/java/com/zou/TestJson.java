package com.zou;

import com.google.gson.Gson;
import com.bean.Book;
import com.util.Constants;

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

@WebServlet("/TestJson")
public class TestJson extends HttpServlet {

    public TestJson() {
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
            PreparedStatement prst = connection.prepareStatement(Constants.SQL_SELECT_BOOK);
            //结果集
            ResultSet rs = prst.executeQuery();
            Gson gson = new Gson();
//            ArrayList<Book> list = new ArrayList<Book>();
            Book book = new Book();
            // 展开结果集数据库
            while (rs.next()) {
                book.setId_B(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setISBN(rs.getString(3));
                book.setPrice(rs.getString(4));
                book.setAuthor(rs.getString(5));
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
