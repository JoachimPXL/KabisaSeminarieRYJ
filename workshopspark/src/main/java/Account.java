import java.util.ArrayList;
import java.util.List;

public class Account {

    private int id;
    private String username;
    private String password;
    private List<Message> message;

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.message = new ArrayList<Message>();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void addMessage(Message message) {
        this.message.add(message);
    }

}
