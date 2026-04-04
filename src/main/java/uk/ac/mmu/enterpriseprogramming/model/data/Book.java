package uk.ac.mmu.enterpriseprogramming.model.data;

public class Book {
    private int id;
    private String title;
    private String author;
    private String date; ;
    private String genres;
    private String characters;
    private String synopsis;

    public Book(int id, String title, String author,String date, String genres, String characters, String synopsis) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.genres = genres;
        this.characters = characters;
        this.synopsis = synopsis;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getCharacters() {
        return characters;
    }

    public String getGenres() {
        return genres;
    }

    public String getDate() {
        return date;
    }
}
