package Util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 * @auther plg
 * @date 2019/7/8 12:03
 */
public class JDBCUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件的读取，只读取一次就可以拿到这些值
     * 使用静态代码块
     * 随着类的加载而加载，且只会执行一次
     */


    static{
          // 读取资源配置文件
        try {
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            InputStream in  = classLoader.getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(in);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            // 注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接对象,
     * @return
     */
    public static Connection getConnnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     * @param statement
     * @param connection
     */
    public static void close(Statement statement,Connection connection){
        try{
            if(statement != null){
                statement.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放资源
     * @param set
     */
    public static void close(Statement statement,Connection connection,ResultSet set){
        try{
            if(statement != null){
                statement.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        if(set != null){
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 * properties 文件读取返回值为null的解决办法
 * file -->  project structure -->Moduse -> resource -->...
 * 配置文件放在src目录下
 */
