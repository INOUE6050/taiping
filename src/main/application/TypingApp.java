package main.application;

public class TypingApp {
    private final Menu menu;

    public TypingApp() {
        this.menu = new Menu();
    }

    public void run(){
        menu.show();
    }
}
