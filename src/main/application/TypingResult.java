package main.application;

public class TypingResult {
    private final double timeSeconds;
    private final double charCount;

    public TypingResult(double timeSeconds, double charCount) {
        this.timeSeconds = timeSeconds;
        this.charCount = charCount;
    }

    public double getTimeSeconds() {
        return timeSeconds;
    }

    public double getCharCount() {
        return charCount;
    }

    public double getThreeMinAns(){
        return ( charCount / timeSeconds) * 180;
    }

    public double getCharsPerSec(){
        return charCount / timeSeconds;
    }
}
