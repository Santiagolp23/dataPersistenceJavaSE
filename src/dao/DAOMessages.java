package dao;

import model.Message;
import service.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOMessages {

    public static void createMessageDB(Message message) {
        try (Connection connect = ConnectDatabase.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO `messages` (`message`, `message_author`) VALUES (?,?)";
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

    public static ArrayList<Message> readMessagesDB() {
        ArrayList<Message> allMessages = new ArrayList<>();
        try (Connection connect = ConnectDatabase.getConnection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM messages";
                ps = connect.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Message currentMessage = new Message();
                    currentMessage.setMessageID(rs.getInt("message_id"));
                    currentMessage.setMessage(rs.getString("message"));
                    currentMessage.setMessageAuthor(rs.getString("message_author"));
                    allMessages.add(currentMessage);
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allMessages;
    }


    public static void updateMessageDB(Message message) {
        try (Connection connect = ConnectDatabase.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE messages SET message = ? WHERE messages.message_id = ?";
                ps = connect.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setInt(2, message.getMessageID());
                ps.executeUpdate();
                System.out.println("Message updated successfully");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static void deleteMessageDB(int messageID) {
        try (Connection connect = ConnectDatabase.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM messages WHERE messages.message_id = ?";
                ps = connect.prepareStatement(query);
                ps.setInt(1, messageID);
                ps.executeUpdate();
                System.out.println("Message has been deleted");

            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("Message couldn't be deleted");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
