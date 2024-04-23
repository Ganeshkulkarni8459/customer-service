package org.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCasesUsingJson extends AbstractTestNGSpringContextTests {

  @Autowired MockMvc mockMvc;

  @Test
  @Order(1)
  public void emailAlreadyExitJson() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/customer/add")
            .content(
                "{\r\n"
                    + "  \"firstName\": \"John\",\r\n"
                    + "  \"lastName\": \"Doe\",\r\n"
                    + "  \"middleName\": \"Smith\",\r\n"
                    + "  \"dateOfBirth\": \"1990-05-15\",\r\n"
                    + "  \"addressLine1\": \"123 Main Street\",\r\n"
                    + "  \"addressLine2\": \"Apt 101\",\r\n"
                    + "  \"zip\": \"12345\",\r\n"
                    + "  \"city\": \"New York\",\r\n"
                    + "  \"state\": \"NY\",\r\n"
                    + "  \"country\": \"USA\",\r\n"
                    + "  \"mobilePhone\": \"1234567890\",\r\n"
                    + "  \"homePhone\": \"0987654321\",\r\n"
                    + "  \"workPhone\": \"321-654-9870\",\r\n"
                    + "  \"emailID\": \"maxwell.doe@example.com\",\r\n"
                    + "  \"customerId\": 123456\r\n"
                    + "}")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Error"))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.message")
                .value("Email is already exist! Please enter valid emailID"))
        .andReturn();
  }

  @Test
  @Order(2)
  public void customerAddSucessJson() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/customer/add")
            .content(
                "{\r\n"
                    + "  \"firstName\": \"John\",\r\n"
                    + "  \"lastName\": \"Doe\",\r\n"
                    + "  \"middleName\": \"Smith\",\r\n"
                    + "  \"dateOfBirth\": \"1990-05-15\",\r\n"
                    + "  \"addressLine1\": \"123 Main Street\",\r\n"
                    + "  \"addressLine2\": \"Apt 101\",\r\n"
                    + "  \"zip\": \"12345\",\r\n"
                    + "  \"city\": \"New York\",\r\n"
                    + "  \"state\": \"NY\",\r\n"
                    + "  \"country\": \"USA\",\r\n"
                    + "  \"mobilePhone\": \"1234567890\",\r\n"
                    + "  \"homePhone\": \"0987654321\",\r\n"
                    + "  \"workPhone\": \"321-654-9870\",\r\n"
                    + "  \"emailID\": \"adam495211892.doe@example.com\",\r\n"
                    + "  \"customerId\": 123456\r\n"
                    + "}")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Success"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Customer added successfully"))
        .andReturn();
  }

  @Test
  @Order(3)
  public void updateCustomerSuccess() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/customer/update/cummins.doe@example.com")
            .content(
                "{\r\n"
                    + "  \"firstName\": \"John\",\r\n"
                    + "  \"lastName\": \"Doe\",\r\n"
                    + "  \"middleName\": \"Smith\",\r\n"
                    + "  \"dateOfBirth\": \"1990-05-15\",\r\n"
                    + "  \"addressLine1\": \"137 Main Street\",\r\n"
                    + "  \"addressLine2\": \"Apt 101\",\r\n"
                    + "  \"zip\": \"12345\",\r\n"
                    + "  \"city\": \"nagar\",\r\n"
                    + "  \"state\": \"MH\",\r\n"
                    + "  \"country\": \"India\",\r\n"
                    + "  \"mobilePhone\": \"1234567890\",\r\n"
                    + "  \"homePhone\": \"0987654321\",\r\n"
                    + "  \"workPhone\": \"321-654-9870\",\r\n"
                    + "  \"emailID\": \"cummins.doe@example.com\",\r\n"
                    + "  \"customerId\": 123456\r\n"
                    + "}")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Success"))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.message").value("Customer Update successfully"))
        .andReturn();
  }

  @Test
  @Order(4)
  public void getCustomerDataSuccess() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/customer/search/root.doe@example.com")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Success"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Customer Found successfully"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerCode").value(252))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.firstName").value("John"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.lastName").value("Doe"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.middleName").value("Smith"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.dateOfBirth").value("1990-05-15"))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.customerData.addressLine1").value("123 Main Street"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.addressLine2").value("Apt 101"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.zip").value("12345"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.city").value("New York"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.state").value("NY"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.country").value("USA"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.mobilePhone").value("1234567890"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.homePhone").value("0987654321"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.workPhone").value("321-654-9870"))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.customerData.emailID").value("root.doe@example.com"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.customerData.customerId").value(123456))
        .andReturn();
  }

  @Test
  @Order(5)
  public void emailIdNotPresent() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/customer/search/david33.doe@example.com")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Fail"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Customer not found"))
        .andReturn();
  }
}
