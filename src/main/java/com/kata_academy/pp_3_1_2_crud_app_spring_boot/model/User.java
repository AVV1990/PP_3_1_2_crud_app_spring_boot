package com.kata_academy.pp_3_1_2_crud_app_spring_boot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;

    public User() {
    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User user = (User) obj;
        return this.age == user.age
                && (this.firstName == user.firstName || (this.firstName != null && this.firstName.equals(user.firstName)))
                && (this.lastName == user.lastName || (this.lastName != null && this.lastName.equals(user.lastName)));
    }


    @Override
    public int hashCode() {
        return 31 + (age == 0 ? 0 : Integer.valueOf(age).hashCode()) + (firstName == null ? 0 : firstName.hashCode()) + (lastName == null ? 0 : lastName.hashCode());
    }

    @Override
    public String toString() {
        return String.format(" User = [firstName = %s, lastName = %s, age = $d]", firstName, lastName, age);
    }
}

