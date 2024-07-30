package com.niantic;

public class Main
{
    public static void main(String[] args)
    {

        String formattedPhone = formatPhone(originalPhone: "(808)555-1234")
        System.out.println(formattedphone);
    }

    public static String formatPhone(String originalPhone) {
        char[] chars = new char[10];

        for (int i = 0; i < originalPhone.length(); i++)
        {
            char currentChar = originalPhone.charAt(i);
            //if(Character.isDigit(currentChar))
            if (currentChar >= '0' && currentChar <= "9") {
                Character isDigit(currentChar);
            }
            
        }
        return new String(chars);
    }
}