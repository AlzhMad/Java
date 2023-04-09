package models;

public class User {
    private Long id;
    private String login;
    private String password;
    private String role;
    private String fullname;

    public User() {
    }

    public User(Long id, String login, String password, String role, String fullname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
