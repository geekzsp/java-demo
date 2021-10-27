package xyz.mosss.spring.examples.framework;

public class MessageService {
    private String id;

    public MessageService(String id) {
        this.id = id;
    }

    public MessageService() {
    }

    public void showId() {
        System.out.println("id is:" + id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
