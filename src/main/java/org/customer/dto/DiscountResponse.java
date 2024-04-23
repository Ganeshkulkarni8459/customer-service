package org.customer.dto;

import org.springframework.stereotype.Component;

@Component
public class DiscountResponse {

  private String discountPercent;

  public String getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(String discountPercent) {
    this.discountPercent = discountPercent;
  }
}
