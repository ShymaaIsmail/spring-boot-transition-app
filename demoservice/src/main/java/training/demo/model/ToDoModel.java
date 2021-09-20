package training.demo.model;

import org.joda.time.DateTime;
import com.googlecode.jmapper.annotations.JMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ToDoModel {

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
