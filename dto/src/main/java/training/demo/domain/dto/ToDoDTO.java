 
package training.demo.domain.dto;

import org.joda.time.DateTime;

import com.googlecode.jmapper.annotations.JGlobalMap;
 

import lombok.*; 


@NoArgsConstructor 
@AllArgsConstructor
@Getter
@Setter 
@JGlobalMap
public class ToDoDTO {
  
   private Long id;
   
   private String description; 
   
   private boolean isDone; 
   
   private DateTime targetDate; 
  
   private long employee_id;
}



