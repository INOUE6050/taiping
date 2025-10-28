package main;

public class Display {
    public static void disOneResult(double[] d){

        System.out.println(String.format("""
                ------------Result-------------
                         Time(seconds): %.0f
                       Character count: %.0f
                 Number of characters
                       entered (/3min): %.2f
                -------------------------------
                """,
                d[0],
                d[1],
                Utils.threeMinAns(d[1], d[0])));
    }
}