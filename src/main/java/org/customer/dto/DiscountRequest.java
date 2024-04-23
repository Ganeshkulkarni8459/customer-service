package org.customer.dto;

import org.springframework.stereotype.Component;

@Component
public class DiscountRequest {

  private String age;
  private String gender;

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
