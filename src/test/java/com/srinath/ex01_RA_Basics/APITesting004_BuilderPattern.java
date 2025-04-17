package com.srinath.ex01_RA_Basics;

public class APITesting004_BuilderPattern {
    public APITesting004_BuilderPattern step1(){
        System.out.println("Step 1");
        return this;
    }
    public APITesting004_BuilderPattern step2(){
        System.out.println("Step 2");
        return this;
    }
    public APITesting004_BuilderPattern step3(){
        System.out.println("Srinath");
        return this;
    }
    public static void main(String[] args) {
        APITesting004_BuilderPattern np = new APITesting004_BuilderPattern();
        np.step3().step2().step1();
    }
}
