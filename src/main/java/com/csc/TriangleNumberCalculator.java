package com.csc;

public class TriangleNumberCalculator {
    public int value(int n){
        if (n == 1){
            return 1;
        }
        else{
            return n + value(n-1);
        }
    }

    public int add(int n, int m){
        return value(n) + value(m);
    }

    public int subtract(int n, int m){
        return value(n) - value(m);
    }
}
