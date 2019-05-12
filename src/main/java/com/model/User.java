package com.model;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class User {
   private String login;
   private String apiKey;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(apiKey, user.apiKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, apiKey);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }
}
