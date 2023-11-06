
import java.io.*;
import java.util.Arrays;
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
            if (fileExist == true && isDirectory == false) continue;
            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                int lines = 0;
                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    lines++;
                }
                System.out.println(lines);
            } catch (FileNotFoundException ex) {
                throw new IllegalArgumentException("Ошибка ресурса", ex);
            }
            catch (IOException ex) {
            throw new IllegalArgumentException("Ресурс отсутствует", ex);
        }
    }
}
}