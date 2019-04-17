import com.util.Constants;
import com.util.DBUtils;
import com.util.LogZ;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/4/12 14:53.
 * @motto : To be, or not to be.
 */

public class DBTest {
    public static void main2(String[] args){
        Connection connection = null;
        try {
            //加载mysql的驱动类
            Class.forName(Constants.DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(Constants.URL, Constants.USER_NAME, Constants.PASSWORD);
//            connection = DBUtils.getConnection();
            PreparedStatement prst = connection.prepareStatement(Constants.SQL_SELECT_NAME);
            //结果集
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                LogZ.error("用户名:" + rs.getString("name"));
            }
            rs.close();
            prst.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
//        createTable();
        insertData();
    }

    /**
     * 插入数据
     */
    @Test
    private static void insertData() {
        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"白夜行","9787544242516","29.80元","[日] 东野圭吾");
        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"活着","9787506365437","20.00元","余华");
        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"围城 ","9787020024759","20.00元","钱钟书");

        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"白夜行","9787544242516","29.80元","[日] 东野圭吾");
        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"活着","9787506365437","20.00元","余华");
        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"围城 ","9787020024759","20.00元","钱钟书");
    }

    /**
     * 新建表
     */
    @Test
    public void createTable() {
        DBUtils.createTable(Constants.SQL_CREATE_BOOK);
        DBUtils.createTable(Constants.SQL_CREATE_PERSON);
        DBUtils.createTable(Constants.SQL_CREATE_WORK);
    }
}
