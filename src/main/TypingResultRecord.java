package main;

import java.time.LocalDateTime;

public record TypingResultRecord(
        LocalDateTime resultDateTime,
        double charsPerSec,
        double threeMinAns,
        double averageThreeMinAns
) {
}
