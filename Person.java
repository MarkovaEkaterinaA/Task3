import jakarta.persistence.*;
import java.io.Serializable;

@Entity // Указывает, что это JPA-сущность
@Table(name = "person") // Название таблицы в базе данных
public class Person implements Serializable { // Интерфейс Serializable для сериализации
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкремент ID
    private Long id;

    @Column(name = "name", nullable = false) // Поле name в таблице
    private String name;

    @Column(name = "age", nullable = false) // Поле age в таблице
    private int age;

    // Конструктор без параметров (обязательно для JPA)
    public Person() {}

    // Конструктор для создания объектов
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Переопределение toString() для удобного вывода
    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}

