import com.util.Constants;
import com.util.CreateID;
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

    public static void main(String[] args) {
/*        createTable();
        insertDataBooks();*/
/*        for (int i = 0; i < 100; i++) {
            LogZ.error(CreateID.getCard());
        }*/

/*      Boolean eCard = DBUtils.selectByCardNum(Constants.SQL_SELECT_UBER_UDID,"2524");//生成的随机数进入数据库中查询一下，看时候有相同的。
        LogZ.error( eCard + "==");*/

         for(int i = 0; i < 1000000; i++){
             insertDataUber();
         }
    }

    /**
     * 插入数据
     */
    private static void insertDataBooks() {
        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"白夜行","9787544242516","29.80元","[日] 东野圭吾");
        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"活着","9787506365437","20.00元","余华");
        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"围城 ","9787020024759","19.00元","钱钟书");

        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"白夜行","9787544242516","29.80元","[日] 东野圭吾");
        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"活着","9787506365437","20.00元","余华");
        DBUtils.executeUpdate(Constants.SQL_INSERT_BOOKS,"围城 ","9787020024759","19.00元","钱钟书");
    }

    private static void insertDataUber() {
        String UDID = CreateID.returnCard();
        DBUtils.executeUpdate(Constants.SQL_INSERT_UBER, UDID,"车找人","杭州","梅川","5月1日","4","150","蜗牛","13282380039","福特蒙迪欧","6年","909606812","顺路的可以包接送。");
    }

    /**
     * 新建表
     */
    @Test
    public static void createTable() {
        DBUtils.createTable(Constants.SQL_CREATE_BOOK);
        DBUtils.createTable(Constants.SQL_CREATE_PERSON);
        DBUtils.createTable(Constants.SQL_CREATE_WORK);
        DBUtils.createTable(Constants.SQL_CREATE_UBER);
    }
}
