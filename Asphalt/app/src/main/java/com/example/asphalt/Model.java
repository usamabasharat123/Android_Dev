package com.example.asphalt;

public class Model
{
    int image ;
    String name;

    String email;

    public Model(int studentimg, String studentname, String studentemail) {
        this.image=studentimg;
        this.name= studentname;
        this.email=studentemail;
    }

    public Model(String name , String email)
    {
        this.name  = name;
        this.email  = email;
    }
}
