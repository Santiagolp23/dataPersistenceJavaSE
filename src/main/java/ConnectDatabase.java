import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectDatabase {
    public Connection get_connection() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_messages","root", "");
            if (connect!= null) {
                System.out.println("Sucessful conneciton");
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return connect;
    }
}
