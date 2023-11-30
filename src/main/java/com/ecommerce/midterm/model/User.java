package com.ecommerce.midterm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String gender;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dob;
    private boolean enabled = true;

    public User() {

    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Order> orders;

}
