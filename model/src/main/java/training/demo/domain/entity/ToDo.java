package training.demo.domain.entity;
  
import org.joda.time.DateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*; 


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "TODO")
public class ToDo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String description; 
   private boolean isDone; 
   private DateTime targetDate; 


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "employee_id",nullable = false, foreignKey =@ForeignKey(name = "fk_todos_employees_id")  )
    @JsonIgnore 

   private Employee employee;

   
 
}