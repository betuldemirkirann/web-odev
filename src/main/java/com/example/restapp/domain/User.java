package com.example.restapp.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    public List<String> hastaliklar = new ArrayList<>();
    public List<String> ilaclar = new ArrayList<>();
    public List<String> tahliller = new ArrayList<>();

}
