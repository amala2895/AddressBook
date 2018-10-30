package edu.nyu.cs.pqs.assingment1;

enum ErrorMessages {
  WRONG_PARAMETER("Wrong Parameter"), NO_ENTRY(
      "No Entry found with specified parameter"), UNABLE_TO_LOAD(
          "Unable to load the file"), UNABLE_TO_SAVE("Unable to save the file");
  private String msg;

  ErrorMessages(String str) {
    this.msg = str;
  }

  String getMessage() {
    return msg;
  }
}
