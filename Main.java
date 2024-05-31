import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import maze.Analizer;

public class Main {
  public static void main(String[] args) {

    ArrayList<String> fileLines = new ArrayList<String>();
    try {
      File entry = new File("data.txt");
      Scanner reader = new Scanner(entry);
      while (reader.hasNextLine()) {
        fileLines.add(reader.nextLine());
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found. The name of file should be data.txt");
      e.printStackTrace();
    }

    Analizer analizer = new Analizer(fileLines);

    analizer.analize();

    System.out.println(analizer.getShortestSuccessRoute());
  }
}