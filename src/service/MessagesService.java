package service;


import java.util.ArrayList;
import java.util.Scanner;
import model.Message;
import dao.DAOMessages;

public class MessagesService {
    static Scanner scan = new Scanner(System.in);

    public static void createMessage() {
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
        Message messageToEdit = new Message();

        System.out.println("Please select the message ID you want to edit: ");
        messageToEdit.setMessageID(Integer.parseInt(scan.nextLine()));

        System.out.println("Please enter the new message: ");
        messageToEdit.setMessage(scan.nextLine());

        DAOMessages.updateMessageDB(messageToEdit);

    }

    public static void deleteMessage() {
        System.out.println("Enter the message ID to delete: ");
        int messageID = Integer.parseInt(scan.nextLine());
        DAOMessages.deleteMessageDB(messageID);
    }

}
