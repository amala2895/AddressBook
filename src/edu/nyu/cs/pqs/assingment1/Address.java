package edu.nyu.cs.pqs.assingment1;

import java.security.InvalidParameterException;

class Address {
  private String address;

  Address(String a) {
    a = a.trim();
    if (validateAddress(a)) {
      address = a;
    } else {
      throw new InvalidParameterException("Address parameter is Invalid");
    }
  }

  String getAddress() {
    return address;
  }

  boolean setAddress(String a) {
    if (validateAddress(a)) {
      address = a;
      return true;
    }
    return false;

  }

  private boolean validateAddress(String a) {
    if (a.length() > 500 || a.matches(".*    .*")) {
      return false;
    }
    return true;
  }
}
