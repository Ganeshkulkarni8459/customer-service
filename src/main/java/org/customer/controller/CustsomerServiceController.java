package org.customer.controller;

import jakarta.validation.Valid;
import org.customer.dto.CustomerRequest;
import org.customer.dto.CustomerResponse;
import org.customer.dto.DiscountRequest;
import org.customer.dto.DiscountResponse;
import org.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustsomerServiceController {

  @Autowired CustomerServiceImpl CustomerServiceImpl;

  @PostMapping(
      path = "/api/v1/customer/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public CustomerResponse addCustomerDetails(@Valid @RequestBody CustomerRequest request) {
    return CustomerServiceImpl.addCustomerDetails(request);
  }

  @PostMapping(
      path = "/api/v1/customer/update/{emailId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public CustomerResponse update(
      @PathVariable String emailId, @RequestBody CustomerRequest request) {
    return CustomerServiceImpl.updateCustomerDetails(emailId, request);
  }

  @GetMapping(path = "/api/v1/customer/search/{emailId}")
  public CustomerResponse searchCustomerByMobileNumber(@PathVariable String emailId) {
    return CustomerServiceImpl.findByMobileNumber(emailId);
  }

  @PostMapping(
      path = "/api/v1/customer/discount",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public DiscountResponse discountServiceController(@RequestBody DiscountRequest request) {
    return CustomerServiceImpl.getDiscount(request);
  }
}
