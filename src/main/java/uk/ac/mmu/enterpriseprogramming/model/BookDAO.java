package uk.ac.mmu.enterpriseprogramming.model;

import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;
import java.util.List;

public interface BookDAO {

  List<BookVO> getBooks(int limit, int offset);

  List<BookVO> getAllBooks();

  BookVO getBook(int id);

  void addBook(BookVO book);

  void deleteBook(int id);

  void updateBook(BookVO book);

  int countBooks();

  List<String> getGenres();
}