package com.CakeBaker.Week1_Homework_CakeBaker;

import org.springframework.stereotype.Service;

@Service
public class SyrupType {

    Syr syrup;

    public SyrupType(Syr syrup) {
        this.syrup = syrup;
    }

    void getSyrupType(){
        syrup.getSyrupType();
    }


}
