package main;

public class Display {
    public static void disOneResult(TypingResult result){
        double timeSeconds = result.getTimeSeconds();
        double charCount = result.getCharCount();

        System.out.println();
        System.out.println(String.format("""
                ------------Result-------------
                         Time(seconds): %.0f
                       Character count: %.0f
                 Number of characters
                        entered (/sec): %.2f
                 Number of characters
                       entered (/3min): %.2f
                -------------------------------
                """,
                timeSeconds,
                charCount,
                result.getCharsPerSec(),
                result.getThreeMinAns()));
    }
}