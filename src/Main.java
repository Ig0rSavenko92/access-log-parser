
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        myScaner ();
    }
    public static void myScaner () {
        int count = 1;
        System.out.println("Путь к файлу:");
        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExist = file.exists();
            boolean isDirectory = file.isDirectory();
            if (fileExist==false)
            System.out.println("Указанный файл не существуе");
            if (isDirectory==true)
            System.out.println("Указанный путь является путём к папке, а не к файлу");
            if (fileExist==true && isDirectory==false) System.out.println("Путь указан верно. " +"Это файл номер "+ count++);
            if (fileExist==true && isDirectory==false) continue;
            System.out.println("Путь к файлу:");
        }
    }
}
