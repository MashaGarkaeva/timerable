package sample;

import javafx.scene.control.PasswordField;

public class User {
    private String name;
    private String surname;
    private String patronymic;
    private String login;
    private String password;
    private String post;

    public User(String name, String surname, String patronymic, String login, String password, String post) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
        this.post = post;
    }

    public User(String name, String surname, String patronymic, String login, String password) {}


    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    /*public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
    private String Email;
    private String Password;

    public User(String email, String password){
        this.Email = email;
        this.Password = password;
    }

    public User(String email, PasswordField password) {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
