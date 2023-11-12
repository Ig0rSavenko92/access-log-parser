
import java.io.*;
import java.text.ParseException;
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
            if (!fileExist)
                System.out.println("Указанный файл не существуе");
            if (isDirectory)
                System.out.println("Указанный путь является путём к папке, а не к файлу");
            if (fileExist && !isDirectory)
                System.out.println("Путь указан верно. " + "Это файл номер " + count++);
            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                int lines = 0;
                int countYandexBot=0;
                int countGoogleBot=0;
                final String GOOGLEBOT= "Googlebot";
                final String YANDEXBOT= "YandexBot";
                Statistics s1 = new Statistics();
                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    if (length > 1024)
                        throw new InvalidLineLenghtException("В файле строка " + lines + ",длиннее 1024 символов. Размер строки " + length + " символа!");
                    lines++;
                    int firstIndexOf = Math.max(line.indexOf("compatible;"), 0);
                    String firstBrackets = line.substring(firstIndexOf);
                    String[] parts = firstBrackets.split(";");
                    String fragment="";
                    if (parts.length >= 2) {fragment = parts[1].trim();}
                    String[] parts2 = fragment.split("/");
                    String bot = parts2 [0];
                    if(bot.equals(GOOGLEBOT)) countGoogleBot++;
                    if(bot.equals(YANDEXBOT)) countYandexBot++;
                    LogEntry log = new LogEntry(line);
                    UserAgent ag = new UserAgent(log.userAgent);
                    s1.addEntry(log);
                }
                System.out.println("Общее количество строк в файле: " + lines);
                double prosentGoogleBot = (double) countGoogleBot/lines*100;
                double prosentYandexBot = (double) countYandexBot/lines*100;
                System.out.println("TotalTraffic: " + s1.getTotalTraffic());
                System.out.println("MaxTime: " + s1.getMaxTime());
                System.out.println("MinTime: " + s1.getMinTime());
                System.out.println("Доля запросов YandexBot: " + prosentYandexBot);
                System.out.println("Доля запросов GoogleBot: " + prosentGoogleBot);
                System.out.println("Часовой трафик: " + s1.getTrafficRate());
                System.out.println("Список всех существующих страниц сайта: " + s1.getHashSetRefer200());
                System.out.println("Список всех не существующих страниц сайта: " + s1.getHashSetRefer404());
                System.out.println("Статистика операционных систем пользователей: " + s1.getTypeSystemStatistics());
                System.out.println("Статистика браузеров пользователей: " + s1.getBrowserStatistics());

            } catch (FileNotFoundException ex) {
                System.out.println("Ошибка! " + ex);
            }
            catch (IOException ex) {
            System.out.println ("Ошибка при вводе/выводе данных из файла!");
           } catch (ParseException e) {
                System.out.println ("Ошибка даты!: " + e);
            }
            continue;
    }
    }
}

