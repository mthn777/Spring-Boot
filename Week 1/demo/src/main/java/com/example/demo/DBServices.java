package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class DBServices {

    Database db;

    public DBServices(Database db) {
        this.db = db;
    }

    String getData(){
        return db.getData();
    }
}
