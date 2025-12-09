package main.application;

public class Validation {
    public static boolean validTime(String time){
        String pattern = "^\\d{1,2}:[0-5]\\d$";
        return time.trim().matches(pattern);
    }

}
