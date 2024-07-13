package smth;

import java.io.FileWriter;
import java.io.*;
import java.util.Scanner;

public class FileReadTest {
    public static void main(String args[])  {
        System.out.println(new File("src/smth/text.txt").exists());
        try {
            Scanner scanner = new Scanner(new FileReader("src/smth/text.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
                }
            scanner.close();
        }
        catch (IOException e){
            System.out.println("Ошибка при чтении" + e.getMessage());
        }
        try{
            FileWriter writer = new FileWriter("src/smth/text.txt", true);
            writer.append("\nThis is Java documentation of some class");
            writer.flush();
            writer.close();
        }
        catch (IOException e){
            System.out.println("Ошибка при записи " + e.getMessage());
        }


    }

}