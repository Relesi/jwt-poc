package com.relesi.jwt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.relesi.jwt.enums.ProfileEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private ProfileEnum profile;

    @DBRef(lazy = true)
    private List<Admin> admin = new ArrayList<>();

    public User() {

    }

    public User(String id, String name, String email, String password, ProfileEnum profile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }


    public List<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(List<Admin> admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                ", admin=" + admin +
                '}';
    }
}


