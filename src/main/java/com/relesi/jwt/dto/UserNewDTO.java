package com.relesi.jwt.dto;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UserNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @NotEmpty(message = "Mandatory Field")
    private String name;

    @NotEmpty(message = "Mandatory Field")
    private String password;
    @NotEmpty(message = "Mandatory Field")
    @Email(message="Email inválido")
    private String email;

    @NotEmpty(message = "Mandatory Field")
    private Integer type;


    public UserNewDTO() {
    }

    public UserNewDTO(String id, String name, String password, String email, Integer type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.type = type;
    }

//    public UserDTO(User obj) {
//    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}



