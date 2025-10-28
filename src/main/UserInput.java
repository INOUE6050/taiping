package main;

import java.util.Scanner;

public class UserInput {
    public static double[] inputResult(){
        double time = inputTime();
        double charLength = inputCharLength();
        return new double[]{time, charLength};
    }

    public static double inputTime(){
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        String time = "";
        while(isContinue) {
            System.out.print("Please enter your time results (min:sec) > ");
            time = scanner.nextLine();
            if(Validation.validTime(time)){
                isContinue = false;
            }else{
                System.out.println("入力形式が違います");
            }
        }
        String[] parts = time.split(":");
        return Utils.parseTimeToSeconds(parts[0], parts[1]);
    }

    public static double inputCharLength(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean isContinue = true;
        while(isContinue){
            System.out.println("""
                    Please enter your text.
                    While typing, you may see \\"~?\\" displayed depending 
                    on the amount of text entered. If this occurs, delete 
                    the question mark, press Enter to start a new line, 
                    and continue typing your text.
                    """);
            System.out.println("Please enter your text > ");
            String line = scanner.nextLine();
            if(!line.isEmpty()){
                sb.append(line).append("\n");
                isContinue = false;
            }else{
                System.out.println("Please enter your text > ");
            }
        }
        String text = sb.toString();
        double charLength = text.replaceAll("[\\r\\n]", "").trim().length();
        return charLength;
    }
}
