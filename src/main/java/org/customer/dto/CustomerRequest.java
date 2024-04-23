package org.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequest {

  @NotBlank(message = "First name cannot be blank")
  @Size(max = 50, message = "First name cannot exceed 50 characters")
  private String firstName;

  @NotBlank(message = "Last name cannot be blank")
  @Size(max = 50, message = "Last name cannot exceed 50 characters")
  private String lastName;

  @NotBlank(message = "Middle Name name cannot be blank")
  @Size(max = 50, message = "Middle name cannot exceed 50 characters")
  private String middleName;

  @NotBlank(message = "Date of birth cannot be blank")
  private String dateOfBirth;

  @NotBlank(message = "Address line 1 cannot be blank")
  private String addressLine1;

  @NotBlank(message = "Address line 2 cannot be blank")
  private String addressLine2;

  @NotBlank(message = "ZIP code cannot be blank")
  private String zip;

  @NotBlank(message = "City cannot be blank")
  private String city;

  @NotBlank(message = "State cannot be blank")
  private String state;

  @NotBlank(message = "Country cannot be blank")
  private String country;

  @Pattern(regexp = "\\d{10}", message = "Mobile phone must be a 10-digit number")
  private String mobilePhone;

  @NotBlank(message = "Country cannot be blank")
  private String homePhone;

  @NotBlank(message = "Country cannot be blank")
  private String workPhone;

  @NotBlank(message = "Email ID cannot be blank")
  @Email(message = "Invalid email format")
  private String emailID;

  @NotNull(message = "Customer ID cannot be null")
  private long customerId;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public String getEmailID() {
    return emailID;
  }

  public void setEmailID(String emailID) {
    this.emailID = emailID;
  }

  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }
}
