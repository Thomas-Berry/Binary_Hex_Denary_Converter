package com.company;

import java.util.Scanner;
public class Main {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static String Binary_To_Denary(String BinaryNumber) {
        int count = 1;
        int total = 0;
        for (int i = BinaryNumber.length() -1; i > -1 ; i--) {
            if (BinaryNumber.charAt(i) == '1') {
                total += count;
            }
            count = count * 2;

        }
        return Integer.toString(total);
    }

    private static String Denary_To_Binary(String DenaryNumber){
        int count = 1;
        int digits = 0;
        String total = "";

        int Denary_Number = Integer.parseInt(DenaryNumber);
        while (count < Denary_Number){
            digits++;
            count = count * 2;
        }
        count = count / 2;
        for (int i = 0; i < digits; i++) {
            if(Denary_Number >= count){
                total = total + "1";
                Denary_Number = Denary_Number - count;
            } else {
                total = total + "0";
            }
            count = count / 2;
        }
        return total;
    }

    public static String Binary_To_Hex(String Binary_Number){
        String total = "";
        for (int i = 0; i < Binary_Number.length() % 4 ; i++) {
            Binary_Number = "0" + Binary_Number;
        }

        for (int i = 0; i < Binary_Number.length(); i = i + 4) {
            String nibble = Binary_Number.substring(i, i+4);
            if ( Integer.parseInt(Binary_To_Denary(nibble)) > 9 ) {
                switch (nibble){
                    case "1111":
                        total += "F";
                        break;
                    case "1110":
                        total += "E";
                        break;
                    case "1101":
                        total += "D";
                        break;
                    case "1100":
                        total += "C";
                        break;
                    case "1011":
                        total += "B";
                        break;
                    case "1010":
                        total += "A";
                        break;
                }
            } else {
                total = total + Binary_To_Denary(nibble);
            }

        }

        return total;
    }

    public static String Hex_To_Binary(String Hex_Number){
        String total = "";
        for (int i = 0; i < Hex_Number.length() ; i++) {
            if(!isNumeric(Hex_Number.substring(i, i + 1))){
                switch (Hex_Number.charAt(i)){
                    case 'A':
                        total += "1010";
                        break;
                    case 'B':
                        total += "1011";
                        break;
                    case 'C':
                        total += "1100";
                        break;
                    case 'D':
                        total += "1101";
                        break;
                    case 'E':
                        total += "1110";
                        break;
                    case 'F':
                        total += "1111";

                }
            }else {
                total += Denary_To_Binary(Hex_Number.substring(i, i+1));
            }
        }
        return total;
    }

    public static void Hex_To_Denary (){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a Hex number");
        String Hex_Number = myObj.nextLine();
        System.out.println(Binary_To_Denary(Hex_To_Binary(Hex_Number)));
    }

    public static void Denary_To_Hex(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a Denary number");
        String Denary_Number = myObj.nextLine();
        System.out.println(Binary_To_Hex(Denary_To_Binary(Denary_Number)));
    }

    public static void main(String[] args) {
        System.out.println("1: Binary to Denary");
        System.out.println("2: Denary to Binary");
        System.out.println("3: Binary to Hex");
        System.out.println("4: Hex to Binary");
        System.out.println("5: Hex to Denary");
        System.out.println("6: Denary to Hex");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter option");
        String input = myObj.nextLine();
        if (input.equals("1")){
            Scanner myInput = new Scanner(System.in);
            System.out.println("Enter binary number");
            String BinaryNumber = myObj.nextLine();
            System.out.println(Binary_To_Denary(BinaryNumber));
        } else if (input.equals("2")){
            Scanner myInput2 = new Scanner(System.in);
            System.out.println("Enter Denary number");
            String DenaryNumber = myObj.nextLine();
            System.out.println(Denary_To_Binary(DenaryNumber));
        } if (input.equals("3")){
            Scanner myInput3 = new Scanner(System.in);
            System.out.println("Enter Binary number");
            String Binary_Number = myObj.nextLine();
            System.out.println(Binary_To_Hex(Binary_Number));
        } if (input.equals("4")){
            Scanner myInput4 = new Scanner(System.in);
            System.out.println("Enter a hex number");
            String Hex_Number = myObj.nextLine();
            System.out.println(Hex_To_Binary(Hex_Number));
        } if (input.equals("5")){
            Hex_To_Denary();
        } if (input.equals("6")){
            Denary_To_Hex();
        }
    }

}

