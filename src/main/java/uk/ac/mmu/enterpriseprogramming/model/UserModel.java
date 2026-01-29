package uk.ac.mmu.enterpriseprogramming.model;

public class UserModel {
    private String name;
    private String email;
    private int age;
    private String country;

    public UserModel(String name, String email, int age, String country) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.country = country;
    }

    // getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public String getCountry() { return country; }
}
