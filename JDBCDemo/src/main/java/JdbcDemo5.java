import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询数据，封装对象
 * @auther plg
 * @date 2019/7/8 11:43
 */
public class JdbcDemo5 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Account> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","like12345");
            String sql = "select * from account";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int balance = resultSet.getInt("balance");
                list.add(new Account(id,balance));
            }
            System.out.println(list);

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
                if(resultSet != null) {
                    resultSet.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
class Account{
    private int id;
    private int balance;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}