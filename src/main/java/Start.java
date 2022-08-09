import java.sql.Connection;

public class Start {
    public static void main(String[] args) {

        ConnectDatabase connect = new ConnectDatabase();

        try (Connection cnx = connect.get_connection()){

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
