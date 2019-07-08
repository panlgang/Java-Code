import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 修改记录
 * @auther plg
 * @date 2019/7/8 11:09
 */
public class JdbcDemo3 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","like12345");
            String sql = "update account set balance = 1500 where id = 4";
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           try{
               if(statement != null){
                   statement.close();
               }
               if(connection != null){
                   connection.close();
               }
           }catch (SQLException e){
               e.printStackTrace();
           }
        }
    }
}
