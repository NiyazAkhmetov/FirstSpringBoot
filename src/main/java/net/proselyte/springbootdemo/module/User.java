package net.proselyte.springbootdemo.module;

import jakarta.persistence.*;
import lombok.Data;

@Data //означает, что по умолчанию будут реализованы некоторые геттерысеттеры и метод toString()
@Entity //показывает, что java class User связан с БД
@Table(name ="users") // спросят ну че ну и как связано спиздани хуяк нахуй вот название таблицы users
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    @Override
    public String toString() {return "name: " + firstName +" " + lastName;}
}

