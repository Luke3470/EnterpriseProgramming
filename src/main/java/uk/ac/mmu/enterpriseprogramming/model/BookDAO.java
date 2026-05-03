package uk.ac.mmu.enterpriseprogramming.model;

import uk.ac.mmu.enterpriseprogramming.model.data.BookFilterDTO;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;
import java.util.List;

public interface BookDAO {

  List<BookVO> getBooks(BookFilterDTO filter);

  BookVO getBook(int id);

  void addBook(BookVO book);

  void deleteBook(int id);

  void updateBook(BookVO book);

  int countBooks(BookFilterDTO filterDTO);

  List<String> getGenres();

  List<BookVO> getAllBooks();
}