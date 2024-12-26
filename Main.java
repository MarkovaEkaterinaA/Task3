public class Main {
    public static void main(String[] args) {
        PersonService service = new PersonService();

        // Добавляем людей
        service.addPerson(new Person("Alice", 30));
        service.addPerson(new Person("Bob", 25));

        // Получаем и выводим всех
        System.out.println("Все люди:");
        service.getAllPersons().forEach(System.out::println);

        // Обновляем данные
        service.updatePerson(1L, "Alice Updated", 35);

        // Удаляем одного человека
        service.deletePerson(2L);

        // Снова выводим всех
        System.out.println("После обновления и удаления:");
        service.getAllPersons().forEach(System.out::println);
    }
}
