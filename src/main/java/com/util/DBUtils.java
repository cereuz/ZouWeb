package com.util;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/4/12 17:05.
 * @motto : To be, or not to be.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作工具类
 * @author lamp
 *
 */
public class DBUtils {

    public static Connection con;

    static {
        try {
            Class.forName(Constants.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(Constants.URL_ZOU0306, Constants.USER_NAME, Constants.PASSWORD);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public static Connection getConnection(String url) {
        try {
            return DriverManager.getConnection(url, Constants.USER_NAME, Constants.PASSWORD);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        if (con != null) {
                            try {
                                con.close();
                            } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 创建数据库 表
     * @param sql
     */
    public static void createTable(String sql){
        con = getConnection(Constants.URL_ZOU0306);  //调用getConnection()方法连接数据库
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement(sql);//预处理
            ps.executeUpdate();//执行更新操作
            LogZ.debug("創建數據庫：" + sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            close( null, ps, con);//调用close()方法关闭资源
        }
    }

    /**
     * 增删改
     * @param sql
     * @param obj
     */
    public static void executeUpdate(String sql,Object...obj){
        con = getConnection(Constants.URL_ZOU0306);  //调用getConnection()方法连接数据库
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement(sql);//预处理
            for(int i=0;i<obj.length;i++){//预处理声明占位符
                ps.setObject(i+1, obj[i]);
            }
            ps.executeUpdate();//执行更新操作
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            close( null, ps, con);//调用close()方法关闭资源
        }
    }


    /**
     * 查询
     * @param sql
     * @param obj
     * @return
     */
    public static List<Map<String,Object>> executeQuery(String sql, Object...obj){
        Connection con = getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement(sql);
            for(int i=0;i<obj.length;i++){
                ps.setObject(i+1, obj[i]);
            }
            rs = ps.executeQuery();
            //new 一个空的list集合用来存放查询结果
            List<Map<String ,Object>> list=new ArrayList<>();
            //获取结果集的列数
            int count = rs.getMetaData().getColumnCount();
            //对结果集遍历每一条数据是一个Map集合，列是k,值是v
            while(rs.next()){
                //一个空的map集合，用来存放每一行数据
                Map<String, Object> map=new HashMap<String, Object>();
                for(int i=0;i<count;i++){
                    Object ob=rs.getObject(i+1);//获取值
                    String key = rs.getMetaData().getColumnName(i+1);//获取k即列名
                    map.put(key, ob);
                }
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            close(rs, ps, con);
        }
        return null;
    }
}