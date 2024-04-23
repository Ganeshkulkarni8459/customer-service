package org.customer.service;

import org.customer.dto.CustomerRequest;
import org.customer.dto.CustomerResponse;

public interface CustomerService {

  public CustomerResponse addCustomerDetails(CustomerRequest customerRequest);

  public CustomerResponse updateCustomerDetails(String emailId, CustomerRequest customerRequest);

  public CustomerResponse findByMobileNumber(String emailId);
}
