package com.CakeBaker.Week1_Homework_CakeBaker;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "frosting.type", havingValue = "strawberry")
public class StrawberryFrosting implements Fros{

    @Override
    public void getFrostingType() {
        System.out.println("Frosting : Strawberry");
    }
}
