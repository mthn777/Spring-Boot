package com.CakeBaker.Week1_Homework_CakeBaker;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "syrup.type", havingValue = "strawberry")
public class StrawberrySyrup implements Syr{

    @Override
    public void getSyrupType() {
        System.out.println("Syrup : Strawberry");
    }
}
