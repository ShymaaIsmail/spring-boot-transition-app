package training.demo.domain.dto;

import org.joda.time.DateTime; 
import com.googlecode.jmapper.annotations.JMap; 
import lombok.*; 

@NoArgsConstructor 
@AllArgsConstructor
@Getter
@Setter
public class ToDoDTO {
  
   @JMap()
   private Long id;
  
   @JMap()
   private String description; 
    
   
   @JMap()
   private Boolean done; 

   @JMap()
   private DateTime targetDate; 
  
   @JMap("${employee.name}")
   private String employeeName;

   @JMap("${employee.id}")
   private long employeeId;
}



