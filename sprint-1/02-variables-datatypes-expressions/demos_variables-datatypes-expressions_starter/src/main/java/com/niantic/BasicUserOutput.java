package com.niantic;

public class BasicUserOutput
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        int quantity;
        quantity = 150;
        System.out.println(quantity);

        long milesToPluto = Integer.MAX_VALUE;
        System.out.println(milesToPluto);
        milesToPluto = milesToPluto * 2;
        System.out.println(milesToPluto);

        long age = 5000;
        int smallAge = (int)age;
        System.out.print(age + " : " + smallAge);
    }
}
