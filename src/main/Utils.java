package main;

import java.awt.*;
import java.net.URI;

public class Utils {
    public static void openTaipingUPL(){
        try {
            URI uri = new URI("https://typing-training.net/");
            if (Desktop.isDesktopSupported()) {
                System.out.println("Switching to the typing site.");
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("You cannot open a browser in this environment.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double parseTimeToSeconds(String min, String sec){
        double doubleMin = Double.parseDouble(min);
        double doubleSec = Double.parseDouble(sec);
        return doubleMin * 60 + doubleSec;
    }

    public static double threeMinAns(double charLength, double time){
        double answer = ( charLength / time) * 180;
        return answer;
    }

    public static double chaperSec(double charLength, double time){
        double answer = charLength / time;
        return answer;
    }
}
