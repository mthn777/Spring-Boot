package com.CakeBaker.Week1_Homework_CakeBaker;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "syrup.type", havingValue = "chocolate")
public class ChocolateSyrup implements Syr {

    @Override
    public void getSyrupType() {
        System.out.println("Syrup : Chocolate");
    }
}
