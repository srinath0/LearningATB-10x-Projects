package com.srinath.ex01_RA_Basics;

public class APITesting002 {
        public void step1(){
            System.out.println("Step1");
        }
        public void step2(){
            System.out.println("Step2");
        }
        public void step3(){
            System.out.println("Step3");
        }
        public static void main(String[] args) {
            //Non-chaining pattern
            APITesting002 np = new APITesting002();
            np.step1();
            np.step2();
            np.step3();
        }

}
