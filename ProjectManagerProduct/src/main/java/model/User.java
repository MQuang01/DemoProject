package model;

public class User {
    private long id;
    private String name;
    private String password;

    private ERole eRole;

    public User(long id, String name, String password, ERole eRole) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.eRole = eRole;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole geteRole() {
        return eRole;
    }

    public void seteRole(ERole eRole) {
        this.eRole = eRole;
    }
}
