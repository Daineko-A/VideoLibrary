package entitys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by PloSkiY on 16.04.2017.
 */
public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/video_library";
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
