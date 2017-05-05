package entitys;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by PloSkiY on 16.04.2017.
 */
public class ConnectionManager {
//    private static final String URL = "jdbc:mysql://localhost:3306/video_library?autoReconnect=true&useSSL=false&characterEncoding=UTF-8";
//    private static final String USERNAME = "root";
//    private static final String PASS = "root";
//    private static DataSource dataSource;
//
//    static {
//        PoolProperties poolProperties = new PoolProperties();
//        poolProperties.setDriverClassName("com.mysql.jdbc.Driver");
//        poolProperties.setUrl(URL);
//        poolProperties.setUsername(USERNAME);
//        poolProperties.setPassword(PASS);
//        dataSource = new DataSource(poolProperties);
//    }
//
//    private ConnectionManager() {}
//
//    public static Connection getConnection() throws SQLException {
//        return dataSource.getConnection();
//    }

    private static final String URL = "jdbc:mysql://localhost:3306/video_library?autoReconnect=true&useSSL=false&characterEncoding=UTF-8";
    private static final String USERNAME = "root";
    private static final String PASS = "root";

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASS);
    }
}
