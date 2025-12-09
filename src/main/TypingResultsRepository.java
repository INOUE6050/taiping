package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TypingResultsRepository {
    private final Path filePath;

    public TypingResultsRepository(String fileName) {
        this.filePath = Path.of(fileName);
    }

    public void saveResult(TypingResult result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), true))){
            List<TypingResultRecord> records = loadAllResults();
            double averageThree = calcAverageThreeMinAns(records, result.getThreeMinAns());

            writer.write(LocalDateTime.now() + ","
                    + result.getCharsPerSec() + ","
                    + result.getThreeMinAns() + ","
                    + averageThree);
            writer.newLine();
        } catch(Exception e){
            System.out.println("Failed to save result to csv" + e.getMessage());
        }
    }

    public List<TypingResultRecord> loadAllResults() {
        List<TypingResultRecord> records = new ArrayList<>();

        try(BufferedReader reader = Files.newBufferedReader(filePath)){
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                records.add(new TypingResultRecord(
                        LocalDateTime.parse(parts[0]),
                        Double.parseDouble(parts[1]),
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3])
                ));
            }
        }catch (IOException e){
            System.out.println("Failed to read results from csv: " + e.getMessage());
        }
        return records;
    }

    public double calcAverageThreeMinAns(List<TypingResultRecord> records, double currentThreeMinAns) {
        double sum = currentThreeMinAns;
        double count = 1;
        for(TypingResultRecord r : records){
            sum += r.averageThreeMinAns();
            count++;
        }
        return sum/count;
    }
}
