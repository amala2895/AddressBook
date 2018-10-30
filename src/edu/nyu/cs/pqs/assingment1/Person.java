package edu.nyu.cs.pqs.assingment1;

import java.security.InvalidParameterException;

class Person {
  private String Name;

  Person(String n) {
    n = n.trim();
    if (validateName(n)) {
      Name = n;
    } else {
      throw new InvalidParameterException("Name Parameter is Invalid");
    }
  }

  String getName() {
    return Name;
  }

  boolean setName(String n) {
    if (validateName(n)) {
      Name = n;
      return true;
    }
    return false;
  }

  private boolean validateName(String n) {
    if (n.length() > 30 || n.matches(".*  .*")) {
      return false;
    }
    return true;
  }

}
