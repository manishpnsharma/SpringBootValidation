package com.manishpnsharma.validation.module;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 20, message = "Name should be between 3 and 20 characters")
    private String name;
    @NotNull
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    //@Size(min = 5, max = 14, message = "Email should be between 5 and 14 characters")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
