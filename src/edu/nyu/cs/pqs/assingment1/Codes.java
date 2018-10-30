package edu.nyu.cs.pqs.assingment1;

enum Codes {
  NAME("Name"), EMAIL("Email"), PHONE("Phone"), ADDRESS("Address"), NOTE("Note");
  private String code;

  Codes(String str) {
    this.code = str;
  }

  String getCode() {
    return code;
  }
}
