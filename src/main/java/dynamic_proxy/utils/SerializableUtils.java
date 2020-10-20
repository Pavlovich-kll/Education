package dynamic_proxy.utils;

import java.io.*;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * Класс с реализованными методами упаковки/распаковки и записи/чтения файлов
 */

public class SerializableUtils {
    public static void serialize(Object object, String fileName, boolean compressed) {
        File file = new File(fileName);
        ObjectOutputStream objectOutputStream = null;
        try {
            OutputStream outputStream = new FileOutputStream(file);
            //сжимаем поток данных
            if (compressed) outputStream = new DeflaterOutputStream(outputStream);
            objectOutputStream = new ObjectOutputStream(outputStream);
            //записываем его
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            System.out.println(e.getMessage());//Creates a localized description of this throwable
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());//Creates a localized description of this throwable
                }
            }
        }
    }

    public static Object deserialize(final String fileName, final boolean compressed) {
        Object object = null;
        File file = new File(fileName);
        ObjectInputStream objectInputStream = null;
        try {
            InputStream inputStream = new FileInputStream(file);
            //Распаковываем данные в формате сжатия
            if (compressed) inputStream = new InflaterInputStream(inputStream);
            objectInputStream = new ObjectInputStream(inputStream);
            //Читаем эти данные
            object = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return object;
    }
}