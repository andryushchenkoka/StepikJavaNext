package chapter9;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

        try{
            reader = new FileReader(filepath);
            int character;
            while((character = reader.read()) != -1){ // read() возвращает int пока файл не закончится. Иначе будет -1
                result += (char)character;      // записываем в переменную очередной считанный символ
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            reader.close();
            return result;
        }
    }


}
