package net.efrei.start.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import net.efrei.start.global.Country;

@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String firstname;

    @Min(0)
    private int age;

    @Enumerated(EnumType.STRING)
    private Country country;

    // Constructors
    public Person() {}

    public Person(@NotBlank String name, @NotBlank String firstname, @Min(0) int age, Country country) {
        this.name = name;
        this.firstname = firstname;
        this.age = age;
        this.country = country;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getAge() {
        return age;
    }

    public Country getCountry() {
        return country;
    }

    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}