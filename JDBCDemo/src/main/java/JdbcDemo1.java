import java.sql.*;

/**
 * @auther plg
 * @date 2019/7/7 18:35
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2 创建连接者对象
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","like12345");
        // 3、sql语句
        String sql = "update account set balance = 20000 where id = 2";
        // 4 创建执行sql语句的对象
        Statement statement = connect.createStatement();
        // 5 执行sql语句
        int ret = statement.executeUpdate(sql);
        System.out.println(ret);
        // 6 关闭资源
        statement.close();
        connect.close();

    }
}
