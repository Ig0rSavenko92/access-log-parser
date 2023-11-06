
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 1;
        while (true) {
            System.out.println("Путь к файлу:");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExist = file.exists();
            boolean isDirectory = file.isDirectory();
            if (fileExist == false)
                System.out.println("Указанный файл не существуе");
            if (isDirectory == true)
                System.out.println("Указанный путь является путём к папке, а не к файлу");
            if (fileExist == true && isDirectory == false)
                System.out.println("Путь указан верно. " + "Это файл номер " + count++);
            if (fileExist == true && isDirectory == false) ;
            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                int lines = 0;
                List <Integer> len = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    len.add(length);
                    lines++;
                }
                int max = len.stream().max(Integer::compare).get();
                int min = len.stream().min(Integer::compare).get();
                System.out.println("Общее количество строк в файле: " + lines);
                System.out.println("Длина самой длинной строки в файле: "+ max);
                System.out.println("Длина самой короткой строки в файле: " + min);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
            catch (IOException ex) {
           System.out.println ("Проблема с файлом " + ex);
        } continue;
    }
}
}