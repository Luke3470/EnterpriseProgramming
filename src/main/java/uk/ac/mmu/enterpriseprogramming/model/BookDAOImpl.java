package uk.ac.mmu.enterpriseprogramming.model;

import uk.ac.mmu.enterpriseprogramming.DB.DB;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    private final DB db;

    public BookDAOImpl(DB db) {
        this.db = db;
    }

    // -------------------------
    // GET PAGINATED
    // -------------------------
    @Override
    public List<BookVO> getBooks(int limit, int offset) {
        List<BookVO> books = new ArrayList<>();
        String sql = "SELECT * FROM books LIMIT ? OFFSET ?";

        try (
            Connection conn = db.createCon();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, limit);
            ps.setInt(2, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    books.add(mapToVO(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    // -------------------------
    // GET ALL
    // -------------------------
    @Override
    public List<BookVO> getAllBooks() {
        List<BookVO> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (
            Connection conn = db.createCon();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)
        ) {
            while (rs.next()) {
                books.add(mapToVO(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    // -------------------------
    // GET ONE
    // -------------------------
    @Override
    public BookVO getBook(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";

        try (
            Connection conn = db.createCon();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapToVO(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // -------------------------
    // ADD
    // -------------------------
    @Override
    public void addBook(BookVO book) {
        String sql = """
            INSERT INTO books 
            (title, author, date, genres, characters, synopsis, coverUrl)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        try (
            Connection conn = db.createCon();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, book.title());
            ps.setString(2, book.author());
            ps.setString(3, book.date());
            ps.setString(4, book.genres());
            ps.setString(5, book.characters());
            ps.setString(6, book.synopsis());
            ps.setString(7, book.coverUrl());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------------------
    // UPDATE
    // -------------------------
    @Override
    public void updateBook(BookVO book) {
        String sql = """
            UPDATE books 
            SET title=?, author=?, date=?, genres=?, characters=?, synopsis=?, coverUrl=? 
            WHERE id=?
        """;

        try (
            Connection conn = db.createCon();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, book.title());
            ps.setString(2, book.author());
            ps.setString(3, book.date());
            ps.setString(4, book.genres());
            ps.setString(5, book.characters());
            ps.setString(6, book.synopsis());
            ps.setString(7, book.coverUrl());
            ps.setInt(8, book.id());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------------------
    // DELETE
    // -------------------------
    @Override
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";

        try (
            Connection conn = db.createCon();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------------------
    // MAPPER
    // -------------------------
    private BookVO mapToVO(ResultSet rs) throws SQLException {
        return new BookVO(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getString("author"),
            rs.getString("date"),
            rs.getString("genres"),
            rs.getString("characters"),
            rs.getString("synopsis"),
            rs.getString("coverUrl")
        );
    }
}