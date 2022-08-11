import java.sql.Connection;
import java.util.Scanner;
import service.*;
import dao.*;

public class Start {
    public static void main(String[] args) {
        int option = 0;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("--------------");
            System.out.println("Messages App");
            System.out.println("1. Create message");
            System.out.println("2. List Messages");
            System.out.println("3. Edit Message");
            System.out.println("4. Delete Message");
            System.out.println("5. Exit");

            option = Integer.parseInt(scan.nextLine());

            switch (option) {
                case 1:
                    MessagesService.createMessage();
                    break;

                case 2:
                    MessagesService.listMessage();
                    break;

                case 3:
                    MessagesService.editMessage();
                    break;
                case 4:
                    MessagesService.deleteMessage();
                    break;
                default:
                    break;
            }

        } while (option!=5);

    }
}
