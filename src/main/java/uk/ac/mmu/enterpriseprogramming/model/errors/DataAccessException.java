package uk.ac.mmu.enterpriseprogramming.model.errors;

public class DataAccessException extends RuntimeException {
  public DataAccessException(String message, Throwable cause) {
    super(message, cause);
  }
}