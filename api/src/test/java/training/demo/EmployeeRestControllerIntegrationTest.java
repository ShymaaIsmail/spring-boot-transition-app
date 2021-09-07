package training.demo; 
import org.junit.jupiter.api.Test; 
import org.springframework.http.MediaType;  
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders; 
import org.junit.Before;  
import org.springframework.test.web.servlet.MvcResult;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
 
import training.demo.domain.entity.Employee;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
 

  class EmployeeRestControllerIntegrationTest extends AbstractTest  {

   Employee Employee_1 = new Employee(1l, "Emp1");
   Employee Employee_2 = new Employee(2l, "Emp2");
   Employee Employee_3 = new Employee(3l, "Emp3");
   

   @Override
   @Before
   public void setUp() {
      super.setUp();
   } 

   @Test  
void contextLoads()   
{  
}  

   @Test
public void getAllEmployees_success() throws Exception {
  
    mvc.perform(MockMvcRequestBuilders
            .get("/employee/all")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[2].name", is("Jane Doe")));
}

    @Test
    public void getEmployeesListWithoutMock() throws Exception {
       String uri = "/employee/all";
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
          .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
       String content = mvcResult.getResponse().getContentAsString();
       Employee[] employeelist = super.mapFromJson(content, Employee[].class);
       assertTrue(employeelist.length == 4);
    }

     
}

     
 