package service;


import java.util.ArrayList;
import java.util.Scanner;
import model.Message;
import dao.DAOMessages;

public class MessagesService {
    public static void createMessage() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your message: ");
        String message = scan.nextLine();
        System.out.println("Your name: ");
        String name = scan.nextLine();

        Message messageObj = new Message();
        messageObj.setMessage(message);
        messageObj.setMessageAuthor(name);
        DAOMessages.createMessageDB(messageObj);

    }

    public static void listMessage() {
        ArrayList<Message> messagesList = DAOMessages.readMessagesDB();

        for (Message currentMessage:messagesList) {
            System.out.println("ID: " + currentMessage.getMessageID());
            System.out.println("Message: " + currentMessage.getMessage());
            System.out.println("Author: " + currentMessage.getMessageAuthor());
        }
        
    }

    public static void editMessage() {
    }

    public static void deleteMessage() {
    }

}
