package org.customer.common;

public enum CustomerResponseCode {
  SUCCESS_CUSTOMER_ADD("Success", "Customer added successfully"),
  FAILED_CUSTOMER_ADD_EXISTS("Error", "Email is already exist! Please enter valid emailID"),
  FAILED_UPDATE_CUSTOMER("Fail", "Customer not present"),
  FAILED_GET_CUSTOMER("Fail", "Customer not found"),
  GET_SUCCESS_CUSTOMER("Success", "Customer Found successfully"),
  UPDATE_CUSTOMER_SUCCESS("Success", "Customer Update successfully");

  private final String status;
  private final String message;

  CustomerResponseCode(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
