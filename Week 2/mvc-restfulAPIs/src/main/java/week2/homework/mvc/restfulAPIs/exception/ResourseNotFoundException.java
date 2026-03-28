package week2.homework.mvc.restfulAPIs.exception;

public class ResourseNotFoundException extends RuntimeException {
  public ResourseNotFoundException(String message) {
      super(message);
  }
}
