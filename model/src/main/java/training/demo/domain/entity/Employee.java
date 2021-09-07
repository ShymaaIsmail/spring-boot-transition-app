package training.demo.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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


@Override
public String toString() 
{
return "Employee [id=" + id + ", uname=" + name + "]";
}
}

