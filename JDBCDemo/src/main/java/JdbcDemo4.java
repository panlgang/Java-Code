import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除语句
 * @auther plg
 * @date 2019/7/8 11:17
 */
public class JdbcDemo4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","like12345");
               Statement statement = connection.createStatement();){
           String sql = "delete from account where id = 4 ";
            int count = statement.executeUpdate(sql);
            System.out.println(count);
        } catch (SQLException e) {
           e.printStackTrace();
       }
    }
}
