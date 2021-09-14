package training.demo.domain.dto;
 
import com.googlecode.jmapper.annotations.JGlobalMap;
 
import lombok.*; 



@NoArgsConstructor 
@AllArgsConstructor
@Getter
@Setter
@JGlobalMap
public class EmployeeDTO {
  
  private Long id;
 
  private String name; 
   
}

