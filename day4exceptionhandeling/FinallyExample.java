package com.week4.day4exceptionhandeling;

import java.util.Scanner;

public class FinallyExample {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Two integer");
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        try{
            int c=num1/num2;
            System.out.println("division of "+num1+" and "+num2+" is "+c);
        }
        catch(ArithmeticException ex){
            ex.printStackTrace();
            System.out.println("Arithmatic exception handled");

        }
        finally {
            System.out.println("Finally always executed");
        }

    }
}
