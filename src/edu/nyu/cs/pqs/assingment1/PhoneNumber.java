package edu.nyu.cs.pqs.assingment1;

import java.security.InvalidParameterException;

class PhoneNumber {
  private String phone;

  PhoneNumber(String p) {
    p = p.trim();
    if (validatePhone(p)) {
      phone = p;
    } else {
      throw new InvalidParameterException("Phone Parameter is Invalid");
    }
  }

  String getPhone() {
    return phone;
  }

  boolean setPhone(String p) {
    if (validatePhone(p)) {
      phone = p;
      return true;
    }
    return false;

  }

  private boolean validatePhone(String p) {
    if (p.length() > 15 || p.matches(".*  .*")) {
      return false;
    }
    return true;
  }
}
