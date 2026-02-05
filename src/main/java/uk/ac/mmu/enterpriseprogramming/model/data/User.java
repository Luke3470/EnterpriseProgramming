package uk.ac.mmu.enterpriseprogramming.model.data;

public class User {
    private String name;
    private String email;
    private int userId;

    public User(String name, String email, int userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    // getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getUserId(){ return userId; }
}
