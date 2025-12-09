package main;

public class Main {
    public static void main(String[] args){
        System.out.println("""
                |===========================|
                |   Taiping Level Checker   |
                |===========================|
                This app measures and stores 
                           your typing speed.""");

        TypingApp app = new TypingApp();
        app.run();
    }
}