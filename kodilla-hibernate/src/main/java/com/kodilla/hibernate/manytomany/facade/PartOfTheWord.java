package com.kodilla.hibernate.manytomany.facade;

public class PartOfTheWord {
    public static String word(String text){
        return ("%" + text + "%");
    }
}
