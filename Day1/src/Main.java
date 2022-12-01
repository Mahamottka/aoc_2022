import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    //INPUT list of elves w their food
    //OUTPUT the elve carrying the most of callories
    public static void main(String[] args) {
        int biggest = 0;
        int previous = 0;
        int secondBig = 0;
        int thirdBig = 0;
        int total = 0;
        try {
            File myObj = new File("elves.dat");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("")) {
                    if (previous >= biggest){
                        thirdBig = secondBig;
                        secondBig = biggest;
                        biggest = previous;
                    } else if (previous >= secondBig){
                        thirdBig = secondBig;
                        secondBig = previous;
                    } else if (previous >= thirdBig){
                        thirdBig = previous;
                    }
                    total = biggest + secondBig + thirdBig;
                    previous = 0;
                    continue;
                }
                int number = Integer.parseInt(data); //tady dostanu to jedno čísilko
                previous = previous + number;
            }
            System.out.println("Total: " + total);
            System.out.println("Biggest number: " + biggest +
                    ", Second biggest: " + secondBig +
                    ", Third biggest: " + thirdBig
            );
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}