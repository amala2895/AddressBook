package edu.nyu.cs.pqs.assingment1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.google.gson.Gson;

public class AddressBook {
  private List<Entry> mycontacts;

  /**
   * The constructor creates a new ArrayList assigns it to the member variable mycontacts.
   * 
   */
  public AddressBook() {
    mycontacts = new ArrayList<Entry>();
  }

  /**
   * This method creates a new Entry object, initializes it with given Parameters and adds it to
   * mycontacts list. If any parameter is null then it is replaced by empty string.
   * 
   * @param name - The max length can be 30 and the input is invalid if there are two or more
   *        consecutive spaces
   * @param phone - The max length can be 15 and the input is invalid if there are two or more
   *        consecutive spaces
   * @param email - The max length can be 50 and the input is invalid if there is a space
   * @param address - The max length can be 500 and the input is invalid if there are four or more
   *        consecutive spaces
   * @param note - The max length can be 2000
   * @throws InvalidParameterException throws exception if any of the parameters are invalid
   */
  public void addEntry(String name, String phone, String email, String address, String note)
      throws InvalidParameterException {
    if (name == null)
      name = "";
    if (phone == null)
      phone = "";
    if (address == null)
      address = "";
    if (email == null)
      email = "";
    if (note == null)
      note = "";
    Entry newEntry = new Entry(name, phone, email, address, note);
    mycontacts.add(newEntry);
  }

  /**
   * This method removes all the Entry Objects from the mycontacts list that have the matching value
   * for the given parameter. While comparing strings the method uses equals() for search string,
   * hence the string should match exactly for search string. The method uses equalsIgnoreCase() for
   * search parameter.
   * 
   * @param searchparameter - the parameter by which the entry has to be removed (can be Name,
   *        Email, Phone)
   * @param searchString - the value of parameter of the entry which has to be removed
   * @return Result object - this object contains three fields status, data and errorMessage. This
   *         functions returns the result object with false status and appropriate error message if
   *         the removing of entry fails. Or it sends the result object with status as true. The
   *         data field remains null.
   */
  public Result removeBy(String searchparameter, String searchString) {
    Result result = new Result();
    Iterator<Entry> i = this.mycontacts.iterator();
    boolean flag = false;
    searchparameter = searchparameter.trim();
    searchString = searchString.trim();
    if (searchparameter.equalsIgnoreCase(Codes.NAME.getCode())) {
      while (i.hasNext()) {
        Entry o = i.next();
        if (o.getName().equals(searchString)) {
          i.remove();
          flag = true;
        }
      }
    } else if (searchparameter.equalsIgnoreCase(Codes.EMAIL.getCode())) {
      while (i.hasNext()) {
        Entry o = i.next();
        if (o.getEmail().equals(searchString)) {
          i.remove();
          flag = true;
        }
      }
    } else if (searchparameter.equalsIgnoreCase(Codes.PHONE.getCode())) {
      while (i.hasNext()) {
        Entry o = i.next();
        if (o.getPhone().equals(searchString)) {
          i.remove();
          flag = true;
        }
      }
    } else {
      result.setStatus(false);
      result.setErrorMessage(ErrorMessages.WRONG_PARAMETER.getMessage());
      return result;
    }
    if (flag == false) {
      result.setStatus(false);
      result.setErrorMessage(ErrorMessages.NO_ENTRY.getMessage());
      return result;
    }
    result.setStatus(true);
    return result;
  }

  private List<HashMap<String, String>> searchByName(String name) {
    List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    for (Entry e : mycontacts) {
      if (e.getName().equalsIgnoreCase(name)) {
        list.add(e.getData());
      }
    }
    return list;
  }

  private List<HashMap<String, String>> searchByEmail(String email) {
    List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    for (Entry e : mycontacts) {
      if (e.getEmail().equalsIgnoreCase(email)) {
        list.add(e.getData());
      }
    }
    return list;
  }

  private List<HashMap<String, String>> searchByPhone(String phone) {
    List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    for (Entry e : mycontacts) {
      if (e.getPhone().equalsIgnoreCase(phone)) {
        list.add(e.getData());
      }
    }
    return list;
  }

  private List<HashMap<String, String>> searchByAddress(String phone) {
    List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    for (Entry e : mycontacts) {
      if (e.getAddress().equalsIgnoreCase(phone)) {
        list.add(e.getData());
      }
    }
    return list;
  }

  private List<HashMap<String, String>> searchByNote(String phone) {
    List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    for (Entry e : mycontacts) {
      if (e.getNote().equalsIgnoreCase(phone)) {
        list.add(e.getData());
      }
    }
    return list;
  }

  /**
   * This method searches for entries in address book that match the given parameter value. The
   * method compares strings using equalsIgnoreCase(), hence not strict about case of the string.
   * 
   * @param searchparameter - the parameter by which the entry has to be searched (can be Name,
   *        Email, Phone, Address, Note)
   * @param searchString - the value of parameter
   * @return Result object - this object contains three fields status, data and errorMessage. This
   *         functions returns the result object with false status and appropriate error message if
   *         the searching fails. Or it sends the result object with status as true and data as
   *         List(of HashMap) of Entries matching the search. The HashMap contains each fields of
   *         entry. The keys of HashMap are Name, Phone, Email, Address, Note. Values of HashMap are
   *         the values of each parameter.
   */

  public Result searchBy(String searchparameter, String searchString) {
    searchparameter = searchparameter.trim();
    searchString = searchString.trim();
    Result result = new Result();
    List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    if (searchparameter.equalsIgnoreCase(Codes.NAME.getCode())) {
      list = searchByName(searchString);
    } else if (searchparameter.equalsIgnoreCase(Codes.EMAIL.getCode())) {
      list = searchByEmail(searchString);
    } else if (searchparameter.equalsIgnoreCase(Codes.PHONE.getCode())) {
      list = searchByPhone(searchString);
    } else if (searchparameter.equalsIgnoreCase(Codes.ADDRESS.getCode())) {
      list = searchByAddress(searchString);
    } else if (searchparameter.equalsIgnoreCase(Codes.NOTE.getCode())) {
      list = searchByNote(searchString);
    } else {
      result.setStatus(false);
      result.setErrorMessage(ErrorMessages.WRONG_PARAMETER.getMessage());
      return result;
    }
    if (list.size() == 0) {
      result.setErrorMessage(ErrorMessages.NO_ENTRY.getMessage());
      result.setStatus(false);
    } else {
      result.setStatus(true);
      result.setData(list);
    }
    return result;
  }

  /**
   * This method converts the AddressBook object to .json format and saves it to a file.
   * 
   * @param File - path of file
   * @return Result object - This object has three fields status, errorMessages and data. If saving
   *         the file is successful then status is set to true. If not successful then status is set
   *         to false and errorMessage is set to appropriate exception message. The data field
   *         remains null.
   */
  public Result saveBook(String File) {
    Gson gson = new Gson();
    Result result = new Result();
    try (FileWriter writer = new FileWriter(File)) {
      gson.toJson(this, writer);
      result.setStatus(true);
    } catch (Exception e) {
      result.setStatus(false);
      result.setErrorMessage(ErrorMessages.UNABLE_TO_SAVE.getMessage() + " -" + e.getMessage());
    }
    return result;
  }

  /**
   * This method loads the .json file converts to AddressBook object.
   * 
   * @param File - path of file to be loaded
   * @return Result object - This object has three fields status, errorMessages and data. If loading
   *         the file is successful then status is set to true. If not successful then status is set
   *         to false and errorMessage is set to appropriate exception message. The data field
   *         remains null.
   * 
   */
  public Result loadBook(String File) {
    Gson gson = new Gson();
    Result result = new Result();
    try (Reader reader = new FileReader(File)) {
      this.mycontacts = gson.fromJson(reader, AddressBook.class).mycontacts;
      result.setStatus(true);
    } catch (Exception e) {
      result.setStatus(false);
      result.setErrorMessage(ErrorMessages.UNABLE_TO_LOAD.getMessage() + " -" + e.getMessage());
    }
    return result;
  }

  @Override public String toString() {
    String result = "";
    for (Entry e : mycontacts) {
      result = result + e.getName() + " " + e.getEmail() + " " + e.getPhone() + " " + e.getAddress()
          + " " + e.getNote() + "\n";
    }
    return result;
  }

  /*
   * In future implementations update method can be provided that will update the fields of Entry
   * object. The setter methods of Entry class can be used at that point.
   */
}
