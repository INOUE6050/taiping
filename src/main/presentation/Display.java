package main.presentation;

import main.application.TypingResult;
import main.application.TypingResultRecord;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Display {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

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

    public static void disAllResults(List<TypingResultRecord> records){
        System.out.println();
        System.out.println("======================================================================================");
        System.out.println("| Date Time           |          Chars/Sec |         Chars/3min | Average Chars/3min |");
        System.out.println("======================================================================================");

        for(TypingResultRecord r : records){
            System.out.println(String.format("| %-20s|%19.2f |%19.2f |%19.2f |",
                    r.resultDateTime().format(FORMATTER),
                    r.charsPerSec(),
                    r.threeMinAns(),
                    r.averageThreeMinAns()));
        }
        System.out.println("======================================================================================");
        System.out.println();
    }
}