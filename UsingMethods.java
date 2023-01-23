/*
 *  Program Name: UsingMethods
 * 
 *  Author: homeshell 
 * 
 *  Date: 2023-01-23 4:30pm
 * 
 *  Description: Gets two user inputs and adds them together. Then asks the user if they wish to continue adding.
 *               The primary purpose of the program is to solidify knowledge of methods and how to pass in parameters.
 *               Effort has been made to create a clean, easy to read program with a concise naming conventions and comments.
 * 
 *  Goal: Learn by doing and have fun coding! Goal achieved.
 */

import java.util.Scanner;

public class UsingMethods {

    public static void main(String[] args) {

        clearScreen();
        boolean runCode = true;

        while(runCode == true) {
        clearScreen();
        Scanner scan = new Scanner(System.in);
        int number1 = 0;
        int number2 = 0;
        int sum = 0;

        number1 = getValidatedNumber(scan, 1);
        System.out.println("First number entered:" + number1);

        number2 = getValidatedNumber(scan, 2);
        System.out.println("Second number entered: " + number2);

        sum = addInputs(number1, number2);
        System.out.println("\nSum of both: " + sum);
        
        runCode = continueCode(scan);
        }

    // Method Block below
    }

    // Passes in scanner, prompts user to enter yes or no, based on answer continue program or terminate.
    public static boolean continueCode(Scanner scan) {
        boolean userChoice = false;
        String continueProgram;

        System.out.print("\nContinue program? ");
        continueProgram = scan.next();
        continueProgram = checkYesNo(scan, continueProgram);

        if (continueProgram.equalsIgnoreCase("yes")) {
            userChoice = true;
        }
        else if (continueProgram.equalsIgnoreCase("no")) {
            userChoice = false;
            System.out.println("Goodbye!");
        }
        return userChoice;
    }
    
    // Passes in scanner, checks if inputted String is valid based on the question, when OK return String value.
    public static String checkYesNo(Scanner scan, String userInput_Continue) {
        while (userInput_Continue.equalsIgnoreCase("yes") != true && userInput_Continue.equalsIgnoreCase("no") != true) {
            System.out.println("Please type either [Yes] or [No].");
            userInput_Continue = scan.next();
        }
        return userInput_Continue;
    }

    // Simply passes in two integer values and returns the sum.
    public static int addInputs(int o, int p) {
        return o + p;
    }

    // Exception handling; When user enters something other than an integer value, prompt them to continue until a valid integer is inputted.
    public static int getValidatedNumber(Scanner scan, int iteration) {
        String userInput = "";
        int userReturnInt = 0;
        boolean validate_input = true;

        System.out.println("\nInput # -- " + iteration);
        
        while (validate_input == true) {
            System.out.print("Enter an integer value: ");
            userInput = scan.nextLine();

            try { 
                userReturnInt = Integer.parseInt(userInput);
                validate_input = false;
            }
            catch(NumberFormatException nfe) {
                System.out.println("\nError Message -- Input is not an integer!");
            }
        }
        return userReturnInt;
    }

    // Clears screen
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
