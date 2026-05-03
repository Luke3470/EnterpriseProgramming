package uk.ac.mmu.enterpriseprogramming.helper;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

public class Validator {

  public static int validateId(String id){
    int value = Integer.parseInt(id);

    if (value < 0){
      throw new NumberFormatException();
    }

    return value;
  }

}
