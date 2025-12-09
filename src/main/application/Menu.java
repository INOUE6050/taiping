package main.application;

import main.data.TypingResultsRepository;
import main.presentation.UserInput;
import main.presentation.Display;

import java.util.Scanner;

public class Menu {
    private final UserInput ui;
    private final TypingResultsRepository repo = new TypingResultsRepository("src/resources/typing_data.csv");

    public Menu() {
        this.ui = new UserInput();
    }

    public void show(){
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        while(isContinue){
            System.out.println("""
                    -----------Menu-----------
                      A. Typing URL
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
                    Utils.openTypingUPL();
                }
                case "B" -> {
                    System.out.println("Selected B");
                    TypingResult result = ui.inputTypingResult();
                    repo.saveResult(result);
                    Display.disOneResult(result);
                }
                case "C" -> {
                    System.out.println("Selected C");
                    Display.disAllResults(repo.loadAllResults());

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
