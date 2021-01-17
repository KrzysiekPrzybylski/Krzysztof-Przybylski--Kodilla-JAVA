package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class Library {

    private final List<String> books = new ArrayList<>();


    @Autowired
    private LibraryDbController libraryDbController;


    public void saveToDB() {
        libraryDbController.saveData();
    }

    public void loadToDB() {
        libraryDbController.loadData();
    }
}
