package ru.olkov.springBoot.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Введите имя!")
    @Size(min = 2, max = 40, message = "Имя должно быть в диапазоне от 2 до 40")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Введите фамилию!")
    @Size(min = 2, max = 40, message = "Фамилия должна быть в диапазоне от 2 до 40")
    @Column(name = "surname")
    private String surName;

    @Min(value = 0,message = "Возраст не может быть отрицательным!")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Заполните поле email!")
    @Email(message = "Неверный формат email")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(String name, String surName, int age, String email) {

        this.name = name;
        this.surName = surName;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
