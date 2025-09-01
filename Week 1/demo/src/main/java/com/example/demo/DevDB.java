package com.example.demo;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="db.type", havingValue = "development")
public class DevDB implements Database{

    @Override
    public String getData() {
        return "Dev DB...";
    }
}
