import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //A for ROCKS -> X -> 1pt lose
        //B for Paper -> Y -> 2pt draw
        //C for Scisors -> Z -> 3pt win
        //Win -> 6, draw -> 3, lose -> 0
        int fin = 0;
        try {
            File myObj = new File("rockpaper.dat");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                int points = 0;
                String data = myReader.nextLine();
                if (data.equals("A X")){
                    //lose scis
                    points = 3;
                } else if (data.equals("A Y")) {
                    //draw rock
                    points = 3 + 1;
                } else if (data.equals("A Z")) {
                    //win paper
                    points = 6 + 2;
                } else if (data.equals("B X")){
                    //Lose rock
                    points = 1;
                } else if (data.equals("B Y")) {
                    //Draw paper
                    points = 3 + 2;
                } else if (data.equals("B Z")) {
                    //Win scis
                    points = 6 + 3;
                } else if (data.equals("C X")){
                    //lose paper
                    points = 2;
                } else if (data.equals("C Y")) {
                    //draw scis
                    points = 3 + 3;
                } else if (data.equals("C Z")) {
                    //win rock
                    points = 6 + 1;
                }
                fin = fin + points;
                System.out.println(fin);
            }
            //System.out.println(fin);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}