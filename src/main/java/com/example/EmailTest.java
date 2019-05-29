package com.example;

//EmailTest.java
public class EmailTest{
    public static void main(String args[]){
        try{
            EmailSender sender = new EmailSender("Qinghang", "qhong@ucsb.edu");
            sender.sendMail();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}