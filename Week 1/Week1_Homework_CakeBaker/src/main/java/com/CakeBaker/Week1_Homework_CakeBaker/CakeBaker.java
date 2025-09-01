package com.CakeBaker.Week1_Homework_CakeBaker;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CakeBaker {

    @Autowired
    FrostingType fros;
    @Autowired
    SyrupType syr;

    public void bakeCake(){
        System.out.println("Baking Cake...");
        fros.getFrostingType();
        syr.getSyrupType();
    }

}
