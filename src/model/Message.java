package model;

public class Message {
    int id_message;
    String message, messageAuthor, messageDate;

    public Message(String message, String messageAuthor, String messageDate) {
        this.message = message;
        this.messageAuthor = messageAuthor;
        this.messageDate = messageDate;
    }

    public Message() {
    }

    public int getMessageID() {
        return id_message;
    }

    public void setMessageID(int id_message) {
        this.id_message = id_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(String messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }
}
