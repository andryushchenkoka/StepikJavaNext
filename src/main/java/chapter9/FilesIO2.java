package chapter9;

import java.io.*;

public class FilesIO2 {

    public static void main(String[] args) {

        String resPath = "src/main/resources/",
                fileFrom = "C:\\Users\\User\\Desktop\\picture.png",
                fileTo = resPath + "pic.png",
                dataIO = resPath + "data.bin";

        useFileIOStream(fileFrom, fileTo);
        useDataIOStream(dataIO);
    }

    // fileInputStream и output - используются для работы с бинарными файлами (не текстовыми)
    // input - read
    // output - write
    public static void useFileIOStream(String fromFilepath, String toFilepath) {

        try (
                FileInputStream inputStream = new FileInputStream(fromFilepath); // из какого файла считать инфу
                FileOutputStream outputStream = new FileOutputStream(toFilepath) // в какой файл записать инфу
        ) {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }

            System.out.println("Скопировано!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // dataInputStream и output - позволяют читать и записывать в файлы данные примитивных типов
    public static void useDataIOStream(String filepath) {
        try (
                DataInputStream inputStream = new DataInputStream(new FileInputStream(filepath));
                DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filepath))
        ) {
            outputStream.writeInt(9);
            outputStream.writeInt(12);
            outputStream.writeChars("Пятница");
            outputStream.writeChar('j');
            outputStream.writeBoolean(false);
            outputStream.writeDouble(26.06);

            System.out.println(inputStream.readInt()); // 9
            System.out.println(inputStream.readInt()); // 12
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}