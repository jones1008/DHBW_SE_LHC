package main.infrastructure.security;

public class RFID implements ICommunication {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
