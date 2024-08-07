package smth;

import java.io.*;
import java.util.Scanner;

public class FileReadTest {
    public static void main(String args[])  {
        System.out.println(new File("src/smth/text.txt").exists());
        System.out.println(new File("src/smth/buff.txt").exists());
        try {
            Scanner scanner = new Scanner(new FileReader("src/smth/text.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
                }
        }
        catch (IOException e){
            System.out.println("Ошибка при чтении" + e.getMessage());
        }
        try{
            FileWriter writer = new FileWriter("src/smth/text.txt", true);
            writer.append("\nThis is Java documentation of some class");
            writer.flush();
        }
        catch (IOException e){
            System.out.println("Ошибка при записи " + e.getMessage());
        }

        try{
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("src/smth/buff.txt", true));
            buffWriter.append("\nThis is String I wrote with BufferedWriter!");
            buffWriter.flush();
        }
        catch (IOException e){
            System.out.println("Ошибка при записи " + e.getMessage());
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/smth/buff.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.out.println("Ошибка при чтении" + e.getMessage());
        }


    }

}