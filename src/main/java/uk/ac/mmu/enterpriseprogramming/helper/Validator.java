package uk.ac.mmu.enterpriseprogramming.helper;

public class Validator {

  public static int validateId(String id){
    int value = Integer.parseInt(id);

    if (value < 0){
      throw new NumberFormatException();
    }

    return value;
  }

}
