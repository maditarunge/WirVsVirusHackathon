package Model;

public class User {

    private String username;
    private String password;        //TODO MR 2020-03-21 1015: encrypt
    private String firstName;
    private String surName;
    private String plz;             //maybe use full address?

    public User(String username, String password, String firstName, String surName, String plz)
    {
        this(username, password);
        setFirstName(firstName);
        setSurName(surName);
        setPlz(plz);
    }

    public User(String username, String password)
    {
        setUsername(username);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }
}
