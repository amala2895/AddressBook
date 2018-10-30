package edu.nyu.cs.pqs;

import java.util.HashMap;
import java.util.List;
import edu.nyu.cs.pqs.assingment1.AddressBook;
import edu.nyu.cs.pqs.assingment1.Result;

public class driver {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Result result = new Result();

    // new book creation
    AddressBook mybook = new AddressBook();

    // adding entries
    System.out.println("add entries");
    // Result result = new Result();
    String[][] data = {{"amala", "900472285", "amala@nyu", "40 nrewport 3103 ", "my notes "},
        {"amala", "900472285", "amala@nyu", "40 nrewport 3103 ", "my notes "},
        {"amala     m cd", "900472285", "amala@nyu", "40 nrewport 3103 ", "my notes "},
        {"amala     m cd", "900472285", "amala@nyu", "40 nrewport 3103 ", "my notes "},
        {"amala", "900472285jkkdkcdknckjdkvcnd", "amala@nyu", "40 nrewport 3103 ", "my notes "},
        {"amala", "900472285jkkdkcdknckjdkvcnd", "amala@nyu", "40 nrewport 3103 ", "my notes "},
        {"amala", "201986", "amala@nyu", "40 nrewport 3103 ", "my notes "},
        {"Nikita", "22837947", "njok  @nyu", "40 nrewport 3103 ", "my notes "},
        {"Nikita", "2019mnmn86", "amala@nyu", "40 nrewport 3103 ", "my notes "},
        {"diwakar", "2225", "amala@nyu", "40 nrewport 3103 ", "my notes "},
        {"kumar", "201986", "amala@nyu", "newport", "my notes "},
        {"anshu", "201986", "anshy@nyu.edu", "newport", "my notes "},
        {null, null, null, null, null}};

    for (int i = 0; i < 12; i++) {
      try {
        mybook.addEntry(data[i][0], data[i][1], data[i][2], data[i][3], data[i][4]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    System.out.println(mybook.toString());


    // search by name, email,phone

    System.out.println("searching");
    List<HashMap<String, String>> rec;

    result = mybook.searchBy("email", "amala@nyu.edu");
    System.out.println(result.getStatus() + " " + result.getErrorMessage());
    rec = result.getData();
    for (HashMap<String, String> entry : rec) {

      for (String key : entry.keySet()) {
        System.out.println(key + ":" + entry.get(key));
      }
    }

    // remove by name,phone,email
    System.out.println("removing");
    result = mybook.removeBy("mailed", "amala");

    System.out.println(result.getStatus() + " " + result.getErrorMessage());
    System.out.println(mybook.toString());

    // save the address book
    result = mybook.saveBook("AddressBook.json");
    System.out.println(result.getStatus() + " " + result.getErrorMessage());

    // load book
    AddressBook book = new AddressBook();
    result = book.loadBook("AddressBook.json");
    System.out.println(result.getStatus() + " " + result.getErrorMessage());

    // System.out.println(book.toString());
  }
}
