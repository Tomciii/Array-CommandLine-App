package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("Welcome to the Command Line App.");
	Scanner scan = new Scanner(System.in);
	DisplayMenu();
	DisplayStrings(args);
        String input = "";
	do{
	    input = scan.nextLine().toLowerCase();
        if (input.equals("ds"))
        {
            DisplayStrings(args);
        }
        else if (input.equals("rs"))
        {
            args = ReverseString(args);
        }
        else if (input.equals("ral"))
        {
            args = RotateArrayLeft(args);
        }
        else if (input.equals("rar"))
        {
            args = RotateArrayRight(args);
        }
        else if (input.equals("ual"))
        {
            args = UppercaseAllLetters(args);
        }
        else if (input.equals("lal"))
        {
            args = LowercaseAllLetters(args);
        }
        else if (input.startsWith("usl"))
        {
            args = UppercaseSpecificLetters(args, input);
        }
        else if (input.startsWith("lsl"))
        {
            args = LowercaseSpecificLetters(args, input);
        }
        else if (input.equals("ufl"))
        {
            args = UppercaseFirstLetter(args);
        }
        else if (input.startsWith("lfl"))
        {
            args = LowercaseFirstLetter(args);
        }
        else if (input.startsWith("ras"))
        {
            args = ReplaceStringArray(args, input);
        }
        else if (input.startsWith("aas"))
        {
            args = AppendArrayString(args, input);
        }
        else if (input.startsWith("ias"))
        {
            args = InsertArrayString(args, input);
        }
        else if (input.startsWith("das"))
        {
            args = DeleteArrayString(args, input);
        }


    } while (!input.equals("q"));
    }

    private static String[] RotateArrayRight(String[] args) {
        String[] result = new String[args.length];

        for (int i = 0; i < args.length; i++)
        {
            if (i == 0)
            {
                result[i] = args[args.length - 1];
            }
            else
            {
                result[i] = args[i - 1];
            }
        }

        return result;
    }

    private static String[] LowercaseAllLetters(String[] args) {
        String[] result = new String[args.length];

        for (int i = 0; i < args.length; i++)
        {
            result[i] = args[i].toLowerCase();
        }

        return result;
    }

    private static String[] UppercaseAllLetters(String[] args) {
        String[] result = new String[args.length];

        for (int i = 0; i < args.length; i++)
        {
            result[i] = args[i].toUpperCase();
        }

        return result;
    }

    private static String[] UppercaseSpecificLetters(String[] args, String input) {
        if (args.length == 0)
        {
            System.out.println("String Array is Empty!");
            return args;
        }

        String[] inputs = input.split(" ");

        if (inputs.length != 2 || inputs[1].length() != 1)
        {
            System.out.println("You need to enter one specific letter you want to uppercase.");
            return args;
        }

        char specificLetter = inputs[1].charAt(0);
        String[] newStringArray = new String[args.length];

        for (int i = 0; i < args.length; i++)
        {
            String currentWord = args[i];
            for (int j = 0; j < args[i].length(); j++)
            {
                if (currentWord.charAt(j) == specificLetter)
                {
                    currentWord = currentWord.substring(0, j) + currentWord.toUpperCase().charAt(j) + currentWord.substring(j + 1);
                }
            }

            newStringArray[i] = currentWord;
        }

        return newStringArray;
    }

    private static String[] LowercaseSpecificLetters(String[] args, String input) {
        if (args.length == 0)
        {
           System.out.println("String Array is Empty!");
            return args;
        }

        String[] inputs = input.split(" ");

        if (inputs.length != 2 || inputs[1].length() != 1)
        {
            System.out.println("You need to enter one specific letter you want to uppercase.");
            return args;
        }

        char specificLetter = inputs[1].charAt(0);

        String[] newStringArray = new String[args.length];

        for (int i = 0; i < args.length; i++)
        {
            String currentWord = args[i];
            for (int j = 0; j < args[i].length(); j++)
            {
                if (currentWord.toLowerCase().charAt(j) == specificLetter)
                {
                    currentWord = currentWord.substring(0, j) + currentWord.toLowerCase().charAt(j) + currentWord.substring(j + 1);
                }
            }

            newStringArray[i] = currentWord;
        }

        return newStringArray;
    }

    private static String[] UppercaseFirstLetter(String[] args) {
        if (args.length == 0)
        {
            System.out.println("String Array is Empty!");
            return args;
        }
        String[] result = new String[args.length];

        for (int i = 0; i < args.length; i++)
        {
            result[i] = args[i].toUpperCase().charAt(0) + args[i].substring(1);
        }

        return result;
    }

    private static String[] LowercaseFirstLetter(String[] args) {
        if (args.length == 0)
        {
            System.out.println("String Array is Empty!");
            return args;
        }
        String[] result = new String[args.length];

        for (int i = 0; i < args.length; i++)
        {
            result[i] = args[i].toLowerCase().charAt(0) + args[i].substring(1);
        }

        return result;
    }

    private static String[] ReplaceStringArray(String[] args, String input) {
        String[] result = new String[args.length];
        String[] inputs;

        try
        {
            inputs = input.split(" ");

            if (inputs.length != 3)
            {
                throw new Exception("You need to put in exactly an index and THEN a string value.");
            }

            int index;
            try {
                index = Integer.parseInt(inputs[1]);
            }
            catch(Exception e){
                System.out.println("Out of bounds");
                return args;

            }

            if (index > (args.length - 1) || index < 0)
            {
                throw new Exception("Index out of bounds!");
            }

            for (int i = 0; i < index; i++)
            {
                result[i] = args[i];
            }

            result[index] = inputs[2];

            for (int i = index + 1; i < args.length; i++)
            {
                result[i] = args[i];
            }

            return result;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return args;
        }
    }

    private static String[] AppendArrayString(String[] args, String input) {
        String[] result = new String[args.length + 1];

       String[] inputs = input.split(" ");

        if (inputs.length != 2)
        {
            System.out.println("You need to enter an input to append.");
            return args;
        }

        for (int i = 0; i < args.length; i++)
        {
            result[i] = args[i];
        }

        result[args.length] = inputs[1];

        return result;
    }

    private static String[] InsertArrayString(String[] args, String input) {
        String[] result = new String[args.length + 1];
        String[] inputs;

        try
        {
            inputs = input.split(" ");

            if (inputs.length != 3)
            {
                throw new Exception("You need to put in exactly an index and THEN a string value.");
            }

            int index;
            try {
                index = Integer.parseInt(inputs[1]);
            }
            catch(Exception e){
                throw new Exception("You need to put in a index value.");
             }

            if (args.length == 0)
            {
            result[0] = inputs[2];
            return  result;
            }

            if (index > (args.length - 1) || index < 0)
            {
                throw new Exception("Index out of bounds!");
            }

            for (int i = 0; i < index; i++)
            {
                result[i] = args[i];
            }

            result[index] = inputs[2];

            for (int i = index; i < result.length; i++)
            {
                if (i != 0)
                {
                    result[i] = args[i - 1];
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return args;
        }

        return result;
    }

    private static String[] RotateArrayLeft(String[] args) {

        String[] result = new String[args.length];

        for (int i = 0; i < args.length; i++)
        {
            if (i == args.length - 1)
            {
                result[i] = args[0];
            }
            else
            {
                result[i] = args[i + 1];
            }
        }

        return result;
    }

    private static String[] ReverseString(String[] args) {
        String[] result = new String[args.length];

        for (int i = 0; i < args.length; i++)
        {
            String reversedWord = "";

            for (int j = args[i].length() - 1; j > -1; j--)
            {
                reversedWord += args[i].charAt(j);
            }

            result[i] = reversedWord;
        }

        return result;
    }

    private static void DisplayStrings(String[] args) {
        if ( args.length > 0)
        {
        for (int i = 0; i < args.length; i++)
        {
            System.out.println(args[i]);
            }
        }
        else
        {
            System.out.println("Args is empty!");
        }
    }

    private static void DisplayMenu() {
        System.out.println("Menu" + "\n" +
                "----" + "\n" +
                "ds... Display strings" + "\n" +
                "rs... Reverse strings" + "\n" +
                "ral... Rotate array left" + "\n" +
                "rar... Rotate array right" + "\n" +
                "ual... Uppercase all letters" + "\n" +
                "lal... Lowercase all letters" + "\n" +
                "usl... Uppercase specific letters" + "\n" +
                "lsl... Lowercase specific letters" + "\n" +
                "ufl... Uppercase first letter" + "\n" +
                "lfl... Lowercase first letter" + "\n" +
                "ras... Replace array string" + "\n" +
                "aas... Append array string" + "\n" +
                "ias... Insert array string" + "\n" +
                "das... Delete array string" + "\n" +
                " q... Quit application \n");
    }

    private static String[] DeleteArrayString(String[] args, String input) {
        if (args.length == 0)
        {
            System.out.println("Array is empty!");
            return args;
        }

        String[] inputs = input.split(" ");

        if (inputs.length > 2)
        {
            System.out.println("You need exactly one number as input.");
            return args;
        }

        if (inputs.length == 1)
        {
            System.out.println("You need to put in a number.");
            return args;
        }

        int index;
        try {
            index = Integer.parseInt(inputs[1]);
        }
        catch(Exception e)
        {
            System.out.println("Your input needs to be a number.");
            return args;
        }

        if (index > args.length - 1)
        {
            System.out.println("Your input needs to be within the array bounds!");
            return args;
        }

        String[] result = new String[args.length - 1];

        try
        {
            for (int i = 0; i < index; i++)
            {
                result[i] = args[i];
            }

            for (int i = index; i < result.length; i++)
            {
                result[i] = args[i + 1];
            }
        }
        catch (Exception e)
        {
            System.out.println("Index out of bounds!.");
            return args;
        }

        return result;
    }
}
