package main;

import java.util.Scanner;

public class Menu {
    private final UserInput ui;

    public Menu() {
        this.ui = new UserInput();
    }

    public void show(){
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        while(isContinue){
            System.out.println("""
                    -----------Menu-----------
                      A. Taiping URL
                      B. Result input
                      C. List of past results
                      Q. Quit
                    --------------------------
                    """);
            System.out.print("Please select a menu > ");
            String userInput = scanner.nextLine();
            switch (userInput){
                case "A" -> {
                    System.out.println("Selected A");
                    Utils.openTaipingUPL();
                }
                case "B" -> {
                    System.out.println("Selected B");
                    TypingResult result = ui.inputTypingResult();
                    Display.disOneResult(result);
                }
                case "C" -> {
                    System.out.println("Selected C");

                }
                case "Q" -> {
                    System.out.println("Selected Q");
                    System.out.println("Exiting the app");
                    isContinue = false;
                }
                default -> {
                    System.out.println("Please enter either A, B, or C.");
                }
            }
        }
    }
}
