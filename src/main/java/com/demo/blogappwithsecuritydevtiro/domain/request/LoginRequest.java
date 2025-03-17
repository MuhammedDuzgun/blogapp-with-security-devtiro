package com.demo.blogappwithsecuritydevtiro.domain.request;

public class LoginRequest {

    private String email;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String email, String pasword) {
        this.email = email;
        this.password = pasword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
