package main;

import main.application.TypingApp;

public class Main {
    public static void main(String[] args){
        System.out.println("""
                |==========================|
                |   Typing Level Checker   |
                |==========================|
                This app measures and stores 
                           your typing speed.""");

        TypingApp app = new TypingApp();
        app.run();
    }
}