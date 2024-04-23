package org.customer.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCasesUsingXml extends AbstractTestNGSpringContextTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	@Order(1)
	public void customerAddSucess() throws Exception {
	    RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/customer/add")
	            .content("<CustomerRequest>\r\n"
	                    + "    <firstName>John</firstName>\r\n"
	                    + "    <lastName>Doe</lastName>\r\n"
	                    + "    <middleName>Smith</middleName>\r\n"
	                    + "    <dateOfBirth>1990-05-15</dateOfBirth>\r\n"
	                    + "    <addressLine1>123 Main Street</addressLine1>\r\n"
	                    + "    <addressLine2>Apt 101</addressLine2>\r\n"
	                    + "    <zip>12345</zip>\r\n"
	                    + "    <city>New York</city>\r\n"
	                    + "    <state>NY</state>\r\n"
	                    + "    <country>USA</country>\r\n"
	                    + "    <mobilePhone>1234567890</mobilePhone>\r\n"
	                    + "    <homePhone>0987654321</homePhone>\r\n"
	                    + "    <workPhone>321-654-9870</workPhone>\r\n"
	                    + "    <emailID>broad129115314514.doe@example.com</emailID>\r\n"
	                    + "    <customerId>123456</customerId>\r\n"
	                    + "</CustomerRequest>")
	            .contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

	    mockMvc.perform(requestBuilder)
	            .andExpect(status().isOk())
	            .andExpect(xpath("/CustomerResponse/status").string("Success"))
	            .andExpect(xpath("/CustomerResponse/message").string("Customer added successfully"))
	            .andReturn();
	}


	@Test
	@Order(2)
	public void emailAlreadyExitXml() throws Exception {
	    RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/customer/add")
	            .content("<CustomerRequest>\r\n"
	                    + "    <firstName>John</firstName>\r\n"
	                    + "    <lastName>Doe</lastName>\r\n"
	                    + "    <middleName>Smith</middleName>\r\n"
	                    + "    <dateOfBirth>1990-05-15</dateOfBirth>\r\n"
	                    + "    <addressLine1>123 Main Street</addressLine1>\r\n"
	                    + "    <addressLine2>Apt 101</addressLine2>\r\n"
	                    + "    <zip>12345</zip>\r\n"
	                    + "    <city>New York</city>\r\n"
	                    + "    <state>NY</state>\r\n"
	                    + "    <country>USA</country>\r\n"
	                    + "    <mobilePhone>1234567890</mobilePhone>\r\n"
	                    + "    <homePhone>0987654321</homePhone>\r\n"
	                    + "    <workPhone>321-654-9870</workPhone>\r\n"
	                    + "    <emailID>david12.doe@example.com</emailID>\r\n"
	                    + "    <customerId>123456</customerId>\r\n"
	                    + "</CustomerRequest>")
	            .contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

	    mockMvc.perform(requestBuilder).andExpect(status().isOk())
	            .andExpect(xpath("/CustomerResponse/status").string("Error")) // Update expectation here
	            .andExpect(xpath("/CustomerResponse/message").string("Email is already exist! Please enter valid emailID")).andReturn();
	}

	
	@Test
	@Order(3)
	public void updateCustomerSuccess() throws Exception {
	    RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/customer/update/cummins.doe@example.com")
	            .content("<CustomerRequest>\r\n"
	                    + "    <firstName>John</firstName>\r\n"
	                    + "    <lastName>Doe</lastName>\r\n"
	                    + "    <middleName>Smith</middleName>\r\n"
	                    + "    <dateOfBirth>1990-05-15</dateOfBirth>\r\n"
	                    + "    <addressLine1>123 Main Street</addressLine1>\r\n"
	                    + "    <addressLine2>Apt 101</addressLine2>\r\n"
	                    + "    <zip>12345</zip>\r\n"
	                    + "    <city>New York</city>\r\n"
	                    + "    <state>NY</state>\r\n"
	                    + "    <country>USA</country>\r\n"
	                    + "    <mobilePhone>1234567890</mobilePhone>\r\n"
	                    + "    <homePhone>0987654321</homePhone>\r\n"
	                    + "    <workPhone>321-654-9870</workPhone>\r\n"
	                    + "    <emailID>cummins.doe@example.com</emailID>\r\n"
	                    + "    <customerId>123456</customerId>\r\n"
	                    + "</CustomerRequest>")
	            .contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

	    mockMvc.perform(requestBuilder).andExpect(status().isOk())
	            .andExpect(xpath("/CustomerResponse/status").string("Success")) // Update expectation here
	            .andExpect(xpath("/CustomerResponse/message").string("Customer Update successfully")).andReturn();
	}

	
	@Test
	@Order(4)
	public void getCustomerDataSuccess() throws Exception {
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .get("/api/v1/customer/search/root.doe@example.com")
	            .contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

	    mockMvc.perform(requestBuilder)
	            .andExpect(status().isOk())
	            .andExpect(xpath("/CustomerResponse/status").string("Success")) // Update expectation here
	            .andExpect(xpath("/CustomerResponse/message").string("Customer Found successfully"))
	            .andExpect(xpath("/CustomerResponse/customerCode").string(Matchers.matchesRegex("\\d+")))
	            .andExpect(xpath("/CustomerResponse/customerData/firstName").string("John"))
	            .andExpect(xpath("/CustomerResponse/customerData/lastName").string("Doe"))
	            .andExpect(xpath("/CustomerResponse/customerData/middleName").string("Smith"))
	            .andExpect(xpath("/CustomerResponse/customerData/dateOfBirth").string("1990-05-15"))
	            .andExpect(xpath("/CustomerResponse/customerData/addressLine1").string("123 Main Street"))
	            .andExpect(xpath("/CustomerResponse/customerData/addressLine2").string("Apt 101"))
	            .andExpect(xpath("/CustomerResponse/customerData/zip").string("12345"))
	            .andExpect(xpath("/CustomerResponse/customerData/city").string("New York"))
	            .andExpect(xpath("/CustomerResponse/customerData/state").string("NY"))
	            .andExpect(xpath("/CustomerResponse/customerData/country").string("USA"))
	            .andExpect(xpath("/CustomerResponse/customerData/mobilePhone").string("1234567890"))
	            .andExpect(xpath("/CustomerResponse/customerData/homePhone").string("0987654321"))
	            .andExpect(xpath("/CustomerResponse/customerData/workPhone").string("321-654-9870"))
	            .andExpect(xpath("/CustomerResponse/customerData/emailID").string("root.doe@example.com"))
	            .andExpect(xpath("/CustomerResponse/customerData/customerId").string(Matchers.matchesRegex("\\d+")))
	            .andReturn();
	}


	
	
	@Test
	@Order(5)
	public void emailIdNotPresent() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/customer/search/collin.doe@example.com")
				.contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

		mockMvc.perform(requestBuilder).andExpect(status().isOk())
		.andExpect(xpath("/CustomerResponse/status").string("Fail"))
		.andExpect(xpath("/CustomerResponse/message").string("Customer not found")).andReturn();
	}

}
