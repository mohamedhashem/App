package com.example.android.app;



//this is very simple class and it only contains the user attributes, a constructor and the getters

public class user {
    private int id,age,phone;
    private String first,last,address,password, email, gender;
    public user(int id, String first, String last, String gender,int age,int phone,String address,String email,String password) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.age=age;
        this.phone=phone;
        this.address=address;
        this.email = email;
        this.password=password;
    }
    public int getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public int getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }



}
