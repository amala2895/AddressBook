package edu.nyu.cs.pqs.assingment1;

import java.security.InvalidParameterException;

class Note {
  private String note;

  Note(String n) {
    n = n.trim();
    if (validateNote(n)) {
      note = n;
    } else {
      throw new InvalidParameterException("Note Parameter is Invalid");
    }
  }

  String getNote() {
    return note;
  }

  boolean setNote(String a) {
    if (validateNote(a)) {
      note = a;
      return true;
    }
    return false;

  }

  private boolean validateNote(String a) {
    if (a.length() > 2000) {
      return false;
    }
    return true;
  }
}
