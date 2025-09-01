package com.example.demo;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="db.type", havingValue = "production")
public class ProdDB implements Database{

    @Override
    public String getData() {
        return "Prod DB...";
    }
}
