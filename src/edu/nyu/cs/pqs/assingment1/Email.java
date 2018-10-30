package edu.nyu.cs.pqs.assingment1;

import java.security.InvalidParameterException;

class Email {
  private String email;

  Email(String e) {
    e = e.trim();
    if (validateEmail(e)) {
      email = e;
    } else {
      throw new InvalidParameterException("Email parameter is Invalid");
    }
  }

  String getEmail() {
    return email;
  }

  boolean setEmail(String e) {
    if (validateEmail(e)) {
      email = e;
      return true;
    }
    return false;

  }

  private boolean validateEmail(String e) {
    if (e.length() > 50 || e.contains(" ")) {
      return false;
    }
    return true;
  }
}
