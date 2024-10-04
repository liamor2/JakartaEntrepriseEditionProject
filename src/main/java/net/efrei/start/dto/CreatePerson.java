package net.efrei.start.dto;

public abstract class CreatePerson {
  
  private String name;
  private String firstname;
  private int age;
  private String country;

  public CreatePerson() {}

  public CreatePerson(String name, String firstname, int age, String country) {
    this.name = name;
    this.firstname = firstname;
    this.age = age;
    this.country = country;
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

  public String getCountry() {
    return country;
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

  public void setCountry(String country) {
    this.country = country;
  }
}