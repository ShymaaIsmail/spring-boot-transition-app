package training.demo;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.Before;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import training.demo.model.EmployeeModel;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

class EmployeeRestControllerIntegrationTest extends AbstractTest {

   EmployeeModel Employee_1 = new EmployeeModel(1l, "Emp1");
   EmployeeModel Employee_2 = new EmployeeModel(2l, "Emp2");
   EmployeeModel Employee_3 = new EmployeeModel(3l, "Emp3");

   @Override
   @Before
   public void setUp() {
      super.setUp();
   }

   @Test
   void contextLoads() {
   }

   @Test
   public void getAllEmployees_success() throws Exception {

      mvc.perform(MockMvcRequestBuilders.get("/employee/all").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[2].name", is("Jane Doe")));
   }

   @Test
   public void getEmployeesListWithoutMock() throws Exception {
      String uri = "/employee/all";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
            .andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      EmployeeModel[] employeelist = super.mapFromJson(content, EmployeeModel[].class);
      assertTrue(employeelist.length == 4);
   }

}
