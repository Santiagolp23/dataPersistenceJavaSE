package dao;

import model.Message;
import service.ConnectDatabase;
import java.sql.*;

public class DAOMessages {

    public static void createMessageDB(Message message) {
        try (Connection connect = ConnectDatabase.getConnection()){
            PreparedStatement ps = null;
            try {
                String query= "INSERT INTO `messages` (`message`, `message_author`) VALUES (?,?)";
                ps = connect.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getMessageAuthor());
                ps.executeUpdate();
                System.out.println("Message created correctly");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void readMessagesDB() {
    }

    public static void deleteMessageDB(int messageID) {
    }

    public static void updateMessageDB(Message message) {
    }

}
