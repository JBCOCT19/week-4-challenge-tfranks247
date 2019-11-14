package com.company;

public class Student {

    private int Id;
    private String name;
    private String email;
    private String password;

    public Student() {
    }

    public Student(int id, String name, String email, String password) {
        Id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
