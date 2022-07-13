package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        while (true){
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();

            System.out.println(Main.calc(str));
        }
    }
    public static String calc(String input) throws Exception {
        int numberOne;
        int numberTwo;
        String[] block = input.split(" ");
        String result = "";
        if (block.length != 3){throw new Exception("Введены некоректные данные!");}

            if (isRoman(block[0]) && isRoman(block[2])) {
                numberOne = romanToArabian(block[0]);
                numberTwo = romanToArabian(block[2]);
                result = numToRoman(toResult(block[1], numberOne, numberTwo ));
            }else if(isCorrectNum(block[0]) && isCorrectNum(block[2])){
                numberOne = Integer.parseInt(block[0]);
                numberTwo = Integer.parseInt(block[2]);
                result =  Integer.toString(toResult(block[1], numberOne, numberTwo ));
            } else {throw new Exception("Введены некоретные данные!");}

        return result;
    }
    private static int romanToArabian (String roman) throws Exception {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            } else {throw new Exception("Введены некоретные данные!");}
    }
    public static int toResult(String str, int numberOne, int numberTwo){
        int result = 0;
        char ch = str.charAt(0);
        switch (ch){
            case '+': result = numberOne + numberTwo; break;
            case '-': result = numberOne - numberTwo; break;
            case '*': result = numberOne * numberTwo; break;
            case '/': result = numberOne / numberTwo; break;
        }
        return result;
    }
    public static boolean isRoman(String str){
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean isRoman = false;
        for (String s : roman) {
            if (s.equals(str)) {
                isRoman = true;
                break;
            }
        }
        return isRoman;
    }
    public static boolean isCorrectNum(String str){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean isCorrectNum = false;
        for (int num : nums) {
            if (String.valueOf(num).equals(str)) {
                isCorrectNum = true;
                break;
            }
        }
        return isCorrectNum;
    }
    public static String numToRoman (int numArabian) throws Exception {
        if(numArabian < 1){ throw new Exception("т.к. в римской системе нет отрицательных чисел"); }
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[numArabian];
    }
}
