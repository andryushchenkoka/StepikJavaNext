package chapter9;

import java.io.*;

public class FilesIO {

    public static void main(String[] args) throws IOException {

        String text = "Кабы не было зимы в городах и сёлах...";
        String result;
        String filepath = "src/main/resources/chapter9.txt";

        useFileWriter(filepath, text);
        System.out.println("Записано в файл");
        result = useFileReader(filepath);
        System.out.println("Считано из файла: " + result);
    }

    public static void useFileWriter(String filepath, String inputText) throws IOException {

        FileWriter writer = null;

        try {
            writer = new FileWriter(filepath);
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public static String useFileReader(String filepath) throws IOException {

        FileReader reader = null;
        String result = "";

        try {
            reader = new FileReader(filepath);
            int character;
            while ((character = reader.read()) != -1) { // read() возвращает int пока файл не закончится. Иначе будет -1
                result += (char) character;      // записываем в переменную очередной считанный символ
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        return result;
    }

    // try with resources
    // Java сама закроет поток, который открыли в try()
    public static void useFileWriter2(String filepath, String inputText) {
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // в try() можно использовать несколько ресурсов
    // перечислять через точку с запятой
    // ресурс из блока try() должен имплементировать интерфейс AutoCloseable
    // (FileReader имплементирует интерфейс, который в свою очередь имплементирует AutoCloseable)
    public static void useFileWriter3(String filepath, String inputText) throws IOException {
        try (
                FileWriter fileWriter = new FileWriter(filepath); // вот здесь
                FileReader fileReader = new FileReader(filepath)
        ) {
            fileWriter.write(inputText);
        }
    }

    // bufferedReader/writer - запоминает символы из файла - 1 или более раз в зависимости от размера файла
    // затем идет посимвольная запись из буфера. Таким образом значительно меньше обращений к файлу (ресурсоемкая операция)
    public static void useBufferedWriter(String filepath, String inputText) {

        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));
        ) {
            bufferedWriter.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String useBufferedReader(String filepath) {

        String result = "";
        int character;

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath)) // java закроет поток
        ) {
            while ((character = bufferedReader.read()) != -1) {
                result += (char) character;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
