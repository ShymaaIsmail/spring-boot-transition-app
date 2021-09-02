package com.example.transitiondemoapp.transitiondemo.model;

public class Employee {

  private Long id;
  private String name; 
  Employee() {}

  public Employee(Long id, String name) {

    this.name = name;
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
 
  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }   
}
