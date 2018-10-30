package edu.nyu.cs.pqs.assingment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Result {
  private boolean status;
  private List<HashMap<String, String>> data;
  private String errorMessage;

  /**
   * The constructor initialized data and errorMessage fields
   */
  public Result() {
    data = new ArrayList<HashMap<String, String>>();
    errorMessage = "";
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public boolean getStatus() {
    return status;
  }

  public List<HashMap<String, String>> getData() {
    return data;
  }

  void setData(List<HashMap<String, String>> newData) {
    this.data = newData;
  }

  void setErrorMessage(String msg) {
    this.errorMessage = msg;
  }

  void setStatus(boolean stat) {
    this.status = stat;
  }
}
