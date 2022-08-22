package org.worldline.exception;

public enum ErrorCodes {

  ECHELLE_NOT_FOUND(1000),
  ECHELLE_NOT_VALID(1001),
  ECHELLE_ALREADY_IN_USE(1002),

  QUESTION_NOT_FOUND(2000),
  QUESTION_NOT_VALID(2001),
  QUESTION_ALREADY_IN_USE(2002);





  private int code;

  ErrorCodes(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
