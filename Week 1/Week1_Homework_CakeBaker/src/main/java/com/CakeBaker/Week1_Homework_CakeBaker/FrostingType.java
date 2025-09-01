package com.CakeBaker.Week1_Homework_CakeBaker;

import org.springframework.stereotype.Service;

@Service
public class FrostingType {

    Fros frosting;

    public FrostingType(Fros frosting) {
        this.frosting = frosting;
    }

    void getFrostingType(){
        frosting.getFrostingType();
    }

}
