package com.exemple.testing;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int add(int a, int b){
        return a + b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }
    public double add(double a, double b){
        return a+b;
    }
    public double multiply(double a, double b) {
        return a*b;
    }
    public Set<Integer> digitsSet(int number) {
        Set<Integer> integers = new HashSet<Integer>();
        String numberStr = String.valueOf(number);
        for(int i =0 ; i< numberStr.length(); i++){
            integers.add(Integer.parseInt(numberStr,i,i+1,10));
        }
        return integers;
    }
}
