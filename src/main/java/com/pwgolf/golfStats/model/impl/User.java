package com.pwgolf.golfStats.model.impl;

import jakarta.persistence.*;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    @NonNull
    private String email;
    private String password;
    @Transient
    boolean loggedIn;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private List<PlayedHole> playedHoles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public List<PlayedHole> getPlayedHoles() {
        return playedHoles;
    }

    public void setPlayedHoles(List<PlayedHole> playedHoles) {
        this.playedHoles = playedHoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }
}
