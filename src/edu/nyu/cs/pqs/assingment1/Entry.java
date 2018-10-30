package edu.nyu.cs.pqs.assingment1;

import java.security.InvalidParameterException;
import java.util.HashMap;

class Entry {
  private Person name;
  private Address address;
  private Email email;
  private Note note;
  private PhoneNumber phone;

  Entry(String n, String p, String e, String a, String no) throws InvalidParameterException {
    this.name = new Person(n);
    this.address = new Address(a);
    this.email = new Email(e);
    this.note = new Note(no);
    this.phone = new PhoneNumber(p);
  }

  String getName() {
    return name.getName();
  }

  String getAddress() {
    return address.getAddress();
  }

  String getEmail() {
    return email.getEmail();
  }

  String getNote() {
    return note.getNote();
  }

  String getPhone() {
    return phone.getPhone();
  }

  boolean setName(String n) {
    return name.setName(n);
  }

  boolean setAddress(String a) {
    return address.setAddress(a);
  }

  boolean setEmail(String e) {
    return email.setEmail(e);
  }

  boolean setNote(String n) {
    return note.setNote(n);
  }

  boolean setPhone(String p) {
    return phone.setPhone(p);
  }

  HashMap<String, String> getData() {
    HashMap<String, String> data = new HashMap<String, String>();
    data.put(Codes.NAME.getCode(), this.getName());
    data.put(Codes.PHONE.getCode(), this.getPhone());
    data.put(Codes.EMAIL.getCode(), this.getEmail());
    data.put(Codes.ADDRESS.getCode(), this.getAddress());
    data.put(Codes.NOTE.getCode(), this.getNote());
    return data;
  }
}
