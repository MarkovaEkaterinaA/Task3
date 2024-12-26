import java.io.*;

public class PersonSerialization {
    private static final String FILE_NAME = "person.dat"; // Имя файла для сериализации

    public static void main(String[] args) {
        // Создаем объект Person
        Person person = new Person("Alice", 30);

        // Сериализация
        serialize(person);

        // Десериализация
        Person deserializedPerson = deserialize();
        System.out.println("Десериализованный объект: " + deserializedPerson);
    }

    // Метод для сериализации объекта в файл
    private static void serialize(Person person) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(person);
            System.out.println("Объект успешно сериализован.");
        } catch (IOException e) {
            System.err.println("Ошибка при сериализации: " + e.getMessage());
        }
    }

    // Метод для десериализации объекта из файла
    private static Person deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при десериализации: " + e.getMessage());
        }
        return null;
    }
}
